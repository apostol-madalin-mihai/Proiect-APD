import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class InputData {
	
	FileReader l_fr;
	
	InputData(String[] t_args){
		try {
			
			l_fr = new FileReader("t_args");
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
