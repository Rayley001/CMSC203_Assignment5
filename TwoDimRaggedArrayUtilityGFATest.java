
/*
 * Class: CMSC203 
 * Instructor:Shah Madhvi
 * Description: This program loads retail sales data, calculates totals and holiday bonuses, 
 * and displays the results in a JavaFX GUI with highlighted highest and lowest values.
 * Due: 11/17/2025
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Leika Ray Joseph
*/

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class represents GFA test cases for a TwoDimRaggedArrayUtility object.
 * 
 * @author Farnaz Eivazi
 * @version 7/13/2022
 * 
 */
public class TwoDimRaggedArrayUtilityGFATest {
	private double[][] dataSet1 = {{1,2,3},{4,5},{6,7,8,9}};
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test getRowTotal method
	 * Returns the total of all the elements of row 1.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		assertEquals(9.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet1,1),.001);
	}
}
