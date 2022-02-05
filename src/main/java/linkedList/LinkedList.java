package linkedList;

public class LinkedList {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.prependValue(5);
        list.prependValue(6);
        list.appendValue(7);
        list.appendValue(8);
        list.appendValue(9);
        list.deleteHead();
        list.deleteTail();
        System.out.println(list.head);
        System.out.println(list.tail);

    }


    Node head;
    Node tail;

    public LinkedList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    public LinkedList() {
    }



    //Complexity: 0(1)
    public Node prependValue(int value){
        Node newNode = new Node(value, head);
        head = newNode;

        //if the linkedlist was empty
        if(this.tail == null){
            tail = newNode;
        }
        return newNode;
    }

    public Node appendValue(int value){
        Node lastNode = new Node(value, null);

        //if the linkedlist was empty
        if(this.head == null){
            this.head = lastNode;
            this.tail = lastNode;
        }
        tail.next = lastNode;
        tail = lastNode;
        return lastNode;
    }

    public Node deleteHead(){
        if(head == null){
            return null;
        }
        if(head.next != null){
            this.head = head.next;
        }else{
            this.head = null;
            this.tail = null;
        }
        return head;
    }

    public Node deleteTail(){
        Node current = head;
        if(current == null){
            return null;
        }
        while(current.next != null){
            if(current.next.next == null){
                current.next = null;
            }else{
                current = current.next;
            }
            tail = current;
        }
        return tail;
    }

}

class Node{
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}



