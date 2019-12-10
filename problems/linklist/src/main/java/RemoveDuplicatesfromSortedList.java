/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3
 */
public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if(head==null){return head;}
		if(head.next==null){return head;}
		ListNode current = head;
		ListNode Next = current.next;
		while(Next!=null){
			if(current.val==Next.val){
				Next = Next.next;
				current.next = Next;
			}else {
				current.next = Next;
				current = current.next;
				Next = current.next;
			}
		}
		return head;
	}
}
