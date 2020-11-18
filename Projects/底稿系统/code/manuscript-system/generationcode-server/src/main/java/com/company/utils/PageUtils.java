package com.company.utils;

import java.net.URL;

import org.apache.log4j.Logger;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.CookieManager;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebClientOptions;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class PageUtils {

	
	private static Logger LOG = Logger.getLogger("PageUtils");
	
	
	/**
	 * 根据url获取页面
	 * @param htmlUrl
	 * @return
	 */
	public static HtmlPage fetchPage(String htmlUrl)
	{
		WebClient client = null;
		HtmlPage htmlPage = null;
		LOG.info("获取区块列表 URL= " + htmlUrl);
		
		try {

			client = new WebClient(BrowserVersion.FIREFOX_45);
			client.waitForBackgroundJavaScriptStartingBefore(30 * 1000);
			client.setAjaxController(new NicelyResynchronizingAjaxController());//设置支持AJAX
			client.setJavaScriptTimeout(30000);//设置JS执行的超时时间
			WebClientOptions options = client.getOptions();
			options.setJavaScriptEnabled(false); //启用JS解释器，默认为true
			options.setCssEnabled(false); //禁用css支持
			options.setThrowExceptionOnScriptError(false); //js运行错误时，是否抛出异常
			options.setTimeout(30000); //设置连接超时时间 ，这里是10S。如果为0，则无限期等待
			options.setDoNotTrackEnabled(false);//启用/禁用“不跟踪”支持
			options.setThrowExceptionOnFailingStatusCode(false);
			CookieManager cookieManager = client.getCookieManager();
			cookieManager.setCookiesEnabled(true);// 设置cookie是否可用
			URL url = new URL(htmlUrl);  
	        WebRequest webRequest = new WebRequest(url, HttpMethod.GET);
	        webRequest.setCharset("utf-8");
			htmlPage = client.getPage(webRequest);
		}
		catch (Exception e)
		{
			LOG.error("抓取数据异常 " + e.getMessage());
		}
		finally
		{
			if(null != client)
			{
				client.close();
				client = null;
			}
		}
		
		return htmlPage;
	}
	
}
