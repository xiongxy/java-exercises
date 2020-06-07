package tcp;

import java.io.Serializable;

/**
 * @author xxyWi
 * Tcp响应类
 */
public class TcpResponse implements Serializable {

    private String state;
    private Object content;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }


    public TcpResponse(String state) {
        this.state = state;
    }

    public TcpResponse(String state, Object content) {
        this.state = state;
        this.content = content;
    }

    public boolean judgeSuccess() {
        return "200".equals(state);
    }

    public static TcpResponse NotFound() {
        return new TcpResponse("404");
    }
}
