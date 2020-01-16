import java.util.HashSet;
import java.util.Set;
/*
Given a linked list, determine if it has a cycle in it.
To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the second node.

Example 2:
Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the first node.

Example 3:
Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.

Follow up:
Can you solve it using O(1) (i.e. constant) memory?
 */
public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		Set Nodes = new  HashSet();
		while (head!=null){
			if(Nodes.contains(head)){
				return true;
			}else {
				Nodes.add(head);
				head = head.next;
			}
		}
		return false;
	}
	public boolean hasCycle1(ListNode head) {
		if(head!=null){
			if(head.next!=null) {
				ListNode slow = head;
				ListNode fast = head.next;
				while (fast.next!= null) {
					if(fast.next.next!=null){
						fast = fast.next.next;
						slow = slow.next;
						if (fast == slow) {
						return true;
						}
					}else {
						return false;
					}
				}
			}
		}
		return false;
	}
}
