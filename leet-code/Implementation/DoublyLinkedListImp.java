package Implementation;

public class DoublyLinkedListImp<T extends Comparable<Integer>> {

	public class Node {
		T value;
		Node next, previous;

		Node(T val) {
			this.value = val;
		}
	}

	Node head, tail = null;

	// THIS IS FOR NON CYCLIC LINKED LIST
	/*
	 * public void addNode(T value) {
	 * Node nodeToInsert = new Node(value);
	 * if (head == null) {
	 * this.head = this.tail = nodeToInsert;
	 * this.head.previous = null;
	 * this.tail.next = null;
	 * } else {
	 * tail.next = nodeToInsert;
	 * nodeToInsert.previous = this.tail;
	 * this.tail = nodeToInsert;
	 * this.tail.next = null;
	 * }
	 * }
	 */

	// For Cyclic linkedList
	public void addNode(T value) {
		Node nodeToInsert = new Node(value);
		if (head == null) {
			this.head = this.tail = nodeToInsert;
			nodeToInsert.next = head;
		} else {
			tail.next = nodeToInsert;
			this.tail = nodeToInsert;
			this.tail.next = head;
		}
	}

	public T minNode() {
		if (this.head == null) {
			System.out.println("Empty list");
			return null;
		}
		T min = this.head.value;
		Node dummy = this.head.next;
		while (dummy != head) {
			if (dummy.value.compareTo((Integer) min) < 0) {
				System.out.println(min);
				min = dummy.value;

			}
			dummy = dummy.next;
		}
		System.out.println("this the min : " + min);
		return min;
	}

	public int countNodes() {

		if (this.head == null)
			return 0;

		int counter = 1;
		Node dummy = this.head.next;
		while (dummy != head) {
			counter++;
			dummy = dummy.next;
		}
		return counter;
	}

	public void display() {
		// Node current will point to head
		Node current = head.next;
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		System.out.println("Nodes of doubly linked list: ");
		System.out.print(head.value + " ");
		while (current != head) {
			// Prints each node by incrementing the pointer.
			System.out.print(current.value + " ");
			current = current.next;
		}
	}

	public static void main(String[] args) {

		DoublyLinkedListImp<Integer> dList = new DoublyLinkedListImp<>();
		// Add nodes to the list
		dList.addNode(7);
		dList.addNode(3);
		dList.addNode(2);
		dList.addNode(4);
		dList.addNode(2);
		dList.addNode(0);
		dList.addNode(5);

		// Displays the nodes present in the list
		dList.display();

		int a = dList.minNode();
		System.out.println(a);

		// Counts the nodes present in the given list
		System.out.println("\nCount of nodes present in the list: " + dList.countNodes());
	}

}