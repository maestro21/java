package recursion;

public class Exp {


    public static long sqrRecursive(int num, int sqr) {
        return sqrRecursive(num, sqr, 1);
    }


    public static long sqrRecursive(int num, int sqr, int sum) {
        if (sqr == 0) {
            return sum;
        }
        sum = sum * num;
        System.out.printf("%d ", sum);
        return sqrRecursive(num, sqr - 1, sum);
    }


    public static void main(String[] args) {
        System.out.printf("\n %d в степени %d = %d", 3, 10, sqrRecursive(3, 10));
    }



}
