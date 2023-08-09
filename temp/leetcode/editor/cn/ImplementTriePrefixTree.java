//Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼
//写检查。 
//
// 请你实现 Trie 类： 
//
// 
// Trie() 初始化前缀树对象。 
// void insert(String word) 向前缀树中插入字符串 word 。 
// boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 
//false 。 
// boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否
//则，返回 false 。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//输出
//[null, null, true, false, true, null, true]
//
//解释
//Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // 返回 True
//trie.search("app");     // 返回 False
//trie.startsWith("app"); // 返回 True
//trie.insert("app");
//trie.search("app");     // 返回 True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length, prefix.length <= 2000 
// word 和 prefix 仅由小写英文字母组成 
// insert、search 和 startsWith 调用次数 总计 不超过 3 * 10⁴ 次 
// 
//
// Related Topics设计 | 字典树 | 哈希表 | 字符串 
//
// 👍 1476, 👎 0 
//
//
//
//

public class ImplementTriePrefixTree {
    public static void main(String[] args) {
        Solution solution = new ImplementTriePrefixTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie {
        int N = 100009;
        int[][] trie;//使用二维数组来存储我们所有的单词字符
        int[] count;//使用count数组记录某个格子被「被标记为结尾的次数」（当idx编号的格子被标记了n次，则有cnt[idx]=n）。
        int index;//使用index来自增记录我们到底用了多少个格子（相当于给被用到格子进行编号）。

        public Trie() {
            trie = new int[N][26];
            count = new int[N];
            index = 0;
        }

        public void insert(String word) {
            int p = 0;
            for (int i = 0; i < word.length(); i++) {
                int u = word.charAt(i) - 'a';
                if (trie[p][u] == 0) trie[p][u] = ++index;
                p = trie[p][u];
            }
        }

        public boolean search(String word) {
            int p = 0;
            for (int i = 0; i < word.length(); i++) {
                int u = word.charAt(i) - 'a';
                if (trie[p][u] == 0) return false;
                p = trie[p][u];
            }
            return count[p] != 0;
        }

        public boolean startsWith(String prefix) {
            int p = 0;
            for (int i = 0; i < prefix.length(); i++) {
                int u = prefix.charAt(i) - 'a';
                if (trie[p][u] == 0) return false;
                p = trie[p][u];
            }
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}