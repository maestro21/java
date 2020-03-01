import javax.swing.*;
import java.util.Random;

public class ShowTree extends JFrame {

    private JTree tree;

    public ShowTree()
    {

        BinaryTree bt = new BinaryTree();
        Random rnd = new Random();
        for (int i=0; i<100; i++) {
            bt.add(rnd.nextInt(200) - 100);
        }

        bt.isBalanced();
        tree = new JTree(bt.buildSwingTree());
        JScrollPane treeView = new JScrollPane(tree);
        treeView.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        treeView.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(treeView);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JTree Example");
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ShowTree();
            }
        });
    }

}
