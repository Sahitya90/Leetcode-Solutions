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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        ListNode a = list1;
        ListNode b = list2;

        while(a != null && b != null){
            if(a.val < b.val){
                tail.next = a;
                a = a.next;
                

            }
            else{
                tail.next = b;
                b = b.next;
                

            }
            tail = tail.next;
        }
        if (a != null) {
             tail.next = a; // Attach the rest of list a
        } else {
             tail.next = b; // Attach the rest of list b
        }

        return dummy.next;
    }

}