package util;

import java.util.Scanner;

/**
 * @author xxyWi
 * 扫描器封装
 */
public class ClientScanner {

    private static Scanner scanner = new Scanner(System.in);

    public static Scanner getScanner() {
        return scanner;
    }

    public static void close() {
        scanner.close();
    }

    public static String getNextLine() {
        return scanner.nextLine();
    }
}
