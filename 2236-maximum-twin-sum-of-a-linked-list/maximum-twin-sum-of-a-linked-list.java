/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public int pairSum(ListNode head) {
        ListNode mid = findMid(head);

        ListNode prev = null;
        ListNode curr = mid;
        ListNode next;
        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode right = prev;
        ListNode left = head;
        int max = 0;

        while(right!=null) {
            int sum = left.val+right.val;
            max = Math.max(max,sum);
            left = left.next;
            right = right.next;
        }
        return max;
    }
}