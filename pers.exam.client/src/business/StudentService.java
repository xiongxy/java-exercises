package business;

import student.StudentDTO;
import tcp.TcpResponse;
import util.TcpPackage;

import java.util.List;

/**
 * @author xxyWi
 * 学生服务类
 */
public class StudentService {
    public static List<StudentDTO> getStudentList() {
        TcpResponse tcpResponse = TcpPackage.send("getStudentList", null);
        return (List<StudentDTO>) tcpResponse.getContent();
    }

    public static boolean addStudent(StudentDTO student) {
        TcpResponse tcpResponse = TcpPackage.send("addStudent", student);
        return tcpResponse.judgeSuccess();
    }

    public static boolean updateStudent(StudentDTO student) {
        TcpResponse tcpResponse = TcpPackage.send("updateStudent", student);
        return tcpResponse.judgeSuccess();
    }

    public static boolean deleteStudent(String inputText) {
        TcpResponse tcpResponse = TcpPackage.send("deleteStudent", inputText);
        return tcpResponse.judgeSuccess();
    }
}
