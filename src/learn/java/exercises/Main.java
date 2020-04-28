package learn.java.exercises;

import java.util.*;
import java.util.regex.Pattern;

/**
 * @author xxywindows@hotmail.com
 */
public class Main {

    private static Pattern pattern = Pattern.compile("^[-+]?[\\d]*$");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isEnd = false;
        while (!isEnd) {
            isEnd = mainFlow(scanner);
        }
    }

    static void menu() {
        System.out.println("�������������������� ��ѡ����Ŀ��ѡ����Ž�����Ӧ��֧ ��������������������");
        System.out.println("1. ��ʾ�û�������������Ϣ,�ж���һ������һ���еĵڼ��첢��ӡ");
        System.out.println("2. ����ҳ� 1000 ���ڵ�������������ӡ����ν��������һ����ǡ�õ�����������֮��,��: 6 = 1 + 2 + 3");
        System.out.println("3. ʵ��˫ɫ�������Ϸ�н���������ɣ��н�������6����������������ɡ����к������Ҫ���������6��1~33֮�䲻�ظ���������롣" +
                "�����������Ҫ���������1��~16֮����������");
        System.out.println("4. �Զ����������ݹ��򣬵��Ѵ洢Ԫ�������ﵽ��������80%ʱ������1.5�������磬��������10���������8��Ԫ��ʱ������������ݣ�������10���15");
        System.out.println("5. ʹ�ö�ά�����ѭ��ʵ����������Ϸ���̵Ļ���");
        System.out.println("��������������������            End           ��������������������");
    }

    static boolean mainFlow(Scanner scanner) {
        menu();
        System.out.print("���������,�˳�������end:");
        String currentSelected = scanner.next();
        currentSelected = currentSelected.toLowerCase();
        switch (currentSelected) {
            case "1":
                oneYearOneDay(scanner);
                break;
            case "2":
                findPerfectNumber(scanner);
                break;
            case "3":
                dichroicSphere(scanner);
                break;
            case "4":
                try {
                    arrayDilatation(scanner);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case "5":
                gobangDraw(scanner);
                break;
            case "end":
                return true;
            default:
                System.out.println("���������!");
        }
        return false;
    }

    static void oneYearOneDay(Scanner scanner) {
        class Helper {
            boolean LeapYearJudgment(int year) {
                if (year % 4 == 0 && year % 100 != 0) {
                    return true;
                } else if (year % 400 == 0 && year % 3200 != 0) {
                    return true;
                } else {
                    return year % 172800 == 0;
                }
            }
        }

        System.out.println("������1");
        int year = 0, mouth = 0, day = 0;
        boolean isLeapYear = false;
        boolean isVerification = false;
        do {
            try {
                System.out.print("��������:");
                year = scanner.nextInt();
                System.out.println(year);
                if (year < 0) {
                    throw new Exception("���������");
                }
                System.out.print("��������:");
                mouth = scanner.nextInt();
                if (mouth < 0 || mouth > 12) {
                    throw new Exception("���������");
                }
                System.out.print("��������:");
                day = scanner.nextInt();
                int maxDay;
                if (Const.BIG_MONTH.contains(mouth)) {
                    maxDay = 31;
                } else if (Const.SMALL_MONTH.contains(mouth)) {
                    maxDay = 30;
                } else if (mouth == 2) {
                    Helper h = new Helper();
                    isLeapYear = h.LeapYearJudgment(year);
                    if (isLeapYear) {
                        maxDay = 29;
                    } else {
                        maxDay = 28;
                    }
                } else {
                    throw new Exception("���������");
                }
                if (day > 1 && day <= maxDay) {
                    isVerification = true;
                }
            } catch (Exception e) {
                System.out.printf("����������� | %s | ���������� \r \n", e.getMessage());
            }
        } while (!isVerification);

        //calc start
        int totalDay = day;
        for (int i = 1; i < mouth; i++) {
            if (i == 2) {
                if (isLeapYear) {
                    totalDay += 29;
                } else {
                    totalDay += 28;
                }
            }
            if (Const.BIG_MONTH.contains(i)) {
                totalDay += 31;
            } else if (Const.SMALL_MONTH.contains(i)) {
                totalDay += 30;
            }
        }
        System.out.printf(" %d �� %d �� %d ����һ���еĵ� %d �� \r \n", year, mouth, day, totalDay);
    }

    static void findPerfectNumber(Scanner scanner) {
        System.out.println("��ʼ��ӡ1000������,��һ��������6�����Դ�6��ʼ");
        for (int i = 6; i < 1000; i++) {
            int sum = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }
            if (sum == i) {
                System.out.printf("���� %d \r \n ", i);
            }
        }
    }

    static void dichroicSphere(Scanner scanner) {
        HashSet<Integer> redHashSet = new HashSet<>();
        Random random = new Random();
        while (redHashSet.size() < 6) {
            int currentNum = random.nextInt(33) + 1;
            redHashSet.add(currentNum);
        }
        System.out.print("����: ");
        for (int i : redHashSet) {
            System.out.print(" " + i + " ");
        }
        System.out.printf("����: %d", random.nextInt(16) + 1);
        System.out.println();
    }

    static void arrayDilatation(Scanner scanner) throws InterruptedException {
        gogo: while (true) {
            System.out.print("��ʼ�������С:");
            String arraySizeString = scanner.next();
            if (!isInteger(arraySizeString)) {
                System.out.println("�����������������!");
                continue gogo;
            }
            int[] array = new int[Integer.parseInt(arraySizeString)];
            //�Զ�����ϵͳ,ÿ�������м���һ����
            for (int i = 0; i < array.length; i++) {
                int totalNum = i + 1;
                Thread.sleep(500);
                System.out.printf("��ӵ� %d ��Ԫ��ֵ \r \n", totalNum);
                array[i] = 1;
                double plotRatio = (double) totalNum / array.length;
                if (plotRatio > 0.8) {
                    System.out.printf("��ʼ����,��ǰ���� %d,��ǰ��ʹ������ %d,�ݻ��� %f  \r \n", array.length, totalNum, plotRatio);
                    //��������  array �����ݻ��� ��copyһ������ �ײ�ʵ��Ҳ���
                    array = new int[(int) Math.ceil(array.length * 1.5)];
                    System.out.printf("���ݽ���,���ݺ�����Ϊ %d \r \n", array.length);
                }
            }
        }
    }

    static void gobangDraw(Scanner scanner) {
        String[] abcd = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
        int checkerboardSize = 17;
        String[][] checkerboard = new String[checkerboardSize][checkerboardSize];
        for (int i = 0; i < checkerboardSize; i++) {
            for (int j = 0; j < checkerboardSize; j++) {
                if (i == 0 && j == 0) {
                    checkerboard[i][j] = " ";
                    continue;
                }
                if (i == 0) {
                    checkerboard[i][j] = abcd[j - 1];
                    continue;
                }
                if (j == 0) {
                    checkerboard[i][j] = abcd[i - 1];
                    continue;
                }
                checkerboard[i][j] = "+";

            }
        }
        for (int i = 0; i < checkerboardSize; i++) {
            for (int j = 0; j < checkerboardSize; j++) {
                System.out.print(" " + checkerboard[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean isInteger(String str) {
        return pattern.matcher(str).matches();
    }
}

class Const {
    public static final ArrayList<Integer> BIG_MONTH = new ArrayList<Integer>() {{
        add(1);
        add(3);
        add(5);
        add(7);
        add(8);
        add(10);
        add(12);
    }};
    public static final ArrayList<Integer> SMALL_MONTH = new ArrayList<Integer>() {{
        add(4);
        add(6);
        add(9);
        add(11);
    }};
}