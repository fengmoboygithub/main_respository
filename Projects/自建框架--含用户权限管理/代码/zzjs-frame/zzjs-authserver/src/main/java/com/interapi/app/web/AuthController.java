package com.interapi.app.web;
import java.util.Base64;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.interapi.app.auth.serviceImpl.LoginUserServiceImpl;
import com.interapi.app.bean.ResponseAuthenticationModel;
import com.interapi.app.bean.ResponseModel;
import com.interapi.app.bmp.model.ResourceTab;
import com.interapi.app.enums.JwtRedisEnum;
import com.interapi.app.utils.RedisUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
 
/**
 * 认证相关 控制器类
 * @author yangyanchao
 *
 */
@RestController
public class AuthController {
	public static Logger logger = LoggerFactory.getLogger(AuthController.class);
    
	@Autowired(required = false)
    private RedisUtil redisUtil;
	@Autowired(required = false)
    private RestTemplate restTemplate;
	@Autowired(required = false)
    private TokenStore tokenStore;
	@Autowired
	private LoginUserServiceImpl loginUserServiceImpl;
	/**
     * 通过密码授权方式向授权服务器获取令牌
     * @param loginDTO
     * @param bindingResult
     * @return
     * @throws Exception
     */
	@ApiOperation(value = "登录", notes = "通过密码授权方式向授权服务器获取令牌", httpMethod = "POST")
    @PostMapping(value = "/auth/login")
    public ResponseAuthenticationModel login(
    		@RequestParam(required = true) String clientId,
    		@RequestParam(required = true) String clientSecret,
    		@RequestParam(required = true) String username,
    		@RequestParam(required = true) String password,
    		HttpServletRequest request)  throws Exception{
		ResponseAuthenticationModel responseModel = new ResponseAuthenticationModel();
    	String secretEncode = "{bcrypt}"+clientSecret;
        //Http Basic 验证
        String clientAndSecret = clientId+":"+secretEncode;
        //这里需要注意为 Basic 而非 Bearer
        clientAndSecret = "Basic "+Base64.getEncoder().encodeToString(clientAndSecret.getBytes());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization",clientAndSecret);
        //授权请求信息
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.put("username", Collections.singletonList(username));
        map.put("password", Collections.singletonList("{bcrypt}"+password));
        map.put("grant_type", Collections.singletonList("password"));
        map.put("scope", Collections.singletonList("all"));
        //HttpEntity
        HttpEntity httpEntity = new HttpEntity(map,httpHeaders);
        String path = request.getContextPath();
    	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
    			+ path;
        String accessTokenUri = basePath + "/oauth/token";
        
        ResponseEntity<OAuth2AccessToken> responseEntity = restTemplate.exchange(accessTokenUri, HttpMethod.POST, httpEntity, OAuth2AccessToken.class);
        OAuth2AccessToken oAuth2AccessToken = responseEntity.getBody();
        if(oAuth2AccessToken != null){
        	String token = oAuth2AccessToken.getValue();
        	Integer expiration = oAuth2AccessToken.getExpiresIn();
        	//将jwt的票据信息放入Redis缓存中 
            redisUtil.set(JwtRedisEnum.getTokenKey(username), token, expiration);
            logger.info("将jwt的票据信息放入Redis缓存中 key:【{}】 value:【{}】过期时间：{}秒",
            		JwtRedisEnum.getTokenKey(username),
            		token,
            		expiration);
            responseModel.setToken(token);
            List<ResourceTab> resourceList = loginUserServiceImpl.getResourceTabListByUserName(username);
            String resourceUris = "";
            if(resourceList != null && resourceList.size() > 0){
            	for(ResourceTab rt : resourceList){
            		resourceUris += rt.getUri()+",";
            	}
            	if(resourceUris.length()>0){
            		resourceUris = resourceUris.substring(0, resourceUris.length()-1);
                }
            }
            responseModel.setResourceUris(resourceUris);
            //将jwt的票据信息为key 接口资源放入Redis缓存中 
            redisUtil.set(JwtRedisEnum.getResourceUrisKey(token, clientId), resourceUris, expiration);
            logger.info("将jwt的票据信息为key 接口资源放入Redis缓存中  key:【{}】 value:【{}】过期时间：{}秒",
            		JwtRedisEnum.getResourceUrisKey(token, clientId),
            		resourceUris,
            		expiration);
            OAuth2Authentication oAuth2Authentication = tokenStore.readAuthentication(oAuth2AccessToken);
			Collection<GrantedAuthority> list = (Collection<GrantedAuthority>) oAuth2Authentication.getAuthorities();
            String authorities = "";
            Iterator<GrantedAuthority> it = list.iterator();
            while(it.hasNext()){
            	authorities += (it.next()).getAuthority()+",";
            }
            if(authorities.length()>0){
            	authorities = authorities.substring(0, authorities.length()-1);
            }
        	responseModel.setAuthorities(authorities);
        	//将jwt的票据信息为key 权限集放入Redis缓存中 
            redisUtil.set(JwtRedisEnum.getAuthoritiesKey(token, clientId), authorities, expiration);
            logger.info("将jwt的票据信息为key 权限集放入Redis缓存中  key:【{}】 value:【{}】过期时间：{}秒",
            		JwtRedisEnum.getAuthoritiesKey(token, clientId),
            		authorities,
            		expiration);
        	responseModel.setMessage("您获得了票据token，请保存在浏览器缓存中");
        	responseModel.setCode(HttpStatus.OK.value());
        } else {
        	responseModel.setMessage("认证失败");
        	responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return responseModel;
    }

    @ApiOperation(value = "退出登录", notes = "通过移除token来达到退出登录的效果", httpMethod = "GET")
    @ApiImplicitParam(name = "accessToken", value = "用来认证的access_token", required = true, dataType = "String")
    @GetMapping("/auth/logout")
    public ResponseEntity<?> logout(String accessToken) {
    	//将安全框架的认证信息放入Redis缓存中 
        OAuth2Authentication oAuth2Authentication = tokenStore.readAuthentication(accessToken);
        String username = (String)oAuth2Authentication.getUserAuthentication().getPrincipal();
        String clientId = oAuth2Authentication.getOAuth2Request().getClientId();
    	//将jwt的票据信息从Redis缓存中删除 
        redisUtil.del(JwtRedisEnum.getTokenKey(username));
        logger.info("将jwt的票据信息从Redis缓存中删除  key:【{}】",
        		JwtRedisEnum.getTokenKey(username)
        		);
        //将接口资源从Redis缓存中删除  
        redisUtil.del(JwtRedisEnum.getResourceUrisKey(accessToken, clientId));
        logger.info("将接口资源从Redis缓存中删除   key:【{}】",
        		JwtRedisEnum.getResourceUrisKey(accessToken, clientId));
        //将权限集从Redis缓存中删除   
        redisUtil.del(JwtRedisEnum.getAuthoritiesKey(accessToken, clientId));
        logger.info("将权限集从Redis缓存中删除 key:【{}】",
        		JwtRedisEnum.getAuthoritiesKey(accessToken, clientId));
    	ResponseModel rdm = new ResponseModel();
		rdm.setMessage("登出操作成功");
		rdm.setCode(HttpStatus.OK.value());
        return ResponseEntity.ok(rdm);
    }
}
