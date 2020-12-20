package linkedList;

class Node{
	int data;
	Node next;
	public Node(int d) {
		data = d;
		next = null;
	}
}

public class CreationOfLinkedList {
	
	static void printList(Node head) {
		if(head == null)
			return;
		
		System.out.print(head.data + " ");
		printList(head.next);
	}
	
	static int countNodes(Node head) {
		if(head == null)
			return 0;
		return 1 + countNodes(head.next); 
	}
	
	static void deleteFromEnd(Node head) {
		if(head == null)
			return ;
		Node prev = null;
		while(head.next != null) {
			prev = head;
			head = head.next;
		}
		prev.next = null;
	}
	
	static void deleteFromBegining(Node head) {
		if(head == null)
			return ;
		head = head.next;
	}
	
	static void deleteAtPosition(Node head, int pos) {
		Node prev = null;
		if(pos == 1)
			deleteFromBegining(head);
		else {
			for(int i=2; i < pos && head != null; i++) {
				prev = head;
				head = head.next;
			}
			prev.next = head.next != null ? head.next : null;
		}
	}
	
	static Node middleElement(Node head) {
		if(head == null)
			return head;
		
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	static void checkLengthEvenOrOdd(Node head) {
		if(head == null)
			System.out.println("even");
		
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(fast.next == null)
				System.out.println("odd");
		}
		System.out.println("even");
	}
	
	static void deleteWithoutHeadPointer(Node node) {
		node.data = node.next.data;
		node.next = node.next.next;
	}
	
	static Node reverseLinkedList(Node head) {
		Node next = null;
		Node prev = null;
		
		while(head != null) {
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		
		return prev;
	}
	
	static Node makeTheMiddleAsHead(Node head) {
		if(head == null)
			return head;
		
		Node prev = null;
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		fast = slow;
		while(fast .next != null)
			fast = fast.next;
		fast.next = head;
		head = slow;
		prev.next = null;
		
		return head;
	}
	
	static boolean searchAnElemnet(Node head, int elm) {
		if(head == null)
			return false;
		Node temp = head;
		while(temp != null) {
			if(elm == temp.data)
				return true;
			temp = temp.next;
		}
		return false;
	}
	
	//nth node from end
	static Node nThNodeFromEnd(Node head, int k) {
		if(head == null)
			return null;
		Node demo = new Node(0);
		demo.next = head;
		
		Node fast = head;
		Node slow = demo;
		
		int i=1;
		while(i < k) {
			fast = fast.next;
			i++;
		}
		while(fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}
	//move last elm to front
	
	public static void main(String[] args) {
		//create linked list
		Node head = new Node(4);
		head.next = new Node(5);
		head.next.next = new Node(6);
		head.next.next.next = new Node(7);
		head.next.next.next.next = new Node(8);
		
		//to print the linked list
		//printList(head);
		
		//to count the no of linked list or length of the list
		//System.out.println("No of nodes are : " + countNodes(head));
		
		//to delete from the end of linked list
//		deleteFromEnd(head);
//		printList(head);
		
		//check the length is even or odd 
//		checkLengthEvenOrOdd(head);
		
		//delete without head
//		deleteWithoutHeadPointer(head.next.next.next);
//		printList(head);
		
		//make the middle elm as head
//		printList(makeTheMiddleAsHead(head));
		
		//search an element in linked list
//		System.out.println(searchAnElemnet(head, 80));
		
		Node temp = nThNodeFromEnd(head, 1);
		System.out.println(temp.data);
	}

}
