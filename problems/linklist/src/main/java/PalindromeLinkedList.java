/*
Given a singly linked list, determine if it is a palindrome.
Example 1:
Input: 1->2
Output: false

Example 2:
Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		if(head!=null&&head.next!=null){
			ListNode Spoint = head;
			ListNode Fpoint = head.next;
			while(Fpoint!=null&&Fpoint.next!=null) {
				Spoint = Spoint.next;
				Fpoint = Fpoint.next.next;
			}
			ListNode newhead = reverse(Spoint.next);
			while(newhead!=null){
				if(newhead.val!=head.val){
					return false;
				}
				newhead = newhead.next;
				head = head.next;
			}
		}
		return true;
	}
	private static ListNode reverse(ListNode head){
		if(head==null||head.next==null){
			return head;
		}else {
			ListNode newhead = reverse(head.next);
			head.next.next = head;
			head.next = null;
			return newhead;
		}
	}
}
