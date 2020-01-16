/*
Reverse a singly linked list.
Example:
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:
A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		if(head!=null&&head.next!=null){
			ListNode pre = null;
			ListNode current = head;
			ListNode next;
			while (current!=null){
				next =current.next;
				current.next = pre;
				pre = current;
				current = next;
			}
			return pre;
		}
	return head;
	}

	public ListNode reverseList_re(ListNode head) {
		if(head==null||head.next==null){
			return head;
		}else {
			ListNode newhead = reverseList(head.next);
			head.next.next = head;
			head.next = null;
			return newhead;
		}
	}
}
