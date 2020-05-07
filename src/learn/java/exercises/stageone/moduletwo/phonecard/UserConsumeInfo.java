package learn.java.exercises.stageone.moduletwo.phonecard;

/**
 * @author xxywindows@hotmail.com
 */
public class UserConsumeInfo {
    private int totalTalkTime;
    private int totalNetworkFlow;
    private double postage;

    public UserConsumeInfo(int totalTalkTime, int totalNetworkFlow, double postage) {
        setTotalTalkTime(totalTalkTime);
        setTotalNetworkFlow(totalNetworkFlow);
        setPostage(postage);
    }

    public int getTotalTalkTime() {
        return totalTalkTime;
    }

    public void setTotalTalkTime(int totalTalkTime) {
        this.totalTalkTime = totalTalkTime;
    }

    public int getTotalNetworkFlow() {
        return totalNetworkFlow;
    }

    public void setTotalNetworkFlow(int totalNetworkFlow) {
        this.totalNetworkFlow = totalNetworkFlow;
    }

    public double getPostage() {
        return postage;
    }

    public void setPostage(double postage) {
        this.postage = postage;
    }
}
