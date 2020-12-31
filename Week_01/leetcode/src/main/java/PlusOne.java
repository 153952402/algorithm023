
public class PlusOne {
    /**
     * 审题：
     *      数组所有元素为整数，数组首元素不会为0
     *  边界条件：
     *      1. 数组尾部元素可能为9，需要进一
     *      2. 数组所有元素都为9，需要开辟新数组存储溢出元素
     *      3. 数组中元素可能超过int值，甚至long
     *  可能解法
     *      1. 逆向循环数组，尾数加一,满十进一
     */

    public int[] plusOne(int[] digits) {
        for (int i = digits.length -1; i >= 0; i--) {
            if(i == 0 && digits[i] == 9) {
                int[] result = new int[digits.length];
                result[0] = 1;
                return result;
            }
            if(digits[i] == 9) {
                digits[i] = 0;
            }else {
                digits[i] = digits[i] + 1;
                break;
            }
        }
        return digits;
    }

}
