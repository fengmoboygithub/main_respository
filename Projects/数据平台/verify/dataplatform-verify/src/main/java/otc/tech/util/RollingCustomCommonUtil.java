package otc.tech.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Random;


public class RollingCustomCommonUtil {
	
	public static String getRandomNum() {
		Random random = new Random();
		return (random.nextInt(9999)+ 1000) + "";
	}

	/**
     * 获取本地IP地址
     *
     * @throws SocketException
     */
    public static String getLocalIP() {
    	String ip = "";
        if (isWindowsOS()) {
            try {
            	ip = InetAddress.getLocalHost().getHostAddress();
			} catch (UnknownHostException e) {
//				e.printStackTrace();
				//LogLog.error(e.getMessage(), e);
			}
        } else {
        	ip = getLinuxLocalIp();
        }
        return ip;
    }
    
    
    /**
     * 判断操作系统是否是Windows
     *
     * @return
     */
    public static boolean isWindowsOS() {
        boolean isWindowsOS = false;
        String osName = System.getProperty("os.name");
        if (osName.toLowerCase().indexOf("windows") > -1) {
            isWindowsOS = true;
        }
        return isWindowsOS;
    }
 
    /**
     * 获取Linux下的IP地址
     *
     * @return IP地址
     * @throws SocketException
     */
    public static String getLinuxLocalIp() {
        String ip = "";
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                String name = intf.getName();
                if (!name.contains("docker") && !name.contains("lo")) {
                    for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                        InetAddress inetAddress = enumIpAddr.nextElement();
                        if (!inetAddress.isLoopbackAddress()) {
                            String ipaddress = inetAddress.getHostAddress().toString();
                            if (!ipaddress.contains("::") && !ipaddress.contains("0:0:") && !ipaddress.contains("fe80")) {
                                ip = ipaddress;
                                System.out.println(ipaddress);
                            }
                        }
                    }
                }
            }
        } catch (SocketException ex) {
            ip = "linux_127.0.0.1";
           // LogLog.error(ex.getMessage(), ex);
        }
        return ip;
    }
    
}
