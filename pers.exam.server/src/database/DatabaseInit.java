package database;

import exam.TestPaperDTO;
import student.StudentDTO;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xxyWi
 * 数据库初始化
 */
public class DatabaseInit {

    public static void Init() throws IOException {
        //初始化"student.txt"
        DatabaseAccount databaseAccount = new DatabaseAccount();

        ArrayList<StudentDTO> studentDTOS = new ArrayList<>();
        StudentDTO student = new StudentDTO();
        student.setNumber("10001");
        student.setName("张三");
        student.setPassword("123456");
        student.setAge(18);
        studentDTOS.add(student);
        databaseAccount.writeFile("student.txt", studentDTOS);


        //初始化"paper.txt"
        ArrayList<TestPaperDTO.TestPaperItem.SelectItem> selectItems = new ArrayList<>();
        selectItems.add(new TestPaperDTO.TestPaperItem.SelectItem("A", "1"));
        selectItems.add(new TestPaperDTO.TestPaperItem.SelectItem("B", "2"));
        selectItems.add(new TestPaperDTO.TestPaperItem.SelectItem("C", "3"));
        selectItems.add(new TestPaperDTO.TestPaperItem.SelectItem("D", "4"));

        ArrayList<TestPaperDTO.TestPaperItem> items = new ArrayList<>();
        items.add(new TestPaperDTO.TestPaperItem("1+1=?", "A", selectItems));

        ArrayList<TestPaperDTO> testPapers = new ArrayList<>();
        testPapers.add(new TestPaperDTO(1, "数学题1", items));
        databaseAccount.writeFile("paper.txt", testPapers);


        //初始化"examHistory.txt"
        //databaseAccount.writeFile("examHistory.txt", new ArrayList<TestPaperDTO>());
    }

}
