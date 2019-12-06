/**
question:You are given two non-empty linked lists representing two non-negative integers.
 		The digits are stored in reverse order and each of their nodes contain a single digit.
 		Add the two numbers and return it as a linked list.
 		You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 		Example:
 				Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 				Output: 7 -> 0 -> 8
				 Explanation: 342 + 465 = 807.
 **/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public class AddTwoNumbers {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode current_head = l1;
		int temp_val = 0;
		int sum_val;
		sum_val = l1.val+l2.val+temp_val;
		l1.val = sum_val % 10;
		temp_val = sum_val / 10;
		while (l1.next!= null && l2.next != null){
			l1 = l1.next;
			l2 = l2.next;
			sum_val = l1.val+l2.val+temp_val;
			l1.val = sum_val % 10;
			temp_val = sum_val / 10;
		}
		if(l2.next != null){
			l1.next = l2.next;
		}
		while (l1.next!=null&&temp_val>0){
			l1 = l1.next;
			sum_val =l1.val+temp_val;
			l1.val =sum_val%10;
			temp_val = sum_val/10;
			}

		if(temp_val>0)
			l1.next = new ListNode(temp_val);
		return current_head;
	}

	public static void main(String args[]){
		ListNode a = new ListNode(5);
		ListNode b = new ListNode(5);
		AddTwoNumbers add = new AddTwoNumbers();
		ListNode c = add.addTwoNumbers(a,b);
		System.out.println(c);
	}
}
