import exceptions.ElementNotFoundException;

import java.util.ArrayList;

public class ArrayBinarySearchTree<T extends Comparable<T>> extends ArrayBinaryTree implements BinarySearchTreeADT {

    /**
     * Constructs a new binary search tree.
     */
    public ArrayBinarySearchTree() {
        super();
    }

    /**
     * Constructs a new binary search tree with an element at the root.
     * @param element new root element
     */
    public ArrayBinarySearchTree(T element) {
        super(element);
    }

    /**
     * Adds an element to the tree.
     * Complexity: O(n log2 n)
     * Precodition: The tree has been instantiated and there is space in the array for an additional element.
     * Postcondition: The tree contains an additional element.
     * @param element the element to be added to this tree
     */
    @Override
    @SuppressWarnings("unchecked")
    public void addElement(Object element) {
        recAddElement((T) element, root);
    }

    /**
     * Recursively add an element to subtree.
     * @param element the element to be added
     * @param root root of the subtree
     */
    @SuppressWarnings("unchecked")
    public void recAddElement(T element, int root) {
        if (root >= array.length) {
            return;
        }
        if (array[root] == null) {
            array[root] = element;
        } else {
            // greater, go right
            if (element.compareTo((T) array[root]) <= 0) {
                recAddElement(element, 2 * root + 1);
            }
            // lesser, go left
            if (element.compareTo((T) array[root]) > 0) {
                recAddElement(element, 2 * (root + 1));
            }
        }
    }

    /**
     * Remove an element from the tree.
     * Complexity: O(n log2 n)
     * Precondition: The tree object has been instantiated and the tree is not empty.
     * Postcondition: The element has been removed from the tree.
     * @param targetElement the element to be removed from the tree
     * @return the element removed from the tree
     */
    @Override
    @SuppressWarnings("unchecked")
    public Object removeElement(Object targetElement) {
        //find it
        int toRemove = findElementLocation((T) targetElement);
        Object removed = null;

        boolean leftChildNull = true;
        boolean rightChildNull = true;

        try {
            leftChildNull = array[2 * toRemove + 1] == null;
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        try {
            rightChildNull = array[2 * (toRemove + 1)] == null;
        } catch (ArrayIndexOutOfBoundsException e) {

        }

        // leaf case
        if (leftChildNull && rightChildNull) {
            removed = array[toRemove];
            array[toRemove] = null;
        }
        // 1 child case
        if (leftChildNull || rightChildNull) {
            // set node to null, take subtree with child and put into node (const from last ass), or take subtree into temp array and insert
            ArrayList<T> subtree = getSubtreeElements(toRemove);
            subtree.remove(array[toRemove]);
            for (T i : subtree) {
                recRemoveElement(i,toRemove);
            }
            array[toRemove] = null;
            for (T i : subtree) {
                addElement(i);
            }

        }
        // 2 child(s) case
        if (!leftChildNull && !rightChildNull) {
            // move up inorder predecessor, delete node to remove

            int predecessorIndex = findInorderPredecessor(toRemove);
            Object temp = array[predecessorIndex];
            array[toRemove] = null;
            array[toRemove] = temp;
            array[predecessorIndex] = null;

            int leftChild = getLeftChild(predecessorIndex);
            int rightChild = getRightChild(predecessorIndex);

            if (leftChild > array.length || rightChild > array.length) {
                return null;
            }

            if (array[leftChild] != null) {
                array[predecessorIndex] = array[leftChild];
                array[leftChild] = null;
            }
            else if (array[rightChild] != null) {
                array[predecessorIndex] = array[rightChild];
                array[rightChild] = null;
            }
        }
        return removed;
    }

    /**
     * Recursively remove an element from a subtree, beginning at the specified index.
     * @param element The element to remove.
     * @param root    The current index
     */
    public void recRemoveElement(T element, int root) {
        if (root >= array.length) {
            return;
        }
        // found, remove
        if (array[root] == element) {
            array[root] = null;
        } else {
            // left subtree
            recRemoveElement(element, 2 * root + 1);
            // right subtree
            recRemoveElement(element, 2 * (root + 1));
        }

    }

    /**
     * Creates an ArrayList holding the elements of a given subtree.
     * @param root root index of the subtree
     * @return an ArrayList of subtree elements
     */
    public ArrayList<T> getSubtreeElements(int root) {
        ArrayList<T> list = new ArrayList<T>();
        recSubtree(list, root);
        return list;
    }

    /**
     * Recursively collect elements in a subtree.
     * @param list list of elements in the subtree
     * @param root the root of the subtree
     */
    private void recSubtree(ArrayList list, int root){
        if (root >= array.length) {
            return;
        }
        if (array[root] == null) {
            return;
        }
        else {
            list.add(array[root]);
            // left subtree
            recSubtree(list, 2 * root + 1);
            // right subtree
            recSubtree(list, 2 * (root + 1));
        }
    }

    /**
     * Find the array index of an element in the tree.
     * @param element the element to locate
     * @return int the index of the element
     */
    private int findElementLocation(T element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        throw new ElementNotFoundException("tree");
    }

    /**
     * Finds the inorder precedessor of a node.
     * @param node array index of the node
     * @return array index of the node's inorder predecessor
     */
    private int findInorderPredecessor(int node) {
        // node is null
        if (array[node] == null) {
            throw new ElementNotFoundException("tree (inorder predecessor)");
        }
        // has left child, rightmost node of left child is predecessor
        if (array[2 * node + 1] != null) {
            return findRightmostChild(2 * node + 1);
        }
        // does not have left child
        return (node - 1) / 2; // parent is predecessor
    }

    /**
     * Recursively locates rightmost child of a node.
     * @param node array index of the node
     * @return array index of the rightmost child
     */
    public int findRightmostChild(int node) {
        // node is null, get parent
        if (array[node] == null) {
            return (node - 1) / 2;
        } else {
            int rightChild = 2 * (node + 1);
            if (rightChild >= array.length) {
                return node;
            }
            return findRightmostChild(rightChild);
        }
    }

    /**
     * Removes all occurrences of an element from the tree.
     * Complexity: O(n log2 n)
     * Precondition: The tree object has been instantiated and contains at least one of the target element.
     * @param targetElement the element to be removed from the tree
     */
    @Override
    public void removeAllOccurrences(Object targetElement) {
        while (contains(targetElement)) {
            removeElement(targetElement);
        }
    }

    /**
     * Remove the minimum element from the tree
     * Complexity: O(1)
     * Precondition: The tree object has at least one element.
     * Postcondition: The minimum element is removed from the tree.
     * @return the element removed from the tree
     */
    @Override
    public T removeMin() {
        return (T)removeElement(findMin());
    }

    /**
     * Remove the maximum element from the tree
     * Complexity: O(1)
     * Precondition: The tree object has at least one element.
     * Postcondition: The maximum element is removed from the tree.
     * @return the element removed from the tree
     */
    @Override
    public T removeMax() {
        return (T)removeElement(findMax());
    }

    /**
     * Finds the minimum element in the tree.
     * Complexity: O(n)
     * Precondition: The tree object has been instantiated.
     * Postcondition: The tree is unchanged.
     * @return the minimum element in the tree.
     */
    @Override
    @SuppressWarnings("unchecked")
    public T findMin() {
        int i = 0;
        while (i < array.length && array[i] != null) {
            i = 2 * i + 1; // this will stop pointing at null left child
        }
        i = (i - 1) / 2; // get parent
        return (T) array[i];
    }

    /**
     * Find the maximum element in the tree.
     * Complexity: O(n)
     * Precondition: The tree object has been instantiated.
     * Postcondition: The tree is unchanged.
     * @return the maxiumum elemnet in the tree.
     */
    @Override
    @SuppressWarnings("unchecked")
    public T findMax() {
        int i = 0;
        while (i < array.length && array[i] != null) {
            i = 2 * (i + 1); // this will stop pointing at null left child
        }
        i = (i - 1) / 2; // get parent
        return (T) array[i];
    }
}

