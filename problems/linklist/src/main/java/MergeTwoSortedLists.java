/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * * Example:
 * * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null){
			return l2;
		}
		if (l2 == null){
			return l1;
		}
		if(l1.val>l2.val){
			ListNode current_node = l2;
			l2 = l1;
			l1 = current_node;
		}
		//保证current_node指向最小值
		ListNode current_node = l1;
		ListNode next_node = current_node.next;

		while (next_node!=null){
			if(l2!=null&&next_node.val>=l2.val){
				current_node.next = l2;
				current_node =current_node.next;
				l2 = l2.next;
				current_node.next = next_node;
			}else {
				current_node = next_node;
				next_node = next_node.next;
			}
		}
		current_node.next = l2;
		return l1;
	}
}
