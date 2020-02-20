import java.util.Iterator;

public class DoubleLinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> tail;

    public DoubleLinkedList() {}

    public boolean isEmpty() {
        return tail == null && head == null;
    }

    public void createFirstElement(T value) {
        Node<T> newNode = new Node<>(value);
        tail = head = newNode;
    }

    public void insertTail(T value) {
        if(isEmpty()) {
            createFirstElement(value);
        } else {
            Node<T> newNode = new Node<>(value);
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void insertHead(T value) {
        if(isEmpty()) {
            createFirstElement(value);
        } else {
            Node<T> newNode = new Node<>(value);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public T deleteHead() {
        if(!isEmpty()) {
            T value = head.value;
            head = head.next;
            head.prev = null;
            return value;
        }
        return null;
    }

    public T deleteTail() {
        if(!isEmpty()) {
            T value = tail.value;
            tail = tail.prev;
            tail.next = null;
            return value;
        }
        return null;
    }

    //TODO реализовать итератор в качестве ДЗ
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            DoubleLinkedList.Node<T> curr = head;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public T next() {
                T value = curr.value;
                curr = curr.next;
                return value;
            }
        };
    }


    private static class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }


    public void print() {
        this.forEach(result -> System.out.print(result + " "));
        System.out.println();System.out.println();
    }


    public static void main(String[] args) {
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();

        doubleLinkedList.insertHead(1);
        doubleLinkedList.insertTail(2);
        doubleLinkedList.insertHead(3);
        doubleLinkedList.insertTail(4);
        doubleLinkedList.insertHead(5);
        doubleLinkedList.insertTail(6);
        doubleLinkedList.insertHead(7);
        doubleLinkedList.insertTail(8);
        doubleLinkedList.insertHead(9);
        System.out.println("After insert 1-9");
        doubleLinkedList.print();

        System.out.printf("Delete tail: %d \n", doubleLinkedList.deleteTail());
        doubleLinkedList.print();

        System.out.printf("Delete head: %d \n", doubleLinkedList.deleteHead());
        doubleLinkedList.print();

    }
}
