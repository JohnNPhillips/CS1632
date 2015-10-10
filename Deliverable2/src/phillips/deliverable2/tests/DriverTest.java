package phillips.deliverable2.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import phillips.deliverable2.code.City;
import phillips.deliverable2.code.Driver;
import phillips.deliverable2.code.Road;

public class DriverTest
{
	@Mock
	City mockCity = Mockito.mock(City.class);
	Road mockRoad = Mockito.mock(Road.class);

	Random mockRng = Mockito.mock(Random.class);

	@Before
	public void setUp() throws Exception
	{
		// Init RNG
		MockitoAnnotations.initMocks(mockRng);

		// Init mock road 0
		MockitoAnnotations.initMocks(mockRoad);
		Mockito.when(mockRoad.getName()).thenReturn("MockRoad");
		Mockito.when(mockRoad.getSource()).thenReturn("Source");
		Mockito.when(mockRoad.getDest()).thenReturn("Dest");

		// Init city
		MockitoAnnotations.initMocks(mockCity);
		Mockito.when(mockCity.getRandomLocation(mockRng)).thenReturn("Source");
		List<Road> outgoingRoads = new ArrayList<Road>();
		outgoingRoads.add(mockRoad);
		Mockito.when(mockCity.getOutgoingRoads(mockRoad.getSource())).thenReturn(outgoingRoads);
	}

	/*
	 * Check that the driver's starting location is the one passed in with the
	 * constructor
	 */
	@Test
	public void testGetLocation()
	{
		Driver d = new Driver(mockCity, mockRoad.getSource());
		assertEquals(d.getLocation(), mockRoad.getSource());
	}

	/*
	 * Check that if driving from a location with no outgoing roads,
	 * the driver's location won't change
	 */
	@Test
	public void testDriveRandomNoRoads()
	{
		Driver d = new Driver(mockCity, mockRoad.getDest());
		Road roadTaken = d.driveRandom(mockRng);

		assertNull(roadTaken);
	}

	/*
	 * Check that if the driver will drive to a new location
	 * if possible
	 */
	@Test
	public void testDriveRandom()
	{
		Driver d = new Driver(mockCity, mockRoad.getSource());
		Road roadTaken = d.driveRandom(mockRng);

		assertEquals(roadTaken, mockRoad);
	}
}
