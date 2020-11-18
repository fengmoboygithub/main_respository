package com.company.cloud;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.company.utils.ExcelHssfUtils;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.NamedNodeMap;

import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.company.utils.PageUtils;

public class TencentCloudSpider {

	static String url = "https://cloud.tencent.com/product";
	@SuppressWarnings("unchecked")
	public static void main(String[] a) {
		
		HtmlPage page = PageUtils.fetchPage(url);
		List<HtmlDivision> parentDivs = (List<HtmlDivision>) page.getByXPath("//div[@class='po-section J-pdOwPoSection']"); 
		Map<String, Map<String, Map<String, String>>> oneMap = new LinkedHashMap<String, Map<String, Map<String, String>>>();
		DomNodeList<DomNode> oneLevelDivs = parentDivs.get(0).getChildNodes();
		for(DomNode node : oneLevelDivs) {
			if(StringUtils.isNotBlank(node.asText())) {
				DomNodeList<DomNode> nodes = node.getChildNodes();
				boolean bc = true;
				String oneKey = "";
				
				for(DomNode n : nodes) {
					if(StringUtils.isNotBlank(n.asText())) {
						if(bc) {
							bc = false;
							String[] aa = n.asText().split("\r\n");
							oneKey = aa[0].trim();
							/*System.out.println(aa[0].trim());
							System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$");*/
							continue;
						}
						
						Map<String, Map<String, String>> twoMap = new LinkedHashMap<String, Map<String, String>>();
						DomNodeList<DomNode> dns = n.getChildNodes();
						for(DomNode n2 : dns) {
							if(StringUtils.isNotBlank(n2.asText())) {
								Map<String, String> threeMap = new LinkedHashMap<String, String>();
								DomNodeList<DomNode> lastNodes = n2.getChildNodes();
								boolean flg = true;
								String twoKey = "";
								for(DomNode n3 : lastNodes) {
									if(StringUtils.isNotBlank(n3.asText())) {
										if(flg) {
											flg = false;
											//twoKey = n3.asText().trim();
											String[] tt = n3.asText().split("\r\n");
											twoKey = tt[0];
  											//System.out.println("---------7777-------------");
											continue;
										}
										
										DomNodeList<DomNode> lnodes = n3.getChildNodes();
										for(DomNode ld : lnodes) {
											if(StringUtils.isNotBlank(ld.asText())){
												DomNodeList<DomNode> llnodes = ld.getChildNodes();
												for(DomNode ddn : llnodes) {
													if(StringUtils.isNotBlank(ddn.asText())) {
														DomNodeList<DomNode> dnns = ddn.getChildNodes();
														String[] aa = ddn.asText().split("\r\n");
														for(DomNode nd : dnns) {
															if(StringUtils.isNotBlank(nd.getNodeName())){
																if("a".equals(nd.getNodeName().trim())) {
																	NamedNodeMap map = nd.getAttributes();
																	threeMap.put(aa[0].replace(" ", ""), "https:" + map.getNamedItem("href").getTextContent().trim());
//																	System.out.println(aa[0]);
//																	System.out.println("https:" + map.getNamedItem("href").getTextContent().trim());
//																	System.out.println("=============----------------=============");
																}
															}
														}
													}
												}
												
											}
										}
									}
								}
								
								twoMap.put(twoKey, threeMap);
							}
						}
						
						oneMap.put(oneKey, twoMap);
					}
				}
			}
		}
		
		List<Object[]> datas = new ArrayList<Object[]>();
		
		for(Map.Entry<String,Map<String,Map<String,String>>> entry : oneMap.entrySet()) {
			//System.out.println("==="+entry.getKey());
			for(Map.Entry<String,Map<String,String>> twoEntry : entry.getValue().entrySet()) {
				//System.out.println("===@@@"+twoEntry.getKey());
				for(Map.Entry<String,String> threeEntry : twoEntry.getValue().entrySet()) {
					/*System.out.println("===@@@###"+threeEntry.getKey());
					System.out.println("===@@@###"+threeEntry.getValue());*/
					Object[] obj = new Object[5];
					obj[1] = entry.getKey();
					obj[2] = twoEntry.getKey();
					obj[3] = threeEntry.getKey();
					obj[4] = threeEntry.getValue();
					datas.add(obj);
				}
			}
		}
		
		String[] titles = new String[] {"序号","一级类型","二级类型","三级类型","链接"};
		ExcelHssfUtils.export("腾讯云产品类型", titles, datas);
	}
	
	
}
