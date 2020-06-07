package test;

import business.ExamService;
import business.UserAccountService;
import database.DatabaseInit;
import exam.TestPaperDTO;
import user.UserAccountDTO;
import user.UserAccountType;

import java.io.IOException;
import java.util.List;

/**
 * @author xxyWi
 * 测试类
 */
public class TestMain {
    public static void main(String[] args) throws IOException {
        DatabaseInit.Init();


        UserAccountDTO userAccountDTO = new UserAccountDTO();
        userAccountDTO.setUserAccountType(UserAccountType.Student);
        userAccountDTO.setUserName("a");
        userAccountDTO.setPassword("a");
        UserAccountService.Login(userAccountDTO);


        List<TestPaperDTO> testPaperList = ExamService.getTestPaperList();
        TestPaperDTO testPaperDTO = ExamService.randomGetTestPaper();
        TestPaperDTO testPaper = ExamService.getTestPaper(1);


    }
}
