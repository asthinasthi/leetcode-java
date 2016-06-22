import java.util.ArrayList;


public class ReverseLinkedList {
	
public static void main(String[] args){
	ReverseLinkedList rLL = new ReverseLinkedList();
	LinkedListNode head = new LinkedListNode(1);
	rLL.generateLinkedList(head);
	
	System.out.println("After");
	rLL.printLinkedList(rLL.reverseList(head));
}

public void generateLinkedList(LinkedListNode head){
	head.setValue(1);
	LinkedListNode currentNode = head;
	for(int i=2;i<10;i++){
		currentNode.next = new LinkedListNode(i);
		currentNode = currentNode.next;
	}
	System.out.println("Before");
	printLinkedList(head);

}
public LinkedListNode reverseList(LinkedListNode head) {
    LinkedListNode prevNode = null;
    
    if(head==null){
    	return null;
    }
	while(head!=null){
		LinkedListNode nextNode = head.next;
		head.next = prevNode;
		prevNode = head;
		head = nextNode;
	}
	
	return prevNode;
  }


public void printLinkedList(LinkedListNode head){
	ArrayList<Integer> values = new ArrayList<Integer>();
	while(head!=null){
		values.add(head.getValue());
		head = head.next;
	}
	System.out.println(values);
}

}

class LinkedListNode{
	private Integer value;
	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	LinkedListNode next;
	
	public LinkedListNode(Integer val){
		this.value = val;
		this.next = null;
	}
	
}
