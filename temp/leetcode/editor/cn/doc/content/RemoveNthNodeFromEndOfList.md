<p>给你一个链表，删除链表的倒数第&nbsp;<code>n</code><em>&nbsp;</em>个结点，并且返回链表的头结点。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/remove_ex1.jpg" style="width: 542px; height: 222px;" /> 
<pre>
<strong>输入：</strong>head = [1,2,3,4,5], n = 2
<strong>输出：</strong>[1,2,3,5]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>head = [1], n = 1
<strong>输出：</strong>[]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>head = [1,2], n = 1
<strong>输出：</strong>[1]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>链表中结点的数目为 <code>sz</code></li> 
 <li><code>1 &lt;= sz &lt;= 30</code></li> 
 <li><code>0 &lt;= Node.val &lt;= 100</code></li> 
 <li><code>1 &lt;= n &lt;= sz</code></li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你能尝试使用一趟扫描实现吗？</p>

<details><summary><strong>Related Topics</strong></summary>链表 | 双指针</details><br>

<div>👍 2561, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=remove-nth-node-from-end-of-list" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[链表双指针技巧全面汇总](https://www.bilibili.com/video/BV1q94y1X7vy)

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 64 页。

要删除倒数第 `n` 个节点，就得获得倒数第 `n + 1` 个节点的引用。

获取单链表的倒数第 `k` 个节点，就是想考察 [双指针技巧](https://labuladong.github.io/article/fname.html?fname=链表技巧) 中快慢指针的运用，一般都会要求你**只遍历一次链表**，就算出倒数第 `k` 个节点。

第一步，我们先让一个指针 `p1` 指向链表的头节点 `head`，然后走 `k` 步：

![](https://labuladong.github.io/pictures/链表技巧/1.jpeg)

第二步，用一个指针 `p2` 指向链表头节点 `head`：

![](https://labuladong.github.io/pictures/链表技巧/2.jpeg)

第三步，让 `p1` 和 `p2` 同时向前走，`p1` 走到链表末尾的空指针时走了 `n - k` 步，`p2` 也走了 `n - k` 步，也就是链表的倒数第 `k` 个节点：

![](https://labuladong.github.io/pictures/链表技巧/3.jpeg)

这样，只遍历了一次链表，就获得了倒数第 `k` 个节点 `p2`。

解法中在链表头部接一个虚拟节点 `dummy` 是为了避免删除倒数第一个元素时出现空指针异常，在头部加入 `dummy` 节点并不影响尾部倒数第 `k` 个元素是什么。

**详细题解：[双指针技巧秒杀七道链表题目](https://labuladong.github.io/article/fname.html?fname=链表技巧)**

**标签：[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)，[链表](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)，[链表双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)**

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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        // 虚拟头结点
        ListNode* dummy = new ListNode(-1);
        dummy->next = head;
        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode* x = findFromEnd(dummy, n + 1);
        // 删掉倒数第 n 个节点
        x->next = x->next->next;
        return dummy->next;
    }

    // 返回链表的倒数第 k 个节点
    ListNode* findFromEnd(ListNode* head, int k) {
        ListNode* p1 = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1->next;
        }
        ListNode* p2 = head;
        // p1 和 p2 同时走 n - k 步
        while (p1 != NULL) {
            p2 = p2->next;
            p1 = p1->next;
        }
        // p2 现在指向第 n - k 个节点
        return p2;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        # 虚拟头结点
        dummy = ListNode(-1)
        dummy.next = head
        # 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        x = self.findFromEnd(dummy, n + 1)
        # 删掉倒数第 n 个节点
        x.next = x.next.next
        return dummy.next

    # 返回链表的倒数第 k 个节点
    def findFromEnd(self, head: ListNode, k: int) -> ListNode:
        p1 = head
        # p1 先走 k 步
        for i in range(k):
            p1 = p1.next
        p2 = head
        # p1 和 p2 同时走 n - k 步
        while p1 != None:
            p1 = p1.next
            p2 = p2.next
        # p2 现在指向第 n - k 个节点
        return p2
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 主函数
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode x = findFromEnd(dummy, n + 1);
        // 删掉倒数第 n 个节点
        x.next = x.next.next;
        return dummy.next;
    }

    // 返回链表的倒数第 k 个节点
    ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        // p1 和 p2 同时走 n - k 步
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        // p2 现在指向第 n - k 个节点
        return p2;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

// 主函数
func removeNthFromEnd(head *ListNode, n int) *ListNode {
    // 虚拟头结点
    dummy := &ListNode{Val: -1, Next: head}
    // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
    x := findFromEnd(dummy, n + 1)
    // 删掉倒数第 n 个节点
    x.Next = x.Next.Next
    return dummy.Next
}

// 返回链表的倒数第 k 个节点
func findFromEnd(head *ListNode, k int) *ListNode {
    p1, p2 := head, head
    // p1 先走 k 步
    for i := 0; i < k; i++ {
        p1 = p1.Next
    }
    // p1 和 p2 同时走 n - k 步
    for p1 != nil {
        p1 = p1.Next
        p2 = p2.Next
    }
    // p2 现在指向第 n - k 个节点
    return p2
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var removeNthFromEnd = function(head, n) {
    // 虚拟头结点
    let dummy = new ListNode(-1);
    dummy.next = head;
    // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
    let x = findFromEnd(dummy, n + 1);
    // 删掉倒数第 n 个节点
    x.next = x.next.next;
    return dummy.next;
};

// 返回链表的倒数第 k 个节点
var findFromEnd = function(head, k) {
    let p1 = head;
    // p1 先走 k 步
    for (let i = 0; i < k; i++) {
        p1 = p1.next;
    }
    let p2 = head;
    // p1 和 p2 同时走 n - k 步
    while (p1 != null) {
        p2 = p2.next;
        p1 = p1.next;
    }
    // p2 现在指向第 n - k 个节点
    return p2;
};
```

</div></div>
</div></div>

<details open><summary><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_remove-nth-node-from-end-of-list" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_remove-nth-node-from-end-of-list"></div></div>
</details><hr /><br />

**类似题目**：
  - [141. 环形链表 🟢](/problems/linked-list-cycle)
  - [142. 环形链表 II 🟠](/problems/linked-list-cycle-ii)
  - [160. 相交链表 🟢](/problems/intersection-of-two-linked-lists)
  - [21. 合并两个有序链表 🟢](/problems/merge-two-sorted-lists)
  - [23. 合并K个升序链表 🔴](/problems/merge-k-sorted-lists)
  - [86. 分隔链表 🟠](/problems/partition-list)
  - [876. 链表的中间结点 🟢](/problems/middle-of-the-linked-list)
  - [剑指 Offer 22. 链表中倒数第k个节点 🟢](/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof)
  - [剑指 Offer 25. 合并两个排序的链表 🟢](/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof)
  - [剑指 Offer 52. 两个链表的第一个公共节点 🟢](/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof)
  - [剑指 Offer II 021. 删除链表的倒数第 n 个结点 🟠](/problems/SLwz0R)
  - [剑指 Offer II 022. 链表中环的入口节点 🟠](/problems/c32eOV)
  - [剑指 Offer II 023. 两个链表的第一个重合节点 🟢](/problems/3u1WK4)
  - [剑指 Offer II 078. 合并排序链表 🔴](/problems/vvXgSW)

</details>
</div>





