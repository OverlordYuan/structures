/*Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
Example 1:
	Input: 1->2->3->3->4->4->5
	Output: 1->2->5
Example 2:
	Input: 1->1->1->2->3
	Output: 2->3

 */
public class RemoveDuplicatesfromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		if(head==null){return head;}
		if(head.next==null){return head;}
		ListNode pre = null;
		ListNode current = head;
		ListNode Next = head.next;
		while(Next!=null){
			if(current.val==Next.val){
				Next = Next.next;
				current.next = Next;
			}else {

			}

		}
		return head;
	}
}
