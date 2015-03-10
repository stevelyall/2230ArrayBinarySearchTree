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
        tree1.addElement("Hello");
        System.out.println(tree1);
        tree1.addElement("World");
        assertEquals(2,tree1.size());
        assertEquals("World",tree1.find("World"));
        System.out.println(tree1);
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