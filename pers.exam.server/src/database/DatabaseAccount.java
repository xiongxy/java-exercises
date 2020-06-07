package database;

import java.io.*;

/**
 * @author xxyWi
 * 数据库访问层(文件)
 */
public class DatabaseAccount {

    public Object readFile(String fileName) throws IOException {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(fileName));
            return ois.readObject();
        } catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                ois.close();
            }
        }
        return null;
    }

    public void writeFile(String fileName, Object object) throws IOException {
        autoCreateFile(fileName);
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(object);
            oos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                oos.close();
            }
        }
    }

    private static void autoCreateFile(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
    }
}
