class Stack<T>{
    private T[] stack;
    private int top;

    public Stack(int size){
        this.stack = (T[]) new Object[size];
        this.top = -1;
    }

    public void push(T i){
        if(isFull()) {
            System.out.println("Stack overflow");
            return;
        }
        this.stack[++this.top] = i;
    }

    public T pop(){
        if(isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return stack[top--];
    }

    public T get(){
        return this.stack[this.top];
    }

    public boolean isEmpty(){
        return (this.top == -1);
    }

    public boolean isFull(){
        return (this.top == this.stack.length - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= top; i++) {
            sb.append(stack[i]);
            sb.append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }
}
