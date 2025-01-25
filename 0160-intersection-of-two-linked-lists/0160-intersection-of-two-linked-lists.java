/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode temp1 = headA;
        ListNode temp2 = headB;

        while (temp1 != temp2) {
            // Move temp1 to the next node or switch to the other list's head
            temp1 = (temp1 != null) ? temp1.next : headB;

            // Move temp2 to the next node or switch to the other list's head
            temp2 = (temp2 != null) ? temp2.next : headA;
        }

        return temp1; // Either the intersection node or null if no intersection
    }
}