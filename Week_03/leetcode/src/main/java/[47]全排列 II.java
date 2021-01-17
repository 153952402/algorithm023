import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class PermutationsIiSolution{
    
    public static void main(String[] args) {
        Solution solution = new PermutationsIiSolution().new Solution();
        solution.permuteUnique(new int[]{0,1,0,9});
    }
    
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        backtrace(nums, 0, new boolean[nums.length], new int[nums.length], results);
        return results;
    }


    /**
     * 第一次解答 2021年1月17日 15:32:55
     */
    private void backtrace(int[] nums, int index, boolean[] used, int[] path, List<List<Integer>> results) {
        //终止条件
        if(index == nums.length) {
            results.add(Arrays.stream(path).boxed().collect(Collectors.toList()));
            return;
        }
        //递归逻辑
        for(int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为如果used[i-1]为true, 则必定是上层递归使用的，与本层递归无关，
            // 不能算作本层的重复使用
            if (i > 0 && nums[i] == nums[i - 1] && !used[i- 1]) {
                continue;
            }
            path[index] = nums[i];
            used[i] = true;
            backtrace(nums, index + 1, used, path, results);
            used[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)




}