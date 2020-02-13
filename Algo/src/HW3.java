import java.io.InputStreamReader;
import java.util.Scanner;

public class HW3 {



    public static void main(String[] args) {
        HW3 hw3 = new HW3();
        hw3.testStack();
        hw3.testQueue();
        hw3.testDeque();
        hw3.reveseStrings();
    }


    public void testStack() {
        Stack<String> stack = new Stack<>(5);
        stack.pop();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println(stack.pop());
        stack.push("d");
        stack.push("e");
        stack.push("f");
        System.out.println(stack.get());
        stack.push("g");
        System.out.println(stack);
    }

    public void testQueue() {
        Queue<String> queue = new Queue<>(5);
        queue.dequeue();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue);
        queue.enqueue("d");
        queue.enqueue("e");
        queue.enqueue("f");
        System.out.println(queue.get());
        queue.enqueue("g");
        System.out.println(queue);
    }


    public void reveseStrings() {
        InputStreamReader isr = new InputStreamReader(System.in);
        Scanner scn = new Scanner(isr);
        String str;
        System.out.println("Please start entering string. Enter `stop` to stop");
        while(scn.hasNext()){
            str = scn.nextLine();
            if (str.equals("stop")) break;
            Stack<Character> s = new Stack<>(str.length());
            for (int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                s.push(c);
            }

            while(!s.isEmpty()) {
                System.out.print(s.pop());
            }
            System.out.println();
        }
    }

    public void testDeque() {
        Deque<String> Deque = new Deque<>(5);
        Deque.insertRight("a");
        Deque.insertLeft("b");
        Deque.insertRight("c");
        Deque.insertLeft("e");
        Deque.insertRight("f");
        System.out.println(Deque);
        Deque.removeLeft();
        Deque.removeRight();
        System.out.println(Deque);
        System.out.println(Deque.getLeft());
        System.out.println(Deque.getRight());

    }

}
