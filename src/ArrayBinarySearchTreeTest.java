import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class ArrayBinarySearchTreeTest {
    ArrayBinarySearchTree tree1, tree2, tree3;

    @Before
    public void setUp() throws Exception {
        tree1 = new ArrayBinarySearchTree();

        tree2 = new ArrayBinarySearchTree();
        tree2.addElement(20);
        tree2.addElement(10);
        tree2.addElement(30);

        tree3 = new ArrayBinarySearchTree(50);
        tree3.addElement(10);
        tree3.addElement(5);
        tree3.addElement(70);
        tree3.addElement(70);
        tree3.addElement(55);
        tree3.addElement(80);
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
    }

    @Test
    public void testAddElementDuplicate() throws Exception {
        ArrayBinarySearchTree<Integer> t3 = new ArrayBinarySearchTree<Integer>();
        t3.addElement(20);
        t3.addElement(10);
        t3.addElement(10);
//        System.out.println("Test add duplicate element");
//        System.out.println(t3);
//        assertEquals(3,t3.size());
    }
    @Test
    public void testRemoveElementLeafOne() throws Exception {
//        System.out.println("Before removing leaf element:\n" + tree2);
        tree2.removeElement(30);
        assertEquals(2, tree2.size());
//        System.out.println("After removing leaf element:\n" + tree2);
    }

    @Test
    public void testRemoveElementLeafTwo() throws Exception {
//        System.out.println("Before removing leaf element:\n" + tree1);
        tree2.removeElement(10);
        assertEquals(2, tree2.size());
//        System.out.println("After removing leaf element:\n" + tree1);
    }

    @Test
    public void testRemoveElementOneChild() throws Exception {
//        System.out.println(tree3);
        assertEquals(6,tree3.size());
        tree3.removeElement(10);
        assertEquals(5,tree3.size());
//        System.out.println(tree3);
        tree3.removeElement(80);
        assertEquals(4,tree3.size());
    }

    @Test
    public void testRemoveElementTwoChildren() throws Exception {
//       System.out.println(tree3);
//       tree3.removeElement(50);
//
//        System.out.println(tree3);
    }

    @Test
    public void testRemoveAllOccurrences() throws Exception {
//        System.out.println(tree3);
        assertEquals(6,tree3.size());
        assertEquals(true,tree3.contains(70));
        tree3.removeAllOccurrences(70);
        assertEquals(4,tree3.size());
        assertEquals(false,tree3.contains(70));
//        System.out.println(tree3);
    }

    @Test
    public void testRemoveMin() throws Exception {
        assertEquals(5,tree3.removeMin());
        assertEquals(10, tree3.removeMin());
    }

    @Test
    public void testRemoveMax() throws Exception {
        assertEquals(80,tree3.removeMax());
        assertEquals(30,tree2.removeMax());
    }

    @Test
    public void testFindMin() throws Exception {
        assertEquals(10, tree2.findMin());
    }

    @Test
    public void testFindMax() throws Exception {
        assertEquals(30,tree2.findMax());
    }

    @Test
    public void testFindRightmostChild() throws Exception {
        assertEquals(2,tree2.findRightmostChild(0));
    }

    @Test
    public void testFindInorderPredecessor() throws Exception {
        assertEquals(1, tree2.findInorderPredecessor(0));
        assertEquals(3, tree3.findInorderPredecessor(tree3.findElementLocation(10)));
    }

    @Test
    public void testToString() throws Exception {

//        System.out.println(tree3);
    }

    @Test
    public void testToStringTreeWithNullLeaf() throws Exception {
        ArrayBinarySearchTree<Integer> t2 = new ArrayBinarySearchTree<Integer>();
        t2.addElement(1);
        t2.addElement(2);
//        System.out.println(t2);
    }

    @Test
    public void testRecRemoveElement() throws Exception {
//        System.out.println("before rec remove: ");
        assertEquals(6,tree3.size());
//        System.out.println(tree3);
        tree3.recRemoveElement(70,0);
//        System.out.println(tree2);
        assertEquals(5,tree3.size());
//        System.out.println("after rec remove: ");
//        System.out.println(tree3);
        tree3.recRemoveElement(70,0);
        assertEquals(4,tree3.size());
//        System.out.println("after rec remove: ");
//        System.out.println(tree3);

    }

    @Test
    public void testFindElementLocation() throws Exception {
        assertEquals(0,tree2.findElementLocation(20));
        assertEquals(1,tree2.findElementLocation(10));
        assertEquals(2,tree2.findElementLocation(30));
    }


}