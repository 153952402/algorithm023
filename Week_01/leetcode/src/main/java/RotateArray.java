
public class RotateArray {
    /**
     * 旋转数组
     *
     * 审题：
     *      1. 要求使用空间复杂度为 O(1) 的 原地 算法。
     *      2. 向右移动 K 个位置，K的值可能超过数组长度
     * 边界条件
     *      1. 数组为空数组
     *      2. K >= nums.length
     * 可用解法
     *      1. 分K次移动，通过system.array.copy每次仅移动一个元素
     *          时间：O(k*n) 空间：O(1)
     *      2. 反转
     *          时间：O(2n) 空间：O(1)
     *      3. 循环移动 (最优解法)
     *          时间：O(n) 空间：O(1)
     */


    /**
     * 循环移动
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int i = 0;
        for(int start = 0; i < nums.length; start++) {
            int current = start;
            int num = nums[current];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = num;
                num = temp;
                current = next;
                i++;
            } while (current != start);
        }
    }
}
