package learn.java.exercises.stageone.modulefour;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author xxywindows@hotmail.com
 */
public class DeleteFileTest {


    private static final String FILE = "src/learn/java/exercises/stageone/modulefour/DeleteFile";

    public static void main(String[] args) {
        simulationCreation();
        DeleteFile(FILE);
    }

    /**
     * ɾ������
     * @param fileName
     */
    private static void DeleteFile(String fileName) {
        File file = new File(fileName);
        forLoopDelete(file);
    }


    /**
     * ѭ��ɾ��
     * @param file
     */
    private static void forLoopDelete(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files.length != 0) {
                    for (File fileSide : files) {
                        forLoopDelete(fileSide);
                    }
                }
            }
            file.delete();
        }
    }


    /**
     * ģ�ⴴ��
     */
    private static void simulationCreation() {
        File file = new File(FILE);
        file.mkdir();
        for (int i = 0; i < 10; i++) {
            File newFile = new File(file, String.valueOf(i));
            newFile.mkdir();
            for (int x = 0; x < 10; x++) {
                File newFile2 = new File(newFile, x + ".txt");
                try {
                    newFile2.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
