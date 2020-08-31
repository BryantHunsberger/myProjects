package Lab_11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ImplementationTest {

	@Test
	public void test() 
	{
		Implementation test = new Implementation();
			
		// Test for possible format options
		int returnM = test.returnFind("buy tesla 20 30\nsell tesla 20 40");
		assertEquals(200,returnM);
			
	}

}
