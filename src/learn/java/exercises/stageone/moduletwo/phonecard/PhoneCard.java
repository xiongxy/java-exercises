package learn.java.exercises.stageone.moduletwo.phonecard;


/**
 * @author xxywindows@hotmail.com
 */
public class PhoneCard {
    private CardType cardType;
    private String cardCode;
    private String userName;
    private String password;
    private double balance;
    private int talkTime;

    public PhoneCard(CardType cardType, String cardCode, String userName, String password, double balance, int talkTime) {
        setCardType(cardType);
        setCardCode(cardCode);
        setUserName(userName);
        setPassword(password);
        setBalance(balance);
        setTalkTime(talkTime);
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getTalkTime() {
        return talkTime;
    }

    public void setTalkTime(int talkTime) {
        this.talkTime = talkTime;
    }

    public void show() {
        System.out.printf("ø®∫≈£∫%s , ”√ªß√˚: %s , ”‡∂Ó %f \n", getCardCode(), getUserName(), getBalance());
    }

}
