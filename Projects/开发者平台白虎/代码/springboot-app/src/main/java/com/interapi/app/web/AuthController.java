package com.interapi.app.web;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.interapi.app.bmp.model.UserTab;
import com.interapi.app.bmp.service.AuthService;
import com.interapi.app.generator.bean.ResponseDataModel;
import com.interapi.app.jwt.bean.JwtAuthenticationResponse;
 
@RestController
public class AuthController {
	public static Logger logger = LoggerFactory.getLogger(AuthController.class);
 
    @Autowired
    private AuthService authService;
 
    @RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> createAuthenticationToken(String username,
    		String password) throws AuthenticationException{
    	logger.info("触发登录操作:::"+username+" :: "+password);
        final String token = authService.login(username,password);
        ResponseDataModel<JwtAuthenticationResponse> rdm = new ResponseDataModel<JwtAuthenticationResponse>();
        rdm.setEntity(new JwtAuthenticationResponse(token));
        rdm.setMessage("您获得了票据token，请保存在浏览器缓存中");
        rdm.setCode(HttpStatus.OK.value());
        return ResponseEntity.ok(rdm);
    }
 
    @RequestMapping(value = "${jwt.route.authentication.register}", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody UserTab addedUser) throws AuthenticationException{
    	logger.info("触发注册操作:::{} :: {}",
    			addedUser.getName(),
    			addedUser.getAccount());
    	UserTab userTab = authService.register(addedUser);
    	ResponseDataModel<UserTab> rdm = new ResponseDataModel<UserTab>();
        rdm.setEntity(userTab);
        rdm.setMessage("您注册成功了");
        rdm.setCode(HttpStatus.OK.value());
        return ResponseEntity.ok(rdm);
    }
}
