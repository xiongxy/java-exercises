package learn.java.exercises.stageone.moduletwo.phonecard;

/**
 * @author xxywindows@hotmail.com
 */
public class CardType {
    private final String desc;

    public static final CardType BIG_CARD = new CardType("´ó¿¨");
    public static final CardType LITTLE_CARD = new CardType("Ð¡¿¨");
    public static final CardType MINI_CARD = new CardType("Î¢ÐÍ¿¨");

    public String getDesc() {
        return desc;
    }

    private CardType(String desc) {
        this.desc = desc;
    }
}
