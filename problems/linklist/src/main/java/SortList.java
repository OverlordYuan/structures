/*
Sort a linked list in O(n log n) time using constant space complexity.
Example 1:
Input: 4->2->1->3
Output: 1->2->3->4

Example 2:
Input: -1->5->3->4->0
Output: -1->0->3->4->5
 */
public class SortList {
	public ListNode sortList(ListNode head) {
		if(head!=null&&head.next!=null){
			ListNode mid = head;
			ListNode cuurent = head.next;

			ListNode left_head = new ListNode(0);
			ListNode left = left_head;
			ListNode right = head;

			while (cuurent!=null){
				if(cuurent.val<mid.val){
					left.next = cuurent;
					left = left.next;
					right.next = cuurent.next;
				}else {
					right = cuurent;
				}
				cuurent = cuurent.next;
			}

			left.next = null;

			left_head.next = sortList(left_head.next);
			mid.next = sortList(mid.next);

			while (left.next!=null){
				left = left.next;
			}

			left.next = mid;
			return left_head.next;
		}
	return head;
	}

}
