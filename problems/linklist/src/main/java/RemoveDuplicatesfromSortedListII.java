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
		if (head.next==null){return head;}
		ListNode newhead = new ListNode(-1);
		newhead.next = head;
		ListNode Pre=newhead;
		ListNode Cur;
		while(Pre.next!=null){
			Cur=Pre.next;
			while(Cur.next!=null && Cur.next.val ==Cur.val){
				Cur=Cur.next;
			}
			if(Cur!=Pre.next){
				Pre.next=Cur.next;
			}else {
				Pre=Pre.next;
			}
		}
		return newhead.next;
	}
}
