给你单链表的头指针 <code>head</code> 和两个整数 <code>left</code> 和 <code>right</code> ，其中 <code>left <= right</code> 。请你反转从位置 <code>left</code> 到位置 <code>right</code> 的链表节点，返回 <strong>反转后的链表</strong> 。

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/rev2ex2.jpg" style="width: 542px; height: 222px;" /> 
<pre>
<strong>输入：</strong>head = [1,2,3,4,5], left = 2, right = 4
<strong>输出：</strong>[1,4,3,2,5]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>head = [5], left = 1, right = 1
<strong>输出：</strong>[5]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>链表中节点数目为 <code>n</code></li> 
 <li><code>1 &lt;= n &lt;= 500</code></li> 
 <li><code>-500 &lt;= Node.val &lt;= 500</code></li> 
 <li><code>1 &lt;= left &lt;= right &lt;= n</code></li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong> 你可以使用一趟扫描完成反转吗？</p>

<details><summary><strong>Related Topics</strong></summary>链表</details><br>

<div>👍 1579, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=reverse-linked-list-ii" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 283 页。

迭代解法很简单，用一个 for 循环即可，但这道题经常用来考察递归思维，让你用纯递归的形式来解决，这里就给出递归解法的思路。

要想真正理解递归操作链表的代码思路，需要从递归翻转整条链表的算法开始，推导出递归翻转前 `N` 个节点的算法，最后改写出递归翻转区间内的节点的解法代码。

关键点还是要明确递归函数的定义，由于内容和图比较多，这里就不写了，请看详细题解。

**详细题解：[递归魔法：反转单链表](https://labuladong.github.io/article/fname.html?fname=递归反转链表的一部分)**

**标签：[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)，递归，[链表](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)，[链表双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)**

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
    ListNode* reverseBetween(ListNode* head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head->next = reverseBetween(head->next, m - 1, n - 1);
        return head;
    }

private:
    ListNode* successor = nullptr; // 后驱节点
    // 反转以 head 为起点的 n 个节点，返回新的头结点
    ListNode* reverseN(ListNode* head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head->next;
            return head;
        }
        // 以 head->next 为起点，需要反转前 n - 1 个节点
        ListNode* last = reverseN(head->next, n - 1);

        head->next->next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head->next = successor;
        return last;/**<extend up -90>![](https://labuladong.github.io/pictures/反转链表/7.jpg) */
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        # base case
        if m == 1:
            return self.reverseN(head, n)
        # 前进到反转的起点触发 base case
        head.next = self.reverseBetween(head.next, m - 1, n - 1)
        return head

    successor = None # 后驱节点
    # 反转以 head 为起点的 n 个节点，返回新的头结点
    def reverseN(self, head: ListNode, n: int) -> ListNode:
        if n == 1:
            # 记录第 n + 1 个节点
            self.successor = head.next
            return head
        # 以 head.next 为起点，需要反转前 n - 1 个节点
        last = self.reverseN(head.next, n - 1)

        head.next.next = head
        # 让反转之后的 head 节点和后面的节点连起来
        head.next = self.successor
        return last # <extend up -90>![](https://labuladong.github.io/pictures/反转链表/7.jpg) #
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    ListNode successor = null; // 后驱节点
    // 反转以 head 为起点的 n 个节点，返回新的头结点
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;/**<extend up -90>![](https://labuladong.github.io/pictures/反转链表/7.jpg) */
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
 
func reverseBetween(head *ListNode, m int, n int) *ListNode {
    var successor *ListNode // 后驱节点

    // 反转以 head 为起点的 n 个节点，返回新的头结点
    var reverseN func(head *ListNode, n int) (*ListNode)
    reverseN = func(head *ListNode, n int) (*ListNode) {
        if n == 1 {
            // 记录第 n + 1 个节点
            successor = head.Next
            return head
        }
        // 以 head.Next 为起点，需要反转前 n - 1 个节点
        last := reverseN(head.Next, n - 1)

        head.Next.Next = head
        // 让反转之后的 head 节点和后面的节点连起来
        head.Next = successor
        return last
    }

    // base case
    if m == 1 {
        return reverseN(head, n)
    }
    // 前进到反转的起点触发 base case
    head.Next = reverseBetween(head.Next, m - 1, n - 1)
    return head
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var reverseBetween = function(head, m, n) {
    let successor = null;
    // 反转以 head 为起点的 n 个节点，返回新的头结点
    const reverseN = function(head, n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        const last = reverseN(head.next, n - 1);
        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;/**<extend up -90>![](https://labuladong.github.io/pictures/反转链表/7.jpg) */
    };
    // base case
    if (m == 1) {
        return reverseN(head, n);
    }
    // 前进到反转的起点触发 base case
    head.next = reverseBetween(head.next, m - 1, n - 1);
    return head;
};
```

</div></div>
</div></div>

<details open><summary><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_reverse-linked-list-ii" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_reverse-linked-list-ii"></div></div>
</details><hr /><br />

**类似题目**：
  - [206. 反转链表 🟢](/problems/reverse-linked-list)
  - [剑指 Offer 24. 反转链表 🟢](/problems/fan-zhuan-lian-biao-lcof)
  - [剑指 Offer II 024. 反转链表 🟢](/problems/UHnkqh)

</details>
</div>



