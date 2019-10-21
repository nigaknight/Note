package singleton.singleton05;

/**
 * @author nigaknight
 * @time 2019/9/24
 **/
public class Solution {
    private static Solution ourInstance = new Solution();

    public static Solution getInstance() {
        return ourInstance;
    }

    private Solution() {
    }
}
