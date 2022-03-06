package cen4802.assignment7;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    @Before
	public void setUpBeforeClass() throws Exception {
	}

	@After
	public void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetTask() {
		String testString = "Test getter method";
		ToDoItem item = new ToDoItem(testString);
		assertEquals(testString, item.getTask());
	}
	
	@Test
	public void testSetTask() {
		String testString = "Test setter method";
		ToDoItem item = new ToDoItem();
		item.setTask(testString);
		assertEquals(testString, item.getTask());
	}
	
	@Test
	public void testAddRemoveItem() {
		String testString = "Test db entry";
		ToDoItem item = new ToDoItem(testString);
		HibernateDb db = new HibernateDb();
		db.addItem(item);
		ArrayList<ToDoItem> list = db.updateList();
		assertEquals(testString, list.get(list.size() - 1).task);
		db.removeItem(testString);
		list = db.updateList();
		for (ToDoItem i: list) {
			assertNotEquals(testString, i.getTask());
		}
		
	}
	
//	@Test
//	public void testRemoveItem() {
//		String testString = "Test db entry";
//		HibernateDb db = new HibernateDb();
//		db.removeItem(testString);
//		ArrayList<ToDoItem> list = db.updateList();
//		for (ToDoItem i: list) {
//			assertNotEquals(testString, i.getTask());
//		}
//	}
}