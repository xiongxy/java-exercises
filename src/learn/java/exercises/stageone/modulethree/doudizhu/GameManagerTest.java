package learn.java.exercises.stageone.modulethree.doudizhu;

import java.util.Scanner;

/**
 * @author xxywindows@hotmail.com
 */
public class GameManagerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameManager gameManager = new GameManager();
        gameManager.gameRun().licensing();
        while (true) {
            System.out.println("————————————————————————————");
            System.out.println("游戏已经开始,游戏规则：");
            System.out.println("1.打印牌局");
            System.out.println("2.重新开始");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    gameManager.print();
                    break;
                case "2":
                    gameManager.nextRound();
                    gameManager.gameRun().licensing();
                    break;
                default:
                    System.out.println("其他功能暂时未开发！");
                    break;
            }
        }

    }
}
