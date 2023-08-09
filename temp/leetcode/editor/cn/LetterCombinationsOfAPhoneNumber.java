//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics哈希表 | 字符串 | 回溯 
//
// 👍 2507, 👎 0 
//
//
//
//

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> combinations = new ArrayList<String>();
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        public List<String> letterCombinations(String digits) {
            if (digits.length() == 0) {
                return combinations;
            }
            backtrack(digits, 0, new StringBuffer());
            return combinations;
        }

        public void backtrack(String digits, int start, StringBuffer combination) {
            //结束条件：start==digits.length();
            if (start == digits.length()) {
                combinations.add(combination.toString());
                return;
            }
            //获得start对应的字母串
            char digit = digits.charAt(start);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            //遍历可能路径
            for (int i = 0; i < lettersCount; i++) {
                //做出选择
                combination.append(letters.charAt(i));
                //移动到下一数字
                backtrack(digits, start + 1, combination);
                //回溯
                combination.deleteCharAt(start);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}