package mainpage;

import business.UserAccountService;
import user.UserAccountDTO;
import user.UserAccountType;
import util.ClientScanner;

/**
 * @author xxyWi
 * 帮助页面
 */
public class HelpPage {
    public static int LoginPage(UserAccountDTO userAccountDTO) {
        System.out.println("请输入账号：");
        var inputText = ClientScanner.getNextLine();
        userAccountDTO.setUserAccountType(UserAccountType.Student);
        userAccountDTO.setUserName(inputText);
        System.out.println("请输入密码：");
        inputText = ClientScanner.getNextLine();
        userAccountDTO.setPassword(inputText);
        if (UserAccountService.login(userAccountDTO)) {
            System.out.println("登录成功");
            return 1;
        } else {
            System.out.println("登录失败,用户名或密码错误!");
            return 0;
        }
    }
}
