package learn.java.exercises.stageone.moduletwo.phonecard;

/**
 * @author xxywindows@hotmail.com
 */
public interface NetworkServiceInterface {
    /**
     * fetch data by rule id
     *
     * @param networkFlow  networkFlow
     * @param phoneCard phoneCard
     */
    void show(int networkFlow, PhoneCard phoneCard);
}
