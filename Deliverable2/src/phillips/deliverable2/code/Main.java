package phillips.deliverable2.code;

import java.util.Random;

public class Main
{
	public static City getCity()
	{
		City c = new City();

		c.addLocation("Outside City");
		c.addLocation("Mall");
		c.addLocation("Bookstore");
		c.addLocation("Coffee Shop");
		c.addLocation("University");

		// Fourth Ave
		c.addRoad(new Road("Outside City", "Fourth Ave", "Mall"));
		c.addRoad(new Road("Mall", "Fourth Ave", "Bookstore"));
		c.addRoad(new Road("Bookstore", "Fourth Ave", "Outside City"));

		// Fifth Ave
		c.addRoad(new Road("Outside City", "Fifth Ave", "University"));
		c.addRoad(new Road("University", "Fifth Ave", "Coffee Shop"));
		c.addRoad(new Road("Coffee Shop", "Fifth Ave", "Outside City"));

		// Meow St.
		c.addRoad(new Road("Mall", "Meow St", "Coffee Shop"));
		c.addRoad(new Road("Coffee Shop", "Meow St", "Mall"));

		// Chirp St.
		c.addRoad(new Road("Bookstore", "Chirp St", "University"));
		c.addRoad(new Road("University", "Chirp St", "Bookstore"));

		return c;
	}

	public static void main(String[] args)
	{
		// Ensure correct arguments were provided
		if (args.length != 1)
		{
			System.out.println("Error: Please specify a single integer seed value as an argument");
			return;
		}

		// Parse seed from command line
		int seed;
		try
		{
			seed = Integer.parseInt(args[0]);
		}
		catch (NumberFormatException nfe)
		{
			System.out.println("Error: Specified argument is not a valid integer");
			return;
		}

		Random rng = new Random(seed);

		City city = getCity();

		for (int i = 0; i < 5; i++)
		{
			// Initialize driver
			String startLoc = city.getRandomLocation(rng);
			Driver driver = new Driver(city, startLoc);

			// Keep driving until out of city
			do
			{
				Road road = driver.driveRandom(rng);
				System.out.printf("Driver %d heading from %s.\n", i, road);
			}
			while (!driver.getLocation().equals("Outside City"));

			System.out.printf("Driver %d has left the city!\n", i);
			System.out.println("-----");
		}
	}
}
