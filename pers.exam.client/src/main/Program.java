package main;

import mainpage.AdminMainPage;
import mainpage.StudentMainPage;
import util.ClientScanner;

import java.io.IOException;

/**
 * @author xxyWi
 */
public class Program {
    public static void main(String[] args) {
        try {
            menu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void menu() throws IOException {
        System.out.println("欢迎进入在线考试系统,输入序号进行相应的操作！");
        System.out.println("[1] 学员系统");
        System.out.println("[2] 管理员系统");
        System.out.println("[0] 退出系统 ");
        System.out.print("请输入：");
        String inputText = ClientScanner.getNextLine();
        switch (inputText) {
            case "1":
                StudentMainPage studentMainPage = new StudentMainPage();
                studentMainPage.start();
                return;
            case "2":
                AdminMainPage adminMainPage = new AdminMainPage();
                adminMainPage.start();
                return;
            case "0":
                System.out.println("系统退出！");
                return;
            default:
                System.out.println("输入错误，系统关闭");
                return;
        }
    }
}
