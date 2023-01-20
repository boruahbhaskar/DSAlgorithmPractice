package LinkedList;/*
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.



Example 1:


Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
Example 2:


Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
Example 3:


Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.


Constraints:

The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.


Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */

public class LinkedListCycle {
  //Defining singly-linked list
    public class ListNode{
        int val;
        ListNode next;

        ListNode(){}

        ListNode(int x){
            val = x;
          //  next = null;
        }

        ListNode(int val, ListNode next){

            this.val = val;
            this.next = next;

        }

    }

    private ListNode head;
    private int size;

    public boolean hasCycle(ListNode head){

        if(head == null || head.next == null) return false;

        // Kept two pointers walker and runner

        ListNode runner = head;
        ListNode walker = head;


        while(runner != null && runner.next != null){

            walker = walker.next;
            runner = runner.next.next;

            //walker walks one node at a time
            //runner walks two node at a time

            //If there is a cycle in the list , runner will meet walker at some point of time

            if(walker == runner) return true;
        }

        return false;
    }




    public void addAtHead(int val){

        ListNode node = new ListNode(val);

        if(head == null){
            head = node;
        }else{
            ListNode current = head;

            node.next = head;
            head  = node;
          }

        size++;
    }

    public void addAtTail(int val){

        ListNode node = new ListNode(val);
        if(head == null){
            head = node;
        }else{

            ListNode current = head;

            for(int i=0; i< size-1;i++){

                current = current.next;

            }
            current.next = node;

           // node.next = head.next; //to make the list cycle
        }
    size++;

    }


    public void addAtIndex(int val,int index){

        if(index > size ) return;

        ListNode node = new ListNode(val);

        if(index <= 0){
            addAtHead(val);
        }else if(index == size){
            addAtTail(val);
        }else{

            ListNode current = head;

            for(int i=0; i<index -1 ; i++){
                current = current.next;
            }

            node.next = current.next;
            current.next = node;
            size++;
        }



    }

    public void printLinkedList(ListNode head){

        ListNode  current = head;

        for(int i=0;i<size;i++){

            System.out.print(current.val+" --> ");
            current = current.next;
        }
        System.out.println("End");
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        /*

          //boundary check
    if(headA == null || headB == null) return null;

    ListNode listA = headA;
    ListNode listB = headB;

    //if a & b have different len, then we will stop the loop after second iteration
    while( listA != listB){
    	//for the end of first iteration, we just reset the pointer to the head of another linkedlist

        /*
        if(listA == null){
            listA = headB;
        }else{
            listA = listA.next;
        }

        if(listB == null){
            listB = headA;
        }else{
            listB = listB.next;
        }



        listA = listA == null ? headB : listA.next;

        listB = listB == null ? headA : listB.next;

    }

    return listA;
         */

        int lengthA=0;
        int lengthB=0;
        ListNode tempA=headA;
        ListNode tempB=headB;
        while(tempA!=null)
        {
            lengthA++;
            tempA=tempA.next;
        }

        while(tempB!=null)
        {
            lengthB++;
            tempB=tempB.next;
        }


        if(lengthA>lengthB)
        {
            while(lengthA>lengthB)
            {
                headA=headA.next;
                lengthA--;
            }

            while(headA!=headB)
            {
                headA=headA.next;
                headB=headB.next;
            }

            return headA;



        }else{
            while(lengthB>lengthA)
            {
                headB=headB.next;
                lengthB--;
            }

            while(headA!=headB)
            {
                headA=headA.next;
                headB=headB.next;
            }

            return headA;

        }




    }


    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);

        //add an auxiliary "dummy" node, which points to the list head. The "dummy" node is used to simplify some corner cases such as a list with only one node, or removing the head of the list.

        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        //Advance the first pointer so that the gap between first qand second is n node apart

        for(int i=0; i <= n; i++){

            first = first.next;

        }

        //Move first to the end , maintaing the gap

        while (first != null){

            first = first.next;
            second = second.next;

        }

        second.next = second.next.next;

        return dummy.next;
        //This will help to return the list with removed node



    }

    // Iterative Solution
    public ListNode reversalListIterative(ListNode head){

       ListNode prev = null;

       while(head != null){

           ListNode next_node = head.next; //like a temporary variable

           head.next = prev; // assign the pointer to the previous node
           prev = head; // Move previous node to the current header
           head = next_node; // Move the head to the next node

       }

       return prev;


    }


    // Recursive Solution for Reversing Linked List

    public ListNode reverseList(ListNode head){

        // recursive solution

       return reverseListRecursiveCall(head,null);

    }



    /*
        When the input node is an empty node, then there is nothing to delete, so we just return a null         node back. (That's the first line)

        When the head of the input node is the target we want to delete, we just return head.next               instead of head to skip it. (That's the third line), else we will return head.

        We apply the same thing to every other node until it reaches null. (That's the second line).

        It basically goes down to the last null node, and rebuilds the linked list, by adding                   only the nodes which are not equal to val to this null, so it goes from
        null ;
        [5->null] //when head is 6 it doesnt add anything to head
        [4-->5-->null]
        [3-->4-->5-->-->null]
        [2-->3-->4-->5-->null]
        [1-->2-->3-->4-->5-->null]

        */

    public ListNode removeElements(ListNode head, int val) {

       /* recursive function

        if (head == null)
            return null;

        head.next = removeElements(head.next,val);

        return head.val==val ? head.next : head;

        */

        // if head is the target value , we need to remove the head and move the head pointer to the next node
        while(head != null && head.val == val){

            head = head.next;
        }

        if(head==null)
            return head;

        ListNode current_node = head;

        while( current_node != null && current_node.next != null){

            if(current_node.next.val == val){
                current_node.next = current_node.next.next;
            }else{
                current_node = current_node.next;
            }

        }

        return head;

    }


    /*  ODD EVEN Linked list
    Input: head = [2,1,3,5,6,4,7]
  Output: [2,3,6,7,1,5,4]
    Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.
    * */


    public ListNode oddEvenList(ListNode head) {

        if(head == null)
            return null;

        ListNode  odd = head, even = head.next, evenHead = even;

        while(even !=null && even.next != null){
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even  = even.next;

        }

        odd.next = evenHead;
        return head;


    }

    private ListNode reverseListRecursiveCall(ListNode head, ListNode prev){

        if(head == null)
            return  prev;

        ListNode next_node = head.next;
        head.next = prev;

        return reverseListRecursiveCall(next_node,head);



    }





    public static void main(String[] args) {

     LinkedListCycle linkedListCycle = new LinkedListCycle();

     linkedListCycle.addAtHead(3);

     linkedListCycle.addAtTail(-4);

     //   linkedListCycle.printLinkedList();

     linkedListCycle.addAtIndex(2,1);

     linkedListCycle.addAtIndex(0,2);

     linkedListCycle.printLinkedList(linkedListCycle.head);

     //ListNode current = head;

    // System.out.println(linkedListCycle.hasCycle(linkedListCycle.head));


       ListNode temp = linkedListCycle.reverseList(linkedListCycle.head);  // linkedListCycle.reversalListIterative(linkedListCycle.head);

        linkedListCycle.printLinkedList(temp);


    }



}
