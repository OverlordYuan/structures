/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
* */
public class MergekSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode head = null;
		if(lists.length==0){return head;};
		if(lists.length>1){
			for (int i=1;i<=lists.length;i*=2){
				for(int j=i;j<lists.length;j=j+i*2){
					lists[j-i] = mergeTwoLists(lists[j-i],lists[j]);
				}
			}
		}
		head = lists[0];
		return head;
	}
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null){return l2;}
		if(l2==null){return l1;}
		if(l1.val>l2.val){
			ListNode current = l2;
			l2 = l1;
			l1 = current;
		}
		ListNode current = l1;
		ListNode next_node = current.next;

		while (next_node!=null){
			if(l2!=null&&next_node.val>=l2.val){
				current.next = l2;
				l2 = l2.next;
				current = current.next;
				current.next = next_node;
			}else {
				current = next_node;
				next_node = current.next;
			}
		}
		current.next = l2;
		return l1;
	}
}
