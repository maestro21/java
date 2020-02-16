import java.awt.*;
import java.io.InputStreamReader;
import java.util.Scanner;

public class HW3 {



    public static void main(String[] args) {
        HW3 hw3 = new HW3();
        hw3.testStack();  // 1st task
        hw3.testQueue();  // 1st task
        hw3.testDeque(); // 3rd task
        hw3.dotsAngle(); // 4th task
        hw3.reveseStrings(); // 2nd task
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


    public void dotsAngle() {
        int len = 100;
        int ang = 360;
        Point[] points = new Point[len];
        // generate points
        for(int i = 0; i < len; i++) {
            Point point = new Point();
            point.x = (int)((Math.random() -0.5) * 100);
            point.y = (int)((Math.random() -0.5) * 100);
            points[i] = point;
        }

        /**
        // if we want to test coords
        points[0].x = 0;
        points[0].y = -1;
        points[1].x = 1;
        points[1].y = 0;
        points[2].x = 0;
        points[2].y = 1;
        points[3].x = -1;
        points[3].y = 0; /**/

        Queue[] angles = new Queue[ang];
        for(int i = 0; i < len; i++) {
            int angle = (int)(90 - Math.toDegrees(Math.atan2(points[i].x, points[i].y)));
            if(angle < 0) angle += 360;

            //if(i < 4)
            System.out.printf("(x:%d, y:%d) => %d \n",points[i].x,points[i].y, angle);
            if(angles[angle] == null) {
                angles[angle] = new Queue<Point>(len);
            }
            angles[angle].enqueue(points[i]);
        }

        int maxShots = 0;
        int bestAngle = 0;
        for(int i = 0; i < ang; i++) {
            if(angles[i] != null) {
                System.out.println(angles[i].size());
                if (angles[i].size() > maxShots) {
                    maxShots = angles[i].size();
                    bestAngle = i;
                }
            }
        }
        System.out.println();
        System.out.printf("Best angle to shoot %d -> you can kill %d gulls with one shot:\n", bestAngle, maxShots);
        for(int i = 0; i < angles[bestAngle].size(); i++) {
            System.out.println(angles[bestAngle].dequeue());
        }
        System.out.println();
    }

}
