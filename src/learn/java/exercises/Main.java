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
        System.out.println("—————————— 请选择题目，选择序号进入相应分支 ——————————");
        System.out.println("1. 提示用户输入年月日信息,判断这一天是这一年中的第几天并打印");
        System.out.println("2. 编程找出 1000 以内的所有完数并打印。所谓完数就是一个数恰好等于它的因子之和,如: 6 = 1 + 2 + 3");
        System.out.println("3. 实现双色球抽象游戏中奖号码的生成，中奖号码有6个红球和蓝球号码组成。其中红球号码要求随机生成6个1~33之间不重复的随机号码。" +
                "其中蓝球号码要求随机生成1个~16之间的随机号码");
        System.out.println("4. 自定义数组扩容规则，当已存储元素数量达到总容量的80%时，扩容1.5倍。例如，总容量是10，当输入第8个元素时，数组进行扩容，容量从10变成15");
        System.out.println("5. 使用二维数组和循环实现五子棋游戏棋盘的绘制");
        System.out.println("——————————            End           ——————————");
    }

    static boolean mainFlow(Scanner scanner) {
        menu();
        System.out.print("请输入题号,退出请输入end:");
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
                System.out.println("错误的输入!");
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

        System.out.println("进入题1");
        int year = 0, mouth = 0, day = 0;
        boolean isLeapYear = false;
        boolean isVerification = false;
        do {
            try {
                System.out.print("请输入年:");
                year = scanner.nextInt();
                System.out.println(year);
                if (year < 0) {
                    throw new Exception("年输入错误");
                }
                System.out.print("请输入月:");
                mouth = scanner.nextInt();
                if (mouth < 0 || mouth > 12) {
                    throw new Exception("月输入错误");
                }
                System.out.print("请输入日:");
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
                    throw new Exception("天输入错误");
                }
                if (day > 1 && day <= maxDay) {
                    isVerification = true;
                }
            } catch (Exception e) {
                System.out.printf("数据输入错误 | %s | 请重新输入 \r \n", e.getMessage());
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
        System.out.printf(" %d 年 %d 月 %d 日是一年中的第 %d 天 \r \n", year, mouth, day, totalDay);
    }

    static void findPerfectNumber(Scanner scanner) {
        System.out.println("开始打印1000内完数,第一个完数是6，所以从6开始");
        for (int i = 6; i < 1000; i++) {
            int sum = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }
            if (sum == i) {
                System.out.printf("完数 %d \r \n ", i);
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
        System.out.print("红球: ");
        for (int i : redHashSet) {
            System.out.print(" " + i + " ");
        }
        System.out.printf("蓝球: %d", random.nextInt(16) + 1);
        System.out.println();
    }

    static void arrayDilatation(Scanner scanner) throws InterruptedException {
        gogo: while (true) {
            System.out.print("初始化数组大小:");
            String arraySizeString = scanner.next();
            if (!isInteger(arraySizeString)) {
                System.out.println("输入错误，请重新输入!");
                continue gogo;
            }
            int[] array = new int[Integer.parseInt(arraySizeString)];
            //自动扩容系统,每次数组中加入一个数
            for (int i = 0; i < array.length; i++) {
                int totalNum = i + 1;
                Thread.sleep(500);
                System.out.printf("添加第 %d 个元素值 \r \n", totalNum);
                array[i] = 1;
                double plotRatio = (double) totalNum / array.length;
                if (plotRatio > 0.8) {
                    System.out.printf("开始扩容,当前容量 %d,当前已使用容量 %d,容积率 %f  \r \n", array.length, totalNum, plotRatio);
                    //进入扩容  array 的扩容基于 新copy一个数组 底层实现也如此
                    array = new int[(int) Math.ceil(array.length * 1.5)];
                    System.out.printf("扩容借宿,扩容后容量为 %d \r \n", array.length);
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