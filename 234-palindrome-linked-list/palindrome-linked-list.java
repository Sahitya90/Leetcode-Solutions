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


 // this is the solution for this question using brute force approach
class Solution {
    public boolean isPalindrome(ListNode head) {
        
//         List <Integer> list = new ArrayList<>();
//         ListNode current = head;

//         while(current != null){
//             list.add(current.val);
//             current = current.next;
//         }

//         int start = 0;
//         int end = list.size() - 1;

//         while(start<end){
//             if(!list.get(start).equals(list.get(end))){
//                 return false;
//             }
            
                
//                 start++;
//                 end--;
            
//         }
//         return true;
        
//     }
// }

//now we will be discussing the optimal approach for this question: 
    ListNode slow = head;
    ListNode fast = head;
    
    

    while(fast != null && fast.next != null){

        slow = slow.next;
        fast = fast.next.next;

        

    }
    

    ListNode prev = null;
    ListNode curr = slow;
    ListNode nextTemp = null;

    while(curr != null){
        nextTemp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextTemp;

       
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
