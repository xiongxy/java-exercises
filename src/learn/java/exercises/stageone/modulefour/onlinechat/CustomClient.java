package learn.java.exercises.stageone.modulefour.onlinechat;


import java.net.Socket;

/**
 * @author xxyWi
 */
public class CustomClient {
    private String name;
    private Socket socket;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public CustomClient(Socket socket) {
        this.socket = socket;
    }
}
