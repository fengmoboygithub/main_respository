package com.company.utils;

/**
 * 代码模板Util类
 * @author yangyanchao
 *
 */
public class CodeTempUtil {
	/**
	 * 得到HTML模板
	 * @return
	 */
	public static String getHtmlTemplate(String codeName, String bodyCode, String mediaFileCode, String jsCode) {
		String allHtmlCode = "";
		allHtmlCode += "\n<!--"+codeName+"HTML代码开始-->\n";
		allHtmlCode += "<!doctype html>\n";
		allHtmlCode += "<html lang=\"en\">\n";
		allHtmlCode += " <head>\n";
		allHtmlCode += "  <meta charset=\"UTF-8\">\n";
		allHtmlCode += "  <meta name=\"Generator\" content=\"\">\n";
		allHtmlCode += "  <meta name=\"Author\" content=\"\">\n";
		allHtmlCode += "  <meta name=\"Keywords\" content=\"\">\n";
		allHtmlCode += "  <meta name=\"Description\" content=\"\">\n";
		allHtmlCode += "  <title>测试"+codeName+"</title>\n";
		if(mediaFileCode != null && mediaFileCode.length() > 0){
			allHtmlCode += "  "+mediaFileCode+"\n";
		}
		allHtmlCode += " </head>\n";
		allHtmlCode += " <body>\n";
		if(bodyCode != null && bodyCode.length() > 0){
			allHtmlCode += ("\n" + bodyCode + "\n");
		}
		if(jsCode != null && jsCode.length() > 0){
			allHtmlCode += (jsCode);
		}
		allHtmlCode += " </body>\n";
		allHtmlCode += "</html>\n";
		allHtmlCode += "\n<!--"+codeName+"HTML代码结束-->\n";
		return allHtmlCode;
	}
	
	/**
	 * 得到JS模板
	 * @return
	 */
	public static String getJsTemplate(String codeName, String bodyCode) {
		String allJsCode = "";
		allJsCode += "\n////////////////////////"+codeName+"--JS代码开始////////////////////////\n";
		if(bodyCode != null && bodyCode.length() > 0){
			allJsCode += ("\n" + bodyCode + "\n");
		}
		allJsCode += "\n////////////////////////"+codeName+"--JS代码结束////////////////////////\n";
		return allJsCode;
	}
	
	/**
	 * 得到数据源模板
	 * @return
	 */
	public static String getJsonTemplate(String codeEnName,String codeName, String bodyCode) {
		String allJsCode = "";
		allJsCode += "\n\t//"+codeName+"\n\tvar "+codeEnName+" = ";
		if(bodyCode != null && bodyCode.length() > 0){
			allJsCode += "function(){\n "+bodyCode+";\n}()";
		} else {
			allJsCode += "function(){return [];}()";
		}
		allJsCode += ";";
		return allJsCode;
	}
}
