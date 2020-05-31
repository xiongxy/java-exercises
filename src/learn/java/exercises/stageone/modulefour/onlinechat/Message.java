package learn.java.exercises.stageone.modulefour.onlinechat;

import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author xxyWi
 */
public class Message implements Serializable {

    private String sender;
    private MessageType type;
    private byte[] data;

    public Message(String name) {
        this.sender = name;
    }

    public Message(MessageType type, byte[] data) {
        this.type = type;
        this.data = data;
    }

    public Message(String name, MessageType type, String data) {
        this.sender = name;
        this.type = type;
        try {
            this.data = data.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public String getText() {
        try {
            return new String(this.data, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public void setData(byte[] data) {
        this.data = data;
    }


    @Override
    public String toString() {
        try {
            return "[" + sender + "]" + "������һ����Ϣ�� \n" +
                    "��Ϣ����Ϊ:" + type + "\n" + "��Ϣ����Ϊ:" + (type == MessageType.TEXT ? new String(data, "UTF-8") : "�ļ�����");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "��Ϣ����";
        }
    }

    enum MessageType {
        //�ļ�
        FILE,
        //�ı�
        TEXT
    }
}
