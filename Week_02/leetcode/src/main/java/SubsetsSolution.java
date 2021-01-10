import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 */
public class SubsetsSolution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> temp) {
        if(i >= nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        //对于每一个数有两种情况
        //1. 该数加入子集
        temp.add(nums[i]);
        backtrack(i + 1, nums, res, temp);
        temp.remove(temp.size() - 1);

        //2. 该数不加入子集
        backtrack(i + 1, nums, res, temp);
    }
}
