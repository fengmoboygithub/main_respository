package com.company.cloud;

import com.company.utils.PageUtils;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlParagraph;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        HtmlPage page = PageUtils.fetchPage("https://www.aliyun.com/product/alinux");
        List<HtmlParagraph> parentDivs = (List<HtmlParagraph>) page.getByXPath("//p[@class='info']");
        String desc = "  ";
        if(parentDivs != null && parentDivs.size() > 0){
            desc = parentDivs.get(0).asText();
        }
        System.out.println(desc);
    }
}
