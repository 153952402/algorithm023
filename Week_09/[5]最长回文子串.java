//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3303 👎 0


package leetcode.editor.cn;
class LongestPalindromicSubstringSolution{
    
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstringSolution().new Solution();
    }
    
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int lo;
    private int maxLen;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2){
            return s;
        }
        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i+1);
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
}