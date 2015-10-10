package phillips.deliverable2.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import phillips.deliverable2.code.City;
import phillips.deliverable2.code.Main;

public class MainTest
{
	/*
	 * Check that the city starts with the correct number of roads
	 */
	@Test
	public void testNumLocations()
	{
		City c = Main.getCity();
		assertEquals(c.getNumLocations(), 5);
	}

	/*
	 * Check that the driver's starting location is the one passed in with the
	 * constructor
	 */
	@Test
	public void testNumRoads()
	{
		City c = Main.getCity();
		assertEquals(c.getNumRoads(), 10);
	}
}
