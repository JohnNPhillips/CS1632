package phillips.deliverable2.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import phillips.deliverable2.code.City;
import phillips.deliverable2.code.Road;

public class CityTest
{
	@Mock
	Road mockRoad0 = Mockito.mock(Road.class);

	Random mockRng0 = Mockito.mock(Random.class);
	Random mockRng1 = Mockito.mock(Random.class);

	@Before
	public void setUp() throws Exception
	{
		// Init mock road 0
		MockitoAnnotations.initMocks(mockRoad0);
		Mockito.when(mockRoad0.getName()).thenReturn("MockRoad0");
		Mockito.when(mockRoad0.getSource()).thenReturn("Source0");
		Mockito.when(mockRoad0.getDest()).thenReturn("Dest0");

		// Init RNG 0 (always returns 0 if nextInt(2) is called)
		MockitoAnnotations.initMocks(mockRng0);
		Mockito.when(mockRng0.nextInt()).thenReturn(0);

		// Init RNG 1 (always returns 1 if nextInt(2) is called)
		MockitoAnnotations.initMocks(mockRng1);
		Mockito.when(mockRng1.nextInt(2)).thenReturn(1);
	}

	/*
	 * Ensure city doesn't start with any locations
	 */
	@Test
	public void cityTestNoLocations()
	{
		City c = new City();
		assertEquals(c.getNumLocations(), 0);
	}
	
	/* 
	 * Ensure city doesn't start with any roads
	 */
	@Test
	public void cityTestNoRoads()
	{
		City c = new City();
		assertEquals(c.getNumRoads(), 0);
	}

	/*
	 * Check that new locations can be added to a city
	 */
	@Test
	public void addLocationTest()
	{
		City c = new City();

		c.addLocation("LocationA");
		assertEquals(c.getNumLocations(), 1);
	}
	
	/*
	 * Check that new locations can't be added twice
	 * Create a city and add the same location twice, verify it only contains one location
	 */
	@Test
	public void addLocationDuplicateTest()
	{
		City c = new City();

		c.addLocation("LocationA");
		c.addLocation("LocationA");
		assertEquals(c.getNumLocations(), 1);
	}

	/*
	 * Check that new roads can be added to a city
	 */
	@Test
	public void addRoadTest()
	{
		City c = new City();

		c.addRoad(mockRoad0);
		assertEquals(c.getNumRoads(), 1);
	}

	/*
	 * Check that you can't add the same road twice
	 * Create a city and try to add the same road twice. Ensure it only contains the road once
	 */
	@Test
	public void addRoadTestDuplicate()
	{
		City c = new City();

		c.addRoad(mockRoad0);
		c.addRoad(mockRoad0);
		assertEquals(c.getNumRoads(), 1);
	}
	
	/*
	 * Make sure getting a random location returns null when the city is empty
	 */
	@Test
	public void getRandomLocationEmptyTest()
	{
		City c = new City();

		assertNull(c.getRandomLocation(mockRng0));
	}

	/*
	 * Make sure getting a random location returns the correct places
	 * Add two locations to a city, pass in random number generators
	 * that return different values, and ensure the correct locations
	 * are returned.
	 */
	@Test
	public void getRandomLocationTest()
	{
		City c = new City();

		// Add locations
		c.addLocation("LocationA");
		c.addLocation("LocationB");

		assertEquals(c.getRandomLocation(mockRng0), "LocationA");
		assertEquals(c.getRandomLocation(mockRng1), "LocationB");
	}

	/*
	 * Getting outgoing roads from non-existent location
	 * Pass a non-existant location into getOutgoingRoads, make sure the returned
	 * list doesn't contain any elements
	 */
	@Test
	public void getOutgoingRoadsEmptyTest()
	{
		City c = new City();

		List<Road> outgoingRoads = c.getOutgoingRoads("NonExistantLocation");
		assertEquals(outgoingRoads.size(), 0);
	}

	/*
	 * Check that get outgoing roads will return the road associated with the source
	 * Add a road to a city, get the outgoing roads from the source, and make sure
	 * it returns the road.
	 */
	@Test
	public void getOutgoingRoadsTest()
	{
		City c = new City();

		c.addRoad(mockRoad0);
		List<Road> outgoingRoads = c.getOutgoingRoads(mockRoad0.getSource());

		assertEquals(outgoingRoads.size(), 1);
		assertEquals(outgoingRoads.get(0), mockRoad0);
	}
}
