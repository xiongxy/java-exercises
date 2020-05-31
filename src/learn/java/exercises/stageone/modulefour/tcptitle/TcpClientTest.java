package learn.java.exercises.stageone.modulefour.tcptitle;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author xxywindows@hotmail.com
 */
public class TcpClientTest {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            UserMessage userMessage = new UserMessage("check", new User("admin", "123456"));
            objectOutputStream.writeObject(userMessage);
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            try {
                UserMessage userMessage1 = (UserMessage) objectInputStream.readObject();
                if ("success".equals(userMessage1.getType())) {
                    System.out.println("µÇÂ¼³É¹¦");
                } else {
                    System.out.println("µÇÂ¼Ê§°Ü");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
