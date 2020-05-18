package learn.java.exercises.stageone.modulethree;

import java.util.regex.Matcher;

/**
 * @author xxywindows@hotmail.com
 */
public class SubjectOne {
    public static void main(String[] args) {
        int totalCapitalLetter = 0, totalLowercaseLetter = 0, totalNum = 0, totalOther = 0;
        final String sample = "ABCD123!@#$%ab";
        for (char a : sample.toCharArray()) {
            String temp = String.valueOf(a);
            if (temp.matches("[A-Z]")) {
                totalCapitalLetter++;
            } else if (temp.matches("[a-z]")) {
                totalLowercaseLetter++;

            } else if (temp.matches("[0-9]")) {
                totalNum++;
            } else {
                totalOther++;
            }
        }
        System.out.printf("��дΪ:%s | СдΪ:%s | ����Ϊ:%s | ����Ϊ:%s", totalCapitalLetter, totalLowercaseLetter, totalNum, totalOther);
    }
}
