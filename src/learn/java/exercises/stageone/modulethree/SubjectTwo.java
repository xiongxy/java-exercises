package learn.java.exercises.stageone.modulethree;


/**
 * @author xxywindows@hotmail.com
 */
public class SubjectTwo {
    public static void main(String[] args) {
        final String s1 = "asdafghjka", s2 = "aaasdfg";
        String max = (s1.length() > s2.length()) ? s1 : s2;
        String min = (max.equals(s1)) ? s2 : s1;
        for (int i = 0; i < min.length(); i++) {
            for (int y = 0, z = min.length() - i; z != min.length() + 1; y++, z++) {
                String maxSubString = min.substring(y, z);
                if (max.contains(maxSubString)) {
                    System.out.println("最大子串为:" + maxSubString);
                    return;
                }
            }
        }
    }
}
