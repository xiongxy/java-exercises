package learn.java.exercises.stageone.moduletwo.phonecard;

/**
 * @author xxywindows@hotmail.com
 */
public class CardType {
    private final String desc;

    public static final CardType BIG_CARD = new CardType("��");
    public static final CardType LITTLE_CARD = new CardType("С��");
    public static final CardType MINI_CARD = new CardType("΢�Ϳ�");

    public String getDesc() {
        return desc;
    }

    private CardType(String desc) {
        this.desc = desc;
    }
}
