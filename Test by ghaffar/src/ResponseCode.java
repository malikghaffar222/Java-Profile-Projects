
public enum ResponseCode {
  OK(Integer.valueOf(1), "),
  OkLOGIN(Integer.valueOf(2), "),
  FAIL(Integer.valueOf(-1), "),
  APPID(Integer.valueOf(-2), "APPID),
  APPIDKEY(Integer.valueOf(-3), "),
  TIME(Integer.valueOf(-4), "),
  NONCE(Integer.valueOf(-5), "nonce),
  ERRORPARAMETER(Integer.valueOf(-6), "),
  ERROECODE(Integer.valueOf(-7), "),
  Custom(Integer.valueOf(-8), ");
  
  public Integer code;
  
  public String msg;
  
  public static ResponseCode RetuenValue(String smg) {
    Custom.msg = smg;
    return Custom;
  }
  
  ResponseCode(Integer code, String msg) {
    this.code = code;
    this.msg = msg;
  }
}
