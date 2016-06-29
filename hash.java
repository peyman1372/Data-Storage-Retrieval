package datastorage;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;


public class hash {
	 HashMap<String, Integer> hashdic = new HashMap<>();

public hash() {
	// TODO Auto-generated constructor stub
	int buffersize = 1024 * 256;
	byte[] buffer = new byte[buffersize];
	String string = null;
	ArrayList<String> words_list;
	ArrayList<Long> fs_list;


	FileInputStream fis;
	try {
		fis = new FileInputStream("Phase.txt");
		FileChannel ch1 = fis.getChannel();
		MappedByteBuffer mb1 = ch1.map(FileChannel.MapMode.READ_ONLY, 0L, ch1.size());
		byte[] WordBuffer = new byte[200];
		int i;
		int j;
		boolean b = false;
		int tmp = 0;
		Trie trie;
		
		
		
		int Number_Of_Max_Nodes_In_Trie = -1;
		int max_index;
		int max_number;
		int count=0;
		while (mb1.hasRemaining()) {

			int nGet = Math.min(mb1.remaining(), buffersize);
			mb1.get(buffer, 0, nGet);

			// b=true;
			i = 0;
			j = nGet;

			for (int k = i; k < j; k++) {
				if ((((buffer[k] & 0xFF) > 0x7e) || ((buffer[k] & 0xFF) == 0x3c) || ((buffer[k] & 0xFF) == 0x3e))) {
					WordBuffer[tmp++] = buffer[k];
				} 
				else {
					string = new String(WordBuffer, 0, tmp, "utf-8");
					if(tmp>0){
					if(hashdic.containsKey(string)){
						hashdic.put(string, hashdic.get(string) + 1);
					}
					else{
						hashdic.put(string, 1);
					}
					}
					tmp=0;
					
					//System.out.println(string);
				}
			}
		}
	}
	
	
	catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
void Search_Total_Frequency(String key){
	if(hashdic.containsKey(key)){
		System.out.println(hashdic.get(key));
	}
	else{
		System.out.println("none");
	}
}

}
