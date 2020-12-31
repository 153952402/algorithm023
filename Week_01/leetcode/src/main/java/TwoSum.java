import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     * 审题：
     *      每种输入只会对应一个答案
     *      数组中同一个元素不能使用两遍。
     * 边界条件
     *      1.数组为空
     *
     * 可能解法：
     *      1.暴力双循环
     *          时间：O(n^2) 空间：O(1)
     *      2.for循环 + hash
     *          时间：O(n) 空间：O(n)
     */

    /**
     * for循环 + hash
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(nums[i]);
            if (index == null) {
               return new int[] {index, i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }
}
