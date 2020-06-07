package mainpage;

import business.UserAccountService;
import user.UserAccountDTO;
import user.UserAccountType;
import util.ClientScanner;

/**
 * @author xxyWi
 * 管理员主页面
 */
public class AdminMainPage {
    String inputText;
    UserAccountDTO userAccountDTO = new UserAccountDTO(UserAccountType.Admin);

    public int start() {
        return mainPage();
    }

    private int mainPage() {
        if (HelpPage.LoginPage(userAccountDTO) == 0) {
            return 0;
        }
        System.out.println("欢迎进入管理员系统,输入序号进行相应的操作！");
        System.out.println("[1] 学员管理系统");
        System.out.println("[2] 试卷管理系统");
        System.out.print("请输入:");
        inputText = ClientScanner.getNextLine();
        switch (inputText) {
            case "1":
                return new StudentManagerPage().start();
            case "2":
                return new TestPaperManagerPage().start();
            case "0":
            default:
                return 0;
        }
    }
}
