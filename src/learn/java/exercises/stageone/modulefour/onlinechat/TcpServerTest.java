package learn.java.exercises.stageone.modulefour.onlinechat;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author xxyWi
 */
public class TcpServerTest {

    private static ArrayList<CustomClient> customClients = new ArrayList<>();

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), new ThreadPoolExecutor.AbortPolicy());
        try {
            serverSocket = new ServerSocket(8888);
            System.out.println("Server Started");
            while (true) {
                Socket socket = serverSocket.accept();
                customClients.add(new CustomClient(socket));
                singleThreadPool.execute(new TcpServerHandle(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 广播消息
     *
     * @param message
     * @param currentSocket
     */
    private static void sendAll(Message message, Socket currentSocket) {
        for (CustomClient customClient : customClients) {
            if (customClient.getSocket() == currentSocket) {
                continue;
            }
            ObjectOutputStream objectOutputStream = null;
            try {
                objectOutputStream = new ObjectOutputStream(customClient.getSocket().getOutputStream());
                objectOutputStream.writeObject(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 根据socket寻找CustomClient
     *
     * @param socket
     * @return
     */
    private static CustomClient findCustomClient(Socket socket) {
        for (CustomClient customClient : customClients) {
            if (customClient.getSocket() == socket) {
                return customClient;
            }
        }
        return null;
    }

    /**
     * 离线
     *
     * @param socket
     */
    private static void offline(Socket socket) {
        CustomClient customClient = TcpServerTest.findCustomClient(socket);
        customClients.remove(customClient);
        try {
            customClient.getSocket().shutdownOutput();
            customClient.getSocket().shutdownInput();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sendAll(new Message("系统", Message.MessageType.TEXT, customClient.getName() + "下线了"), null);
    }

    /**
     * TcpServer端主要处理
     */
    static class TcpServerHandle implements Runnable {
        private Socket socket;
        private ObjectInputStream objectInputStream;
        private String name;

        TcpServerHandle(Socket socket) {
            this.socket = socket;
            //获取用户名
            try {
                InputStream inputStream = socket.getInputStream();
                byte[] bytes = new byte[1024];
                Integer n = inputStream.read(bytes);
                String name = new String(bytes, 0, n);
                this.name = name;
                CustomClient customClient = TcpServerTest.findCustomClient(socket);
                customClient.setName(name);
                TcpServerTest.sendAll(new Message("系统", Message.MessageType.TEXT, "欢迎: " + name + " 登录系统"), null);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                this.objectInputStream = new ObjectInputStream(socket.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while (true) {
                Message message = receive();
                if (message.getType() == Message.MessageType.TEXT && "bye".equalsIgnoreCase(message.getText())) {
                    TcpServerTest.offline(this.socket);
                    return;
                }
                TcpServerTest.sendAll(message, null);
            }
        }

        /**
         * 接收消息
         *
         * @return Message
         */
        public Message receive() {
            try {
                Message message = (Message) objectInputStream.readObject();
                System.out.println(this.name + "发送的消息：" + message.toString());
                return message;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
