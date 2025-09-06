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


/*
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;

        //Find the Middle
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the Second half
        ListNode prev = null;
        ListNode currNode = slow;

        while(currNode != null) {
            ListNode nextNode = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = nextNode;
        }

        //Compare Both halves
        ListNode firstHalf = head, secondHalf = prev;
        while(firstHalf != null && secondHalf != null) {
            if(firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }
}
*/


// Approach 2

class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        ListNode temp = head;

        while(temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        temp = head;

        while(temp != null && !stack.isEmpty()) {
            if(temp.val != stack.pop()) {
                return false;
            }
            temp = temp.next;
        }

        return true;
    }
}