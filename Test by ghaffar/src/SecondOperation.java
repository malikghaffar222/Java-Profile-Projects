
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecondOperation {
  @Value("${CAJSLR}")
  private String CAJSLR;
  
  @Value("${CRJSLAO}")
  private String CRJSLAO;
  
  @Value("${CRJSLAT}")
  private String CRJSLAT;
  
  @Value("${CRJSLAH}")
  private String CRJSLAH;
  
  @Value("${CRJSLAF}")
  private String CRJSLAF;
  
  @Value("${CRJSLAI}")
  private String CRJSLAI;
  
  @Value("${CRJSLAS}")
  private String CRJSLAS;
  
  @Value("${CRJSLAE}")
  private String CRJSLAE;
  
  @Value("${CRJSLAG}")
  private String CRJSLAG;
  
  @Value("${CRJSLAN}")
  private String CRJSLAN;
  
  @Value("${CRJSLAU}")
  private String CRJSLAU;
  
  public String OperationalEncryption(String obj) throws Exception {
    String publickey = this.CRJSLAU;
    System.out.println(publickey);
    String encrypt = RSAEncrypt.encrypt(obj, publickey);
    return encrypt;
  }
  
  public String OperationalDecrypt(String obj) throws Exception {
    String result = this.CRJSLAO + this.CRJSLAT + this.CRJSLAH + this.CRJSLAF + this.CRJSLAI + this.CRJSLAS + this.CRJSLAE + this.CRJSLAG + this.CRJSLAN;
    byte[] cajslrBytes = this.CAJSLR.getBytes();
    String key = AES_CBC.byte2hex(cajslrBytes);
    String decrypt = AES_CBC.decrypt(result, key);
    String aseDecrypt = RSAEncrypt.decrypt(obj, decrypt);
    return aseDecrypt;
  }
}
