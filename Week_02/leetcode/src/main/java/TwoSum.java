import java.util.HashMap;

/**
 * 两数之和
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(nums[i]);
            if(index != null) {
                return new int[] {index, i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }
}
