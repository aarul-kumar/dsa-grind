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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode temp = head;
        int n = 1;
        while(temp.next!=null) {
            temp = temp.next;
            n++;
        }
        temp.next = head;
        int r = n-(k%n);
        ListNode temp2 = head;
        for(int i=1; i<r; i++) {
            temp2 = temp2.next;
        }
        head = temp2.next;
        temp2.next = null;
        return head;
    }
}