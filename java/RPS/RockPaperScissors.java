package RPS;

import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		player pl=new player();
		computer com=new computer();
		game gm=new game();
		boolean playAgain=true;
		while(playAgain) {
			try {
				System.out.print("Enter rock,paper,scissors: ");
				String input=sc.nextLine().toLowerCase();
				if(!input.equals("rock") && !input.equals("paper") && !input.equals("scissors")) {
					throw new IllegalArgumentException("Invalid input!");
				}
				pl.setChoice(input);
				com.generateChoice();
				System.out.println("computer chose: "+ com.getChoice());
				String result=gm.determineWinner(pl.getChoice(), com.getChoice());
				System.out.println(result);
				FileManager.saveResult("player: "+ pl.getChoice() + ",compter: "+com.getChoice()+ ",Result: "+ result);
				System.out.print("Play Again?(y/n): ");
				String answer=sc.nextLine().toLowerCase();
				if(!answer.equals("y")) {
					playAgain=false;
				}
			}
			catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());	
			}
		}
		gm.displayScore();
		sc.close();

	}

}
