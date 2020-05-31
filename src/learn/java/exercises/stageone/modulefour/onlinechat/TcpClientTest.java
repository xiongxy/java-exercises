package learn.java.exercises.stageone.modulefour.onlinechat;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xxyWi
 */
public class TcpClientTest {

    private static final String SENDFILE_KEY = "sendfile";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 10,
                0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1024), new ThreadPoolExecutor.AbortPolicy());
        Socket socket = null;
        try {
            socket = new Socket(InetAddress.getLocalHost(), 8888);
            //ע��һ������
            singleThreadPool.execute(new ReceiveHandle(socket));

            //��������
            System.out.println("����������:");
            String name = scanner.nextLine();
            OutputStreamWriter nameOutputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
            nameOutputStreamWriter.write(name);
            nameOutputStreamWriter.flush();

            System.out.println("���������ҳɹ���");
            System.out.println("��������У�ʹ�á�sendfile���ؼ��ַ����ļ�,���쿪ʼ:");
            ObjectOutputStream sendStream = new ObjectOutputStream(socket.getOutputStream());
            while (true) {
                String text = scanner.nextLine();
                Message message = new Message(name);
                if (SENDFILE_KEY.equalsIgnoreCase(text)) {
                    message.setType(Message.MessageType.FILE);
                    //ģ�ⷢ���ļ�
                    //����һ���ļ�
                    FileOutputStream fileOutputStream = new FileOutputStream("a.txt");
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                    outputStreamWriter.write("����һ�������ݵ��ļ�");
                    outputStreamWriter.close();
                    //��ȡ�������ļ�������
                    FileInputStream fileInputStream = new FileInputStream("a.txt");
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    byte[] b = new byte[1024];
                    int len = -1;
                    while ((len = fileInputStream.read(b)) != -1) {
                        bos.write(b, 0, len);
                    }
                    byte[] fileByte = bos.toByteArray();
                    message.setData(fileByte);
                } else {
                    message.setType(Message.MessageType.TEXT);
                    message.setData(text.getBytes("UTF-8"));
                }
                sendStream.writeObject(message);
                if (text.equalsIgnoreCase("bye")) {
                    System.out.println("�����ˣ�");
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * ���մ����ڲ���
     */
    static class ReceiveHandle implements Runnable {
        private Socket socket;

        public ReceiveHandle(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            ObjectInputStream receiveStream = null;
            try {
                while (true) {
                    receiveStream = new ObjectInputStream(socket.getInputStream());
                    Message message = (Message) receiveStream.readObject();
                    if (message.getType() == Message.MessageType.TEXT) {
                        System.err.println("�㲥��Ϣ��" + message.toString());
                    } else {
                        System.err.println("�㲥��Ϣ��" + message.toString());
                        System.err.printf("�����յ���һ���ļ�");
                        String fileName = uuid() + ".txt";
                        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName));
                        bos.write(message.getData());
                        bos.flush();
                        System.err.printf("�ļ�������:" + fileName);
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static String uuid() {
        String s = UUID.randomUUID().toString();
        return s.replace("-", "");
    }
}
