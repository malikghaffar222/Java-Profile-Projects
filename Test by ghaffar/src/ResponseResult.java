
import java.io.Serializable;

public class ResponseResult<T> implements Serializable {
  private Integer status;
  
  private T data;
  
  private String msg;
  
  private final long timestamps = System.currentTimeMillis();
  
  private static final long serialVersionUID = 8992436576262574064L;
  
  public Integer getStatus() {
    return this.status;
  }
  
  public void setStatus(Integer status) {
    this.status = status;
  }
  
  public T getData() {
    return this.data;
  }
  
  public void setData(T data) {
    this.data = data;
  }
  
  public String getMsg() {
    return this.msg;
  }
  
  public void setMsg(String msg) {
    this.msg = msg;
  }
  
  public static synchronized <T> ResponseResult<T> e(ResponseCode statusEnum) {
    return e(statusEnum, null);
  }
  
  public static synchronized <T> ResponseResult<T> e(ResponseCode statusEnum, T data) {
    ResponseResult<T> res = new ResponseResult<>();
    res.setStatus(statusEnum.code);
    res.setMsg(statusEnum.msg);
    res.setData(data);
    return res;
  }
}
