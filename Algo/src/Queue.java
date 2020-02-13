class Queue<T> {
    private T[] queue;
    private int front;
    private int rear;
    private int size;

    public Queue(int s){
        queue = (T[]) new Object[s];
        front = 0;
        rear = -1;
        size = 0;
    }
    public void enqueue(T i){
        if(isFull()) {
            System.out.println("Queue overflow");
            return;
        }
        if(rear == queue.length - 1)
            rear = -1;
        queue[++rear] = i;
        size++;
    }

    public T dequeue(){
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        T temp = queue[front++];
        if(front == queue.length)
            front = 0;
        size--;
        return temp;
    }

    public T get(){
        return queue[front];
    }
    public boolean isEmpty(){
        return (size == 0);
    }

    public boolean isFull(){
        return (size == queue.length);
    }

    public int size(){
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(queue[i]);
            sb.append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }
}
