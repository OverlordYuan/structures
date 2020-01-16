/*
Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
 */
public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		while (head!=null&&head.val==val){
			head = head.next;
		}
		if(head!=null){
			ListNode current = head;
			ListNode next;
			while(current.next!=null){
				next = current.next;
				if(next.val!=val){
					current = next;
				}else {
					current.next = next.next;
				}
			}
		}
		return head;
	}
}

