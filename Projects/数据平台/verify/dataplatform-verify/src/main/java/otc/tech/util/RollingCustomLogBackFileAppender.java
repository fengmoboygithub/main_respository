package otc.tech.util;

//import org.springframework.beans.factory.annotation.Value;

import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy;

/**
 * 自定义slf4j配置文件
 * 
 * @author zzjs
 *
 */
public class RollingCustomLogBackFileAppender<E> extends TimeBasedRollingPolicy<E> {

    /*public void setFile(String file) {
		String val = file.trim();
		String configFileName = val.substring(val.lastIndexOf("/")+1, val.length());
		String fianlFileName = val.substring(0, val.lastIndexOf("/")+1) + configFileName.substring(0, configFileName.lastIndexOf(".") != -1 
				? configFileName.lastIndexOf(".") 
						: configFileName.length())
				+ "_" + getLocalIP() 
				+ configFileName.substring(configFileName.lastIndexOf(".") != -1 
				? configFileName.lastIndexOf(".") 
						: configFileName.length(), configFileName.length());
	}*/
    
    static final String FNP_NOT_SET = "The FileNamePattern option must be set before using TimeBasedRollingPolicy. ";
    
    @Override
	public void start() {
		if (fileNamePatternStr != null) {
			String val = fileNamePatternStr.trim();
			String path = val.substring(0, val.lastIndexOf("/") + 1);
			String configFileName = val.substring(val.lastIndexOf("/") + 1, val.length());
			//前缀
			String prefix = configFileName.substring(0, configFileName.indexOf("%")!=-1 ? configFileName.indexOf("%") : configFileName.length());
			//格式化
			String middle = configFileName.substring(configFileName.indexOf("%"), configFileName.indexOf(".")!=-1 ? configFileName.indexOf(".") : configFileName.length());
			//后缀
			String suffix = configFileName.substring(configFileName.lastIndexOf(".") != -1 ? configFileName.lastIndexOf(".") : 0, configFileName.length());
			fileNamePatternStr = path + prefix
					+ RollingCustomCommonUtil.getLocalIP() + "_" + RollingCustomCommonUtil.getRandomNum() + "_" + middle + suffix;
			
		} else {
			addWarn(FNP_NOT_SET);
			addWarn(CoreConstants.SEE_FNP_NOT_SET);
			throw new IllegalStateException(FNP_NOT_SET + CoreConstants.SEE_FNP_NOT_SET);
		}
		super.start();
	}
    
    /*@Override
    public void setFileNamePattern(String fnp) {
    	String slf4jpathLocal = ResourceUtil.getRealPath("slf4jpath");
    	fileNamePatternStr = slf4jpathLocal;
    }*/
    
    public static void main(String[] args) {
		String val = "/log/reportsys_log/reportsys_slf4j_%d{yyyyMMdd}.log";
		String path = val.substring(0, val.lastIndexOf("/") + 1);
		String configFileName = val.substring(val.lastIndexOf("/") + 1, val.length());
		//前缀
		String prefix = configFileName.substring(0, configFileName.indexOf("%")!=-1 ? configFileName.indexOf("%") : configFileName.length());
		//格式化
		String middle = configFileName.substring(configFileName.indexOf("%"), configFileName.indexOf(".")!=-1 ? configFileName.indexOf(".") : configFileName.length());
		//后缀
		String suffix = configFileName.substring(configFileName.lastIndexOf(".") != -1 ? configFileName.lastIndexOf(".") : 0, configFileName.length());
		System.out.println(path);
		System.out.println(configFileName);
		System.out.println(prefix);
		System.out.println(middle);
		System.out.println(suffix);
		String fileNamePatternStr = path + prefix
				+ RollingCustomCommonUtil.getLocalIP() + "_" + middle + suffix;
		
//		String fileNamePatternStr = val.substring(0, val.lastIndexOf("/") + 1)
//				+ configFileName.substring(0,
//						configFileName.lastIndexOf(".") != -1 ? configFileName.lastIndexOf(".")
//								: configFileName.length())
//				+ "_" + rollCL.getLocalIP()
//				+ configFileName.substring(configFileName.lastIndexOf(".") != -1 ? configFileName.lastIndexOf(".")
//						: configFileName.length(), configFileName.length());
		System.out.println(fileNamePatternStr);
		
	}

}
