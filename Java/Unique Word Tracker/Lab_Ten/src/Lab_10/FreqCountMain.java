package Lab_10;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

/*	
C212 - Lab 10 - FreqCountMain
Version: 13.0.2
@Author  Bryant Hunsberger | bjhunsbe
Last Edited: 4/15/2020 
*/

// This class is responsible for passing a txt file to the FrequencyCounter class for analysis
// This class passes information from the FrequencyCounter class to a blank statistics.txt. This
// class also organizes our statistics in such a way that it is readable and neat. Lastly, this
// class creates an ArrayList, which has the type StringData which holds frequency, string length, and 
// the string. It then organizes the words found in a text so they are organized by counts
public class FreqCountMain {

	public static void main(String[] args) throws FileNotFoundException 
	{
		FrequencyCounter readTale = new FrequencyCounter("C:\\Users\\bryant\\Desktop\\Java\\Lab_Ten\\src\\Lab_10\\tale.txt");
		FrequencyCounter readTinyTale = new FrequencyCounter("C:\\Users\\bryant\\Desktop\\Java\\Lab_Ten\\src\\Lab_10\\tinyTale.txt");
		readTinyTale.populateFiles();
		readTale.populateFiles();
		
		PrintWriter writeIntoStat = new PrintWriter("C:\\Users\\bryant\\Desktop\\Java\\Lab_Ten\\src\\Lab_10\\statistics.txt");
		
		writeIntoStat.println("tinyTale.txt has " + readTinyTale.getNumberWords() + " number of words!");
		writeIntoStat.println("tinyTale.txt has " + readTinyTale.getNumberLines() + " number of lines!");
		writeIntoStat.println("tinyTale.txt has " + readTinyTale.getMyUniqueWords() + " distinct words!");
		writeIntoStat.println("\n");
	
		ArrayList<StringData> stringPreInfo = new ArrayList<>(); 
		ArrayList<StringData> stringPreInfo2 = new ArrayList<>(); 
		Set<String> mykeys = readTale.getWordOccurences().keySet();
		Set<String> mykeys2 = readTinyTale.getWordOccurences().keySet();
		
		
		for (String key : mykeys)
		{
			Integer freq = (Integer) readTale.getWordOccurences().get(key);
			//System.out.println(key + "->" + freq);
			StringData newList = new StringData(key, freq);
			stringPreInfo.add(newList);
		}
		for (String key : mykeys2)
		{
			Integer freq = (Integer) readTinyTale.getWordOccurences().get(key);
			//System.out.println(key + "->" + freq);
			StringData newList = new StringData(key, freq);
			stringPreInfo2.add(newList);
		}
		
		Collections.sort(stringPreInfo, new SortCounts());
		Collections.sort(stringPreInfo2, new SortCounts());

		for (StringData nextWord : stringPreInfo2)
		{
			writeIntoStat.println(nextWord.getMyString() + " {Word Length: " + nextWord.getStringLength() + "}: " + nextWord.getCount());
		}
		
		writeIntoStat.println("\n------------------------------------------------------------------------------\n");
		
		writeIntoStat.println("tale.txt has " + readTale.getNumberWords() + " number of words!");
		writeIntoStat.println("tale.txt has " + readTale.getNumberLines() + " number of lines!");
		writeIntoStat.println("tale.txt has " + readTale.getMyUniqueWords() + " distinct words!");
		
		writeIntoStat.println("\n");
		
		for (StringData nextWord : stringPreInfo)
		{
			writeIntoStat.println(nextWord.getMyString() + " {Word Length: " + nextWord.getStringLength() + "}: " + nextWord.getCount());
		}
		
		writeIntoStat.close();
	}

}
