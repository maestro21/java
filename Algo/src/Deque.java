class Deque<T>
{

    int size;
    public int head, end;
    private T[] deque;

    public Deque(int s)
    {
        deque = (T[]) new Object[s];
        head = 0;
        end = 0;
        size = 0;
    }

    public void insertRight(T e)
    {
        if (isFull())
        {
            System.out.println("Deque is full.");
        }
        else if (isEmpty())
        {
            end = head;
            deque[head] = e;
            size++;
        }
        else
        {
            head++;
            if (head >= deque.length) {
                head = 0;
            }
            deque[head] = e;
            size++;
        }
    }

    public void insertLeft(T e)
    {
        if (isFull())
        {
            System.out.println("Deque is full.");
        }
        else if (isEmpty())
        {
            head = end;
            deque[end] = e;
            size++;
        }
        else
        {
            end--;
            if (end < 0) {
                end = deque.length - 1;
            }

            deque[end] = e;
            size++;
        }
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public boolean isFull(){
        return (size == deque.length);
    }
    public int size()
    {
        return size;
    }

    public T getLeft()
    {
        if (size != 0) {
            return deque[end];
        }

        return null;
    }

    public T getRight()
    {
        if (size != 0) {
            return deque[head];
        }

        return null;
    }

    public T removeLeft()
    {
        if (size != 0)
        {
            T tmp = deque[end];
            end++;
            if (end>=deque.length)
                end = 0;
            size --;
            return tmp;
        }

        return null;
    }

    public T removeRight()
    {
        if (size!=0)
        {
            T tmp = deque[head];
            head--;
            if (head<0)
                head = deque.length - 1;
            size --;
            return tmp;
        }

        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(deque[i]);
            sb.append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }
}