import exceptions.ElementNotFoundException;

public class ArrayBinarySearchTree<T extends Comparable<T>> extends ArrayBinaryTree implements BinarySearchTreeADT {

// TODO no arg and 1 arg constructor
//    public ArrayBinarySearchTree(T element) {
//        super(element);
//    }

    @Override
    @SuppressWarnings("unchecked")
    public void addElement(Object element) {
        recAddElement((T) element, root);
    }

    @SuppressWarnings("unchecked")
    public void recAddElement(T element, int root) {
        if (root >= array.length) {
            return;
        }
        if (array[root] == null) {
            array[root] = element;
        }
        else {
            // greater, go right
            if (element.compareTo((T) array[root]) <= 0 ) {
                recAddElement(element, 2 * root + 1);
            }
            // lesser, go left
            if (element.compareTo((T) array[root]) > 0 ) {
                recAddElement(element, 2 * (root + 1));
            }
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object removeElement(Object targetElement) {
        //find it
        int toRemove = findElementLocation((T)targetElement);
        Object removed = null;

        boolean leftChildNull = true;
        boolean rightChildNull = true;
        try {
            leftChildNull = array[2*toRemove+1]==null;
        }
        catch (ArrayIndexOutOfBoundsException e) {

        }
        try {
            rightChildNull = array[2*(toRemove+1)]==null;
        }
        catch (ArrayIndexOutOfBoundsException e){

        }

        // leaf case
        if (leftChildNull && rightChildNull) {
            removed = array[toRemove];
            array[toRemove] = null;
        }
        // 1 child case
        if (leftChildNull || rightChildNull) {
            // set node to null, take subtree with child and put into node (const from last ass), or take subtree into temp array and insert
            // TODO

        }
        // 2 child(s) case
        if (!leftChildNull && !rightChildNull) {
            // find it, null it, inorder predecessor (could have child), move up inorder predecessor, delete predecessor, start delete at left child
            // TODO
        }
        return removed;
    }

    public void recRemoveElement() {

    }

    public int findElementLocation(T element) {
        for (int i=0; i < array.length; i++) {
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
    public int findInorderPredecessor(int node){
        // node is null
        if (array[node] == null) {
            throw new ElementNotFoundException("tree (inorder predecessor)");
        }
        // has left child, rightmost node of left child is predecessor
        if (array[2*node+1] != null) {
            return findRightmostChild(2*node+1);
        }
        // does not have left child
        return (node-1)/2; // parent is predecessor
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
        }
        else {
            int rightChild = 2*(node+1);
            if (rightChild>=array.length) {
                return node;
            }
            return findRightmostChild(rightChild);
        }
    }

    @Override
    public void removeAllOccurrences(Object targetElement) {

    }

    @Override
    public T removeMin() {
        return null;
    }

    @Override
    public T removeMax() {
        return null;
    }


    @Override
    @SuppressWarnings("unchecked")
    public T findMin() {
        int i = 0;
        while (i < array.length && array[i] != null) {
            i = 2 * i + 1; // this will stop pointing at null left child
        }
        i = (i-1)/2; // get parent
        return (T) array[i];
    }

    @Override
    @SuppressWarnings("unchecked")
    public T findMax() {
        int i = 0;
        while (i< array.length && array[i] != null) {
            i = 2 * (i + 1); // this will stop pointing at null left child
        }
        i = (i-1)/2; // get parent
        return (T) array[i];
    }
}

