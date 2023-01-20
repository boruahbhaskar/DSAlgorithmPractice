package LinkedList;/*
Design Linked List

Solution
Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement the MyLinkedList class:

MyLinkedList() Initializes the MyLinkedList object.
int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
void addAtTail(int val) Append a node of value val as the last element of the linked list.
void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.


Example 1:

Input
["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
[[], [1], [3], [1, 2], [1], [1], [1]]
Output
[null, null, null, null, 2, null, 3]

Explanation
MyLinkedList myLinkedList = new MyLinkedList();
myLinkedList.addAtHead(1);
myLinkedList.addAtTail(3);
myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
myLinkedList.get(1);              // return 2
myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
myLinkedList.get(1);              // return 3


Constraints:

0 <= index, val <= 1000
Please do not use the built-in LinkedList library.
At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and deleteAtIndex.

 */

public class LinkedListDesign {




    class Node{

        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }

    private Node head;
    private int size;

   /* Initialize your data structure here */
   public LinkedListDesign(){

       this.size = 0;
       this.head = null;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {

        if(index < 0 || index>=size) return -1;

        if(size == 1 ){
            return head.val;
        }

        Node current = head;
        for(int i=0; i< index; i++){
            current=current.next;
        }

        return current.val;
    }


    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        if (head == null){
            head = node;
        }else{
            node.next = head;
            head = node;
        }

        size++;

    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {

        Node node = new Node(val);


        if(head == null){
            head = node;
        }else{
            Node current = head;
            for( int i =0; i < size-1;i++){
                current = current.next;
            }
            current.next = node;

        }
        size++;

    }

    /** Add a node of value val before the index-th node in the linked list.
     *  If index equals to the length of linked list, the node will be appended to the end of linked list.
     *  If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {

        if ( index > size) return;

        if(index <= 0){
            addAtHead(val);
        }else if(index ==size){
            addAtTail(val);
        }
        else{


            Node current = head;
            for(int i=0;i<index-1;i++){
                current =current.next;
            }

            Node node = new Node(val);
            node.next = current.next;
            current.next = node;

            size++;
        }


    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {

        System.out.println(" size --> "+size);

        if(index < 0 || index >= size) return;

        size--;

        if(index == 0){
            head = head.next;
            return;
        }

        Node current = head;

        for(int i = 0; i<index-1;i++){
            current = current.next;

        }

        current.next = current.next.next;

    }

    public void printLinkedList(){

        Node current = head;

        for(int i=0;i<size;i++){

            System.out.print(current.val+" --> ");
            current = current.next;
        }
        System.out.println("End");
    }

    public static void main(String[] args) {

        LinkedListDesign linkedListDesign = new LinkedListDesign();


        linkedListDesign.printLinkedList();

        linkedListDesign.addAtHead(10);

        linkedListDesign.printLinkedList();

        System.out.println(linkedListDesign.get(4));

       /* linkedListDesign.addAtTail(3);

        linkedListDesign.printLinkedList();

        linkedListDesign.addAtIndex(1,2);

        linkedListDesign.printLinkedList();

        System.out.println(linkedListDesign.get(1));

        linkedListDesign.deleteAtIndex(1);

        linkedListDesign.printLinkedList();

        System.out.println(linkedListDesign.get(1));

        */


    }

}
