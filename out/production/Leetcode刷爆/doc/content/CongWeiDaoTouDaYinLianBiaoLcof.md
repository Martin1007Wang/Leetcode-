<p>输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>head = [1,3,2]
<strong>输出：</strong>[2,3,1]</pre>

<p>&nbsp;</p>

<p><strong>限制：</strong></p>

<p><code>0 &lt;= 链表长度 &lt;= 10000</code></p>

<details><summary><strong>Related Topics</strong></summary>栈 | 递归 | 链表 | 双指针</details><br>

<div>👍 430, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这题解法很多，比如我们可以借助「[栈](https://appktavsiei5995.pc.xiaoe-tech.com/detail/p_6265457ce4b09dda125f9bc2/6)」这种先进后出的结构来得到链表的倒序遍历结果，但是本文使用 [东哥手把手带你刷二叉树（纲领篇）](https://labuladong.github.io/article/fname.html?fname=二叉树总结) 和 [递归链表](https://appktavsiei5995.pc.xiaoe-tech.com/detail/p_626554bae4b0cedf38a9371e/6) 中讲到的后序遍历技巧来写代码。

递归函数本质上就是让操作系统帮我们维护了递归栈，和栈的解法效率上完全相同，但是这样写代码有助于我们深入理解递归的思维。

**标签：[栈](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121993002939219969)，[链表](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)**

## 解法代码

提示：🟢 标记的是我写的解法代码，🤖 标记的是 chatGPT 翻译的多语言解法代码。如有错误，可以 [点这里](https://github.com/labuladong/fucking-algorithm/issues/1113) 反馈和修正。

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
public:
    vector<int> reversePrint(ListNode* head) {
        traverse(head);
        return res;
    }

    // 记录链表长度
    int len = 0;
    // 结果数组
    vector<int> res;
    // 结果数组中的指针
    int p = 0;

    // 递归遍历单链表
    void traverse(ListNode* head) {
        if (head == nullptr) {
            // 到达链表尾部，此时知道了链表的总长度
            // 创建结果数组
            res.resize(len);
            return;
        }
        len++;
        traverse(head->next);
        // 后序位置，可以倒序操作链表
        res[p] = head->val;
        p++;
    }

    // 用「分解问题」的思路写递归解法
    // 因为 C++ 的 vector 可以支持 push_back 操作，所以我们不需要改变返回值类型
    vector<int> reversePrint2(ListNode* head) {
        // base case
        if (head == nullptr) {
            return {};
        }

        // 把子链表翻转的结果算出来，示例 [3,2]
        vector<int> subProblem = reversePrint2(head->next);
        // 把 head 的值接到子链表的翻转结果的尾部，示例 [3,2,1]
        subProblem.push_back(head->val);
        return subProblem;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def reversePrint(self, head: ListNode) -> List[int]:
        # 用「遍历」的思路写递归解法
        def traverse(head):
            nonlocal len_, res, p
            if not head:
                res = [0] * len_
                return
            len_ += 1
            traverse(head.next)
            res[p] = head.val
            p += 1
        
        len_ = 0
        res = []
        p = 0
        traverse(head)
        return res

    def reversePrint2(self, head: ListNode) -> List[int]:
        # 用「分解问题」的思路写递归解法
        def sub_problem(head):
            if not head:
                return []
            sub_res = sub_problem(head.next)
            sub_res.append(head.val)
            return sub_res
        
        return sub_problem(head)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
// 用「遍历」的思路写递归解法
class Solution {
    public int[] reversePrint(ListNode head) {
        traverse(head);
        return res;
    }

    // 记录链表长度
    int len = 0;
    // 结果数组
    int[] res;
    // 结果数组中的指针
    int p = 0;

    // 递归遍历单链表
    void traverse(ListNode head) {
        if (head == null) {
            // 到达链表尾部，此时知道了链表的总长度
            // 创建结果数组
            res = new int[len];
            return;
        }
        len++;
        traverse(head.next);
        // 后序位置，可以倒序操作链表
        res[p] = head.val;
        p++;
    }



    // 用「分解问题」的思路写递归解法
    // 因为 Java 的 int[] 数组不支持 add 相关的操作，所以我们把返回值修改成 List
    // 定义：输入一个单链表，返回该链表翻转的值，示例 1->2->3
    List<Integer> reversePrint2(ListNode head) {
        // base case
        if (head == null) {
            return new LinkedList<>();
        }

        // 把子链表翻转的结果算出来，示例 [3,2]
        List<Integer> subProblem = reversePrint2(head.next);
        // 把 head 的值接到子链表的翻转结果的尾部，示例 [3,2,1]
        subProblem.add(head.val);
        return subProblem;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

/*
用「遍历」的思路写递归解法
*/

func reversePrint(head *ListNode) []int {
    var res []int
    var len int

    // 递归遍历单链表
    var traverse func(*ListNode)
    traverse = func(head *ListNode) {
        if head == nil {
            // 到达链表尾部，此时知道了链表的总长度
            // 创建结果数组
            res = make([]int, len)
            return
        }
        len++
        traverse(head.Next)
        // 后序位置，可以倒序操作链表
        res[len-p-1] = head.Val
        p++
    }

    traverse(head)
    return res
}

/*
用「分解问题」的思路写递归解法
因为 Go 不支持泛型，所以我们把返回值修改成 []int
定义：输入一个单链表，返回该链表翻转的值，示例 1->2->3
*/
func reversePrint2(head *ListNode) []int {
    // base case
    if head == nil {
        return []int{}
    }

    // 把子链表翻转的结果算出来，示例 [3,2]
    subProblem := reversePrint2(head.Next)
    // 把 head 的值接到子链表的翻转结果的尾部，示例 [3,2,1]
    return append(subProblem, head.Val)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * 用「遍历」的思路写递归解法
 */

var reversePrint = function(head) {
  let len = 0; // 记录链表长度
  let res = []; // 结果数组
  let p = 0; // 结果数组中的指针

  // 递归遍历单链表
  const traverse = (head) => {
    if (!head) {
      // 到达链表尾部，此时知道了链表的总长度
      // 创建结果数组
      res = new Array(len);
      return;
    }
    len++;
    traverse(head.next);
    // 后序位置，可以倒序操作链表
    res[p] = head.val;
    p++;
  };

  traverse(head);
  return res;
};


/**
 * 用「分解问题」的思路写递归解法
 * 因为 Java 的 int[] 数组不支持 add 相关的操作，所以我们把返回值修改成 List
 * 定义：输入一个单链表，返回该链表翻转的值，示例 1->2->3
 */
var reversePrint2 = function(head) {
  // base case
  if (!head) {
    return new LinkedList();
  }

  // 把子链表翻转的结果算出来，示例 [3,2]
  let subProblem = reversePrint2(head.next);
  // 把 head 的值接到子链表的翻转结果的尾部，示例 [3,2,1]
  subProblem.push(head.val);
  return subProblem;
};
```

</div></div>
</div></div>

<details open><summary><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_cong-wei-dao-tou-da-yin-lian-biao-lcof" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_cong-wei-dao-tou-da-yin-lian-biao-lcof"></div></div>
</details><hr /><br />

</details>
</div>



