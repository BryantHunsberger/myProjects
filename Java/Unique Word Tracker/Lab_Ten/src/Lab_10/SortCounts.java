package Lab_10;

import java.util.Comparator;

/*	
C212 - Lab 10 - SortCounts
Version: 13.0.2
@Author  Bryant Hunsberger | bjhunsbe
Last Edited: 4/15/2020 
*/

// This class is essential in allowing the organization of words found in text by their relative counts
// The words with higher counts are at the top, those with the lowest are at the bottom
// This class returns a postive or negative number used to compare the 2 StringData objects by count
public class SortCounts implements Comparator<StringData> {

	@Override
	public int compare(StringData o1, StringData o2) {
		// TODO Auto-generated method stub
		return (o2.getCount() - o1.getCount());
	}

}
