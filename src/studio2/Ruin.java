package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		// All Variables 
		System.out.print("Start amount: ");
		int startAmount = in.nextInt();
		System.out.print("Win Chance: ");
		double winChance = in.nextDouble();
		System.out.print("Win Limit: ");
		int winLimit = in.nextInt();
		
		
		System.out.print("Total Simulations: ");
		int totalSimulations = in.nextInt();
		int ruinCount = 0;
		for (int i = 1; i<= totalSimulations; i++) 
		{
			int playCount = 0;
			int stat=startAmount;
			while (stat < winLimit && stat > 0 ) 
			{
				double play = Math.random(); 
				if (play <= winChance) 
				{ 
					stat +=1;
					//System.out.println("Win");
				
				}
				else 
				{
					stat -= 1;
					//System.out.println("Loss");
				
				}
				playCount += 1;
			}
				
			if (stat == winLimit) 
				{
					System.out.println("Simulation "+i +": "+playCount+ " WIN");
				}
				else if (stat == 0) 
				{
					ruinCount ++;
					System.out.println("Simulation "+i +": "+playCount+ " LOSE");
				}
			
		}
		double ruinRate = (double) ruinCount/ totalSimulations;
		double alpha = (1-winChance )/winChance;
		double expectedRuin = (Math.pow(alpha, startAmount)-Math.pow(alpha, winLimit))/(1-Math.pow(alpha, winLimit));
		System.out.println("Ruin Rate from Simulation: " + ruinRate + " Expected Ruin Rate: " + expectedRuin);
	}

}

