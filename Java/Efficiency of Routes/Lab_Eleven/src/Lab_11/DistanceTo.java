package Lab_11;

/*	
C212 - Lab 11 - DistanceTo
Version: 13.0.2
@Author  Bryant Hunsberger | bjhunsbe
Last Edited: 4/22/2020 
*/

// This class expresses distance to another city
// This class also gives the target which the distance refers to
public class DistanceTo implements Comparable<DistanceTo> {
	
	private String target; 
	private int distance;
	
	public DistanceTo(int dist, String city) 
	{
		distance = dist;
		target = city; 
	}
	public String getTarget() 
	{ 
		return target; 
	}
	public int getDistance() 
	{ 
		return distance; 
	}
	public int compareTo(DistanceTo other) 
	{
		return distance - other.distance;
	}
}
