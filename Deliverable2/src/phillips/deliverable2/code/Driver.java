package phillips.deliverable2.code;

import java.util.List;
import java.util.Random;

public class Driver
{
	private City _city;
	private String _loc;

	public Driver(City c, String loc)
	{
		this._city = c;
		this._loc = loc;
	}

	public Road driveRandom(Random rng)
	{
		// Get list of possible roads
		List<Road> candidateRoads = _city.getOutgoingRoads(_loc);
		if (candidateRoads.size() == 0)
		{
			return null;
		}

		// "Drive" down a random road
		int roadIndex = rng.nextInt(candidateRoads.size());
		Road takenRoad = candidateRoads.get(roadIndex);

		_loc = takenRoad.getDest();

		return takenRoad;
	}

	public String getLocation()
	{
		return _loc;
	}
}
