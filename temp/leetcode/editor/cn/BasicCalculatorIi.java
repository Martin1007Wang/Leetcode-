//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 整数除法仅保留整数部分。 
//
// 你可以假设给定的表达式总是有效的。所有中间结果将在 [-2³¹, 2³¹ - 1] 的范围内。 
//
// 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "3+2*2"
//输出：7
// 
//
// 示例 2： 
//
// 
//输入：s = " 3/2 "
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：s = " 3+5 / 2 "
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开 
// s 表示一个 有效表达式 
// 表达式中的所有整数都是非负整数，且在范围 [0, 2³¹ - 1] 内 
// 题目数据保证答案是一个 32-bit 整数 
// 
//
// Related Topics栈 | 数学 | 字符串 
//
// 👍 701, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BasicCalculatorIi {
    public static void main(String[] args) {
        Solution solution = new BasicCalculatorIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            Queue<Character> queue = new LinkedList<Character>();
            for (char c : s.toCharArray()) {
                queue.add(c);
            }
            return helper(queue);
        }

        public int helper(Queue<Character> queue) {
            Stack<Integer> stack = new Stack<>();
            char sign = '+';
            int num = 0;
            while (!queue.isEmpty()) {
                char c = queue.poll();
                if (Character.isDigit(c)) {
                    num = 10 * num + Character.getNumericValue(c);
                }if (c == '(') {
                    helper(queue);
                }if (!Character.isDigit(c) && c != ' ' || queue.isEmpty()) {
                    if (sign == '+') {
                        stack.push(num);
                    }if (sign == '-') {
                        stack.push(-num);
                    }if (sign == '*') {
                        stack.push(stack.pop() * num);
                    } if (sign == '/') {
                        stack.push(stack.pop() / num);
                    }
                    sign = c;
                    num = 0;
                }if (c == ')') {
                    break;
                }
            }
            int res = 0;
            for (int i : stack) {
                res += i;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}