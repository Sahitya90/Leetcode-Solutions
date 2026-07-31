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
    public void reorderList(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode curr = slow.next;
        slow.next = null;

        ListNode prev = null;
        
        while(curr != null){

            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        //after the prev becomes the head of the reversed second half

       
        ListNode curr2 = prev;
        ListNode curr1 = head;
        

        while(curr2 != null){

            //store the next node of both the lists
            ListNode next1 = curr1.next;
            ListNode next2 = curr2.next;

            //adding elements from both lists
            curr1.next = curr2;
            curr2.next = next1;

            //advance the pointer
            curr1 = next1;
            curr2 = next2;
        }


    }
}