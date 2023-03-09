# Linked List Cycle II

 A programming problem where one is required to find the first cycle in a linked list

## Problem Statement

Given the `head` of a linked list, return *the node where the cycle begins. If there is no cycle, return* `null`.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the `next` pointer. Internally, `pos` is used to denote the index of the node that tail's `next` pointer is connected to (**0-indexed**). It is `-1` if there is no cycle. **Note that** `pos` **is not passed as a parameter**.

**Do not modify** the linked list.

**Example 1:**

![](https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist.png)

**Input:** head = [3,2,0,-4], pos = 1
**Output:** tail connects to node index 1
**Explanation:** There is a cycle in the linked list, where tail connects to the second node.

**Example 2:**

![](https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test2.png)

**Input:** head = [1,2], pos = 0
**Output:** tail connects to node index 0
**Explanation:** There is a cycle in the linked list, where tail connects to the first node.

**Example 3:**

![](https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test3.png)

**Input:** head = [1], pos = -1
**Output:** no cycle
**Explanation:** There is no cycle in the linked list.

**Constraints:**

- The number of the nodes in the list is in the range `[0, 104]`.
- `-105 <= Node.val <= 105`
- `pos` is `-1` or a **valid index** in the linked-list.

## Explanation & Summary

To understand why it is necessary for the slow pointer to start from the head and both pointers to meet at the start of the cycle, we need to consider the mechanics of how the two pointers move through the linked list.

Let's say we have a linked list with a cycle and we set the slow pointer to start from the head of the list. The slow pointer moves one step at a time, while the fast pointer moves two steps at a time. As the two pointers move through the list, they will eventually meet at some point.

Let's assume that the slow pointer has traveled k steps before the two pointers meet. At this point, the fast pointer has traveled 2k steps. Since the fast pointer moves twice as fast as the slow pointer, we can write:

2k = k + n*r

where n is the number of complete cycles the fast pointer has made around the cycle, and r is the length of the cycle. Rearranging this equation, we get:

k = n*r

This equation tells us that the number of steps the slow pointer has traveled is a multiple of the length of the cycle. In other words, when the two pointers meet, the slow pointer must be at a node that is exactly k steps away from the start of the cycle, which is also n complete cycles away from the start of the cycle.

Now let's consider what happens if we start the slow pointer from a node that is not the head of the list, but is some node inside the cycle. In this case, let's say the slow pointer starts at a node that is m steps away from the start of the cycle. When the fast pointer meets the slow pointer, we will have:

2k = m + n*r

where k is the number of steps the slow pointer has traveled before the two pointers meet. Rearranging this equation, we get:

k = (n*r - m)/2

This equation tells us that the number of steps the slow pointer has traveled before the two pointers meet is equal to half the difference between the number of steps the fast pointer has traveled around the cycle and the number of steps the slow pointer is away from the start of the cycle.

The problem with this scenario is that it's not clear what value of n we should use to calculate the distance from the start of the cycle. We know that the slow pointer is m steps away from the start of the cycle, but we don't know how many complete cycles the fast pointer has made around the cycle. Without this information, we cannot calculate the distance from the start of the cycle.

Therefore, to be able to detect the start of the cycle, we must start the slow pointer from the head of the list, where we know the distance from the start of the cycle is 0. This ensures that when the two pointers meet, the slow pointer is exactly k steps away from the start of the cycle, and we can calculate the start of the cycle by moving a second pointer from the head of the list to the point where the two pointers meet, one step at a time.
