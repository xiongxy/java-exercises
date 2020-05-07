package learn.java.exercises.stageone.moduletwo.checkerboard;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author xxywindows@hotmail.com
 */
public class Checkerboard {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[-+]?[\\d]*$");

    String[] boundary = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
    int checkerboardSize = 17;
    String[][] checkerboard = new String[checkerboardSize][checkerboardSize];

    public Checkerboard() {
        for (int i = 0; i < checkerboardSize; i++) {
            for (int j = 0; j < checkerboardSize; j++) {
                if (i == 0 && j == 0) {
                    checkerboard[i][j] = " ";
                    continue;
                }
                if (i == 0) {
                    checkerboard[i][j] = boundary[j - 1];
                    continue;
                }
                if (j == 0) {
                    checkerboard[i][j] = boundary[i - 1];
                    continue;
                }
                checkerboard[i][j] = ".";
            }
        }
    }

    public void draw() {
        System.out.println("�������̣�");
        for (int i = 0; i < checkerboardSize; i++) {
            for (int j = 0; j < checkerboardSize; j++) {
                System.out.print(" " + checkerboard[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isInteger(String str) {
        return NUMBER_PATTERN.matcher(str).matches();
    }

    public void printGameRule() {
        System.out.println("������:");
        System.out.println("1. �����ڷ��׷�ִ�ӣ������������塣��������Ϊ 0 -  " + (checkerboardSize - 2));
        System.out.println("2. ����Ϊ���� �ո��������:9 15");
        System.out.println("3. �ڷ�����Ϊ B �׷�����Ϊ W");
    }

    public void gameStart(Scanner scanner) {
        boolean isGameEnd = false;
        while (!isGameEnd) {
            System.out.println("�ڷ�ִ�����壬�������꣺");
            isGameEnd = playChess(scanner, true);
            if (!isGameEnd) {
                System.out.println("�׷�ִ�����壬�������꣺");
                isGameEnd = playChess(scanner, false);
            }
        }
    }


    public String victoryVerification(int x, int y) {
        String current = checkerboard[y][x];

        //��ʱx��
        int i;

        //�����ж�
        int count = 1;
        for (int k = x - 1; k >= 1; k--) {
            if (current.equals(checkerboard[y][k])) {
                count++;
            } else {
                break;
            }
        }
        for (int k = x + 1; k < checkerboardSize; k++) {
            if (current.equals(checkerboard[y][k])) {
                count++;
            } else {
                break;
            }
        }
        if (count == 5) {
            return current;
        }

        //�����ж�
        count = 1;
        for (int k = y - 1; k >= 1; k--) {
            if (current.equals(checkerboard[k][x])) {
                count++;
            } else {
                break;
            }
        }
        for (int k = y + 1; k < checkerboardSize; k++) {
            if (current.equals(checkerboard[k][x])) {
                count++;
            } else {
                break;
            }
        }
        if (count == 5) {
            return current;
        }

        //б���ж�  /
        count = 1;
        i = x;
        for (int k = y - 1; k >= 1; k--) {
            i++;
            if (current.equals(checkerboard[k][i])) {
                count++;
            } else {
                break;
            }
        }
        i = x;
        for (int k = x + 1; k < checkerboardSize; k++) {
            i--;
            if (current.equals(checkerboard[k][i])) {
                count++;
            } else {
                break;
            }
        }
        if (count == 5) {
            return current;
        }


        //б���ж�  \
        count = 1;
        i = x;
        for (int k = y - 1; k >= 1; k--) {
            i--;
            if (current.equals(checkerboard[k][i])) {
                count++;
            } else {
                break;
            }
        }
        i = x;
        for (int k = x + 1; k < checkerboardSize; k++) {
            i++;
            if (current.equals(checkerboard[k][i])) {
                count++;
            } else {
                break;
            }
        }
        if (count == 5) {
            return current;
        }
        return "";
    }

    public boolean playChess(Scanner scanner, boolean isBlackSide) {
        boolean isGameEnd = false;
        Axis axis = getAxis(scanner);
        if (isBlackSide) {
            checkerboard[axis.y][axis.x] = "B";
        } else {
            checkerboard[axis.y][axis.x] = "W";
        }
        draw();
        String victoryResult = victoryVerification(axis.x, axis.y);
        switch (victoryResult) {
            case "B":
                System.out.println("�ڷ�ʤ��");
                isGameEnd = true;
                break;
            case "W":
                System.out.println("�׷�ʤ��");
                isGameEnd = true;
                break;
            default:
                break;
        }
        return isGameEnd;
    }

    public Axis getAxis(Scanner scanner) {
        int xCoordinate = 0, yCoordinate = 0;
        boolean inputError = true;
        while (inputError) {
            String input = scanner.nextLine();
            String[] strArr = input.split(" ");
            if (strArr.length == 2) {
                if (isInteger(strArr[0]) && isInteger(strArr[1])) {
                    xCoordinate = Integer.parseInt(strArr[0]);
                    yCoordinate = Integer.parseInt(strArr[1]);
                    if (xCoordinate > 15 || xCoordinate < 0 || yCoordinate > 15 || yCoordinate < 0) {
                        System.out.println("���뷶Χ�������������");
                    } else {
                        xCoordinate++;
                        yCoordinate++;
                        boolean verificationResult = placingVerification(xCoordinate, yCoordinate);
                        if (!verificationResult) {
                            System.out.println("���������Ѿ��������ӣ�����������");
                        } else {
                            inputError = false;
                        }
                    }
                } else {
                    System.out.println("�����ʽ�������������");
                }
            } else {
                System.out.println("�����ʽ�������������");
            }
        }
        return new Axis(xCoordinate, yCoordinate);
    }

    public boolean placingVerification(int xCoordinate, int yCoordinate) {
        return ".".equals(checkerboard[yCoordinate][xCoordinate]);
    }

    public class Axis {
        public int x;
        public int y;

        public Axis(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

