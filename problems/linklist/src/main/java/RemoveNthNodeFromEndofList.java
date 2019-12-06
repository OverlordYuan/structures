/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * * Example:
 * * Given linked list: 1->2->3->4->5, and n = 2.
 * * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * * Given n will always be valid.
 * * Follow up:
 * * Could you do this in one pass?
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode current_node = head;
		ListNode flag_node = head;
		ListNode pre_node = null;
		for(int i=0;i<n;i++){
			flag_node = flag_node.next;
		}
		while(flag_node!=null){
			pre_node = current_node;
			current_node = current_node.next;
			flag_node = flag_node.next;
		}
		if(pre_node==null){
			if(current_node.next==null){
				head = pre_node;
			}else {
				head = current_node.next;
			}
		}else {
			pre_node.next  = current_node.next;
		}
		return head;
	}
}
