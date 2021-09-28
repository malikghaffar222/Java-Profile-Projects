
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.UUID;

public class appIdUtils {
  private static final String SERVER_NAME = "caojiale_cjl528";
  
  private static final String[] chars = new String[] { 
      "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", 
      "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", 
      "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", 
      "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", 
      "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", 
      "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", 
      "Y", "Z" };
  
  public static String getAppId() {
    StringBuffer shortBuffer = new StringBuffer();
    String uuid = UUID.randomUUID().toString().replace("-", "");
    for (int i = 0; i < 8; i++) {
      String str = uuid.substring(i * 4, i * 4 + 4);
      int x = Integer.parseInt(str, 16);
      shortBuffer.append(chars[x % 62]);
    } 
    return shortBuffer.toString();
  }
  
  public static String getAppSecret(String appId) {
    try {
      String[] array = { appId, "caojiale_cjl528" };
      StringBuffer sb = new StringBuffer();
      Arrays.sort((Object[])array);
      for (int i = 0; i < array.length; i++)
        sb.append(array[i]); 
      String str = sb.toString();
      MessageDigest md = MessageDigest.getInstance("SHA-1");
      md.update(str.getBytes());
      byte[] digest = md.digest();
      StringBuffer hexstr = new StringBuffer();
      String shaHex = "";
      for (int j = 0; j < digest.length; j++) {
        shaHex = Integer.toHexString(digest[j] & 0xFF);
        if (shaHex.length() < 2)
          hexstr.append(0); 
        hexstr.append(shaHex);
      } 
      return hexstr.toString();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
      throw new RuntimeException();
    } 
  }
  
  public static void main(String[] args) {
    String appId = getAppId();
    String appSecret = getAppSecret(appId);
    System.out.println("appId: " + appId);
    System.out.println("appSecret: " + appSecret);
  }
}
