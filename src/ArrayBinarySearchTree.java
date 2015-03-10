import exceptions.ElementNotFoundException;

public class ArrayBinarySearchTree<T extends Comparable<T>> extends ArrayBinaryTree implements BinarySearchTreeADT {


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
            // TODO
        }
        // 2 child(s) case
        if (!leftChildNull && !rightChildNull) {
            // TODO
        }

        return removed;
    }

    public int findElementLocation(T element) {
        for (int i=0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        throw new ElementNotFoundException("tree");
    }

    public void recRemoveElement(T element, int root) {

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
        while (array[i] != null) {
            i = 2 * i + 1; // this will stop pointing at null left child
        }
        i = (i-1)/2; // get parent
        return (T) array[i];
    }

    @Override
    @SuppressWarnings("unchecked")
    public T findMax() {
        int i = 0;
        while (array[i] != null) {
            i = 2 * (i + 1); // this will stop pointing at null left child
        }
        i = (i-1)/2; // get parent
        return (T) array[i];
    }
}

