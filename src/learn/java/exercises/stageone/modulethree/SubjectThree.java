package learn.java.exercises.stageone.modulethree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xxywindows@hotmail.com
 */
public class SubjectThree {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>(10);
        final String sample = "123,456,789,123,456";
        String[] array = sample.split(",");
        for (String b : array) {
            if (b.matches("[0-9]+")) {
                Integer temp = Integer.parseInt(b);
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                } else {
                    map.put(temp, 1);
                }
            }
        }
        map.forEach((k, v) -> System.out.println("Êý×Ö : " + k + "; ´ÎÊý : " + v));
    }
}
