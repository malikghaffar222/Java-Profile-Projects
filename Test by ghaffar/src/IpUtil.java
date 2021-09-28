
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;

public class IpUtil {
  public static final String ERROR_IP = "127.0.0.1";
  
  public static final Pattern pattern = Pattern.compile("(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})");
  
  public static boolean isValidIP(HttpServletRequest request) {
    String ip = getUserIP(request);
    return isValidIP(ip);
  }
  
  public static String getRemoteIp(HttpServletRequest request) {
    String ip = request.getHeader("x-real-ip");
    if (ip == null)
      ip = request.getRemoteAddr(); 
    String[] stemps = ip.split(",");
    if (stemps != null && stemps.length >= 1)
      ip = stemps[0]; 
    ip = ip.trim();
    if (ip.length() > 23)
      ip = ip.substring(0, 23); 
    return ip;
  }
  
  public static String getUserIP(HttpServletRequest request) {
    String ip = request.getHeader("X-Real-IP");
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
      ip = request.getHeader("x-forwarded-for"); 
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getRemoteAddr();
      if ("0:0:0:0:0:0:0:1".equals(ip))
        ip = "127.0.0.1"; 
    } 
    if ("unknown".equalsIgnoreCase(ip)) {
      ip = "127.0.0.1";
      return ip;
    } 
    int index = ip.indexOf(',');
    if (index >= 0)
      ip = ip.substring(0, index); 
    return ip;
  }
  
  public static String getLastIpSegment(HttpServletRequest request) {
    String ip = getUserIP(request);
    if (ip != null) {
      ip = ip.substring(ip.lastIndexOf('.') + 1);
    } else {
      ip = "0";
    } 
    return ip;
  }
  
  public static boolean isValidIP(String ip) {
    if (StringUtils.isEmpty(ip))
      return false; 
    Matcher matcher = pattern.matcher(ip);
    boolean isValid = matcher.matches();
    return isValid;
  }
  
  public static String getLastServerIpSegment() {
    String ip = getServerIP();
    if (ip != null) {
      ip = ip.substring(ip.lastIndexOf('.') + 1);
    } else {
      ip = "0";
    } 
    return ip;
  }
  
  public static String getServerIP() {
    try {
      InetAddress inetAddress = InetAddress.getLocalHost();
      String hostAddress = inetAddress.getHostAddress();
      return hostAddress;
    } catch (UnknownHostException e) {
      e.printStackTrace();
      return "127.0.0.1";
    } 
  }
  
  public static String getIpAddress(HttpServletRequest request) {
    String ip = null;
    try {
      String Xip = request.getHeader("X-Real-IP");
      String XFor = request.getHeader("X-Forwarded-For");
      if (StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)) {
        int index = XFor.indexOf(",");
        if (index >= 0)
          return XFor.substring(0, index); 
        return XFor;
      } 
      ip = Xip;
      if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip))
        ip = request.getHeader("Proxy-Client-IP"); 
      if (StringUtils.isEmpty(ip) || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        ip = request.getHeader("WL-Proxy-Client-IP"); 
      if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip))
        ip = request.getHeader("HTTP_CLIENT_IP"); 
      if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip))
        ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
      if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip))
        ip = request.getRemoteAddr(); 
    } catch (Exception e) {
      e.printStackTrace();
    } 
    return ip;
  }
}
