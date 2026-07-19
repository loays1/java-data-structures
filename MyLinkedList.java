package javaapplication4;

public class MyLinkedList {
    Node head;
    Node tail;
    int size = 0;
    void addFirst(int data){
        Node n = new Node(data);
        if(head == null){
            head = tail = n;
        }
        else{
            n.next = head;
            head = n;
        }
        size++;
    }
    void addLast(int data){
        Node n = new Node(data);
        if(head == null){
            head = tail = n;
        }
        else{
            tail.next = n;
            tail = n;
        }
        size++;
    }
    void addByIndex(int index , int data){
        if(index > size || index < 0)throw new IndexOutOfBoundsException();
        Node n = new Node (data);
        if(head == null){
            head = tail = n;
            size++;
        }
        else if(index == 0)addFirst(data);
        else if(index == size)addLast(data);
        else{
            Node temp = head;
            index--;
            while(index-->0)temp = temp.next;
            n.next = temp.next;
            temp.next = n;
            size++;
        }
    }
    void removeFirst(){
        if(head == null)return;
        head = head.next;
        if(head == null)tail = null;
        size--;
    }
    void removeLast(){
        if(tail == null)return;
        else if(tail == head)head = tail = null;
        else{
            Node temp = head;
            while(temp.next!= tail)temp = temp.next;
            tail = temp;
            tail.next = null;
        }
        size--;
    }
    void removeByIndex(int index){
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
       else if(index == 0)removeFirst();
       else if(index == size-1)removeLast();
       else {
       index --;
       Node temp = head;
       while(index-->0)temp = temp.next;
        temp.next = temp.next.next;
        size--;
       }
    }
    boolean isEmpty(){
        return size == 0;
    }
    void print(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    
}
