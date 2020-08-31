package Lab_11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class CostOfRoutesTest {

	@Test

	// This test works to see what the minimum route for each of the entered cities are
	// It inputs a string, and gives an integer output representative of the minimum
	public void test() 
	{
		CostOfRoutes test = new CostOfRoutes();
		
		// Test for possible format options
		int minPueblo = test.costOfRoutesTesting("Pueblo");
		assertEquals(5,minPueblo);
		
		int minPierre = test.costOfRoutesTesting("Pierre");
		assertEquals(2,minPierre);
		
		int minPhoenix = test.costOfRoutesTesting("Phoenix");
		assertEquals(4,minPhoenix);
		
		int minPeoria = test.costOfRoutesTesting("Peoria");
		assertEquals(8,minPeoria);
		
		int minPitts = test.costOfRoutesTesting("Pittsburg");
		assertEquals(13,minPitts);
		
		int minPensa = test.costOfRoutesTesting("Pensacola");
		assertEquals(9,minPensa);
		
		int minPrince = test.costOfRoutesTesting("Princeton");
		assertEquals(14,minPrince);
		
		
		
	}
}
