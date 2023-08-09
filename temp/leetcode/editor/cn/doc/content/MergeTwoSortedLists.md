<p>将两个升序链表合并为一个新的 <strong>升序</strong> 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。&nbsp;</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/merge_ex1.jpg" style="width: 662px; height: 302px;" /> 
<pre>
<strong>输入：</strong>l1 = [1,2,4], l2 = [1,3,4]
<strong>输出：</strong>[1,1,2,3,4,4]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>l1 = [], l2 = []
<strong>输出：</strong>[]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>l1 = [], l2 = [0]
<strong>输出：</strong>[0]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>两个链表的节点数目范围是 <code>[0, 50]</code></li> 
 <li><code>-100 &lt;= Node.val &lt;= 100</code></li> 
 <li><code>l1</code> 和 <code>l2</code> 均按 <strong>非递减顺序</strong> 排列</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>递归 | 链表</details><br>

<div>👍 3144, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 即将开始，最后 1 天报名！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=merge-two-sorted-lists" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[链表双指针技巧全面汇总](https://www.bilibili.com/video/BV1q94y1X7vy)

经典算法题了，[双指针技巧](https://labuladong.github.io/article/fname.html?fname=链表技巧) 用起来。

![](https://labuladong.github.io/pictures/链表技巧/1.gif)

这个算法的逻辑类似于「拉拉链」，`l1, l2` 类似于拉链两侧的锯齿，指针 `p` 就好像拉链的拉索，将两个有序链表合并。

**代码中还用到一个链表的算法题中是很常见的「虚拟头结点」技巧，也就是 `dummy` 节点**，它相当于是个占位符，可以避免处理空指针的情况，降低代码的复杂性。

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
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        // 虚拟头结点
        ListNode* dummy = new ListNode(-1), *p = dummy;
        ListNode* p1 = l1, *p2 = l2;

        while (p1 != nullptr && p2 != nullptr) {/**<extend down -200>![](https://labuladong.github.io/pictures/链表技巧/1.gif) */
            // 比较 p1 和 p2 两个指针
            // 将值较小的的节点接到 p 指针
            if (p1->val > p2->val) {
                p->next = p2;
                p2 = p2->next;
            } else {
                p->next = p1;
                p1 = p1->next;
            }
            // p 指针不断前进
            p = p->next;
        }

        if (p1 != nullptr) {
            p->next = p1;
        }

        if (p2 != nullptr) {
            p->next = p2;
        }

        return dummy->next;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        # 虚拟头结点
        dummy = ListNode(-1)
        p = dummy
        p1 = l1
        p2 = l2

        while p1 and p2: # <extend down -200>![](https://labuladong.github.io/pictures/链表技巧/1.gif) #
            # 比较 p1 和 p2 两个指针
            # 将值较小的的节点接到 p 指针
            if p1.val > p2.val:
                p.next = p2
                p2 = p2.next
            else:
                p.next = p1
                p1 = p1.next
            # p 指针不断前进
            p = p.next

        if p1:
            p.next = p1

        if p2:
            p.next = p2

        return dummy.next
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 虚拟头结点
        ListNode dummy = new ListNode(-1), p = dummy;
        ListNode p1 = l1, p2 = l2;

        while (p1 != null && p2 != null) {/**<extend down -200>![](https://labuladong.github.io/pictures/链表技巧/1.gif) */
            // 比较 p1 和 p2 两个指针
            // 将值较小的的节点接到 p 指针
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            // p 指针不断前进
            p = p.next;
        }

        if (p1 != null) {
            p.next = p1;
        }

        if (p2 != null) {
            p.next = p2;
        }

        return dummy.next;
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
func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
    // 虚拟头结点
    dummy := &ListNode{-1, nil}
    p := dummy
    p1 := l1
    p2 := l2

    for p1 != nil && p2 != nil {/**<extend down -200>![](https://labuladong.github.io/pictures/链表技巧/1.gif) */
        // 比较 p1 和 p2 两个指针
        // 将值较小的的节点接到 p 指针
        if p1.Val > p2.Val {
            p.Next = p2
            p2 = p2.Next
        } else {
            p.Next = p1
            p1 = p1.Next
        }
        // p 指针不断前进
        p = p.Next
    }

    if p1 != nil {
        p.Next = p1
    }

    if p2 != nil {
        p.Next = p2
    }

    return dummy.Next
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
    // 虚拟头结点
    var dummy = new ListNode(-1), p = dummy;
    var p1 = l1, p2 = l2;

    while (p1 !== null && p2 !== null) {/**<extend down -200>![](https://labuladong.github.io/pictures/链表技巧/1.gif) */
        // 比较 p1 和 p2 两个指针
        // 将值较小的的节点接到 p 指针
        if (p1.val > p2.val) {
            p.next = p2;
            p2 = p2.next;
        } else {
            p.next = p1;
            p1 = p1.next;
        }
        // p 指针不断前进
        p = p.next;
    }

    if (p1 !== null) {
        p.next = p1;
    }

    if (p2 !== null) {
        p.next = p2;
    }

    return dummy.next;
};
```

</div></div>
</div></div>

<details open><summary><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_merge-two-sorted-lists" data="G1FGIxHCxoEIgZ9nFNJFRSkjoogPoFYHvCH61Geo1W5GiBqpCZFX2DGvM98hb35iXuOEEU7Uvxisb22MxB1bIimHdlBVuyf9BzzYgXYnk5xUdJ0fzqVOaI9pLoeZKvtv0pRkXbuf0vfO4BCE+AspEwOyO4/71RKTSc1lDs/6dziI4ve/3+/VDiFTAqGbJqk08Qp33ls74hYioXDueTODW3o0857J7aJf4P/7ve/0586fFEopByPQKdUh1J9IhOPec7JorSj63+9Rm0JlUCEqgxEoB+HixGIJPHxQ3EWDUFmqo7/3vA5pqBKIK9nQbraG1i+52gUFRCfn9wWfB4w399zR197TRDcNPfAXBu4i5TCpw3sRWb0v3g8TM3rxO14R0z/juR9gsfSHIiY24x/dW7vS80t/gcOJ+3sMAotICJUnJuxRkw8gh8teBicTi1hgo/ulmx0yFv5bC4cXYPvY2kDtbV+Uia2ysvR+NGMfpqZd/kXu1V2IaOtAQFXk2duSbuoq0VQ6t7zZ6JwGm4zwF0xzIvLf25NbaBHFyszVvm4mL3FU9z7UKhHl4oOb5zbjAW7sHxgiQu+mlwxeOS9oQeEqN6id3h6W9ooTSfXaorfbnDfAzV3nQfTVTWOCjbTuMr/NjONM0RfrVYNNt6K8dvzQ+5dyIBZBeD0HujZvCm7sbexsHl2+ZUaBMa6SPoWOhj5UdnWln4TbZ3luImuX/WJ2TMxLFegO+7kCP1NRblMlb05IaavmCSH9xKUL91eh3o7tFvRcqNcTSwztnDaXIlKzIQqA7XkwDh/z9OQGxWQAObWYwUmFFFoHQuV/D3XbF15Pz14+mxSQA7k7y3bJGfkGOyU3cOc8tcvviX6E/etQ9p+594OvX3Tjws37+XWHN4iqpqqtumSJtjEJc/hlgnfa8JFU6ZhvhHhGfiKN/5M+xNsG7IrdNnhoPjuRIyhMHOswOzaQgJnz1Cv/7pb8GrSg/J3OIKpqO/rhGeRUX3ABSd9nICeUxv/WXTN4qQLQsugC7ORaNB1q/B/JVpN4ovTjM8ipvuACkr4VQH4ijb+34tknCzipAqAwXYAdG0igg8Z3PHCVxBKlH55BbvUFF5D0fRbOyAml8f/trhm8VAFoWTQBdgotmig1fjNlS0ksUfrxGeRWX3ABSd8KID+Rxt878eyTBZxUAVCYLsCODSTQQeMXLb+3JJYo/fAMcqsvuICk77NwRk4ojf/vds3gpQpAy6IJsFNr0dgEFQX6AEH6sdkdyyxtBBeQpA/4uRLDqjRrHWDntAy7kszWll3PpC6I0aoXz1KxKDa+smTn22YH0nsLHzk3unSLDaQI/VsxAjA2kDHwQnCEpbGOuD1oKzRmWHKUZXfLW0Y7KBR2ygZ5+zPctjzyKHkcJR6gy+vCA2zZqAZvjI9v9vmu4ps5Pa2xy/d7YXGNnNLJk8Qd1azqKCWz7SR5h3qSyypAFYoO9kSfChhyi6aa2XSzG/uHeBw9jTVrDJ2BQ8f16ah5io7taV1SAa2QoqN7apdVwDwFRYd7sk8FvEukyTuyp/SpgMChOPr1Lcvdl1LV5Ny9G3Y6IK7LPfXgZk6+FNecZo5jVHdLqpmXmepC9TJa1qZ4Ljb5EyYlKd4/HMYyKMWb1T9Lnjrm2Hq2ReCogDKRTaKyIoy0HgCTNlBmYDZqUgGUzQ1cuwo2BnU7olXYaq9qTUai0nrEpFrrZFWBiDKVy7SjchpUjqGdA6p7iFJd6oxtKQxYoKTt2vnbUngUYXHJbqZs87L4rlV+fuiVk2GI2TJOXKX34jPposz9F/+92dVaOHXT3dybplyy/VeQw6n2/sthVaF6vueIMvddLvbq/Id7VjFYiYa5sw/b17OpGfoarmO82C2uJ/f2YjCMgNt4CGhOdjfotESt5mwueAbuq8ZgXgudivvfhIsw3JVZGNRQ1k2D2rIxMU5zdgxIrhgWWm7S/Q7by7fQJevrwedgO/fV5HjVHG3UriC2H4Cz9R5a8k0i4GhvrkaWUNccLQWJSLT0ikSmN9ZijpZelcEiJmwJvV2RwJBLYDiBVgy3G5vbnPLf4Xv3+X1loBmze2DF0UKmNPziwd0re/sZSsx+kajsAAqdY7RvsjKVlay9gu9h4lrHrC/xCLjbK4cJGmOf4kHD96ZKWV4B7Puv6O/uOaIZ+TtUHTbWMmiuSXBXsgLhZSTOVmUqRh0rOQ+8VOPKt5ZohIARlJi0OJV1gv/mHLg+U0xnKJ3LJ862cqnM6I6VFiHRB67sr0YCtarvcA6kbeqVgrV69oabTBbDWJop2GG226/uJY2h8Q1y2HvJ7G7jsU2tjHcnmDXOdvbW5/KawcZdbO1Fm5xGHDOgMw2dg21sLUVbJnepqKKvdundlG0JHvWLMYUR04O7V/RjUNUUiMbPYJuszY+Y0NB3KFCDXcqwubcuZ3s5avm9D6g+U6GMl3v9FHpldmM90d5dXBZ0pNsomBFqFiq5BCtNazU8oDnYMtkm38qH2qZpM1R0eT0MZ1t4d74dRunjVt/j1ybgb+4RW/R7SM8WG3uPbrNcJMTqZgGiBrUvuw79d+/OBQzZGiVmqqLGroIpq1ev1qmCVVgHtqWCRVcHdqEqsfrqwKajwGq6qQoLTcEQU9TeAjWrFKwnBSNJUVtIweRRsGwUDBhF7RRQc0TB6lAwLhS1IRRMBQWLQKHjr2j/XqEbr9BbV+iUK9r3Bu1iK/SkFTrMivaLYe+Pu9HKCkG8E5wr2duv9l0civdyhTdJbbjavHUmUMZPklbriqRoT9rqtG1qC9Z27pkdonGgAbomLe9BOsSZyRIJkpEgHeLM5IEESUiQCnFmikCCRCRIRoLUiDNTEglSIkEqJEiDODNVIkESEqRGgrSIM1MLCZKRIA0SpEOcmcZIkAoJ0iLOTBtI0Bxkx4uGtSfMUnIYEL3nXuNl/wegh48EDizfnue4LMvy///L3y6/8/yl689tf+Aoc07FvTyChOTc8tOrf98R+nDzmZLi7WOj7J9TvpID0w876OPi//YNW7cndpw4Eant7t69y/SrtlJFyTygTs73xC+m46mfW59moSko/mNMft8vC7/c2973y+of8Vf+FAYdgvPEA02NtsxGPNBseR79b7m8nGy6U1WILDvmMxM/5YmmY+qdVCWR6FmL6cvl1vMz7mWdTKbDQyxN+yuVv38MO2ZG7MfzyBcmuObWrite/ej9Yz2LGMmlolC63T+qxX2QcAF4Gq9Z/u/f9Y9nhFCY95S9ejJhNBZ38osHiX3PiQYwXuvLrDwCzJSmUn750NsP+L71+9hP8B8="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_merge-two-sorted-lists"></div></div>
</details><hr /><br />

**类似题目**：
  - [1305. 两棵二叉搜索树中的所有元素 🟠](/problems/all-elements-in-two-binary-search-trees)
  - [141. 环形链表 🟢](/problems/linked-list-cycle)
  - [142. 环形链表 II 🟠](/problems/linked-list-cycle-ii)
  - [160. 相交链表 🟢](/problems/intersection-of-two-linked-lists)
  - [19. 删除链表的倒数第 N 个结点 🟠](/problems/remove-nth-node-from-end-of-list)
  - [23. 合并K个升序链表 🔴](/problems/merge-k-sorted-lists)
  - [264. 丑数 II 🟠](/problems/ugly-number-ii)
  - [313. 超级丑数 🟠](/problems/super-ugly-number)
  - [86. 分隔链表 🟠](/problems/partition-list)
  - [876. 链表的中间结点 🟢](/problems/middle-of-the-linked-list)
  - [88. 合并两个有序数组 🟢](/problems/merge-sorted-array)
  - [97. 交错字符串 🟠](/problems/interleaving-string)
  - [977. 有序数组的平方 🟢](/problems/squares-of-a-sorted-array)
  - [剑指 Offer 22. 链表中倒数第k个节点 🟢](/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof)
  - [剑指 Offer 25. 合并两个排序的链表 🟢](/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof)
  - [剑指 Offer 49. 丑数 🟠](/problems/chou-shu-lcof)
  - [剑指 Offer 52. 两个链表的第一个公共节点 🟢](/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof)
  - [剑指 Offer II 021. 删除链表的倒数第 n 个结点 🟠](/problems/SLwz0R)
  - [剑指 Offer II 022. 链表中环的入口节点 🟠](/problems/c32eOV)
  - [剑指 Offer II 023. 两个链表的第一个重合节点 🟢](/problems/3u1WK4)
  - [剑指 Offer II 078. 合并排序链表 🔴](/problems/vvXgSW)

</details>
</div>





