/*Reverse a linked list from position m to n. Do it in one-pass.

		Note: 1 ≤ m ≤ n ≤ length of list.

		Example:

		Input: 1->2->3->4->5->NULL, m = 2, n = 4
		Output: 1->4->3->2->5->NULL

 */
public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
 		if(head!=null&&head.next!=null&&n!=m){
 			ListNode newhead = new ListNode(0);
			newhead.next = head;
			ListNode pre = newhead;
			ListNode end = head;
			for(int i=1;i<m;i++){
				pre = end;
				end = end.next;
			}
 			ListNode current;
 			while (end.next!=null&&m++<n){
				current = end.next;
				end.next = current.next;
				current.next = pre.next;
				pre.next = current;
			}
 			return newhead.next;
		}else {
 			return head;
 		}
	}
}
