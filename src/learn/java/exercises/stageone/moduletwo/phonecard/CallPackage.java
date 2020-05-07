package learn.java.exercises.stageone.moduletwo.phonecard;

/**
 * @author xxywindows@hotmail.com
 */
public class CallPackage extends AbstractPackage implements CallServiceInterface {
    private int talkTime;
    private int messageTotal;

    public CallPackage(int talkTime, int messageTotal, double postage) {
        setTalkTime(talkTime);
        setMessageTotal(messageTotal);
        setPostage(postage);
    }

    public int getTalkTime() {
        return talkTime;
    }

    public void setTalkTime(int talkTime) {
        this.talkTime = talkTime;
    }

    public int getMessageTotal() {
        return messageTotal;
    }

    public void setMessageTotal(int messageTotal) {
        this.messageTotal = messageTotal;
    }

    @Override
    public void show(int talkTime, PhoneCard phoneCard) {
        phoneCard.show();
        System.out.printf("ͨ��ʱ����%d  \n", getTalkTime());
    }

    @Override
    public void show() {
        System.out.printf("ͨ��ʱ����%d , ��������: %d, ÿ���ʷ�: %f \n", getTalkTime(), getMessageTotal(), getPostage());
    }
}
