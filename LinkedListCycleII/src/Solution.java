import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x, ListNode node) {
            val = x;
            next = node;
        }

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    Set<ListNode> nodesVisited = new HashSet<>();
    public ListNode detectCycle2(ListNode head) {
        if(head == null){
            return null;
        }
        if(nodesVisited.contains(head)){
            return head;
        }
        else{
            nodesVisited.add(head);
            return detectCycle2(head.next);

        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Move both pointers until they meet
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // Cycle detected
                // Move a second pointer from the head to the point where the two pointers meet
                ListNode secondPtr = head;
                while (secondPtr != slow) {
                    secondPtr = secondPtr.next;
                    slow = slow.next;
                }
                return secondPtr; // This is the start of the cycle
            }
        }

        return null; // No cycle detected
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        Solution.ListNode head = sol.new ListNode(3);
        head.next = sol.new ListNode(2, sol.new ListNode(0, sol.new ListNode(-4, head)));
        System.out.println("Cycle starts at " + Integer.toString(sol.detectCycle(head).val));
        System.out.println("Cycle starts at " + Integer.toString(sol.detectCycle2(head).val));
    }
}