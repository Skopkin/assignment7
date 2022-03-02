package cen4802.assignment7;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
	static void setUpBeforeClass() throws Exception {
	}

	@After
	static void tearDownAfterClass() throws Exception {
	}

	@Before
	void setUp() throws Exception {
	}

	@After
	void tearDown() throws Exception {
	}
	
	@Test
	void testGetTask() {
		String testString = "Test getter method";
		ToDoItem item = new ToDoItem(testString);
		assertEquals(testString, item.getTask());
	}
	
	@Test
	void testSetTask() {
		String testString = "Test setter method";
		ToDoItem item = new ToDoItem();
		item.setTask(testString);
		assertEquals(testString, item.getTask());
	}
}
