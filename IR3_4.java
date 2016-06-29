package datastorage;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;


public class IR3_4{
   
        public  HashMap<String,Integer> FileNameIndexHm=new HashMap<>();
        public 	HashMap<Integer,HashMap<String, Integer>> hashArray = new HashMap<>() ;
        public  File OutputFile;

    public IR3_4() {
        FileNameIndexHm.put("ء",0); FileNameIndexHm.put("آ",1);
        FileNameIndexHm.put("ئ",2);
        FileNameIndexHm.put("ا",3); FileNameIndexHm.put("ب",4); 
        FileNameIndexHm.put("ت",5); FileNameIndexHm.put("ث",6);FileNameIndexHm.put("ج",7);
        FileNameIndexHm.put("ح",8);FileNameIndexHm.put("خ",9);FileNameIndexHm.put("د",10);
        FileNameIndexHm.put("ذ",11);FileNameIndexHm.put("ر",12);FileNameIndexHm.put("ز",13);
        FileNameIndexHm.put("س",14);FileNameIndexHm.put("ش",15);FileNameIndexHm.put("ص",16);
        FileNameIndexHm.put("ض",17);FileNameIndexHm.put("ط",18);FileNameIndexHm.put("ظ",19);
        FileNameIndexHm.put("ع",20);FileNameIndexHm.put("غ",21);FileNameIndexHm.put("ف",22);
        FileNameIndexHm.put("ق",23);FileNameIndexHm.put("ك",24);FileNameIndexHm.put("ل",25);
        FileNameIndexHm.put("م",26);FileNameIndexHm.put("ن",27);FileNameIndexHm.put("ه",28);
        FileNameIndexHm.put("و",29);FileNameIndexHm.put("ي",30);
        FileNameIndexHm.put("پ",31);FileNameIndexHm.put("چ",32);FileNameIndexHm.put("ژ",33);FileNameIndexHm.put("گ",34);
    }
        
        
    public  void Run() throws UnsupportedEncodingException, IOException {
        
           File file = new File("Words_Weight");
           file.mkdir();          
           BufferedReader br1;
           String temp1;
           String temp2;      
           Writer outDoc;
           
           // set words idf to hash
	       for (int i = 0; i < 35; i++) {
	    	   BufferedReader idfReader = new BufferedReader(new FileReader("Words_Postings/File_"+i+".txt"));
	    	   String reader1 = idfReader.readLine();
	    	   String reader2 = idfReader.readLine();
	    	   HashMap<String, Integer> tmpHash = new HashMap<>();
	    	   while (reader1 != null) {
				tmpHash.put(reader1, Integer.parseInt(reader2));
				
				reader1 = idfReader.readLine();
				reader2 = idfReader.readLine();
	    	   }
	    	   hashArray.put(i, tmpHash);
	    	   
	       }
         for(int i=0;i<=4808;i++){    
            br1 = new BufferedReader(new FileReader("Docs_Words/Doc_Word_"+i+".txt"));
            temp1=br1.readLine();
            temp2=br1.readLine();
            OutputFile=new File("Words_Weight/Doc_Weight_"+i+".txt");
            OutputFile.createNewFile();
            outDoc=new BufferedWriter(new OutputStreamWriter(
                               new FileOutputStream(OutputFile), "UTF8"));
            BufferedReader  maxReader = new BufferedReader(new FileReader("Docs_Words/Doc_Word_Max_"+i+".txt"));
            Double maxWord =Double.parseDouble(maxReader.readLine()); 
            while(temp1!=null){
            	
                double wieght ;
                wieght = (Double.parseDouble(temp2)/maxWord)*((Double)(Math.log(4808/Get_Doc_Frequency(temp1))/Math.log(2)));
                outDoc.write(temp1+" "+wieght+"\r\n");
                outDoc.flush();
                temp1=br1.readLine();
                temp2=br1.readLine();
            }
            outDoc.close();
         }
    }

    public int Get_Doc_Frequency(String word) throws FileNotFoundException, IOException{        
         return hashArray.get(FileNameIndexHm.get(word.substring(0,1))).get(word);
    }
}



    
    
    
    
    
    
