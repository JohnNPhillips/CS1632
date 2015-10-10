package phillips.deliverable2.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class City
{
	private List<String> _locs = new ArrayList<String>();
	private List<Road> _roads = new ArrayList<Road>();

	/*
	 * Add a destination to the city
	 */
	public void addLocation(String loc)
	{
		// Add location if it doesn't already exist
		if (!_locs.contains(loc))
		{
			_locs.add(loc);
		}
	}

	/*
	 * Add a road to the city, and adding the source and destination
	 * if they don't already exist.
	 */
	public void addRoad(Road r)
	{
		// Add source and destination if they don't already exist
		addLocation(r.getSource());
		addLocation(r.getDest());

		// Add road if it doesn't already exist
		if (!_roads.contains(r))
		{
			_roads.add(r);
		}
	}

	/*
	 * Return the number of locations in the city
	 */
	public int getNumLocations()
	{
		return _locs.size();
	}

	/*
	 * Return the number of roads in the city
	 */
	public int getNumRoads()
	{
		return _roads.size();
	}

	/*
	 * Get a random location in the city
	 */
	public String getRandomLocation(Random rng)
	{
		if (_locs.size() == 0)
		{
			return null;
		}

		int locIndex = rng.nextInt(_locs.size());

		return _locs.get(locIndex);
	}

	/*
	 * Return a list of roads that originate at the given source
	 */
	public List<Road> getOutgoingRoads(String src)
	{
		List<Road> outgoing = new ArrayList<Road>();

		for (Road r : _roads)
		{
			if (r.getSource() == src)
			{
				outgoing.add(r);
			}
		}

		return outgoing;
	}
}
