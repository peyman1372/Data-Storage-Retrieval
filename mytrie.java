package datastorage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;


public class mytrie {

	public HashMap<String, Integer> FileNameIndexHm = new HashMap<>();
	

	public void hashmap() {
		FileNameIndexHm.put("??", 0);
		FileNameIndexHm.put("??", 1);
		FileNameIndexHm.put("??", 2);
		FileNameIndexHm.put("??", 3);
		FileNameIndexHm.put("??", 4);
		FileNameIndexHm.put("??", 5);
		FileNameIndexHm.put("??", 6);
		FileNameIndexHm.put("??", 7);
		FileNameIndexHm.put("??", 8);
		FileNameIndexHm.put("??", 9);
		FileNameIndexHm.put("??", 10);
		FileNameIndexHm.put("??", 11);
		FileNameIndexHm.put("??", 12);
		FileNameIndexHm.put("??", 13);
		FileNameIndexHm.put("??", 14);
		FileNameIndexHm.put("??", 15);
		FileNameIndexHm.put("??", 16);
		FileNameIndexHm.put("??", 17);
		FileNameIndexHm.put("??", 18);
		FileNameIndexHm.put("??", 19);
		FileNameIndexHm.put("??", 20);
		FileNameIndexHm.put("??", 21);
		FileNameIndexHm.put("??", 22);
		FileNameIndexHm.put("??", 23);
		FileNameIndexHm.put("??", 24);
		FileNameIndexHm.put("??", 25);
		FileNameIndexHm.put("??", 26);
		FileNameIndexHm.put("??", 27);
		FileNameIndexHm.put("??", 28);
		FileNameIndexHm.put("??", 29);
		FileNameIndexHm.put("??", 30);
		FileNameIndexHm.put("??", 31);
		FileNameIndexHm.put("??", 32);
		FileNameIndexHm.put("??", 33);
		FileNameIndexHm.put("??", 34);
	}
	static String[] DictionaryFileNames = new String[35];
	static int TempIndex = 0;
	public static void Merge(ArrayList<String> words, ArrayList<Long> fs) throws FileNotFoundException, IOException {
		//System.out.println("test");

                    File OutputFile = new File("Dictionary/" + DictionaryFileNames[TempIndex]);
                    FileOutputStream out;
                    out = new FileOutputStream(OutputFile, true);

                    int size = words.size();
                    int counter = 0;
                    while (counter < size) {
                            out.write((words.get(counter) + "\r\n" + fs.get(counter++) + "\r\n").getBytes());
                            out.flush();
                    }

		}
	public static void Trim_Files() throws FileNotFoundException, IOException{

			  BufferedReader br1;
			  String temp1;
			  String temp2;
			  HashMap<String,Long> hashmap=new HashMap<>();
			  for(int i=0;i<35;i++){

			    br1 = new BufferedReader(new FileReader("Dictionary/"+DictionaryFileNames[i]));
			    temp1=br1.readLine();
			    temp2=br1.readLine();
			    while(temp1!=null){

			      if(hashmap.containsKey(temp1)){
			        hashmap.put(temp1,hashmap.get(temp1)+Long.valueOf(temp2));
			      }
			      else{
			        hashmap.put(temp1,Long.valueOf(temp2));
			      }
			      temp1=br1.readLine();
			      temp2=br1.readLine();
			    }
			    br1.close();

			    FileChannel outChan = new FileOutputStream("Dictionary/"+DictionaryFileNames[i], true).getChannel();
			    outChan.truncate(0);

			    File Output=new File("Dictionary/"+DictionaryFileNames[i]);
			    Writer out = new BufferedWriter(new OutputStreamWriter(
			      new FileOutputStream(Output), "UTF8"));
			    String temp;
			    Iterator<String> it = hashmap.keySet().iterator();
			    while (it.hasNext())
			    {
			      temp=it.next();
			      out.write(temp+"\r\n"+hashmap.get(temp)+"\r\n");
			      out.flush();
			    }
			    outChan.close();
			    out.close();
			    hashmap.clear();
			    System.gc();


			  }
				System.out.println("hoooooooooooooooooooi");


			}
	public mytrie(String fileName) {
			// TODO Auto-generated constructor stub
		
		 String TempFileName;
		 String TempMergeFileName ;

		//int TempIndex;
		TempFileName="File_Temp.txt";
		TempMergeFileName="File_Temp_Merge.txt";
		FileNameIndexHm.put("??", 0);
		FileNameIndexHm.put("??", 1);
		FileNameIndexHm.put("??", 2);
		FileNameIndexHm.put("??", 3);
		FileNameIndexHm.put("??", 4);
		FileNameIndexHm.put("??", 5);
		FileNameIndexHm.put("??", 6);
		FileNameIndexHm.put("??", 7);
		FileNameIndexHm.put("??", 8);
		FileNameIndexHm.put("??", 9);
		FileNameIndexHm.put("??", 10);
		FileNameIndexHm.put("??", 11);
		FileNameIndexHm.put("??", 12);
		FileNameIndexHm.put("??", 13);
		FileNameIndexHm.put("??", 14);
		FileNameIndexHm.put("??", 15);
		FileNameIndexHm.put("??", 16);
		FileNameIndexHm.put("??", 17);
		FileNameIndexHm.put("??", 18);
		FileNameIndexHm.put("??", 19);
		FileNameIndexHm.put("??", 20);
		FileNameIndexHm.put("??", 21);
		FileNameIndexHm.put("??", 22);
		FileNameIndexHm.put("??", 23);
		FileNameIndexHm.put("??", 24);
		FileNameIndexHm.put("??", 25);
		FileNameIndexHm.put("??", 26);
		FileNameIndexHm.put("??", 27);
		FileNameIndexHm.put("??", 28);
		FileNameIndexHm.put("??", 29);
		FileNameIndexHm.put("??", 30);
		FileNameIndexHm.put("??", 31);
		FileNameIndexHm.put("??", 32);
		FileNameIndexHm.put("??", 33);
		FileNameIndexHm.put("??", 34);
		File file = new File("Dictionary");
                file.mkdirs(); 
                for(int i=0;i<35;i++){
                    DictionaryFileNames[i]="File_".concat(Integer.toString(i)).concat(".txt");
                    file =new File("Dictionary/"+DictionaryFileNames[i]);
                    try {
                        file.createNewFile();
                        file =new File("Dictionary/"+TempFileName);
                        file.createNewFile();
                        file =new File("Dictionary/"+TempMergeFileName);
                        file.createNewFile();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
		  

		int buffersize =1	;
			//	1024 * 256;
		byte[] buffer = new byte[buffersize];
		String string = null;
		ArrayList<String> words_list;
		ArrayList<Long> fs_list;

		FileInputStream fis;
		try {
                    fis = new FileInputStream(fileName);
                    FileChannel ch1 = fis.getChannel();
                    MappedByteBuffer mb1 = ch1.map(FileChannel.MapMode.READ_ONLY, 0L, ch1.size());
                    byte[] WordBuffer = new byte[200];
                    int i;
                    int j;
                    boolean b = false;
                    int tmp = 0;
                    Trie trie;



                    trie = new Trie(FileNameIndexHm);
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
					} else {
						string = new String(WordBuffer, 0, tmp, "utf-8");
						if (tmp > 0) {
							if (trie.getWord(string) != null) {
								//System.out.println(string);

								trie.updateWord(string, trie.getF(string) + 1);

							} else {
								if (Number_Of_Max_Nodes_In_Trie < 20000) {
									trie.addWord(string, 1);

									Number_Of_Max_Nodes_In_Trie++;

								} else {
									max_index = 0;
									max_number = 0;

									for (int v = 0; v < 35; v++) {
										if (trie.count[v] > max_number) {
											max_number = trie.count[v];
											max_index = v;

										}
									}
									if (max_number > 0) {

										words_list = (ArrayList<String>) trie.root.children[max_index].getWords();

										fs_list = (ArrayList<Long>) trie.root.children[max_index].getFs();
										trie.root.children[max_index] = null;
										trie.count[max_index] = 0;
										TempIndex = max_index;
										Number_Of_Max_Nodes_In_Trie -= max_number;

										Merge(words_list, fs_list);

										words_list.clear();

										fs_list.clear();

										// System.gc();

										trie.addWord(string, 1);

										Number_Of_Max_Nodes_In_Trie++;

									}
								}

							}
						}
						tmp = 0;

					}
				}
				
				if(count==15){
					  System.gc();
					  count=0;
					} 
			}

			string=new String(WordBuffer,0,tmp,"utf-8");


			if(tmp>0){
			 if((string.compareTo(" ")!=0)&&(string.compareTo("")!=0)&&(string.compareTo("<??????????>")!=0)){
			  if(trie.getWord(string)!=null){
			    trie.updateWord(string,trie.getF(string)+1);
			  }
			  else{

			    if(Number_Of_Max_Nodes_In_Trie<20000){

			      trie.addWord(string,1);

			      Number_Of_Max_Nodes_In_Trie++; 

			    }
			    else{

			      max_index=0;
			      max_number=0;

			      for(int v=0;v<35;v++){
			        if(trie.count[v]> max_number){
			          max_number=trie.count[v];
			          max_index=v;
			        }
			      }


			      if(max_number>0){
			        words_list=(ArrayList<String>)trie.root.children[max_index].getWords();

			        fs_list=(ArrayList<Long>)trie.root.children[max_index].getFs();
			        trie.root.children[max_index]=null;
			        trie.count[max_index]=0;
			        Number_Of_Max_Nodes_In_Trie-=max_number;
			        TempIndex=max_index;

			        Merge(words_list,fs_list);


			        words_list.clear();

			        fs_list.clear();
			       // System.gc();

			        trie.addWord(string,1);

			        Number_Of_Max_Nodes_In_Trie++; 
			      }




			    }
			  }
			}
			}
			for(int n=0;n<35;n++){
				  if(trie.root.children[n]!=null){   
				   words_list=(ArrayList<String>)trie.root.children[n].getWords();

				   fs_list=(ArrayList<Long>)trie.root.children[n].getFs();

				   TempIndex=n;
				   Merge(words_list,fs_list);
				   words_list.clear();

				   fs_list.clear();

				   System.gc();
				 }
				}
			Trim_Files();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}
	
	
}
