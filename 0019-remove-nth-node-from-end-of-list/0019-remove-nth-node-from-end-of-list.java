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


// Approach 1

 
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {  
        ListNode temp = head;
        int len = 0;

        // 1. Find length
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        // 2. If we need to remove the head node
        if (n == len) {
            return head.next;
        }

        // 3. Find the node before the one we need to delete
        temp = head;
        for (int i = 1; i < len - n; i++) {
            temp = temp.next;
        }

        // 4. Remove nth node from end
        temp.next = temp.next.next;

        return head; 
    }
}




// Approach 2


/*
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {  
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = head;

        while(n > 0 && right != null) {
            right = right.next;
            n--;
        }

        while(right != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;

        return dummy.next;
   
    }
}

*/