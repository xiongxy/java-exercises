package learn.java.exercises.stageone.modulefour.tcptitle;


import java.io.Serializable;

/**
 * @author xxyWi
 */
public class UserMessage implements Serializable {

    static final long serialVersionUID = -18555229948L;

    private String type;
    private User user;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserMessage(String type, User user) {
        this.type = type;
        this.user = user;
    }
}
