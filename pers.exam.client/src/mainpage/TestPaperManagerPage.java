package mainpage;

import user.UserAccountDTO;
import util.ClientScanner;

/**
 * @author xxyWi
 * 试卷管理主页面
 */
public class TestPaperManagerPage {
    String inputText;
    UserAccountDTO userAccountDTO = new UserAccountDTO();

    public int start() {
        return mainPage();
    }

    private int mainPage() {
        System.out.println("欢迎进入试卷管理系统,输入序号进行相应的操作！");
        System.out.println("[1] 查看所有试卷");
        System.out.println("[2] 查看试卷详细信息");
        System.out.println("[3] 增加试卷");
        System.out.println("[4] 删除试卷");
        System.out.print("请输入:");
        inputText = ClientScanner.getNextLine();
        switch (inputText) {
            case "0":
            default:
                return 0;
        }
    }
}
