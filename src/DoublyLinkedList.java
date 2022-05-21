import java.util.SortedSet;
import java.util.TreeSet;

public class DoublyLinkedList
{
    //Represent a node of the doubly linked list

    class Node{
        PhonebookData data;
        Node previous;
        Node next;

        public Node(PhonebookData data) {
            this.data = data;
        }
    }

    //Represent the head and tail of the doubly linked list
    Node head, tail = null;

    //addNode() will add a node to the list
    public void addNode(PhonebookData  data) {
        //Create a new node
        Node newNode = new Node(data);

        //If list is empty
        if(head == null) {
            //Both head and tail will point to newNode
            head = tail = newNode;
            //head's previous will point to null
            head.previous = null;
            //tail's next will point to null, as it is the last node of the list
            tail.next = null;
        }
        else {
            //newNode will be added after tail such that tail's next will point to newNode
            tail.next = newNode;
            //newNode's previous will point to tail
            newNode.previous = tail;
            //newNode will become new tail
            tail = newNode;
            //As it is last node, tail's next will point to null
            tail.next = null;
        }
    }

    //display() will print out the nodes of the list
    public void display() {
        //Node current will point to head
        Node current = head;
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of doubly linked list: ");
        while(current != null) {
            //Prints each node by incrementing the pointer.

            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    SortedSet searchHeadFirst(String searchItem) {
        Node current = head;
        SortedSet sortedSet = new TreeSet();
        while (current != null)
        {
            //Checks each node by incrementing the pointer.
            if (current.data.name.toLowerCase().contains(searchItem.toLowerCase()) || current.data.mobilePhone.contains(searchItem)) {
                sortedSet.add(current.data);
            }
            current = current.next;
        }
        return sortedSet;
    }
    public SortedSet searchTailFirst(String searchItem) {
        SortedSet sortedSet = new TreeSet();
        Node current = tail;
        if (tail == null) {
            System.out.println("List is empty");
            return null;
        }
        //    System.out.println("Nodes of doubly linked list: ");
        while (current != null) {
            //Checks each node by incrementing the pointer.
            if (current.data.name.toLowerCase().contains(searchItem.toLowerCase()) || current.data.mobilePhone.contains(searchItem)) {
                sortedSet.add((PhonebookData) current.data);
            }
            current = current.previous;
        }
        return sortedSet;
    }
}