package testcases;

import structures.LinkedList;
import static org.junit.Assert.*;
import org.junit.Test;

import com.sun.corba.se.impl.orbutil.graph.Node;

import org.junit.After;
import org.junit.Before;

/**
 * Test cases for LinkedList lab 
 * 
 * 
 * Test invalid boundary dates, dates treated as leap years (but are not), and
 * invalid days for months.
 * 
 * @author Mason Perrella
 *
 */

public class TestLinkedList
{
    private LinkedList<Object> myList;

    @Before
    public void setUp() throws Exception
    {
    	myList = new LinkedList<Object>();
    	myList.addFirst("mason");
    }

    @After
    public void tearDown() throws Exception
    {

    }

    /**
     * 
     * Test remove from list function.
     * 
     */
    @Test
    public void removeOneNode()
    {
    	assertTrue(myList.size() == 1);
    	myList.addFirst("Plante");
    	assertTrue(myList.size() == 2);
    	assertTrue(myList.remove("Plante"));
    	assertTrue(myList.size() == 1);
    	}
    
    @Test
    public void removeTwoNodes()
    {
    	assertTrue(myList.size() == 1);
    	myList.addFirst("Plante");
    	myList.addLast("charlie");
    	myList.addLast("Code");
    	assertTrue(myList.size() == 4);
        assertTrue(myList.remove("charlie"));
        assertTrue(myList.remove("Code"));
    	assertTrue(myList.size() == 2);
    	assertFalse(myList.contains("charlie"));
        assertFalse(myList.contains("Code"));

    	myList.remove("Plante");
    	}
    
    @Test
    public void removeInvalidNode()
    {
    	assertTrue(myList.size() == 1);
    	myList.addFirst(1);
    	myList.addLast("paper");
    	assertTrue(myList.size() == 3);
        assertFalse(myList.remove("invalid"));
    	assertTrue(myList.size() == 3);
        assertFalse(myList.remove(2));
    	assertTrue(myList.size() == 3);
    	}
    
    /**
     * 
     * Tests if the linked list contains objects after being added.
     * 
     */
    @Test
    public void containsMultipleNodes()
    {
    	myList.addFirst('c');
    	myList.addFirst('d');
    	assertTrue(myList.contains('c'));
    	assertTrue(myList.contains('d'));
    }
    
    @Test
    public void doesNotContainNode()
    {
    	myList.addFirst('f');
    	myList.addLast('z');
    	assertFalse(myList.contains('c'));
    	assertFalse(myList.contains('d'));
    	
    }
    
    @Test
    public void emptyListTestContain()
    {
    	myList.remove("mason");
    	assertFalse(myList.contains("mason"));
    	
    }
    
    /**
     * 
     * Test insert before 
     * 
     */
    @Test
    public void insertOneNodeBefore()
    {
    	
    	myList.addLast("loco");
    	myList.addLast("corn");
    	
    	assertTrue(myList.insertBefore("plop", "loco"));
    	assertTrue(myList.contains("plop"));
    	
    	
    }
    
    @Test
    public void insertOneObjectBefore()
    {
        myList.addFirst("twelve");
        myList.addFirst(7);
        assertTrue(myList.insertBefore("JESUS", "mason"));
        assertTrue(myList.insertBefore("JESUS", "mason"));
    }
    
    @Test
    public void insertMultipleObjectBefore()
    {
        myList.addFirst("twelve");
        myList.addFirst(7);
        myList.addLast(100);
        myList.addLast("blue");
        myList.addFirst('m');
        assertTrue(myList.insertBefore("bacon", "blue"));
        assertTrue(myList.size() == 7);
    }
    
    @Test
    public void insertUnavailableObject()
    {
        myList.addFirst("vnfjvnfjnv");
        myList.remove("mason");
        myList.addLast(7);
        myList.addLast('b');
        assertFalse(myList.insertBefore("Computer", "mason"));
        myList.remove(7);
        assertFalse(myList.insertBefore("Computer", 7));

    }
   
    /**
     * 
     * Test remove first
     * 
     */
    @Test
    public void removeFirstNode()
    {
    	myList.addFirst(2);
    	myList.removeFirst();
    	assertFalse(myList.contains(2));
    	
    	
    }
    
    @Test
    public void removeFirstFewNodes()
    {
    	myList.addFirst('d');
    	myList.addFirst('c');
    	myList.addFirst('a');
    	myList.removeFirst();
    	myList.removeFirst();
    	myList.removeFirst();
    	assertFalse(myList.contains('d'));
    	assertFalse(myList.contains('c'));
    	assertFalse(myList.contains('a'));
    	assertTrue(myList.contains("mason"));
    	assertTrue(myList.size() == 1);
    	
    	
    }
    
    @Test
    public void testCantRemoveFirstNode()
    {
    	myList.remove("mason");
    	assertFalse(myList.contains("mason"));
    	assertTrue(myList.size() == 0);
    	myList.removeFirst();
    	assertTrue(myList.size() == 0);

    	
    	
    }
    @Test
    public void testRemoveOnlyFirstNode()
    {
        assertTrue(myList.size() == 1);
    	myList.removeFirst();
    	assertFalse(myList.contains("mason"));
    	assertTrue(myList.size() == 0);
    	
    	
    }
    
    /**
     * 
     * Test remove last.
     * 
     */
    @Test
    public void removeLastNode()
    {
    	myList.addLast(2);
    	myList.removeLast();
    	assertFalse(myList.contains(2));
    	assertTrue(myList.size() == 1);
    }
    
    @Test
    public void removeLastFewNodes()
    {
    	myList.addLast('d');
    	myList.addLast('c');
    	myList.addLast('a');
    	myList.removeLast();
    	myList.removeLast();
    	myList.removeLast();
    	assertFalse(myList.contains('d'));
    	assertFalse(myList.contains('c'));
    	assertFalse(myList.contains('a'));
    	assertTrue(myList.contains("mason"));
    	assertTrue(myList.size() == 1);
    	
    	
    }
    
    @Test
    public void testRemoveOnlyNode()
    {
    	myList.removeLast();
    	assertFalse(myList.contains("mason"));
    	assertTrue(myList.size() == 0);
    	
    	
    }
    
    @Test
    public void testCantRemoveLastNode()
    {
    	myList.remove("mason");
    	assertFalse(myList.contains("mason"));
    	assertTrue(myList.size() == 0);
    	myList.removeLast();
    	assertTrue(myList.size() == 0);

    	
    	
    }
    /**
     * 
     * Test getFirst
     * 
     */
    @Test
    public void getFirstandOnlyNode()
    {
    	assertTrue(myList.getFirst() == "mason");
    	
    }
    
    @Test
    public void getFirstAfterAddNode()
    {
    	myList.addFirst(5);
    	myList.addFirst("Parker");
    	assertTrue(myList.getFirst() == "Parker");
    	
    }
    @Test
    public void getFirstAfterAddFewNodes()
    {
    	myList.addLast(100);
    	myList.addFirst("james");
    	myList.addLast("cool");
    	myList.addFirst("CLOSURE");
    	assertTrue(myList.getFirst() == "CLOSURE");
    	myList.addFirst("hello");
        assertTrue(myList.getFirst() == "hello" );

    	
    }
    
    /**
     * 
     * Test getLast
     * 
     */
    @Test
    public void getLastandOnlyNode()
    {
    	assertTrue(myList.getLast() == "mason");
    }
    
    @Test
    public void getLastAfterAddNode()
    {
    	myList.addLast(5);
    	myList.addLast("Parker");
    	assertTrue(myList.getLast() == "Parker");
    	
    }
    @Test
    public void getLastAfterAddFewNodes()
    {
    	myList.addLast(100);
    	myList.addFirst("james");
    	myList.addLast("cool");
    	myList.addFirst("CLOSURE");
    	assertTrue(myList.getLast() == "cool");
    	
    }
    @Test
    public void getLastInvalidTest()
    {
        myList.remove("mason");
        assertTrue(myList.getLast() == null);
    }
    
    @Test
    public void getLastAfterMultipleNodes()
    {
        myList.addLast(100);
        myList.addFirst("james");
        myList.addLast("cool");
        myList.addFirst("CLOSURE");
        assertTrue(myList.getLast() == "cool");
        myList.addLast("hello");
        assertTrue(myList.getLast() == "hello" );

        
    }
    
    /**
     * 
     * Tests if the object being passed in is now set as the data in the first node(head).
     * 
     */
    @Test
    public void setFirstNode()
    {
    	myList.addLast("JOHN CENA");
    	myList.setFirst("close");
    	
    	assertTrue(myList.getFirst() == "close");
    	assertTrue(myList.getLast() == "JOHN CENA");
    	assertFalse(myList.contains("mason"));
    }
    
    @Test
    public void setFirstNodeinLargeList()
    {
    	myList.addLast("JOHN CENA");
    	myList.addLast("IS");
    	myList.addLast("MY");
    	myList.addLast("IDOL");
    	myList.addLast("SO");
    	myList.addLast("IS");
    	myList.addLast("DR. PLANTE");
    	myList.setFirst("Bloopers");
    	
    	assertTrue(myList.getFirst() == "Bloopers");
    }
    
    @Test
    public void setFirstNodeinLargeGenericList()
    {
    	myList.addLast("JOHN CENA");
    	myList.addLast(7);
    	myList.addLast('d');
    	myList.addLast('c');
    	myList.addLast("quantum");
    	myList.addLast(true);
    	myList.addLast("DR. PLANTE");
    	
    	myList.setFirst("quantum");
    	
    	assertTrue(myList.getFirst() == "quantum");
    }
    /**
     * 
     * Checks the position of an object in the list.  The first space(the Head)
     * is at position 1 for my code.
     * 
     */
    @Test
    public void indexOfSmallList()
    {

        assertTrue(myList.indexOf("mason") == 1);
    }
    
    @Test
    public void indexOfObjectNotInList()
    {
        assertFalse(myList.indexOf("john cena") == 1);
    }
    
    @Test
    public void indexOfObjectAfterAdd()
    {
        myList.addFirst(6);
        myList.addFirst("closure");
        myList.addLast("javascript");
        System.out.println(myList);

        System.out.println(myList.indexOf("javascript"));

        assertTrue(myList.indexOf("javascript") == 4);
    }
    
    @Test
    public void indexOfObjectInLongList()
    {
        myList.addFirst(6);
        myList.addFirst("closure");
        myList.addLast("javascript");
        myList.addFirst("p");
        myList.addFirst(67);
        myList.addFirst("blue");
        myList.addLast("cool");
        myList.addFirst("true");
        assertTrue(myList.indexOf("true") == 1);
        assertTrue(myList.indexOf("cool") == 9);

    }
    
    /**
     * 
     * Test that the size of the list is correct after adding, removing, and from a empty
     * list
     * 
     */
    @Test
    public void testSizeEmptyList()
    {
         myList.remove("mason");
         assertTrue(myList.size() == 0);
    }
    
    @Test
    public void testSizeAfterAddingList()
    {
         myList.addFirst(5);
         myList.addLast(100);
         myList.addFirst("calculus");
         assertTrue(myList.size() == 4);
         myList.addFirst("grapes");
         assertTrue(myList.size() == 5);
    }
    
    @Test
    public void testSizeMultipleAddingAndRemovingFromList()
    {
        myList.addFirst(5);
        myList.addLast(100);
        myList.addFirst("calculus");
        assertTrue(myList.size() == 4);
        myList.addFirst("grapes");
        assertTrue(myList.size() == 5);
        myList.remove("calculus");
        myList.remove(5);
        assertTrue(myList.size() == 3);
        myList.remove(100);
        myList.remove("grapes");
        assertTrue(myList.size() == 1);
        myList.addLast("before");
        myList.insertBefore("PLANTE","before");
        assertTrue(myList.size()==3);
    }
    
    
}