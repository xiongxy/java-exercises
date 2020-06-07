package business;

import tcp.TcpResponse;
import user.UserAccountDTO;
import util.TcpPackage;

/**
 * @author xxyWi
 * 账户服务类
 */
public class UserAccountService {

    public static boolean login(UserAccountDTO userAccountDTO) {
        TcpResponse tcpResponse = TcpPackage.send("login", userAccountDTO);
        assert tcpResponse != null;
        return tcpResponse.getState().equals("200");
    }

    public static boolean editPassword(UserAccountDTO userAccountDTO) {
        TcpResponse tcpResponse = TcpPackage.send("editPassword", userAccountDTO);
        assert tcpResponse != null;
        return tcpResponse.getState().equals("200");
    }
}
