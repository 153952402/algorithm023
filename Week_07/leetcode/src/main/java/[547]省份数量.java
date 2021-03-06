//
// 
// 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连
//。 
//
// 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。 
//
// 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 
//isConnected[i][j] = 0 表示二者不直接相连。 
//
// 返回矩阵中 省份 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 200 
// n == isConnected.length 
// n == isConnected[i].length 
// isConnected[i][j] 为 1 或 0 
// isConnected[i][i] == 1 
// isConnected[i][j] == isConnected[j][i] 
// 
// 
// 
// Related Topics 深度优先搜索 并查集 
// 👍 496 👎 0


package leetcode.editor.cn;
class NumberOfProvincesSolution{
    
    public static void main(String[] args) {
        Solution solution = new NumberOfProvincesSolution().new Solution();
    }
    
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //DFS / unionFind
    public int findCircleNum(int[][] isConnected) {
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 方法一，深度优先搜索
     */
    class Solution_1_DFS {
        private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            boolean[] visited = new boolean[n];
            int count = 0;
            for(int i = 0; i < n; i++) {
                if(!visited[i]) {
                    dfs(isConnected, visited, i);
                    count++;
                }
            }
            return count;
        }

        private void dfs(int[][] isConnected, boolean[] visited, int i) {
            for(int j = 0; j < isConnected.length; j++) {
                if(isConnected[i][j] == 1 && !visited[j]) {
                    visited[j] = true;
                    dfs(isConnected, visited, j);
                }
            }
        }
    }

    /**
     * 方法二 并查集
     */
    class Solution_1_UnionFind {
        public int findCircleNum(int[][] isConnected) {
            UnionFind unionFind = new UnionFind(isConnected.length);
            for(int i = 0; i < isConnected.length; i++) {
                for(int j = 0; j < isConnected.length; j++) {
                    if(isConnected[i][j] == 1) {
                        unionFind.union(i, j);
                    }
                }
            }
            return unionFind.count;
        }

        class UnionFind {
            int[] parents;
            int count;
            public UnionFind(int n) {
                parents = new int[n];
                for(int i = 0; i < n; i++) {
                    parents[i] = i;
                }
                count = n;
            }
            public int find(int x) {
                if(parents[x] == x) {
                    return x;
                }
                return parents[x] = find(parents[x]);
            }

            public void union(int p, int q) {
                int pRoot = find(p);
                int qRoot = find(q);
                if(pRoot != qRoot) {
                    parents[pRoot] = qRoot;
                    count--;
                }
            }

        }
    }
    
}