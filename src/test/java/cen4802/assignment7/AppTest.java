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
}
