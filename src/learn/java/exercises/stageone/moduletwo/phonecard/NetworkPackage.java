package learn.java.exercises.stageone.moduletwo.phonecard;

/**
 * @author xxywindows@hotmail.com
 */
public class NetworkPackage extends AbstractPackage implements NetworkServiceInterface {

    private int networkFlow;

    public NetworkPackage(int networkFlow,double postage) {
       setNetworkFlow(networkFlow);
       setPostage(postage);
    }

    public int getNetworkFlow() {
        return networkFlow;
    }

    public void setNetworkFlow(int networkFlow) {
        this.networkFlow = networkFlow;
    }

    @Override
    public void show() {
        System.out.printf("上网流量：%d ,  每月资费: %f \n", getNetworkFlow(), getPostage());
    }

    @Override
    public void show(int networkFlow, PhoneCard phoneCard) {
        phoneCard.show();
        this.show();
    }
}
