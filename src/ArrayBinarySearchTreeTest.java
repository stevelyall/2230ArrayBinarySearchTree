import org.junit.Before;
import org.junit.Test;

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
        System.out.println("After adding one element:\n" + tree1);
        tree1.addElement(10);
        System.out.println("After adding second element:\n" + tree1);
        assertEquals(2, tree1.size());
        assertEquals(10,tree1.find(10));
        tree1.addElement(30);
        System.out.println("After adding third element:\n" + tree1);
        assertEquals(3,tree1.size());
        assertEquals(30,tree1.find(30));
    }

    @Test
    public void testRemoveElement() throws Exception {

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

    }

    @Test
    public void testFindMax() throws Exception {

    }
}