
import java.util.ArrayList;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import net.sf.json.JSONArray;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AES_CBC {
  private static final Logger LOGGER = LoggerFactory.getLogger(AES_CBC.class);
  
  private static final String ENCODING = "GBK";
  
  private static final String KEY_ALGORITHM = "AES";
  
  private static final String DEFAULT_CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";
  
  private static final String FILL_VECTOR = "1997041720000528";
  
  public static String encrypt(String content, String password) {
    if (StringUtils.isAnyEmpty(new CharSequence[] { content, password })) {
      LOGGER.error("AES encryption params is null");
      return null;
    } 
    byte[] raw = hex2byte(password);
    SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
    Cipher cipher = null;
    try {
      cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      IvParameterSpec iv = new IvParameterSpec("1997041720000528".getBytes());
      cipher.init(1, skeySpec, iv);
      byte[] anslBytes = content.getBytes("GBK");
      byte[] encrypted = cipher.doFinal(anslBytes);
      return byte2hex(encrypted).toUpperCase();
    } catch (Exception e) {
      LOGGER.error("AES encryption operation has exception,content:{},password:{}", new Object[] { content, password, e });
      return null;
    } 
  }
  
  public static String decrypt(String content, String password) {
    if (StringUtils.isAnyEmpty(new CharSequence[] { content, password })) {
      LOGGER.error("AES decryption params is null");
      return null;
    } 
    try {
      byte[] raw = hex2byte(password);
      SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      IvParameterSpec iv = new IvParameterSpec("1997041720000528".getBytes());
      cipher.init(2, skeySpec, iv);
      byte[] encrypted1 = hex2byte(content);
      byte[] original = cipher.doFinal(encrypted1);
      return new String(original, "GBK");
    } catch (Exception e) {
      LOGGER.error("AES decryption operation has exception,content:{},password:{}", new Object[] { content, password, e });
      return null;
    } 
  }
  
  public static byte[] hex2byte(String strhex) {
    if (strhex == null)
      return null; 
    int l = strhex.length();
    if (l % 2 == 1)
      return null; 
    byte[] b = new byte[l / 2];
    for (int i = 0; i != l / 2; i++)
      b[i] = (byte)Integer.parseInt(strhex.substring(i * 2, i * 2 + 2), 16); 
    return b;
  }
  
  public static String byte2hex(byte[] b) {
    String hs = "";
    String stmp = "";
    for (int n = 0; n < b.length; n++) {
      stmp = Integer.toHexString(b[n] & 0xFF);
      if (stmp.length() == 1) {
        hs = hs + "0" + stmp;
      } else {
        hs = hs + stmp;
      } 
    } 
    return hs.toUpperCase();
  }
  
  public static void mainaaaaaaa(String[] args) throws Exception {
    String MnemonicWordkey = "2000052819970417";
    String WalletKey = "1997041720000528";
    List<String> weijiami = new ArrayList<>();
    weijiami.add("kind");
    weijiami.add("enable");
    weijiami.add("hollow");
    weijiami.add("much");
    weijiami.add("small");
    weijiami.add("globe");
    weijiami.add("carpet");
    weijiami.add("name");
    weijiami.add("mountain");
    weijiami.add("nephew");
    weijiami.add("patient");
    weijiami.add("seven");
    List<String> jiaami = new ArrayList<>();
    for (String jiami : weijiami) {
      byte[] bytes = "2000052819970417".getBytes();
      String key2 = byte2hex(bytes);
      String encryptStr = encrypt(jiami, key2);
      jiaami.add(encryptStr);
    } 
    System.out.println(JSONArray.fromObject(jiaami));
  }
  
  public static void main(String[] args) {
    String MnemonicWordkey = "2000052819970417";
    byte[] bytes = "2000052819970417".getBytes();
    String key = byte2hex(bytes);
    System.out.println(16+ key);
    String encrypt = encrypt("MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKv/UnvY1jo/+vOJMXhLkPpnrGwQQwnpypbFB/TCa+iNlVXS7OueHmHWHveOW64gRua1ObfJgp+D2dPwYU3wnj6JQGTtHXMmK0WdjZoEUYk+PWNVN7cmpin0t+hH7ryCxRL1j7iPfSrwD78rVhz5tri/98HW7zdipnj9Mff5/q5zAgMBAAECgYASb8b2sZKdIdiTnGQqIeeDf/Nyjfexq1bk/G/S47hPcEXOslJlG0jkceBV5vOa4ajX+BscwUP4N1j1J/I2OZGss08jaLsTPcwIw+dvglPqKvj4efkMtPG0YhE76sW3ZzLO//HZw4I6A9iNX1LexWG9KjmE5P8gtalj9tG3JYiweQJBAOEFxDcDaqD6EIVOAH547nwZuuhQDaM5th8H7KLapo0dcBjBVAQyQVSU2R/yhIGhqiiDCnG4sMP7Lx2f0EAoHhUCQQDDrNhTVAMrBsTuQsFJ9SgLmZDG7qJVrMJpEea6MPoxxnVR5cMh8PTUICbgx8TrEoXK2YI1cAp41uLPSxiOqURnAkBvPvqSeA3vJ7GjNbzoycCdedr9nxYe7Bktni1PFenhOfyBQJLYwD+sISp2sN7xd4s4HBC9yCEbwsK4UpoSHcNBAkADxiGl+cjV25uQvNjdhEzxbFTOgWvAG0TkoePBU5B/xUQeAEBzNyKBtN0LGM9DeWf7MZbBURfinMJjHR+sILehAkEAtQK93mU2brpXErjLyHiOGN74Y6/36nU9Sfrp2tGIy1nK4YmDKEojJ9HBQfIIducw69xdMEOgiyDExJQgSo+BGg==", key);
    System.out.println(""+ encrypt);
    String decrypt = decrypt(encrypt, key);
    System.out.println(""+ decrypt);
  }
  
  public static void mainaaaa(String[] args) {
    String privateKEY = "3BDD40128C1E0D66169AA85A197E1359C51D6AF91895D0DED98F7F6F87F2C6F85A43110128BA9EB1EC1591DCFEC7CFBE041384AA5CA6C7D0974742CDAFC21BF155FED7BC30D15FF30C4590652944B3CD0CFD64DB6D253571F3B967ABAA5E9C73CFB4D4D517D1AF692BD4B813D029AE591BF69D3B8A91363CDA6B96DB0842B133";
    String WalletKey = "200005281997417";
    String byte2hex = byte2hex(WalletKey.getBytes());
  }
}
