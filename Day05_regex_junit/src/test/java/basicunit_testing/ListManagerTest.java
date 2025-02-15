package basicunit_testing;

import static org.junit.jupiter.api.Assertions.*;

import org.example.junit.basic_junit.ListManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class ListManagerTest {

    private List<Integer> testList;

    //Setup method to initialize the list before each test
    @BeforeEach
    public void setUp() {
        testList = new ArrayList<>();
    }

    //Test addElement method
    @Test
    public void testAddElement() {
        ListManager.addElement(testList, 10);
        assertEquals(1, ListManager.getSize(testList), "Size should be 1 after adding one element.");
        assertTrue(testList.contains(10), "The list should contain the added element.");
    }

    //Test removeElement method
    @Test
    public void testRemoveElement() {
        testList.add(10);
        testList.add(20);
        ListManager.removeElement(testList, 10);

        //Verify the element is removed
        assertEquals(1, ListManager.getSize(testList), "Size should be 1 after removing one element.");
        assertFalse(testList.contains(10), "The list should not contain the removed element.");

        //Verify that attempting to remove an element not in the list returns false
        boolean result = ListManager.removeElement(testList, 30);
        assertFalse(result, "Removing a non-existing element should return false.");
    }

    //Test getSize method
    @Test
    public void testGetSize() {
        assertEquals(0, ListManager.getSize(testList), "Size should be 0 for an empty list.");

        testList.add(10);
        testList.add(20);
        assertEquals(2, ListManager.getSize(testList), "Size should be 2 after adding two elements.");

        ListManager.removeElement(testList, 10);
        assertEquals(1, ListManager.getSize(testList), "Size should be 1 after removing one element.");
    }
}
