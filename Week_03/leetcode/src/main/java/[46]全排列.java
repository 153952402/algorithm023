//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1065 👎 0



import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class PermutationsSolution{
    
    public static void main(String[] args) {
        Solution solution = new PermutationsSolution().new Solution();
    }
    
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        tow(nums, 0, results);
        return results;
    }



}
//leetcode submit region end(Prohibit modification and deletion)


    /**
     * 第一次解答
     */
    private void tow(int[] nums, int index, List<List<Integer>> results) {
        if(index == nums.length) {
            results.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for(int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            tow(nums, index + 1, results);
            swap(nums, i, index);
        }
    }

    /**
     * 答案
     */
    private void one(int[] nums, int index, List<List<Integer>> results) {
        if(index == nums.length) {
            List<Integer> result = new ArrayList<>();
            for(int num : nums) {
                result.add(num);
            }
            results.add(result);
            return;
        }
        for(int i = index; i < nums.length; i++) {
            swap(nums, i ,index);
            one(nums, index + 1, results);
            swap(nums, i, index);
        }
    }
    private void swap(int[] nums, int i , int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}