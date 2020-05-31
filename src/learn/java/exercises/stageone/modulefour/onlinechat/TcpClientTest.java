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
            //注册一个接收
            singleThreadPool.execute(new ReceiveHandle(socket));

            //发送姓名
            System.out.println("请输入姓名:");
            String name = scanner.nextLine();
            OutputStreamWriter nameOutputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
            nameOutputStreamWriter.write(name);
            nameOutputStreamWriter.flush();

            System.out.println("加入聊天室成功！");
            System.out.println("聊天过程中，使用【sendfile】关键字发送文件,聊天开始:");
            ObjectOutputStream sendStream = new ObjectOutputStream(socket.getOutputStream());
            while (true) {
                String text = scanner.nextLine();
                Message message = new Message(name);
                if (SENDFILE_KEY.equalsIgnoreCase(text)) {
                    message.setType(Message.MessageType.FILE);
                    //模拟发送文件
                    //创建一个文件
                    FileOutputStream fileOutputStream = new FileOutputStream("a.txt");
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                    outputStreamWriter.write("这是一个有数据的文件");
                    outputStreamWriter.close();
                    //读取创建的文件并发送
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
                    System.out.println("下线了！");
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
     * 接收处理内部类
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
                        System.err.println("广播信息：" + message.toString());
                    } else {
                        System.err.println("广播信息：" + message.toString());
                        System.err.printf("您接收到了一个文件");
                        String fileName = uuid() + ".txt";
                        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName));
                        bos.write(message.getData());
                        bos.flush();
                        System.err.printf("文件名称是:" + fileName);
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
