//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
// Related Topics 树 
// 👍 898 👎 0


import java.util.Deque;
import java.util.LinkedList;

class LowestCommonAncestorOfABinaryTreeSolution{
    
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTreeSolution().new Solution();
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
    /**
     * 方法二：递归求解
     *      时间：O(n) 空间：O(logn)
     */
    public TreeNode one_recursive(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = one_recursive(root, p , q);
        TreeNode right = one_recursive(root, p , q);
        if(left == null && right == null) {
            return null;
        }else if(left != null && right != null){
            return root;
        }else {
            return left == null ? right : left;
        }
    }

    /**
     * 方法一：栈求解
     *          时间：O(2n) 空间：O(2logn)
     */
    public TreeNode one_stack(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> stack_p = new LinkedList<TreeNode>();
        getStack(root, p, stack_p);
        Deque<TreeNode> stack_q = new LinkedList<TreeNode>();
        getStack(root, q, stack_q);
        while(stack_p.peek() != stack_q.peek()) {
            if(stack_p.size() > stack_q.size()) {
                stack_p.pop();
            }else if (stack_p.size() < stack_q.size()){
                stack_q.pop();
            }else {
                stack_q.pop();
                stack_p.pop();
            }
        }
        return stack_p.peek();
    }
    private void getStack(TreeNode root, TreeNode x, Deque<TreeNode> stack) {
        if(root == null) return;
        if(root == x) {
            stack.push(root);
            return;
        }
        stack.push(root);
        int size = stack.size();
        getStack(root.left, x, stack);
        getStack(root.right, x, stack);
        if(stack.size() == size) {
            stack.pop();
        }
    }
    
}