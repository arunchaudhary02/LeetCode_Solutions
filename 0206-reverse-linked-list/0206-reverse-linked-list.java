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
    public ListNode reverseList(ListNode head) {
        ListNode lastNode = null;
        ListNode currentNode = head;

        while(currentNode != null) {
            ListNode nextNode = currentNode.next;
            currentNode.next = lastNode;
            lastNode = currentNode;
            currentNode = nextNode;
        }

        head = lastNode;
        return head;
    }
}