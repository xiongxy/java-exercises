package business;

import student.StudentDTO;
import user.UserAccountDTO;
import user.UserAccountType;

import java.io.IOException;
import java.util.List;

/**
 * @author xxyWi
 * 账户业务类
 */
public class UserAccountService {
    final static String ADMIN_USERNAME_PASSWORD = "admin";

    public static boolean Login(UserAccountDTO userAccountDTO) throws IOException {
        if (userAccountDTO.getUserAccountType() == UserAccountType.Admin) {
            if (ADMIN_USERNAME_PASSWORD.equals(userAccountDTO.getPassword()) && ADMIN_USERNAME_PASSWORD.equals(userAccountDTO.getUserName())) {
                return true;
            }
        } else if (userAccountDTO.getUserAccountType() == UserAccountType.Student) {
            List<StudentDTO> studentList = StudentService.getStudentList();
            long count = studentList.stream().filter(studentDTO -> studentDTO.getNumber().equals(userAccountDTO.getUserName()) && studentDTO.getPassword().equals(userAccountDTO.getPassword())).count();
            if (count != 0) {
                return true;
            }
        }
        return false;
    }
}
