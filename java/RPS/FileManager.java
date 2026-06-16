package RPS;

import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
	public static void saveResult(String result) {
		try {
			FileWriter writer=new FileWriter("result.txt",true);
			writer.write(result+"\n");
			writer.close();
		}
		catch(IOException e) {
			System.out.println("Error saving results.");
		}
	}

}
