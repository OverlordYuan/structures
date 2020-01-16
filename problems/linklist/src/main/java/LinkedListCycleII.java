import java.util.HashSet;
import java.util.Set;

/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
Note: Do not modify the linked list.

Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.

Example 2:
Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.

Example 3:
Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.

Follow-up:
Can you solve it without using extra space?
 */
public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		Set Nodes = new HashSet();
		while (head!=null){
			if(Nodes.contains(head)){
				return head;
			}else {
				Nodes.add(head);
				head = head.next;
			}
		}
		return null;
	}

	public ListNode detectCycle1(ListNode head) {
		if(head!=null){
			if(head.next!=null) {
				ListNode slow = head;
				ListNode fast = head;
				while (fast.next!= null) {
					if(fast.next.next!=null){
						fast = fast.next.next;
						slow = slow.next;
						if (fast == slow) {
							ListNode slow1 = head;
							while (slow1!=fast){
								slow1 = slow1.next;
								fast = fast.next;
							}
							return fast;
						}
					}else {
						return null;
					}
				}
			}
		}
		return null;
	}
}
