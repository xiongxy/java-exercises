package business;

import database.DatabaseAccount;
import student.StudentDTO;

import java.io.IOException;
import java.util.List;

/**
 * @author xxyWi
 * 学生业务类
 */
public class StudentService {

    private static final String STUDENT_DATABASE_CONN = "student.txt";
    public static List<StudentDTO> getStudentList() throws IOException {
        DatabaseAccount databaseAccount = new DatabaseAccount();
        List<StudentDTO> studentList = (List<StudentDTO>) databaseAccount.readFile(STUDENT_DATABASE_CONN);
        return studentList;
    }

    public static boolean addStudent(StudentDTO studentDTO) throws IOException {
        List<StudentDTO> studentList = getStudentList();
        studentList.add(studentDTO);
        DatabaseAccount databaseAccount = new DatabaseAccount();
        databaseAccount.writeFile(STUDENT_DATABASE_CONN, studentList);
        return true;
    }

    public static boolean updateStudent(StudentDTO studentDTO) throws IOException {
        List<StudentDTO> studentList = getStudentList();
        StudentDTO item = studentList.stream().filter(student -> studentDTO.getNumber().equals(studentDTO.getNumber())).findFirst().get();
        item.setName(studentDTO.getName());
        item.setAge(studentDTO.getAge());
        item.setPassword(studentDTO.getPassword());
        DatabaseAccount databaseAccount = new DatabaseAccount();
        databaseAccount.writeFile(STUDENT_DATABASE_CONN, studentList);
        return true;
    }

    public static boolean deleteStudent(String number) throws IOException {
        List<StudentDTO> studentList = getStudentList();
        StudentDTO item = studentList.stream().filter(student -> number.equals(student.getNumber())).findFirst().get();
        studentList.remove(item);
        DatabaseAccount databaseAccount = new DatabaseAccount();
        databaseAccount.writeFile(STUDENT_DATABASE_CONN, studentList);
        return true;
    }


}
