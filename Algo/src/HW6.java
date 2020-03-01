import java.util.Random;

public class HW6 {

    public static void main(String[] args) {
        Random rnd = new Random();

        int balancedTrees = 0;
        int n = 10000;
        int maxHeight = 4; // 99+% of 5 & 6 lvl trees are imbalanced so we put max 4.
        for(int t = 0; t < n; t++) {
            BinaryTree bt = new BinaryTree();
            while(bt.getHeight() < maxHeight) {
                bt.add(rnd.nextInt(200) - 100);
            }
            System.out.printf("Created tree with size %s\n" , bt.getSize());
            if(bt.isBalanced()) {
                balancedTrees++;
            }
        }
        System.out.printf("%d out of %d trees are balanced (%d%s)", balancedTrees, n, (balancedTrees * 100 / n),  "%");
    }

}
