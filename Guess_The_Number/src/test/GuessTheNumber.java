package test;

import java.util.*;
public class GuessTheNumber {

	public static void main(String args[]) { 
		
		int count = 0;
		
		Scanner s = new Scanner(System.in);
		
		try (s;) {
			Random r = new Random();
			
			int random = r.nextInt(10);
			
			
				
				while(true) {
					if(count<5) {
						
						System.out.println("Guess The Number: ");
						int number = s.nextInt();
						
						count++ ;
						
						if(count<5) {
							if(random > number) {
								System.out.println("too low, guess higher values...");
							}
							else if(random < number) {
								System.out.println("too high, guess lower values...");
							}
							else{
								System.out.println("You guessed Correct...");
								System.out.println("You have guessed the correct number in " +count+ " attempts");
								break;
							}
						}
					}
					else {
							System.out.println("Attempts Expired...");
							System.out.println("GAME OVER!");
							break;
					
						}
					}
				}
			}
			
		}
