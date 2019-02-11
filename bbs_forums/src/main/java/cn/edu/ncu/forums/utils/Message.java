package cn.edu.ncu.forums.utils;

/**
 * Description: http请求返回值
 *
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2018/12/14 23:04
 * @version : 1.0
 */
public class Message {
    private int status;
    private String message;
    private Object result;

    public Message() {
    }

    public Message(int status, String message, Object result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Message{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }
}
