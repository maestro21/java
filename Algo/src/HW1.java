import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class HW1 {

    PrintWriter pw;
    Scanner sc;


    public static void main(String[] args) {
        HW1 hw = new HW1();
        hw.threeDigitsZeroSum();
        hw.twoBiggest();
        hw.aPlusB();
    }


    // Difficulty: cubic
    public void threeDigitsZeroSum() {
        int[] arr = { -4, -3, -2, -1, 1, 2, 3, 4 };

        System.out.println("Task1: find all 3 number combinations that has sum = 0");
        System.out.println("Array: " + Arrays.toString(arr));

        int a, b, c;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    a = arr[i]; b = arr[j]; c = arr[k];
                    if ((a + b + c) == 0 && (a != b && a != b && c != a)) {
                        System.out.println("" + a + " + " + b + " + " + c + " = 0");
                    }
                }
            }
        }
    }

    // Difficulty: linear * 2
    public void twoBiggest() {
        int[] arr = new int[10];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 10);
        }

        int big1 = 0, big2 = 0, e = 0;
        for(int i = 0; i < arr.length; i++) {
            e = arr[i];
            if(e > big1) {
                big1 = e;
            }
        }

        for(int i = 0; i < arr.length; i++) {
            e = arr[i];
            if(e > big2 && e < big1 ) {
                big2 = e;
            }
        }
        System.out.println();
        System.out.println("Task2: find 2 biggest numbers in array");
        System.out.println(Arrays.toString(arr));
        System.out.println("Biggest: " + big1 + ", 2nd biggest:" + big2);
    }

    // @see https://acmp.ru/index.asp?main=task&id_task=1
    public void aPlusB(){
        try {
            sc = new Scanner(new File("input.txt"));
            int a = sc.nextInt(), b = sc.nextInt();
            pw = new PrintWriter(new File("output.txt"));
            pw.print(a + b);
            pw.close();
            sc = new Scanner(new File("output.txt"));
            int res = sc.nextInt();
            System.out.println();
            System.out.println("Task3: output a + b from input.txt to output.txt");
            System.out.println("" + a + " + " + b + " = " + res);
        } catch(IOException e) {
            System.out.println(e.toString());
        }
    }
}
