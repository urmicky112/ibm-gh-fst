package RPS;

public class game {
	private int playerScore;
	private int computerScore;
	public String determineWinner(String playerChoice,String computerChoice) {
		if(playerChoice.equals(computerChoice)) {
			return "Draw";
		}
		if((playerChoice.equals("rock") && computerChoice.equals("scissors")) || 
				(playerChoice.equals("paper") && computerChoice.equals("rock")) ||
				(playerChoice.equals("scissors") && computerChoice.equals("paper"))) {
			playerScore++;
			return "player Wins";
		}
		computerScore++;
		return "computer Wins";
		
	}
	public void displayScore() {
		System.out.println("\n Final Scores");
		System.out.println("player: "+playerScore);
		System.out.println("computer: "+ computerScore);
	}
}
