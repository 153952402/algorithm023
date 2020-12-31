
public class RemoveDuplicatesFromSortedArray {
    /**
     * 删除排序数组中的重复项
     *
     * 审题：
     *      1. 已排序数组，数组默认升序排序
     *      2. 原地修改数组，仅允许使用O(1)额外空间
     *      3. 不需要考虑数组中超出新长度后面的元素
     * 边界条件：
     *      1.空数组
     *      2.数组所有元素均相等
     *      3.没有重复元素
     * 可用解法：
     *      1. 开辟新数组，依次判重并复制（不符合题目要求）
     *          时间：O(n), 空间：O(n)
     *
     *      2. 双指针 (最优解法)
     *          时间：O(n), 空间：O(1)
     */


    /**
     * 双指针
     */
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 1;
        while (j < nums.length) {
            //++i != j 避免原地复制值
            if (nums[i] != nums[j] && ++i != j) {
                nums[i] = nums[j];
            }
            j++;
        }
        return ++i;
    }
}
