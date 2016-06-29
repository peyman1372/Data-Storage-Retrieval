package datastorage;

import java.io.BufferedReader;
import java.io.DataInputStream;
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

import javax.xml.crypto.Data;

public class hash_buffereader {
	 HashMap<String, Integer> hashdic = new HashMap<>();

public hash_buffereader() {
	// TODO Auto-generated constructor stub
	int buffersize = 1024 * 256;
	byte[] buffer = new byte[buffersize];
	String string = null;
	ArrayList<String> words_list;
	ArrayList<Long> fs_list;

    //InputStream is = null;
    BufferedReader dis = null;

	try {
		FileReader is =new FileReader("phase.txt");

		// is = new FileInputStream("Phase.txt");
		dis = new BufferedReader(is);
      //   dis = new BufferedReader(is);

		//FileChannel ch1 = fis.getChannel();
		//MappedByteBuffer mb1 = ch1.map(FileChannel.MapMode.READ_ONLY, 0L, ch1.size());
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
		//int totalbyte =dis.available();
		String line = dis.readLine();

		while (line != null) {
			int nGet = Math.min(line.getBytes().length, buffersize);
		//System.out.println(nGet);
		//	dis.readFully(buffer, 0,nGet);
WordBuffer = line.getBytes();
			// b=true;
			i = 0;
			j = nGet;

			for (int k = i; k < j; k++) {
				System.out.println("test");

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
					
				}
			}
		//	totalbyte-=nGet;
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
