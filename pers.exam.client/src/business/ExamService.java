package business;

import exam.TestPaperDTO;
import student.StudentDTO;
import tcp.TcpResponse;
import util.TcpPackage;

import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * @author xxyWi
 * 试卷服务类
 */
public class ExamService {

    public static List<TestPaperDTO> getTestPaperList() throws IOException {
        TcpResponse tcpResponse = TcpPackage.send("getTestPaperList", null);
        return (List<TestPaperDTO>) tcpResponse.getContent();
    }

    public static TestPaperDTO getTestPaper(int testPaperId) throws IOException {
        TcpResponse tcpResponse = TcpPackage.send("getTestPaper", testPaperId);
        return (TestPaperDTO) tcpResponse.getContent();
    }

    public static TestPaperDTO randomGetTestPaper() throws IOException {
        TcpResponse tcpResponse = TcpPackage.send("randomGetTestPaper", null);
        return (TestPaperDTO) tcpResponse.getContent();
    }

    public static boolean addTestPaper(TestPaperDTO testPaperDTO) throws IOException {
        TcpResponse tcpResponse = TcpPackage.send("addTestPaper", testPaperDTO);
        return tcpResponse.judgeSuccess();
    }

    public static boolean deleteTestPaper(int testPaperId) throws IOException {
        TcpResponse tcpResponse = TcpPackage.send("deleteTestPaper", testPaperId);
        return tcpResponse.judgeSuccess();
    }
}
