package datastorage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaders {
	
	int bufferSize = 1 ;
	BufferedReader bufferedReader ;
	
	public void Breader(String fileName) throws IOException{
		bufferedReader = new BufferedReader(new FileReader(fileName), bufferSize);
		String readLine ;
		while ((readLine = bufferedReader.readLine())!=null){
			
		}
	}
	
	
}