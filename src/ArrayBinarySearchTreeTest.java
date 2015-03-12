import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class ArrayBinarySearchTreeTest {
    ArrayBinarySearchTree tree1;

    @Before
    public void setUp() throws Exception {
        tree1 = new ArrayBinarySearchTree();
    }

    @Test
    public void testAddElementWithEmptyRoot() throws Exception {
        assertTrue(tree1.isEmpty());
        tree1.addElement("Hello");

        assertFalse(tree1.isEmpty());
        assertEquals("Hello", tree1.iterator().next());
    }

    @Test
    public void testAddElementWithNonEmptyRoot() throws Exception {
        tree1.addElement(20);
//        System.out.println("After adding one element:\n" + tree1);

        tree1.addElement(10);
//        System.out.println("After adding second element:\n" + tree1);
        assertEquals(2, tree1.size());
        assertEquals(10,tree1.find(10));

        tree1.addElement(30);
//        System.out.println("After adding third element:\n" + tree1);
        assertEquals(3,tree1.size());
        assertEquals(30,tree1.find(30));

        // TODO add element to full tree throw exception?
    }

    @Test
    public void testRemoveElementLeafOne() throws Exception {
        tree1.addElement(20);
        tree1.addElement(10);
        tree1.addElement(30);
//        System.out.println("Before removing leaf element:\n" + tree1);
        tree1.removeElement(30);
        assertEquals(2, tree1.size());
//        System.out.println("After removing leaf element:\n" + tree1);
    }

    @Test
    public void testRemoveElementLeafTwo() throws Exception {
        tree1.addElement(20);
        tree1.addElement(10);
        tree1.addElement(30);
//        System.out.println("Before removing leaf element:\n" + tree1);
        tree1.removeElement(10);
        assertEquals(2, tree1.size());
//        System.out.println("After removing leaf element:\n" + tree1);
    }

    @Test
    public void testRemoveAllOccurrences() throws Exception {

    }

    @Test
    public void testRemoveMin() throws Exception {

    }

    @Test
    public void testRemoveMax() throws Exception {

    }

    @Test
    public void testFindMin() throws Exception {
        tree1.addElement(20);
        tree1.addElement(10);
        tree1.addElement(30);
        assertEquals(10, tree1.findMin());

        // todo internal null, unbananced tree?
    }

    @Test
    public void testFindMax() throws Exception {
        tree1.addElement(20);
        tree1.addElement(10);
        tree1.addElement(30);
        assertEquals(30,tree1.findMax());
    }

    @Test
    public void testFindRightmostChild() throws Exception {
        tree1.addElement(20);
        tree1.addElement(10);
        tree1.addElement(30);
        assertEquals(2,tree1.findRightmostChild(0));
    }

    @Test
    public void testFindInorderPredecessor() throws Exception {
        tree1.addElement(20);
        tree1.addElement(10);
        tree1.addElement(30);
        assertEquals(1, tree1.findInorderPredecessor(0));
    }

    // TODO show in driver
    @Test
    public void testToString() throws Exception {
        tree1.addElement(20);
        tree1.addElement(10);
        tree1.addElement(30);
        //System.out.println(tree1);
    }

    // TODO show in driver
    @Test
    public void testToStringTreeWithNullLeaf() throws Exception {
        ArrayBinarySearchTree<Integer> t2 = new ArrayBinarySearchTree<Integer>();
        t2.addElement(1);
        t2.addElement(2);
        System.out.println(t2);
    }
}