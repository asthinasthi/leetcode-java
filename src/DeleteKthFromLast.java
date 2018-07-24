public class DeleteKthFromLast {


	public static void main(String[] args) {
		
		DeleteKthFromLast obj = new DeleteKthFromLast();
		
		ListNode head = obj.new ListNode(1);
		head.next = obj.new ListNode(2);
		head.next.next = obj.new ListNode(3);
		head.next.next.next = obj.new ListNode(4);
		head.next.next.next.next = obj.new ListNode(5);
		printLinkedList(head);
		ListNode newHead = removeNthFromEnd(head, 3);
		System.out.println();
		printLinkedList(newHead);
	}
	
	
	 public static ListNode removeNthFromEnd(ListNode head, int n){
		 if(head == null){
			 return null;
		 }
		 ListNode slow = head;
		 ListNode fast = head ;
		 for(int i=0; i <n ; i++){
			 fast = fast.next;			 
		 }

		 while(fast!=null){
			 fast = fast.next;
			 slow = slow.next;
		 }
		 
		 return deleteNode(head, slow);
	 }
	 
	 static void printLinkedList(ListNode head){
		 while(head!=null){
			 System.out.print(head.val + "-->");
			 head = head.next;
		 }
	 }
	 
	 static ListNode deleteNode(ListNode head, ListNode node){
		 //1-->2-->3
		 if(node == null || head==null)
			 return null;
		if(head == node){
			return head.next;
		}
		 ListNode iteratorNode = head;
		 while(iteratorNode.next!=node){
			 iteratorNode = iteratorNode.next;
		 }
		 ListNode temp = iteratorNode.next;
		 iteratorNode.next = temp.next;
		 temp.next = null;
		 return head;
	 }
 class ListNode {
	 int val;
	 ListNode next;
	 public ListNode(int x) { val = x; }
}
}
