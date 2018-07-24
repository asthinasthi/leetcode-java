import static org.junit.Assert.*;

import org.junit.Test;

public class RemDupFromLL {

	@Test
	public void test() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(4);
		printLinkedList(head);
		System.out.println();
		printLinkedList(deleteDuplicates(head));
	}

    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        if(temp == null)return null;
        while(temp.next !=null){
        	if(temp.val == temp.next.val){
        		temp.next = temp.next.next;
        	}else{
        		temp = temp.next;
        	}
        }
    	
    	return head;
    }
    
	 static void printLinkedList(ListNode head){
		 while(head!=null){
			 System.out.print(head.val + "-->");
			 head = head.next;
		 }
	 }
}
