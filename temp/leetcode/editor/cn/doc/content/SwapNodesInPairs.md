<p>给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/swap_ex1.jpg" style="width: 422px; height: 222px;" /> 
<pre>
<strong>输入：</strong>head = [1,2,3,4]
<strong>输出：</strong>[2,1,4,3]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>head = []
<strong>输出：</strong>[]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>head = [1]
<strong>输出：</strong>[1]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>链表中节点的数目在范围 <code>[0, 100]</code> 内</li> 
 <li><code>0 &lt;= Node.val &lt;= 100</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>递归 | 链表</details><br>

<div>👍 1849, 👎 0<span style='float: right;'></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题不难，常规方法就是维护多个指针，遍历一遍链表顺便把每两个节点翻转。不过迭代的思路虽然直接，但细节问题会比较多，写起来麻烦。

所以我直接用递归的方式来写，只要搞明白递归函数的定义，然后利用这个定义就可以完成这道题。

其实前文 [如何 `k` 个一组反转链表](https://labuladong.github.io/article/fname.html?fname=k个一组反转链表) 中讲过的 [25. K 个一组翻转链表](/problems/reverse-nodes-in-k-group) 就是这道题的进阶版，你可以去做一做。

**标签：单链表，递归**

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
    // 定义：输入以 head 开头的单链表，将这个单链表中的每两个元素翻转，
    // 返回翻转后的链表头结点
public:
    ListNode* swapPairs(ListNode* head) {
        if (head == nullptr || head->next == nullptr) { //递归结束条件
            return head;
        }
        ListNode* first = head;
        ListNode* second = head->next;
        ListNode* others = head->next->next;
        // 先把前两个元素翻转
        second->next = first;
        // 利用递归定义，将剩下的链表节点两两翻转，接到后面
        first->next = swapPairs(others);
        // 现在整个链表都成功翻转了，返回新的头结点
        return second;/**<extend up -200>![](https://labuladong.github.io/pictures/kgroup/7.jpg) */
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
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        """
        :type head: ListNode
        :rtype: ListNode
        输入以 head 开头的单链表，将这个单链表中的每两个元素翻转，
        返回翻转后的链表头结点
        """
        if not head or not head.next:
            # 如果当前节点 head 为空, 或者下一个节点 head.next 为空, 将 head 直接返回
            return head
        # 定义三个变量, 分别为当前节点, 当前节点的下一个节点和下下个节点
        first, second, others = head, head.next, head.next.next
        # 先把前两个元素翻转
        second.next = first
        # 利用递归定义, 将剩下的链表节点两两翻转, 接到后面
        first.next = self.swapPairs(others)
        # 现在整个链表都成功翻转了, 返回新的头结点
        return second
        """
        原链表为：head → 1 → 2 → 3 → 4 → null，
        要求链表为：head → 2 → 1 → 4 → 3 → null。
        ![](https://labuladong.github.io/pictures/kgroup/7.jpg)
        """
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 定义：输入以 head 开头的单链表，将这个单链表中的每两个元素翻转，
    // 返回翻转后的链表头结点
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        ListNode others = head.next.next;
        // 先把前两个元素翻转
        second.next = first;
        // 利用递归定义，将剩下的链表节点两两翻转，接到后面
        first.next = swapPairs(others);
        // 现在整个链表都成功翻转了，返回新的头结点
        return second;/**<extend up -200>![](https://labuladong.github.io/pictures/kgroup/7.jpg) */
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

// 定义：输入以 head 开头的单链表，将这个单链表中的每两个元素翻转，
// 返回翻转后的链表头结点
func swapPairs(head *ListNode) *ListNode {
    if head == nil || head.Next == nil {
        return head
    }
    first := head
    second := head.Next
    others := head.Next.Next
    // 先把前两个元素翻转
    second.Next = first
    // 利用递归定义，将剩下的链表节点两两翻转，接到后面
    first.Next = swapPairs(others)
    // 现在整个链表都成功翻转了，返回新的头结点
    return second
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * 定义：输入以 head 开头的单链表，将这个单链表中的每两个元素翻转，
 * 返回翻转后的链表头结点
 */
var swapPairs = function(head) {
    if (head == null || head.next == null) {
        return head;
    }
    // 先把前两个元素翻转
    let first = head;
    let second = head.next;
    let others = head.next.next;
    second.next = first;
    // 利用递归定义，将剩下的链表节点两两翻转，接到后面
    first.next = swapPairs(others);
    // 现在整个链表都成功翻转了，返回新的头结点
    return second;/**<extend up -200>![](https://labuladong.github.io/pictures/kgroup/7.jpg) */
};
```

</div></div>
</div></div>

<details open><summary><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_swap-nodes-in-pairs" data="G7gREVWbpwC0SrDdoFEFecedPvOKLtP4xELksbH12QeMyNorv1YrX9+tvE5IjgaPqLKVAgYbAc5kYAdsvSNYBs6pOIPNICse9t9+r98lKbEjmvjqSmChKln4nLmzf4pA+7bALL/Skaanj+FcvxIk1FmL504GHG+7ufvvQJs4bO4a+IaBa80orINI4erL8fbpIBbI//Cfe6m8WRGJa98U8UpjZsGRu8Zmx/G57fN/3dcxg9CllnzTJgPVdEP/hECSS3AS1u467cv0LNU1b6GYnek2xphEjItNWz+3ik+q8H0ZVxDtTmHccqDRM1DFr9oTn+38Ky9/fHy23YARbL8dT6u3PoFXvXnOZOdU0Fo7PQ9tDf1C7Xqc7aFsN6JVlNEORp93bQclkYaSRbgxsRs9jw6YIgBe9yS3gGA30H2pSErcEuGK9K7LteOdOlf0HwyIjFj6FpNvvU8pu8zD3vr4DmSC1E3yYy9yFIIEn8y+G/AJBAIVFnN0uO16zNYz52NzF5AB6PcTZID0LbSFtjCFo9yuXJF5XJoWb56LKP/0KALW3AmD1F3i84niLM6QQ+rKJimbhQ1R5q5koohl0sn2mNddYSyw7eQny+X690U9W2x/NejNG0CUjW8m6+rp6i538BUYgbAj5+AnZeJE/6Ln4cZF0U0f7ccOP/RAlr+pFDaVk8seOtQs7nIbSIk3Rd08lWJMNwiQNN/6s1xt8fE0yJQk8AEOxrEoFneDgNks6rP2egPBsVpibmRvMaKdpNIgbmAWByqSdb+9nJs9QZhOF4iPvaktvEhOnf20tTnY2iEuOTWlJ93i21iU1m/YhJkmDZwP+Rozg/3oeFovpBsomd2gVV26QV9wCDELszvs0AXxXPAVSHCBYcm54CvgmLKoHLNUq7c1dQlO3Fe0hxfjMGn+lXpiL86Qk1oak31Vgg9uQ9Vv+fH1zRmVjdPC9K5BkN0qy3nvm6BK0Hz4m3oy//Yo98K/pE82cq3nQIRS+l9+lHqivBR+iiTe/Q0cORI50fBTQPStlrWpFBDQfJo7D9OgpFVMzvFCjTqkRumNq08zlJm6eRqC/fbGXBaFG3k226WHAQ8xBZc2PC1pV0noiOBsFkj3eNOhTLInzkTPjIHBh0vNkjve0t797vPsR6I+QftpaI99CxC0OCyJizNkxFCdL43QzNyR1H0g49ntF/IOZoB5WouvW9TAadnzslSbcUprwb3WOffyCBPb/l9DhMY2tauH4NsQfnx9A5+FstVXL2VhRNwcue8dqutZHK5TLxDBr4MOyoV5i+kVWZ52WsEwiXrLbLJBKLNsbkM5fhkXdA2Hv8tWNopUdEZsVNmUs/UGSnectfbW4qiJgTHPXL5ma/HH9R5mOXHoJW4pEWI4s0P4kn/RxtK7r0UnRKdy8gjE0XSKu1Zgd54uBiSwY//K2tF4oXYqoVw7urcYS9fUWCy/oridvvY2UGzlU5ZSgHhkGuSC5XuZ7yqSEAu2vOmJQp52HOztGVM3e5ujq4f51y3K2qBPUV6uz4HarnyPiyMY0/5N6n95ZrJsx4D1ugc8vUzpgvxyiMCyx5/JdvmvNyM2KvQSYD2y2Mg8eRz8aEEf1B0HxtTiBifZ83nyKNaG3Q3kFZvN7I4h6IoHDybRrLy5EZzv+6cOsBHuUgFbYC6+B1q83v8vBwebBG2WhRE0SYgb5zCnECx5QMgwFWColxwZhgosxsjRRCBJLza33RNO5ZhnDFb5qa5Fl+gH0yzlbHN9WXQbCizNHUAfkvYSekYWF6RUxaLOz5a9aEfM23d5q2BPhdhis2nYrwBT2/V6yVquu8Hm7FcyF7WtS8c4jVzvQabSYt48CkMKjjRc0k7/2RTmAy9CFLHt7u49D57KccL/xpMHj07zScn+7ADYegs="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_swap-nodes-in-pairs"></div></div>
</details><hr /><br />

</details>
</div>







