package phillips.deliverable2.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import phillips.deliverable2.code.Road;

public class RoadTest
{
	/*
	 * Make sure that a road can't be instantiated with null source
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNullRoadSrc()
	{
		new Road(null, "Name", "Dest");
	}

	/*
	 * Make sure that a road can't be instantiated with null name
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNullRoadName()
	{
		new Road("Source", null, "Dest");
	}

	/*
	 * Make sure that a road can't be instantiated with null destination
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNullRoadDest()
	{
		new Road("Source", "Name", null);
	}

	/*
	 * getSource function should return the source provided in the constructor
	 */
	@Test
	public void testGetSource()
	{
		Road r = new Road("source", "road", "destination");

		assertEquals(r.getSource(), "source");
	}

	/*
	 * getName function should return the name provided in the constructor
	 */
	@Test
	public void testGetName()
	{
		Road r = new Road("source", "road", "destination");

		assertEquals(r.getName(), "road");
	}

	/*
	 * getDest function should return the destination provided in the
	 * constructor
	 */
	@Test
	public void testGetDest()
	{
		Road r = new Road("source", "road", "destination");

		assertEquals(r.getDest(), "destination");
	}

	/*
	 * Two separate road objects with the same source, road name, and
	 * destination should be considered equal.
	 */
	@Test
	public void testEqualsObject()
	{
		Road r1 = new Road("source", "road", "destination");
		Road r2 = new Road("source", "road", "destination");

		assertTrue(r1.equals(r2));
		assertTrue(r2.equals(r1));
	}

	/*
	 * Two identical roads should return the same hashcode
	 */
	@Test
	public void testHashCodeEqualsObject()
	{
		Road r1 = new Road("source", "road", "destination");
		Road r2 = new Road("source", "road", "destination");

		assertEquals(r1.hashCode(), r2.hashCode());
	}

	/*
	 * Roads with different destinations should not be considered equal
	 */
	@Test
	public void testNotEqualsDestination()
	{
		Road r1 = new Road("source", "road", "destination");
		Road r2 = new Road("source", "road", "destination2");

		assertFalse(r1.equals(r2));
		assertFalse(r2.equals(r1));
	}

	/*
	 * Roads with different sources should not be considered equal
	 */
	@Test
	public void testNotEqualsSource()
	{
		Road r1 = new Road("source", "road", "destination");
		Road r2 = new Road("source2", "road", "destination");

		assertFalse(r1.equals(r2));
		assertFalse(r2.equals(r1));
	}

	/*
	 * Roads with different names should not be considered equal
	 */
	@Test
	public void testNotEqualsName()
	{
		Road r1 = new Road("source", "road", "destination");
		Road r2 = new Road("source", "road2", "destination");

		assertFalse(r1.equals(r2));
		assertFalse(r2.equals(r1));
	}

	/*
	 * Roads should not be considered equal to null values
	 * and should not crash when being compared
	 */
	@Test
	public void testNotEqualsNull()
	{
		Road r1 = new Road("source", "road", "destination");

		assertFalse(r1.equals(null));
	}

	/*
	 * Check that the toString method outputs the correct value
	 */
	@Test
	public void testToString()
	{
		Road r = new Road("A", "Road", "B");

		assertEquals(r.toString(), "A to B via Road");
	}
}
