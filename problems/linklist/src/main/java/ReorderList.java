/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:
Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:
Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
public class ReorderList {
	public void reorderList(ListNode head) {
		if(head!=null&&head.next!=null){
			ListNode slow = head;
			ListNode fast = head;
			while (fast != null && fast.next != null){
				slow = slow.next;
				fast = fast.next.next;
			}
			ListNode mid = reverse(slow.next);
			slow.next = null;
			merge(head,mid);
		}
	}

	private static ListNode reverse(ListNode head){
		if (head == null || head.next == null)
			return head;
		ListNode newHead = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}

	private static void merge(ListNode first, ListNode second) {
		ListNode firstNext;
		ListNode secondNext;
		while (second != null) {
			firstNext = first.next;
			secondNext = second.next;
			first.next = second;
			second.next = firstNext;
			first = firstNext;
			second = secondNext;
		}
	}
}
