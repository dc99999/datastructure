package com.ds;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LinkedListCustom {

	 int length;
	 static Node head;
	static Node tail;
	
	public void add(int value) {
		
		Node newNode = new Node(value, null, null);
		if(length == 0) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		length++;
	}
	
	public void print(String literal) {
		System.out.println("Current Operation :   "+literal);
		Node temp = head;
		if (length > 0) {
		while (Objects.nonNull(temp)) {
			System.out.println(temp.getValue());
			temp = temp.getNext();
		}
	   } else System.out.println("List is Empty ");
	}
	
	public void removeLast( ) {
		Node temp = head;
		Node pre = head;
		
		if (length >0) {
		while (Objects.nonNull(temp.getNext())) {
			pre = temp;
			temp = temp.getNext();
		}
		tail = pre;
		tail.setNext(null);
		length--;
		if (length == 0) {
			head = tail = null;
		}
		
	   } else System.out.println("List is Empty ");
	}
	
	void addFirst(int value) {
		Node newNode = new Node(value, null, null);
		if (length ==0 ) {
			head = tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		length++;
	}
	
	void removeFirst() {
		
		if (length == 0 ) {
			System.out.println(" List is Empty ");
		} else {
			Node temp = head;
			head = head.next;
			temp.next = null;
			length--;
			if (length ==0) {
				tail = null;
			}
		}
		
	}
	
	
	public boolean hasLoop() {
		Node fast = head;
		Node slow = head;
		boolean hasLoop = false;
		while(fast!= null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				hasLoop = true;
				break;
			}
		}
		return hasLoop;
	}
	
	Node findMiddle() {
		
		Node fast = head;
		Node slow = head;
		
		while(fast != null && fast.next!= null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
		
	}
	
	Node getByIndex(int index) {

		if (index >= length || index < 0)
			return null;

		Node temp = head;

		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}

		return temp;
	}
	
	
	void insertByIndex(int index, int value) {
			if (index > length || index < 0) {
				System.out.println("Invalid index");
				return;
			}
			
			if(index == 0) {
				addFirst(value);
				return;
			}
			
			if(index == length) {
				add(value);
				return;
			}
			
			Node newNode = new Node(value, null, null);
			Node prevNode = getByIndex(index-1);
			newNode.next = prevNode.next;
			prevNode.next = newNode;
			length++;
	 }
	
	
	void removeByIndex(int index) {
	
		if (index > length || index < 0) {
			System.out.println("Invalid index");
			return;
		}
		
		if(index == 0) {
			removeFirst();
			return;
		}
		
		if(index == length) {
			removeLast();
			return;
		}

		Node prevNode = getByIndex(index-1);
		Node nodeToRemove = prevNode.getNext();
		prevNode.next =  nodeToRemove.getNext();
		nodeToRemove.next = null;
		length--;
 }
	
	
	
	
	
	
	
	public int getLength() {
		return length;
	}

	public static void main(String[] args) {
		LinkedListCustom customLl = new LinkedListCustom();
		System.out.println("Initial Length "+customLl.getLength());
		customLl.add(1);
		customLl.add(2);
		customLl.add(3);
		customLl.add(4);
		customLl.add(5);
		//customLl.removeLast();
		customLl.addFirst(1);
		customLl.removeFirst();
		System.out.println("Current Lenght :  "+customLl.getLength());
		System.out.println("get By Index 2 "+customLl.getByIndex(2).getValue());
		//customLl.insertByIndex(2, 22);
		customLl.print(" After Doing all Operation of set By index");
		//customLl.removeByIndex(2);
		System.out.println("tail value "+tail.getValue());
		
//		customLl.add(40);
//		customLl.add(50);
//		customLl.add(60);
		customLl.print(" After Doing all Operation ");
		
//		customLl.reverseList();
//		customLl.partitionList(45);
		customLl.reverseBetween(1, 3);
		customLl.print(" After Reverse Operation ");
		
	}
	
	public Node findKthFromEnd(int k) {
        Node slow = head;
        Node fast = head;
 
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
 
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
 
        return slow;
    }
	
	 public void removeDuplicates() {
	        Set<Integer> values = new HashSet<>();
	        Node previous = null;
	        Node current = head;
	        while (current != null) {
	            if (values.contains(current.value)) {
	                previous.next = current.next;
	                length -= 1;
	            } else {
	                values.add(current.value);
	                previous = current;
	            }
	            current = current.next;
	        }
	    }
	 
	 
	// 1,2,3,4,5
	 // 1 4 3 2 5
	 public void reverseBetween(int startIndex, int endIndex) {
	        if (head == null) return;
	    
	        Node dummyNode = new Node(0, null, null);
	        dummyNode.next = head;
	        
	        
	        Node previousNode = dummyNode;
	        
	                               //1
	        for (int i = 0; i < startIndex; i++) {
	            previousNode = previousNode.next;
	        }
	        System.out.println(" PRev value "+previousNode.value);
	    
	        Node currentNode = previousNode.next;
	        System.out.println("Value "+currentNode.value);
	        for (int i = 0; i < endIndex - startIndex; i++) {
	            Node nodeToMove = currentNode.next;
	            currentNode.next = nodeToMove.next;
	            nodeToMove.next = previousNode.next;
	            previousNode.next = nodeToMove;
	        }
	    
	        head = dummyNode.next;
	    }



	 

	    public int binaryToDecimal() {
	        int num = 0;
	        Node current = head;
	        while (current != null) {
	            num = num * 2 + current.value;
	            current = current.next;
	        }
	        return num;
	    }
	
    public void partitionList(int x) {
        if (head == null) return;
 
        Node dummy1 = new Node(0, null, null);
        Node dummy2 = new Node(0, null, null);
        Node prev1 = dummy1;
        Node prev2 = dummy2;
        Node current = head;
 
        while (current != null) {
            if (current.value < x) {
                prev1.next = current;
                prev1 = current;
            } else {
                prev2.next = current;
                prev2 = current;
            }
            current = current.next;
        }
 
        prev2.next = null;
        System.out.println("Dummy2"+dummy2.value +"  NExt  "+dummy2.next.value);
        prev1.next = dummy2.next;
 
        head = dummy1.next;
    }//	void reverseList () {
//		Node temp = head;
//		head = tail;
//		tail = temp;
//		Node before = null;
//		Node after = null;
//		
//		for (int i = 0; i < length; i++) {
//			after = temp.next;
//			temp.next = before;
//			before = temp;
//			temp  = after;
//		}
//		
//	}

	private void reverseList() {
		
		if (length == 0) {
			System.out.println("List is empty so can be reversed");
		}

		Node temp = head;
		head = tail ;
		tail = temp;
		
		Node after = null;
		Node before = null;
		
		for (int i = 0; i < length; i++) {
			after = temp.next;
			temp.next = before;
			before = temp;
			temp = after;
			
		}
	}
}


class Node {
	int value;
    Node prev;
	Node next;

	
	public Node(int value, Node prev,Node next) {
		super();
		this.value = value;
		this.prev = prev;
		this.next = next;
	}
	public int getValue() {
		return value;
	}
	public Node getPrev() {
		return prev;
	}
	public Node getNext() {
		return next;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public void setPrev(Node prev) {
		this.prev = prev;
	}
	public void setNext(Node next) {
		this.next = next;
	}

	
	
	
}