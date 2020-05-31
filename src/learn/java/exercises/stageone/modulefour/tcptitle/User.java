package learn.java.exercises.stageone.modulefour.tcptitle;

import java.io.Serializable;

public class User implements Serializable {

    static final long serialVersionUID = -187516993124229948L;

    private String userName;
    private String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
