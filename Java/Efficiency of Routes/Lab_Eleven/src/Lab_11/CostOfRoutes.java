package Lab_11;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/*	
C212 - Lab 11 - CostOfRoutes
Version: 13.0.2
@Author  Bryant Hunsberger | bjhunsbe
Last Edited: 4/22/2020 
*/

// This class works to find which routes are the most efficient to each of the cities on the map
// This class will then find the minimum distance and output it for each of the cities
// The user can use this portion of the class to find the most efficient route between any city
// The user needs knowledge of the cities, which cities are connected, and the distances between the cities
public class CostOfRoutes {

	public static void main(String[] args) {
		
		PriorityQueue<DistanceTo> myCities = new PriorityQueue<>();
		Map<String,Integer> shortestKnownDistance = new HashMap<>();
		Scanner nextIn = new Scanner(System.in);
		System.out.println("What is your starting city?: ");
		String startingCity = nextIn.nextLine(); // Starting point
		
		DistanceTo origin;
		origin = new DistanceTo(0, startingCity); 
		myCities.add(origin); // Start added to priority queue
		
		while (!(myCities.isEmpty())) // Priority Queue has items still
		{
			String smallestRoute = myCities.peek().getTarget(); // Smallest Element
			int distance = myCities.peek().getDistance();
			myCities.remove();
			
			if (!(shortestKnownDistance.containsKey(smallestRoute))) // If it's not in the map
			{
				
			
		
				shortestKnownDistance.put(smallestRoute, distance);
				
				
				System.out.print("How many cities have a direct connection from " + smallestRoute + "?: ");
				int numCities = nextIn.nextInt();
				nextIn.nextLine();
				
				if (numCities == 0)
				{
					//Nothing
				}
				else
				{
					for(int i = 0; i < numCities; i++)
					{
						System.out.print("\n");
						System.out.print("Add nextCity: ");
						String nextCity = nextIn.nextLine();
						System.out.print("\n");
						System.out.print("What is the distance from " + smallestRoute + " to " + nextCity + "?: ");
						int nextDist = nextIn.nextInt();
						nextIn.nextLine();
						System.out.print("\n");
						origin = new DistanceTo((nextDist + distance), nextCity);
				
						myCities.add(origin);
						
					}
				}
				
				
			}
			
			
		}
		
		
		
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("\nThe shortest distance to all cities from " + startingCity + " is: \n");
		
		for(String key : shortestKnownDistance.keySet())
		{
			Integer keyDistance = shortestKnownDistance.get(key);
			
			System.out.println(key + " : " + keyDistance);
		}
		
		nextIn.close();
	}
	
	// This function is primarily used for the JUnit testing, it takes in a user string for the city they wish to inquire
	// about to find the most efficient route
	// @param myPt, the user string representative of a city
	// @return, returns an integer value of the most efficient distance
	public int costOfRoutesTesting(String myPt)
	{
		PriorityQueue<DistanceTo> myCities2 = new PriorityQueue<>();
		Map<String,Integer> shortestKnownDistance2 = new HashMap<>();
		DistanceTo pracOrigin = new DistanceTo(0, "Pendleton");
		
		myCities2.add(pracOrigin);
		
		while (!(myCities2.isEmpty())) // Priority Queue has items still
		{
			String smallestRoute = myCities2.peek().getTarget(); // Smallest Element
			int distance = myCities2.peek().getDistance();
			myCities2.remove();
			
			if (!(shortestKnownDistance2.containsKey(smallestRoute))) // If it's not in the map
			{
				
			
		
				shortestKnownDistance2.put(smallestRoute, distance);
				int numCities = 0;
				
				if (smallestRoute == "Pendleton")
				{
					numCities = 3;
				}
				else if (smallestRoute == "Pierre")
				{
					numCities = 1;
				}
				else if (smallestRoute == "Pueblo")
				{
					numCities = 1;
				}
				else if (smallestRoute == "Phoenix")
				{
					numCities = 4;
				}
				else if (smallestRoute == "Peoria")
				{
					numCities = 1;
				}
				else if (smallestRoute == "Pittsburg")
				{
					numCities = 2;
				}
				else if (smallestRoute == "Pensacola")
				{
					numCities = 2;
				}
				else if (smallestRoute == "Princeton")
				{
					numCities = 0;
				}
				
				if (numCities == 0)
				{
					//Nothing
				}
				else
				{
					int j = 0;
					String nextCity = "";
					for(int i = 0; i < numCities; i++)
					{
						System.out.print("\n");
						if (smallestRoute == "Pendleton")
						{
							if (j == 0)
							{
								nextCity = "Pierre";
								j++;
							}
							else if (j == 1)
							{
								nextCity = "Pueblo";
								j++;
							}
							else
							{
								nextCity = "Phoenix";
								j++;
							}
						}
						else if (smallestRoute == "Pierre")
						{
							nextCity = "Pueblo";
						}
						else if (smallestRoute == "Pueblo")
						{
							nextCity = "Peoria";
						}
						else if (smallestRoute == "Phoenix")
						{
							if (j == 0)
							{
								nextCity = "Pueblo";
								j++;
							}
							else if (j == 1)
							{
								nextCity = "Peoria";
								j++;
							}
							else if (j == 2)
							{
								nextCity = "Pittsburg";
								j++;
							}
							else
							{
								nextCity = "Pensacola";
								j++;
							}
						}
						else if (smallestRoute == "Peoria")
						{
							nextCity = "Pittsburg";
						}
						else if (smallestRoute == "Pittsburg")
						{
							if (j == 0)
							{
								nextCity = "Princeton";
								j++;
							}
							else
							{
								nextCity = "Pensacola";
								j++;
							}
						}
						else if (smallestRoute == "Pensacola")
						{
							if (j == 0)
							{
								nextCity = "Pittsburg";
								j++;
							}
							else
							{
								nextCity = "Princeton";
								j++;
							}
						}
					
						int nextDist = 0;
						
						
						if ((smallestRoute == "Pensacola") && (nextCity == "Pittsburg"))
						{
							nextDist = 4;
						}
						if ((smallestRoute == "Pensacola") && (nextCity == "Princeton"))
						{
							nextDist = 5;
						}
						if ((smallestRoute == "Pittsburg") && (nextCity == "Princeton"))
						{
							nextDist = 2;
						}
						if ((smallestRoute == "Pittsburg") && (nextCity == "Pensacola"))
						{
							nextDist = 4;
						}
						if ((smallestRoute == "Peoria") && (nextCity == "Pittsburg"))
						{
							nextDist = 5;
						}
						if ((smallestRoute == "Phoenix") && (nextCity == "Pueblo"))
						{
							nextDist = 3;
						}
						if ((smallestRoute == "Phoenix") && (nextCity == "Peoria"))
						{
							nextDist = 4;
						}
						if ((smallestRoute == "Phoenix") && (nextCity == "Pittsburg"))
						{
							nextDist = 10;
						}
						if ((smallestRoute == "Phoenix") && (nextCity == "Pensacola"))
						{
							nextDist = 5;
						}
						if ((smallestRoute == "Pueblo") && (nextCity == "Peoria"))
						{
							nextDist = 3;
						}
						if ((smallestRoute == "Pierre") && (nextCity == "Pueblo"))
						{
							nextDist = 3;
						}
						if ((smallestRoute == "Pendleton") && (nextCity == "Pierre"))
						{
							nextDist = 2;
						}
						if ((smallestRoute == "Pendleton") && (nextCity == "Pueblo"))
						{
							nextDist = 8;
						}
						if ((smallestRoute == "Pendleton") && (nextCity == "Phoenix"))
						{
							nextDist = 4;
						}
						
						
		
						pracOrigin = new DistanceTo((nextDist + distance), nextCity);
				
						myCities2.add(pracOrigin);
						
					}
				}
				
				
			}
			
			
		}
		
		
		return shortestKnownDistance2.get(myPt);
	}

}
