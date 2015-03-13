public class Main {


    public static void main(String[] args) {
        ArrayBinarySearchTree<Integer> tree1, tree2, tree3;

        // create new tree with no arg constructor
        System.out.println("Creating a new empty tree:");
        tree1 = new ArrayBinarySearchTree();
        System.out.println("Printing tree...");
        System.out.println(tree1);
        System.out.println("Tree is empty?..." + tree1.isEmpty() + ", size: " + tree1.size());
        System.out.println("Adding elements:");
        tree1.addElement(40);
        System.out.println("Tree is empty?..." + tree1.isEmpty() + ", size: " + tree1.size());
        tree1.addElement(30);
        tree1.addElement(70);
        tree1.addElement(80);
        tree1.addElement(20);
        System.out.println("Printing tree...");
        System.out.println(tree1);
        System.out.println("Tree is empty?..." + tree1.isEmpty() + ", size: " + tree1.size());
        System.out.println("Adding more elements to tree...");
        tree1.addElement(35);
        tree1.addElement(60);
        System.out.println("Printing tree...");
        System.out.println(tree1);
        System.out.println("Tree is empty?..." + tree1.isEmpty() + ", size: " + tree1.size());

        // remove leaf node
        System.out.println("Remove a leaf node: 60");
        tree1.removeElement(60);

        System.out.println("Printing tree...");
        System.out.println(tree1);
        System.out.println("Tree is empty?..." + tree1.isEmpty() + ", size: " + tree1.size());

        System.out.println("Re-add element to tree...");
        tree1.addElement(60);

        // remove node
        System.out.println("Remove a node with two children: 30");
        tree1.removeElement(30);

        System.out.println("Printing tree...");
        System.out.println(tree1);
        System.out.println("Tree is empty?..." + tree1.isEmpty() + ", size: " + tree1.size());

        System.out.println("Printing tree...");
        System.out.println(tree1);
        // remove min
        System.out.println("Remove min...");
        tree1.removeMin();
        System.out.println(tree1);

        // remove max
        System.out.println("Remove max...");
        tree1.removeMax();
        System.out.println(tree1);

        System.out.println("Printing tree...");
        System.out.println(tree1);
        System.out.println("Tree is empty?..." + tree1.isEmpty() + ", size: " + tree1.size());

        // create tree with one argument
        System.out.println("Creating a new tree with 1 element:");
        tree2 = new ArrayBinarySearchTree(45);
        System.out.println("Printing new tree with one element (1 arg constructor)...");
        System.out.println(tree2);
        System.out.println("Tree is empty?..." + tree2.isEmpty() + ", size: " + tree2.size());
    }
}
