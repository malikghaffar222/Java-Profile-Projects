
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RSAEncrypt {
  private static Logger logger = LoggerFactory.getLogger(RSAEncrypt.class);
  
  private static final String KEY_ALGORITHM = "RSA";
  
  private static final int RSA_KEY_SIZE = 1024;
  
  public static final String UTF8 = "UTF-8";
  
  private static final int MAX_ENCRYPT_BLOCK = 117;
  
  private static final int MAX_DECRYPT_BLOCK = 128;
  
  private static Map<Integer, String> keyMap = new HashMap<>();
  
  public static void main(String[] args) throws Exception {
    String MnemonicWordkey = "2000052819970417";
    byte[] bytes = "2000052819970417".getBytes();
    String key = AES_CBC.byte2hex(bytes);
    System.out.println("16+ key);
    genKeyPair();
    String message = "111111111122222222223333333333444444444455555555556666666666777777777788888888889999999999101010101010dwadwadwadawdfwafwafwafwaffwafawfawfawfwafwafawfawfawfwafwgawgagagwahghawhahzxvzxvzxvzxvjjerjer4t4wetijtrykm;illiululutyoyryeru534543hrtjtkkkyulyupo6wy4ywazrgrtryh5auzrjutyi6ytgky5oeaz4ul58756thtew waty4yta4y4y4y7 a4t346y4qa";
    System.out.println("+ (String)keyMap.get(Integer.valueOf(0)));
    System.out.println("+ (String)keyMap.get(Integer.valueOf(1)));
    String encrypt = AES_CBC.encrypt(keyMap.get(Integer.valueOf(1)), key);
    System.out.println("+ encrypt);
    String decrypt = AES_CBC.decrypt(encrypt, key);
    System.out.println("+ decrypt);
    System.out.println("===============================================================");
    String messageEn = encrypt(message, keyMap.get(Integer.valueOf(0)));
    System.out.println("+ messageEn);
    String messageDe = decrypt(messageEn, keyMap.get(Integer.valueOf(1)));
    System.out.println("+ messageDe);
    System.out.println("===============================================================");
    String enc = encryptByPrivateKey(message, keyMap.get(Integer.valueOf(1)));
    System.out.println("+ enc);
    String de = decryptByPublicKey(enc, keyMap.get(Integer.valueOf(0)));
    System.out.println("+ de);
    System.out.println("===============================================================");
    String sign = sign(message, keyMap.get(Integer.valueOf(1)));
    System.out.println("+ sign);
    boolean result = verify(message, keyMap.get(Integer.valueOf(0)), "QiGUiq8GJpBQY1Rf94W5nT//VuNre5Ge/SXtB53pxsTcYciz8Ue3kOVVTrTHfFvntLIv/v5EwrUCjePnBENfz5pZiU6sqcpKVWFBrRSKUHLq4/hadvH1KcP+UPUwoveRe8VNSrhQG3VERZkezYULhc7aBfE6ENWiqaWbS3gAVBg=");
    System.out.print("+ result);
  }
  
  public static void genKeyPair() throws NoSuchAlgorithmException {
    KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
    keyPairGen.initialize(1024, new SecureRandom());
    KeyPair keyPair = keyPairGen.generateKeyPair();
    RSAPrivateKey privateKey = (RSAPrivateKey)keyPair.getPrivate();
    RSAPublicKey publicKey = (RSAPublicKey)keyPair.getPublic();
    String publicKeyString = new String(Base64.encodeBase64(publicKey.getEncoded()));
    String privateKeyString = new String(Base64.encodeBase64(privateKey.getEncoded()));
    keyMap.put(Integer.valueOf(0), publicKeyString);
    keyMap.put(Integer.valueOf(1), privateKeyString);
  }
  
  public static String encrypt(String str, String publicKey) throws Exception {
    byte[] decoded = Base64.decodeBase64(publicKey);
    RSAPublicKey pubKey = (RSAPublicKey)KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
    Cipher cipher = Cipher.getInstance("RSA");
    cipher.init(1, pubKey);
    int inputLen = (str.getBytes("UTF-8")).length;
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    int offset = 0;
    int i = 0;
    while (inputLen - offset > 0) {
      byte[] cache;
      if (inputLen - offset > 117) {
        cache = cipher.doFinal(str.getBytes("UTF-8"), offset, 117);
      } else {
        cache = cipher.doFinal(str.getBytes("UTF-8"), offset, inputLen - offset);
      } 
      out.write(cache, 0, cache.length);
      i++;
      offset = i * 117;
    } 
    byte[] encryptedData = out.toByteArray();
    out.close();
    String outStr = Base64.encodeBase64String(encryptedData);
    return outStr;
  }
  
  public static String decrypt(String str, String privateKey) throws Exception {
    byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
    byte[] decoded = Base64.decodeBase64(privateKey);
    RSAPrivateKey priKey = (RSAPrivateKey)KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
    Cipher cipher = Cipher.getInstance("RSA");
    cipher.init(2, priKey);
    int inputLen = inputByte.length;
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    int offset = 0;
    int i = 0;
    while (inputLen - offset > 0) {
      byte[] cache;
      if (inputLen - offset > 128) {
        cache = cipher.doFinal(inputByte, offset, 128);
      } else {
        cache = cipher.doFinal(inputByte, offset, inputLen - offset);
      } 
      out.write(cache, 0, cache.length);
      i++;
      offset = i * 128;
    } 
    byte[] decryptedData = out.toByteArray();
    out.close();
    String outStr = new String(decryptedData);
    return outStr;
  }
  
  public static String encryptByPrivateKey(String data, String privateKey) {
    try {
      byte[] kb = Base64.decodeBase64(privateKey.getBytes("UTF-8"));
      PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(kb);
      KeyFactory keyFactory = KeyFactory.getInstance("RSA");
      PrivateKey key = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
      Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
      cipher.init(1, key);
      int inputLen = (data.getBytes("UTF-8")).length;
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      int offset = 0;
      int i = 0;
      while (inputLen - offset > 0) {
        byte[] cache;
        if (inputLen - offset > 117) {
          cache = cipher.doFinal(data.getBytes("UTF-8"), offset, 117);
        } else {
          cache = cipher.doFinal(data.getBytes("UTF-8"), offset, inputLen - offset);
        } 
        out.write(cache, 0, cache.length);
        i++;
        offset = i * 117;
      } 
      byte[] encryptedData = out.toByteArray();
      out.close();
      String outStr = Base64.encodeBase64String(encryptedData);
      return outStr;
    } catch (Exception e) {
      logger.error("Failed to encryptByPrivateKey data.", e);
      throw new RuntimeException();
    } 
  }
  
  public static String decryptByPublicKey(String data, String publicKey) {
    try {
      byte[] inputByte = Base64.decodeBase64(data.getBytes("UTF-8"));
      byte[] kb = Base64.decodeBase64(publicKey.getBytes("UTF-8"));
      X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(kb);
      KeyFactory keyFactory = KeyFactory.getInstance("RSA");
      PublicKey key = keyFactory.generatePublic(x509EncodedKeySpec);
      Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
      cipher.init(2, key);
      int inputLen = inputByte.length;
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      int offset = 0;
      int i = 0;
      while (inputLen - offset > 0) {
        byte[] cache;
        if (inputLen - offset > 128) {
          cache = cipher.doFinal(inputByte, offset, 128);
        } else {
          cache = cipher.doFinal(inputByte, offset, inputLen - offset);
        } 
        out.write(cache, 0, cache.length);
        i++;
        offset = i * 128;
      } 
      byte[] decryptedData = out.toByteArray();
      out.close();
      String outStr = new String(decryptedData);
      return outStr;
    } catch (Exception e) {
      logger.error("Failed to decryptByPublicKey data.", e);
      throw new RuntimeException();
    } 
  }
  
  public static String sign(String data, String privateKey) throws Exception {
    byte[] kb = Base64.decodeBase64(privateKey.getBytes("UTF-8"));
    PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(kb);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    PrivateKey key = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
    Signature signature = Signature.getInstance("MD5withRSA");
    signature.initSign(key);
    signature.update(data.getBytes());
    return new String(Base64.encodeBase64(signature.sign()));
  }
  
  public static boolean verify(String srcData, String publicKey, String sign) throws Exception {
    byte[] kb = Base64.decodeBase64(publicKey.getBytes("UTF-8"));
    X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(kb);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    PublicKey key = keyFactory.generatePublic(x509EncodedKeySpec);
    Signature signature = Signature.getInstance("MD5withRSA");
    signature.initVerify(key);
    signature.update(srcData.getBytes());
    return signature.verify(Base64.decodeBase64(sign.getBytes()));
  }
}
