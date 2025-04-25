package org.dataStructuresAlgo.linkedList.singlyLinkedList;

public class SingleLinkedList {

    private Node head = null;

    public void insertAtStart(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    public void insertAtGivenIndex(int index, int data) {
        if(index < 0) {
            throw new IndexOutOfBoundsException("Out of bound exception");
        }

        Node node = new Node(data);
        if(index == 0) {
            node.next = head;
            head = node;
        } else {
            Node temp = head;
            int currentIndex = 0;
            while(temp != null && currentIndex < index-1) {
                temp = temp.next;
                currentIndex++;
            }
            node.next = temp.next;
            temp.next = node;
        }
    }

    public void insertAtEnd(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void merge(Node list1, Node list2) {

        Node head = new Node(Integer.MIN_VALUE);
        Node temp = head;
        while(list1 != null && list2 != null) {
            if(list1.data < list2.data) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        if(list1 == null) {
            temp.next = list2;
        } else {
            temp.next = list1;
        }

    }

    public Node mergeTwoLists(Node list1, Node list2) {

        Node head = new Node();
        Node temp = head;

        while(list1 != null && list2 != null) {
            if(list1.data <= list2.data) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        
        if(list1 == null) {
            temp.next = list2;
        } else {
            temp.next = list1;
        }
        return head.next;
    }

    public static void main(String[] args) {
        //For linked list, you need to start with the head/ root
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        System.out.println(head.next.data);

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.insertAtEnd(60);
        singleLinkedList.insertAtEnd(70);
        singleLinkedList.insertAtEnd(80);
        System.out.println("--------------------");
        singleLinkedList.print();

        singleLinkedList.insertAtStart(5);
        System.out.println("--------------------");
        singleLinkedList.print();

        singleLinkedList.insertAtGivenIndex(2, 100);
        System.out.println("--------------------");
        singleLinkedList.print();


        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        singleLinkedList2.insertAtEnd(6);
        singleLinkedList2.insertAtEnd(7);
        singleLinkedList2.insertAtEnd(8);
        System.out.println("--------------------");
        singleLinkedList2.print();

        SingleLinkedList singleLinkedList3 = new SingleLinkedList();
        singleLinkedList3.merge(singleLinkedList2.head, singleLinkedList.head);
        System.out.println("--------------------");
        singleLinkedList3.print();

        SingleLinkedList singleLinkedList4 = new SingleLinkedList();
        singleLinkedList4.mergeTwoLists(head, head);
    }
}
