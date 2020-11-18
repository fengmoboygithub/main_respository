package com.company.utils;

import com.company.base.exception.BaseException;
import com.company.enums.RequestParameterType;
import com.google.gson.JsonObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

public class HttpClientUtils {

    private static PoolingHttpClientConnectionManager connectionManager = null;
    private static HttpClientBuilder httpBuilder = null;
    private static RequestConfig requestConfig = null;

    private static int MAXCONNECTION = 10;

    private static int DEFAULTMAXCONNECTION = 5;

    private static String IP = "cnivi.com.cn";
    private static int PORT = 80;

    static {
        //设置http的状态参数
        requestConfig = RequestConfig.custom()
                .setSocketTimeout(5000)
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .build();

        HttpHost target = new HttpHost(IP, PORT);
        connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(MAXCONNECTION);//客户端总并行链接最大数
        connectionManager.setDefaultMaxPerRoute(DEFAULTMAXCONNECTION);//每个主机的最大并行链接数
        connectionManager.setMaxPerRoute(new HttpRoute(target), 20);
        httpBuilder = HttpClients.custom();
        httpBuilder.setConnectionManager(connectionManager);
    }

    public static CloseableHttpClient getConnection() {
        CloseableHttpClient httpClient = httpBuilder.build();
        return httpClient;
    }

    /**
     * query 方式提交
     * @param map
     * @param url
     * @param method
     * @return
     */
    public static HttpUriRequest getRequestMethod(Map<String, String> map, String url, RequestMethod method) {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> e : entrySet) {
            String name = e.getKey();
            String value = e.getValue();
            NameValuePair pair = new BasicNameValuePair(name, value);
            params.add(pair);
        }
        HttpUriRequest reqMethod = null;
        if (method.equals(RequestMethod.POST)) {
            reqMethod = RequestBuilder.post().setUri(url)
                    .addParameters(params.toArray(new BasicNameValuePair[params.size()]))
                    .setConfig(requestConfig).build();
        } else if (method.equals(RequestMethod.GET)) {
            reqMethod = RequestBuilder.get().setUri(url)
                    .addParameters(params.toArray(new BasicNameValuePair[params.size()]))
                    .setConfig(requestConfig).build();
        }
        return reqMethod;
    }
    /**
     * path 方式提交
     * @param map
     * @param url
     * @param method
     * @return
     */
    public static HttpUriRequest getRequestMethodForPath(Map<String, String> map, String url, RequestMethod method) {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> e : entrySet) {
            String name = e.getKey();
            String value = e.getValue();
            NameValuePair pair = new BasicNameValuePair(name, value);
            params.add(pair);
        }
        HttpUriRequest reqMethod = null;
        if (method.equals(RequestMethod.POST)) {
            reqMethod = RequestBuilder.post().setUri(url)
                    .addParameters(params.toArray(new BasicNameValuePair[params.size()]))
                    .setConfig(requestConfig).build();
        } else if (method.equals(RequestMethod.GET)) {
            reqMethod = RequestBuilder.get().setUri(url)
                    .addParameters(params.toArray(new BasicNameValuePair[params.size()]))
                    .setConfig(requestConfig).build();
        }
        return reqMethod;
    }
    /**
     *  body  application/json方式提交
     * @param map
     * @param url
     * @return
     */
    public static HttpEntityEnclosingRequestBase getRequestMethodForJson(Map<String, String> map, String url, RequestMethod method) throws BaseException {
        JsonObject jsonParameters = new JsonObject();
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> e : entrySet) {
            String name = e.getKey();
            String value = e.getValue();
            jsonParameters.addProperty(name, value);
        }
        String parameters = jsonParameters.toString();
        HttpEntityEnclosingRequestBase reqMethod = null;
        if (method.equals(RequestMethod.POST)) {
            reqMethod = new HttpPost(url);
        } else if (method.equals(RequestMethod.PUT)) {
            reqMethod = new HttpPut(url);
        } else if (method.equals(RequestMethod.PATCH)){
            reqMethod = new HttpPatch(url);
        } else {
            throw new BaseException("请求类型错误，"+method.name()+"必须是POST、PUT、PATCH的一种");
        }
        reqMethod.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));
        reqMethod.addHeader("Content-type","application/json; charset=utf-8");
        reqMethod.setHeader("Accept", "application/json");
        return reqMethod;
    }

    /**
     * 测试HttpClient
     * @param args
     * @throws IOException
     */
    public static void main(String args[]) throws IOException {
        Map<String, String> map = new HashMap<String, String>();
        map.put("currentPage", "1");
        map.put("itemsPerPage", "10");

        HttpClient client = getConnection();
        HttpUriRequest post = getRequestMethod(map, "http://127.0.0.1:8091/api/ProjectInfo/getListByPage?currentPage=1&itemsPerPage=10", RequestMethod.POST);
        HttpResponse response = client.execute(post);

        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity entity = response.getEntity();
            String message = EntityUtils.toString(entity, "utf-8");
            System.out.println(message);
        } else {
            System.out.println("请求失败");
        }
    }
}
