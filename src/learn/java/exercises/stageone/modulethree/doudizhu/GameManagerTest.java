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
            System.out.println("��������������������������������������������������������");
            System.out.println("��Ϸ�Ѿ���ʼ,��Ϸ����");
            System.out.println("1.��ӡ�ƾ�");
            System.out.println("2.���¿�ʼ");
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
                    System.out.println("����������ʱδ������");
                    break;
            }
        }

    }
}
