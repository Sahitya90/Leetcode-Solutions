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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //this is the brute force approach 

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode current = head;
        
        int L = 0;

        while(current != null){

            L++;
            current = current.next;
        }

        current = dummy;
        for(int i = 0; i<(L-n);i++){
            current = current.next;
        }
        current.next = current.next.next;

        return dummy.next;
    }
}