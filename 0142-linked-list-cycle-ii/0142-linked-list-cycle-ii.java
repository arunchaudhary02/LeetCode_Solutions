/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();

        ListNode currNode = head;

        while(currNode != null) {
            if(seen.contains(currNode)) {
                return currNode;
            }

            seen.add(currNode);
            currNode = currNode.next;
        }

        return null;
    }
}