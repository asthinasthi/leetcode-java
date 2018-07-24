
public class OrderLinkedList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);
//		head.next.next.next.next.next = new ListNode(6);
		printLinkedList(head);
		printLinkedList(oddEvenList(head));
	}
	
	static ListNode oddEvenList(ListNode head){
		if(head == null)
			return null;
		ListNode odd = head;
		ListNode even = head.next;
		ListNode evenHead = even;
		while(odd!=null && even!=null){
			odd.next = even.next;
			
			if(even.next == null)
				even.next = null;
			else
				even.next = even.next.next;

			even = even.next;
			
			if(odd.next == null)
				odd.next = evenHead;
			else
				odd = odd.next;

//			printLinkedList(oddHead);
//			printLinkedList(evenHead);
		}
		odd.next = evenHead;
		return head;
	}
	
	 static void printLinkedList(ListNode head){
		 System.out.println();
		 while(head!=null){
			 System.out.print(head.val + "-->");
			 head = head.next;
		 }
	 }
}
