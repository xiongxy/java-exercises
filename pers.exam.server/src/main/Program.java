package main;

import database.DatabaseAccount;
import database.DatabaseInit;
import tcp.TcpRequest;
import tcp.TcpResponse;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xxyWi
 */
public class Program {
    public static void main(String[] args) {

        try {
            DatabaseInit.Init();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), new ThreadPoolExecutor.AbortPolicy());
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("Server Started");
            while (true) {
                Socket socket = serverSocket.accept();
                singleThreadPool.execute(new TcpServerHandle(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tcp服务处理Handle
     */
    static class TcpServerHandle implements Runnable {
        private Socket socket;
        private ObjectInputStream objectInputStream;
        private ObjectOutputStream objectOutputStream;

        TcpServerHandle(Socket socket) {
            this.socket = socket;
            try {
                this.objectInputStream = new ObjectInputStream(socket.getInputStream());
                this.objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            TcpRequest message = receive();
            TcpResponse tcpResponse = null;
            try {
                tcpResponse = CoreProcess.process(message);
            } catch (IOException e) {
                e.printStackTrace();
                send(TcpResponse.NotFound());
            }
            send(tcpResponse);
        }

        /**
         * 接收消息
         *
         * @return Message
         */
        public TcpRequest receive() {
            try {
                TcpRequest tcpRequest = (TcpRequest) objectInputStream.readObject();
                return tcpRequest;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }

        /**
         * 回写消息
         *
         * @return Message
         */
        public void send(TcpResponse tcpResponse) {
            try {
                objectOutputStream.writeObject(tcpResponse);
                objectOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
