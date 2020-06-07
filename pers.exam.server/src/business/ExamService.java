package business;

import database.DatabaseAccount;
import exam.TestPaperDTO;

import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * @author xxyWi
 * 试卷业务类
 */
public class ExamService {
    private static final String EXAM_DATABASE_CONN = "paper.txt";

    public static List<TestPaperDTO> getTestPaperList() throws IOException {
        DatabaseAccount databaseAccount = new DatabaseAccount();
        List<TestPaperDTO> testPaperList = (List<TestPaperDTO>) databaseAccount.readFile(EXAM_DATABASE_CONN);
        return testPaperList;
    }

    public static TestPaperDTO getTestPaper(int testPaperId) throws IOException {
        List<TestPaperDTO> testPaperList = getTestPaperList();
        TestPaperDTO item = testPaperList.stream().filter(testPaper -> testPaper.getId() == testPaperId).findFirst().get();
        return item;
    }

    public static TestPaperDTO randomGetTestPaper() throws IOException {
        List<TestPaperDTO> testPaperList = getTestPaperList();
        int count = testPaperList.size();
        Random random = new Random();
        int number = random.nextInt(count);
        return testPaperList.get(number);
    }

    public static boolean addTestPaper(TestPaperDTO testPaperDTO) throws IOException {
        List<TestPaperDTO> testPaperList = getTestPaperList();
        testPaperList.add(testPaperDTO);
        DatabaseAccount databaseAccount = new DatabaseAccount();
        databaseAccount.writeFile(EXAM_DATABASE_CONN, testPaperList);
        return true;
    }

    public static boolean deleteTestPaper(int testPaperId) throws IOException {
        List<TestPaperDTO> testPaperList = getTestPaperList();
        TestPaperDTO item = testPaperList.stream().filter(testPaper -> testPaper.getId() == testPaperId).findFirst().get();
        testPaperList.remove(item);
        DatabaseAccount databaseAccount = new DatabaseAccount();
        databaseAccount.writeFile(EXAM_DATABASE_CONN, testPaperList);
        return true;
    }

}
