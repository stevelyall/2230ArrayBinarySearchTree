
public class ArrayBinarySearchTree<T extends Comparable<T>> extends ArrayBinaryTree implements BinarySearchTreeADT {


    @Override
    public void addElement(Object element) {
        recAddElement((T) element, root);
    }

    public void recAddElement(T element, int root) {
        if (array[root] == null) {
            array[root] = element;
            return;
        }
        else {
            // greater, go right
            if ( element.compareTo((T) array[root]) > 0 ) {
                recAddElement(element, 2 * root + 1);
            }
            // lesser, go left
            if (element.compareTo((T) array[root]) <= 0 ) {
                recAddElement(element, 2 * (root + 1));
            }
        }
    }

    @Override
    public Object removeElement(Object targetElement) {
        return null;
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
    public T findMin() {
        int i = 0;
        while (array[i] != null) {
            i = 2 * i + 1; // this will stop pointing at null left child
        }
        i = (i-1)/2; // get parent
        return (T) array[i];
    }

    @Override
    public T findMax() {
        int i = 0;
        while (array[i] != null) {
            i = 2 * (i + 1); // this will stop pointing at null left child
        }
        i = (i-1)/2; // get parent
        return (T) array[i];
    }
}

