//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。 
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 
//输入：s = "leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由 可打印的 ASCII 字符组成 
// 
//
// Related Topics双指针 | 字符串 
//
// 👍 306, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        Solution solution = new ReverseVowelsOfAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isYuan(char a) {
            return a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u' || a == 'A' || a == 'E' || a == 'I' || a == 'O' || a == 'U';
        }

        public String reverseVowels(String s) {
            char[] c = s.toCharArray();
            if (c.length == 0) return null;
            int left = 0, right = s.length() - 1;
            while (left < right) {
                if (isYuan(c[left])) {
//                    System.out.println(String.valueOf(left) + ':' + c[left]);
                    while (!isYuan(c[right])) right--;
//                    System.out.println(String.valueOf(right) + ':' + c[right]);
                    char temp = c[right];
                    c[right] = c[left];
                    c[left] = temp;
                    right--;
                }
                left++;

            }
            return String.valueOf(c);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}