package Activity_1;

public class act1main {

	public static void main(String[] args) {
		car toyota = new car();
        toyota.make = 2014;
        toyota.color = "Black";
        toyota.transmission = "Manual";
    
        //Using Car class method
        toyota.displayCharacterstics();
        toyota.accelerate();
        toyota.brake();

	}

}
