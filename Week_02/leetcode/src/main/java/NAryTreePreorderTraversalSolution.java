import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * N 叉树的前序遍历
 */
public class NAryTreePreorderTraversalSolution {
    /**
     * 递归解法
     */
    public List<Integer> preorder_recursive(Node root) {
        List<Integer> list = new ArrayList<>();
        recursive(root, list);
        return list;
    }
    private void recursive(Node root, List<Integer> list) {
        if(root == null) return;
        list.add(root.val);
        for (Node children : root.children) {
            recursive(children, list);
        }
    }

    /**
     * 迭代解法
     */
    public List<Integer> preorder_loop(Node root) {
        List<Integer> result = new ArrayList<>();
        Deque<Node> stack = new LinkedList();
        stack.add(root);
        while (!stack.isEmpty()) {
           Node node = stack.pop();
           result.add(node.val);
           for(int i = node.children.size() - 1; i >= 0; i--) {
               stack.push(node.children.get(i));
           }
        }
        return result;
    }

    class Node {
        public int val;
        public List<Node> children;
        public Node() {}
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
