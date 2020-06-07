package mainpage;

import business.ExamService;
import business.UserAccountService;
import exam.TestPaperDTO;
import user.UserAccountDTO;
import user.UserAccountType;
import util.ClientScanner;

import java.io.IOException;
import java.util.List;

/**
 * @author xxyWi
 * 学员主页面
 */
public class StudentMainPage {
    String inputText;
    UserAccountDTO userAccountDTO = new UserAccountDTO(UserAccountType.Student);

    public int start() throws IOException {
        return mainPage();
    }

    private int mainPage() throws IOException {
        if (HelpPage.LoginPage(userAccountDTO) == 0) {
            return 0;
        }
        System.out.println("欢迎进入学员系统,输入序号进行相应的操作！");
        System.out.println("[1] 修改密码");
        System.out.println("[2] 开始考试");
        System.out.print("请输入:");
        inputText = ClientScanner.getNextLine();
        switch (inputText) {
            case "1":
                editPasswordPage();
                return 1;
            case "2":
                startExamPage();
                return 1;
            default:
                return 0;
        }
    }

    private void editPasswordPage() {
        System.out.print("请输入修改后的密码：");
        inputText = ClientScanner.getNextLine();
        userAccountDTO.setPassword(inputText);
        UserAccountService.editPassword(userAccountDTO);
    }

    private void startExamPage() throws IOException {
        System.out.println("获取试卷中...");
        TestPaperDTO testPaperDTO = ExamService.randomGetTestPaper();
        System.out.println("试卷名称:" + testPaperDTO.getPaperTitle());
        List<TestPaperDTO.TestPaperItem> items = testPaperDTO.getItems();
        for (TestPaperDTO.TestPaperItem item : items) {
            System.out.println("题目：" + item.getTitle());
            item.getItems().stream().forEach(selectItem -> {
                System.out.println(selectItem.getOption() + ":" + selectItem.getContent());
            });
            System.out.print("请输入答案：");
            var currentAnswer = ClientScanner.getNextLine();
            System.out.println("你的答案：" + currentAnswer + ";回答" + (currentAnswer.equals(item.getAnswer()) ? "正确" : "错误"));
        }
    }
}
