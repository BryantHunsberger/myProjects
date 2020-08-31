package Lab_11;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/*	
C212 - Lab 11 - Implementation
Version: 13.0.2
@Author  Bryant Hunsberger | bjhunsbe
Last Edited: 4/22/2020 
*/

// This class is responsible for the process of buying and selling stocks. The user can buy stocks with
// a certain quantity and price. Each type of stock has it's on queue to which it stores its data.
// When a user sells stock, the profits are then printed to the user!
public class Implementation {

	public static void main(String[] args) {
		
		Scanner nextRes = new Scanner(System.in);
		
		Queue<Block> myQueues;
		Block newStock;
		Queue<Block> myStocks = new LinkedList<>();
		Map<String, Queue<Block>> myStuff = new HashMap<>();
		
		System.out.println("Hello user, below you will find a menu for dealing with your stocks!\n");
		System.out.println("If you wish to Buy stock - Enter: buy symbol quantity price\nIf you "
				+ "wish to Sell stock - Enter: sell symbol quantity price\n"
				+ "If you wish to Quit - Enter quit 0 0 0\n");
		
		String operation = "";
		String symbol = "";
		int quantity = 0;
		double price = 0;
		
		operation = nextRes.next();
		symbol = nextRes.next();
		quantity = nextRes.nextInt();
		price = nextRes.nextDouble();
		
		
		while (!(operation.equals("quit")) && !(operation.equals("Quit"))) 
		{
			if ((operation.equals("buy")) || (operation.equals("Buy")))
			{
				
				newStock = new Block(quantity, price);
				
				if (!(myStuff.containsKey(symbol)))
				{
					
					myQueues = new LinkedList<>();
					myQueues.add(newStock);
					myStuff.put(symbol, myQueues);
				}
				else
				{
					myStuff.get(symbol).add(newStock);
				}
			
			}
			else if ((operation.equals("sell")) || (operation.equals("Sell")))
			{
				int num = quantity;
				boolean cap = true;
				int sold = (int)price;
				int bought = 0;
				int profit = 0;
				while (num > 0)
				{
					if (!(myStuff.get(symbol).isEmpty()))
					{
						num -= myStuff.get(symbol).peek().getQuantity();
						bought = (int) myStuff.get(symbol).peek().getPrice();
						profit += ((myStuff.get(symbol).peek().getQuantity()) * (sold - bought));
						myStuff.get(symbol).remove();
						
					}
					else
					{
						System.out.println("You cant sell this many shares!");
						num = 0;
						cap = false;
					}
				}
				
				if (cap)
				{	
					System.out.println("Your profit is: " + profit);
				}
					
			
				
			}
			System.out.println("If you wish to Buy stock - Enter: buy symbol quantity price\nIf you "
					+ "wish to Sell stock - Enter: sell symbol quantity price\n"
					+ "If you wish to Quit - Enter quit\n");
			
			operation = nextRes.next();
			symbol = nextRes.next();
			quantity = nextRes.nextInt();
			price = nextRes.nextDouble();
			
		}
		
			
		
		
		
		System.out.println("Goodbye!");
	}

}
