package learn.java.exercises.stageone.modulefour;

import java.io.*;
import java.lang.reflect.Field;
import java.util.concurrent.*;

/**
 * @author xxywindows@hotmail.com
 */
public class ThreadPollCopyTest {

    private static final String FILE = "src/learn/java/exercises/stageone/modulefour/ThreadPollCopy";
    private static final String FILE_COPY_TO = "src/learn/java/exercises/stageone/modulefour/ThreadPollCopyTo";

    public static void main(String[] args) {
        //��װ�˰���Ĺ�Լ��������ֱ��ͨ��Executor�����̳߳�
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1));
        simulationCreation();
        pool.execute(new Runnable() {
            @Override
            public void run() {
                File src = new File(FILE);
                File dest = new File(FILE_COPY_TO);
                try {
                    Copy(src,dest);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Copy
     * @param src
     * @param dest
     * @throws IOException
     */
    private static void Copy(File src,File dest) throws IOException {
        File newFile = new File(dest,src.getName());
        // �ж�ƴ�ӳɵ�·���Ƿ����
        if(!newFile.exists()){
            newFile.mkdirs();
        }
        // ��ȡԴĿ¼�е����е��ļ����ļ���
        File[] files = src.listFiles();
        for (File file : files) {
            if(file.isFile()){
                // ��ʼ�����ļ�
                FileInputStream fis = new FileInputStream(file);
                FileOutputStream fos = new FileOutputStream(new File(newFile,file.getName()));
                byte[] b = new byte[1024];
                int len;
                while((len  = fis.read(b)) !=-1){
                    fos.write(b, 0, len);
                }
                fos.close();
                fis.close();

            }else if(file.isDirectory()){
                Copy(file, newFile);
            }
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
