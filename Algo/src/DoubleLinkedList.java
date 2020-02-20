import java.util.Iterator;

public class DoubleLinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> tail;

    public DoubleLinkedList() {
        head = new Node<>(null);
        tail = new Node<>(null);
        head.next = tail;
        tail.prev = head;
    }

    public void insertTail(T value) {
        Node<T> last = tail.prev;
        Node<T> newNode = new Node<>(value);
        newNode.next = tail;
        newNode.prev = last;
    }

    public void insertHead(T value) {
        Node<T> first = head.next;
        Node<T> newNode = new Node<>(value);
        newNode.prev = head;
        newNode.next = first;
    }

    public T deleteHead() {
        //TODO реализовать в качестве ДЗ
        return null;
    }

    public T deleteTail() {
        //TODO реализовать в качестве ДЗ
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
        doubleLinkedList.insertTail(2);
        doubleLinkedList.insertTail(2);doubleLinkedList.insertTail(2);



/*
        doubleLinkedList.insertHead(1);
        doubleLinkedList.insertTail(2);
        doubleLinkedList.insertHead(3);
        doubleLinkedList.insertTail(4);
        doubleLinkedList.insertHead(5);
        doubleLinkedList.insertTail(6);
        doubleLinkedList.insertHead(7);
        doubleLinkedList.insertTail(8);
        doubleLinkedList.insertTail(9); */
        System.out.println("After insert 1-9");
        doubleLinkedList.print();
    }
}
