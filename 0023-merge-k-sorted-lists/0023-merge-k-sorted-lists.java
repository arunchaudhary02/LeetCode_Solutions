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
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // only head pointer of all lists are added
        for(ListNode node : lists) {
            if(node != null) {
                minHeap.offer(node);
            }
        }

        ListNode head = new ListNode(-1);
        ListNode currPtr = head;

        while(!minHeap.isEmpty()) {
            currPtr.next = minHeap.poll();
            currPtr = currPtr.next;

            if(currPtr.next != null) {
                minHeap.offer(currPtr.next);
            }
        }

        return head.next;
    }
}