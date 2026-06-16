package RPS;

import java.util.Random;

public class computer extends player {
	private static final String[] CHOICES= {"rock","paper","scissors"};
	public void generateChoice() {
		Random random=new Random();
		setChoice(CHOICES[random.nextInt(CHOICES.length)]);
	}

}
