//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 469 👎 0


import java.util.ArrayList;
import java.util.List;

class CombinationsSolution{
    
    public static void main(String[] args) {
        Solution solution = new CombinationsSolution().new Solution();
    }
    
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(n,0, k, new ArrayList<>(), results);
        return results;
    }

    private void dfs(int n, int index, int k, List<Integer> path, List<List<Integer>> results) {
        if(path.size() == k) {
            results.add(new ArrayList<>(path));
            return;
        }
        for(int i = index + 1; i <= n; i++) {
            path.add(i);
            dfs(n,  i, k, path, results);
            path.remove(path.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
}