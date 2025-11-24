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

//  the logic we are going to use here is the combination of three patterns, first we use the slow and fast pointer pattern to find the middle of the list, then we reverse the second half of the list and at last we join both the lists in the order that they become like the result
class Solution {
    public void reorderList(ListNode head) {
        
        ListNode slow = head; 
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;

        ListNode prev = null;
        ListNode curr = second;
        ListNode temp;

        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        ListNode first = head;
        second = prev;

        while(second != null){
            ListNode temp1= first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
        
    }
}