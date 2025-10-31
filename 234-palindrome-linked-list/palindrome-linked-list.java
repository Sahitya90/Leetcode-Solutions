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
    public boolean isPalindrome(ListNode head) {
        
        ListNode slow = head; 
        ListNode fast = head;

        while(fast != null && fast.next != null){

            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode prev = null;
        ListNode current = slow;
        ListNode nextTemp = null;

        while(current != null){

            nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;

        }
        
        ListNode left = head;
        ListNode right = prev;


        while(right != null){

            if(left.val != right.val){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
}
