package main;

import business.ExamService;
import business.StudentService;
import business.UserAccountService;
import database.DatabaseAccount;
import exam.TestPaperDTO;
import student.StudentDTO;
import tcp.TcpRequest;
import tcp.TcpResponse;
import user.UserAccountDTO;

import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * @author xxyWi
 * 主要业务处理逻辑分发
 */
public class CoreProcess {
    public static TcpResponse process(TcpRequest tcpRequest) throws IOException {
        var prefix = tcpRequest.getPrefix();
        boolean success = false;
        switch (prefix) {
            case "login":
                success = UserAccountService.Login((UserAccountDTO) tcpRequest.getContent());
                return success ? new TcpResponse("200") : TcpResponse.NotFound();


            case "getStudentList":
                List<StudentDTO> studentList = StudentService.getStudentList();
                return new TcpResponse("200", studentList);
            case "addStudent":
                success = StudentService.addStudent((StudentDTO) tcpRequest.getContent());
                return success ? new TcpResponse("200") : TcpResponse.NotFound();
            case "updateStudent":
                success = StudentService.updateStudent((StudentDTO) tcpRequest.getContent());
                return success ? new TcpResponse("200") : TcpResponse.NotFound();
            case "deleteStudent":
                success = StudentService.deleteStudent((String) tcpRequest.getContent());
                return success ? new TcpResponse("200") : TcpResponse.NotFound();


            case "getTestPaperList":
                List<TestPaperDTO> testPaperList = ExamService.getTestPaperList();
                return new TcpResponse("200", testPaperList);
            case "getTestPaper":
                TestPaperDTO testPaperDTO = ExamService.getTestPaper((Integer) tcpRequest.getContent());
                return new TcpResponse("200", testPaperDTO);
            case "randomGetTestPaper":
                TestPaperDTO randomTestPaper = ExamService.randomGetTestPaper();
                return new TcpResponse("200", randomTestPaper);
            case "addTestPaper":
                success = ExamService.addTestPaper((TestPaperDTO) tcpRequest.getContent());
                return success ? new TcpResponse("200") : TcpResponse.NotFound();
            case "deleteTestPaper":
                success = ExamService.deleteTestPaper((Integer) tcpRequest.getContent());
                return success ? new TcpResponse("200") : TcpResponse.NotFound();


            default:
                return TcpResponse.NotFound();
        }
    }
}

