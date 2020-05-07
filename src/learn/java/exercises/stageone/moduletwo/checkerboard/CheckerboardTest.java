package learn.java.exercises.stageone.moduletwo.checkerboard;

import java.util.Scanner;

/**
 * @author xxywindows@hotmail.com
 */
public class CheckerboardTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Checkerboard checkerboard = new Checkerboard();
        checkerboard.printGameRule();
        checkerboard.draw();
        checkerboard.gameStart(scanner);
    }
}
