
public class MergeSortedArray {
    /**
     * 审题：
     *      1. 待合并数组有序且升序
     *      2. 待合并数组nums1有足够空间容纳两个待合并数组中的所有元素
     * 边界条件：
     *      1. 待合并数组均为空数组
     *      2. 待合并数组nums1、nums2其中有一个为空，另一个不为空
     *      3. 待合并数组元素均相同
     *      4. nums1数组中最小值大于nums2数组中的最大值
     * 可用解法
     *      1. 类似归并，从数组后往前依次填入最大值
     *          时间 O(m+n) 空间 O(1)
     *
     */

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n -1;
        int p = m - 1;
        int q = n - 1;
        while (q >= 0) {
            // p > 0 解决 nums1最小元素大于nums2最小元素的情况
            //即 nums1 {4,5,6} , nums2 {1,2,3}
            if (p > 0 && nums1[p] >= nums2[q]) {
                nums1[i] = nums1[p--];
            } else {
                nums1[i] = nums2[q--];
            }
            i++;
        }
    }
}
