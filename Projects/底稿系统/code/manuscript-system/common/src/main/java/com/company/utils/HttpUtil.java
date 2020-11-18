package com.company.utils;

import com.alibaba.druid.util.StringUtils;
import com.company.base.exception.BaseException;
import com.company.enums.RequestParameterType;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.apache.commons.codec.Charsets;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.io.IOUtils;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URI;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public   class HttpUtil<main> {
	private static final Logger logger = LogManager.getLogger();

	private static final MediaType CONTENT_TYPE_FORM = MediaType.parse("application/x-www-form-urlencoded");
	private static final String DEFAULT_USER_AGENT = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.146 Safari/537.36";

	private HttpUtil() {
	}
	
	public static final String httpClientPost(String url) {
		String result = "";
		HttpClient client = new HttpClient();
		GetMethod getMethod = new GetMethod(url);
		try {
			client.executeMethod(getMethod);
			result = getMethod.getResponseBodyAsString();
		} catch (Exception e) {
			logger.error(e);
		} finally {
			getMethod.releaseConnection();
		}
		return result;
	}
	 
	public static final String httpClientPost(String url, ArrayList<NameValuePair> list) {
		String result = "";
		HttpClient client = new HttpClient();
		PostMethod postMethod = new PostMethod(url);
		try {
			NameValuePair[] params = new NameValuePair[list.size()];
			for (int i = 0; i < list.size(); i++) {
				params[i] = list.get(i);
			}
			postMethod.addParameters(params);
			client.executeMethod(postMethod);
			result = postMethod.getResponseBodyAsString();
		} catch (Exception e) {
			logger.error(e);
		} finally {
			postMethod.releaseConnection();
		}
		return result;
	}

	public static void main(String[] args) {
//		String result = HttpUtil.doHttpPost("http://36.110.110.35:30010/tyzhapi/api/system/menu/selectDatamByUserId","{\"currentPage\":\"1\",\"itemsPerPage\":\"10\"}");
//		System.out.println(result);
		Map<String,String> map = new HashMap<>();
		map.put("userId","93902");
		try {
			doHttpGet("http://36.110.110.35:30010/tyzhapi/api/system/menu/selectDatamByUserId",map);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
     * 构建post请求
     * @param url     请求地址
     * @param paramsJson  请求参数
     * @return String
     * 		  返回json数据
     */
    public static String doHttpPost(String url, String paramsJson)
    {
    	CloseableHttpClient httpClient = HttpClientBuilder.create().build();
    	StringEntity params = new StringEntity(paramsJson, Consts.UTF_8);
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-Type", "application/json;charset=utf-8");
        httpPost.setEntity(params);
        HttpResponse response;
		try {
			logger.debug("doHttpPost [url={} param={}]", url, EntityUtils.toString(httpPost.getEntity(), "utf-8"));
			response = httpClient.execute(httpPost);
			return EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (IOException e) {
			return "{\"code\":-1, \"msg\":\"接口调用出错\"}";
		}
    }

	public static String doHttpGet(String url, Map<String,String> map) throws Exception{
		// 创建Httpclient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 定义请求的参数
		URIBuilder uriBuilder = new URIBuilder(url);
		for(Map.Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			uriBuilder.setParameter(key, value);
		}
		URI uri = uriBuilder.build();
//		URI uri = new URIBuilder(url).setParameter("userId", "93902").build();
		// 创建http GET请求
		HttpGet httpGet = new HttpGet(uri);
		//response 对象
		CloseableHttpResponse response = null;
		try {
			// 执行http get请求
			response = httpclient.execute(httpGet);
			// 判断返回状态是否为200
			String content = "";
			if (response.getStatusLine().getStatusCode() == 200) {
				content = EntityUtils.toString(response.getEntity(), "UTF-8");
			}
			return content;
		} finally {
			if (response != null) {
				response.close();
			}
			httpclient.close();
		}
	}
	
	public static String post(String url, String params) {
		RequestBody body = RequestBody.create(CONTENT_TYPE_FORM, params);
		Request request = new Request.Builder().url(url).post(body).build();
		return exec(request);
	}

	private static String exec(okhttp3.Request request) {
		try {
			okhttp3.Response response = new OkHttpClient().newCall(request).execute();
			if (!response.isSuccessful())
				throw new RuntimeException("Unexpected code " + response);
			return response.body().string();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static String postSSL(String url, String data, String certPath, String certPass) {
		HttpsURLConnection conn = null;
		OutputStream out = null;
		InputStream inputStream = null;
		BufferedReader reader = null;
		try {
			KeyStore clientStore = KeyStore.getInstance("PKCS12");
			clientStore.load(new FileInputStream(certPath), certPass.toCharArray());
			KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
			kmf.init(clientStore, certPass.toCharArray());
			KeyManager[] kms = kmf.getKeyManagers();
			SSLContext sslContext = SSLContext.getInstance("TLSv1");

			sslContext.init(kms, null, new SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
			URL _url = new URL(url);
			conn = (HttpsURLConnection) _url.openConnection();

			conn.setConnectTimeout(25000);
			conn.setReadTimeout(25000);
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);

			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("User-Agent", DEFAULT_USER_AGENT);
			conn.connect();

			out = conn.getOutputStream();
			out.write(data.getBytes(Charsets.toCharset("UTF-8")));
			out.flush();

			inputStream = conn.getInputStream();
			reader = new BufferedReader(new InputStreamReader(inputStream, Charsets.toCharset("UTF-8")));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line).append("\n");
			}
			return sb.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			IOUtils.closeQuietly(out);
			IOUtils.closeQuietly(reader);
			IOUtils.closeQuietly(inputStream);
			if (conn != null) {
				conn.disconnect();
			}
		}
	}
	
	/**
	 * 得到请求的根目录
	 * 
	 * @param request
	 * @return
	 */
	public static String getBasePath(HttpServletRequest request) {
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path;
		return basePath;
	}
	
	/**
	 * 得到请求的IP地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getIp(HttpServletRequest request) {
		String ip = request.getHeader("X-Real-IP");
		if (StringUtils.isEmpty(ip)) {
			ip = request.getHeader("Host");
		}
		if (StringUtils.isEmpty(ip)) {
			ip = request.getHeader("X-Forwarded-For");
		}
		if (StringUtils.isEmpty(ip)) {
			ip = "0.0.0.0";
		}
		return ip;
	}


	/**
	 * 私有httpclient请求方法，只有get请求。如有需要请自行添加参数
	 * @author yangyc
	 * @param argMap    请求参数
	 * @param url   远程终端地址
	 */
	public static Map<String, Object> HttpRequestutil(Map<String, String> argMap, String url, RequestMethod method, RequestParameterType parameterType) {
		// 创建连接
		org.apache.http.client.HttpClient client = HttpClientUtils.getConnection();
		// 创建请求请求
		HttpUriRequest req = null;
		try {
			if(parameterType.equals(RequestParameterType.QUERY)){
				//query方式
				req = HttpClientUtils.getRequestMethod(argMap, url, method);
			} else if(parameterType.equals(RequestParameterType.BODY)){
				//body方式
				req = HttpClientUtils.getRequestMethodForJson(argMap, url, method);
			} else if(parameterType.equals(RequestParameterType.PATH)){
				//path方式
				req = HttpClientUtils.getRequestMethodForPath(argMap, url, method);
			}
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			logger.error("自定义错误信息：", e.getLocalizedMessage());
		}
		Map<String,Object> resMap = null;
		try {
			// 获取响应
			HttpResponse response = client.execute(req);
			//----------处理302
			logger.info("跨终端请求返回码：",response.getStatusLine().getStatusCode());
			if (response.getStatusLine().getStatusCode() == 302) {
				Header header = response.getFirstHeader("location"); // 跳转的目标地址是在 HTTP-HEAD 中的
				String newuri = header.getValue(); // 这就是跳转后的地址，再向这个地址发出新申请，以便得到跳转后的信息是啥。
				resMap = HttpRequestutil(argMap, newuri, method, parameterType);
				logger.info("重定向返回信息{}", resMap);
			}else {
				// 响应转map
				HttpEntity entity = response.getEntity();
				String message = EntityUtils.toString(entity, "utf-8");
				ObjectMapper objectMapper = new ObjectMapper();
				resMap = objectMapper.readValue(message, Map.class);
			}


		}catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("错误信息：", e.getLocalizedMessage());
			e.printStackTrace();
		}
		return resMap;
	}
}