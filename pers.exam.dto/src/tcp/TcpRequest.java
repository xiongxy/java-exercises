package tcp;

import java.io.Serializable;

/**
 * @author xxyWi
 * Tcp请求类
 */
public class TcpRequest implements Serializable {
    private String prefix;
    private Object content;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public TcpRequest(String prefix, Object content) {
        this.prefix = prefix;
        this.content = content;
    }
}
