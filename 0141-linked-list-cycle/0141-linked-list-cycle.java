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

// HashSet


// public class Solution {
//     public boolean hasCycle(ListNode head) {
//         Set<ListNode> seen = new HashSet<>();
//         ListNode curr = head;
//         while(curr != null) {
//             if(seen.contains(curr)) {
//                 return true;
//             }
//             seen.add(curr);
//             curr = curr.next;
//         }

//         return false;
//     }
// }

// second method (Tortoise and Hare Algorithm)

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }

        return false;
    }
}