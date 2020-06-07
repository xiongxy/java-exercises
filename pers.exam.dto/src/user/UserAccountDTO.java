package user;

import java.io.Serializable;

/**
 * @author xxyWi
 * 用户传输类
 */
public class UserAccountDTO implements Serializable {

    private UserAccountType userAccountType;
    private String userName;
    private String password;


    public UserAccountType getUserAccountType() {
        return userAccountType;
    }

    public void setUserAccountType(UserAccountType userAccountType) {
        this.userAccountType = userAccountType;
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

    @Override
    public String toString() {
        return "User.UserAccountDTO{" +
                "userAccountType=" + userAccountType +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    public UserAccountDTO() {
    }

    public UserAccountDTO(UserAccountType userAccountType) {
        this.userAccountType = userAccountType;
    }

    public UserAccountDTO(UserAccountType userAccountType, String userName, String password) {
        this.userAccountType = userAccountType;
        this.userName = userName;
        this.password = password;
    }
}
