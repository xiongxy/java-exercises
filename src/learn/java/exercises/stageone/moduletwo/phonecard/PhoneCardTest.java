package learn.java.exercises.stageone.moduletwo.phonecard;


/**
 * @author xxywindows@hotmail.com
 */
public class PhoneCardTest {
    public static void main(String[] args) {

        PhoneCard phoneCard = new PhoneCard(CardType.BIG_CARD, "13717547947", "xiongxiaoyu", "123456789", 900, 1000);
        phoneCard.show();

        CallPackage callPackage = new CallPackage(900, 500, 900);
        AbstractPackage abstractCallPackage = callPackage;
        abstractCallPackage.show();

        CallServiceInterface callServiceInterface = callPackage;
        callServiceInterface.show(900, phoneCard);


        NetworkPackage networkPackage = new NetworkPackage(700, 900);
        AbstractPackage abstractNetworkPackage = networkPackage;
        abstractNetworkPackage.show();

        NetworkServiceInterface networkServiceInterface = networkPackage;
        networkServiceInterface.show(900, phoneCard);


    }
}
