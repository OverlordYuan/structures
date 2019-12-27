//Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
//		You should preserve the original relative order of the nodes in each of the two partitions.
//	Example:
//		Input: head = 1->4->3->2->5->2, x = 3
//		Output: 1->2->2->4->3->5

public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		if(head==null||head.next==null){return head;}
		ListNode newhead =new ListNode(0);
		ListNode current = newhead;
		while (head!=null&&head.val<x){
			current.next = head;
			current = current.next;
			head = head.next;
		}
		if(head!=null){
			ListNode head_current = head;
			while (head_current.next!=null){
				if(head_current.next.val<x){
					current.next = head_current.next;
					current = current.next;
					head_current.next = head_current.next.next;
				}else {
					head_current = head_current.next;
					}
				}
			}
		current.next=head;
	return newhead.next;
	}
}
