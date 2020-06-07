package util;

import tcp.TcpRequest;
import tcp.TcpResponse;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author xxyWi
 * Tcp包封装类
 */
public class TcpPackage {
    public static TcpResponse send(String prefix, Object content) {
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(new TcpRequest(prefix, content));

            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            TcpResponse o = (TcpResponse) objectInputStream.readObject();
            return o;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

        }
        return null;
    }
}
