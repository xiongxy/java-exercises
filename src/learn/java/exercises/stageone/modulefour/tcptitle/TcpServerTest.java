package learn.java.exercises.stageone.modulefour.tcptitle;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author xxywindows@hotmail.com
 */
public class TcpServerTest {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket accept = null;
        try {
            serverSocket = new ServerSocket(8888);
            while (true) {
                accept = serverSocket.accept();
                InputStream inputStream = accept.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                UserMessage userMessage = (UserMessage) objectInputStream.readObject();
                if ("admin".equals(userMessage.getUser().getUserName()) && "123456".equals(userMessage.getUser().getPassword())) {
                    userMessage.setType("success");
                } else {
                    userMessage.setType("fail");
                }
                OutputStream outputStream = accept.getOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(userMessage);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                assert serverSocket != null;
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert accept != null;
                accept.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
