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
import java.util.Iterator;


public class IR3_1{
   
        public  HashMap<String,Integer> FileNameIndexHm=new HashMap<>();
        public  HashMap<String,ArrayList<Integer>> hm=new HashMap<>();
        public  HashMap<String,Integer> thm=new HashMap<>();
        public  int  file_list;
        public  ArrayList<Integer> q;
        public  BufferedWriter[] out;
        public  BufferedWriter[] tout;

    public IR3_1() {
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
       
        
            out=new BufferedWriter[35];
            tout=new BufferedWriter[35];
        
           File file = new File("Words_Postings");
           file.mkdir();
            
           String temp;
           file_list=1;
           Iterator<String> it;
      
            file = new File("Words_Postings/"+"File_List_"+file_list);
           file.mkdir(); 
           
           //it =FileNameIndexHm.keySet().iterator();
           //while (it.hasNext())
           //{            
             // temp=it.next();
           for(int i=0;i<35;i++){
              file=new File("Words_Postings/"+"File_List_"+file_list+"/File_"+i+".txt");
              file.createNewFile();
              file=new File("Words_Postings/"+"File_List_"+file_list+"/TempFile_"+i+".txt");
              file.createNewFile();
           }
              
          // }
           
          
           
           BufferedReader br1;
           String temp1;
           String temp2;      
          
         
         for(int i=0;i<=4808;i++){
             
            br1 = new BufferedReader(new FileReader("Docs_Words/Doc_Word_"+i+".txt"));
            temp1=br1.readLine();
            temp2=br1.readLine();
    
            while(temp1!=null){
                if(hm.containsKey(temp1)){
                    hm.get(temp1).add(i);
                    thm.put(temp1,thm.get(temp1)+1);
                }
                else{
                    q=new ArrayList<>();
                    q.add(i);
                    hm.put(temp1,q);
                    thm.put(temp1,1);
                    
                }
                
                temp1=br1.readLine();
                temp2=br1.readLine();
            }
           
           if(hm.size()>20000){
                    
                     flush_hm();
                   
            }
            br1.close();
         }
      
         flush_hm();
         Trim_Files();
    }

    
    public  void Trim_Files() throws FileNotFoundException, IOException{
        File Output1;
        Writer out1;
        BufferedReader br1;
        String temp1;
        String temp2;
        
     
        HashMap<String,Integer> hashmap=new HashMap<>();
        for(int i=0;i<35;i++){
           
            for(int j=1;j<=687;j++){
               br1 = new BufferedReader(new FileReader("Words_Postings/"+"File_List_"+j+"/TempFile_"+i+".txt"));
               temp1=br1.readLine();
               temp2=br1.readLine();
               while(temp1!=null){
                   
                   
                   if(hashmap.containsKey(temp1)){
                      
                           hashmap.put(temp1,hashmap.get(temp1)+Integer.valueOf(temp2));
                       
                   }
                   
                   else{
                     
                      hashmap.put(temp1,Integer.valueOf(temp2));
                   }
                   
                   temp1=br1.readLine();
                   temp2=br1.readLine();
               }
               
               br1.close();
              if(j%150==0){
                  System.gc();
              }
            } 
              
               
               Output1=new File("Words_Postings/File_"+i+".txt");
               out1= new BufferedWriter(new OutputStreamWriter(
         	        new FileOutputStream(Output1), "UTF8"));
           
                                  Iterator<String> it = hashmap.keySet().iterator();
                                  while (it.hasNext())
                                  {
                                    temp1=it.next();
          
                                    out1.write(temp1+"\r\n"+hashmap.get(temp1)+"\r\n");
                                    out1.flush();
                                    
                                    
                                  }
            out1.close();
            hashmap.clear();
            System.gc();   
            
        }      
            
     }

    private void flush_hm() throws IOException{
        
        Iterator<String> it=hm.keySet().iterator();
        String temp;
        String temp1;
        int s;
        
        for(int i=0;i<35;i++){
            out[i] = new BufferedWriter(new OutputStreamWriter(
 			 new FileOutputStream(new File("Words_Postings/"+"File_List_"+file_list+"/File_"+i+".txt")), "UTF8"));
          
        }
        for(int i=0;i<35;i++){
          tout[i]=new BufferedWriter(new OutputStreamWriter(
 			 new FileOutputStream(new File("Words_Postings/"+"File_List_"+file_list+"/TempFile_"+i+".txt")), "UTF8")); 
        }
        
        ArrayList<Integer> t;
        while(it.hasNext()){
            temp=it.next();
            temp1=temp;
            t=hm.get(temp);
            s=FileNameIndexHm.get(temp.substring(0,1));
                                 
                                        for(int i=0;i<t.size();i++){
                                            temp=temp+"-"+t.get(i);
                                        }
                                        temp=temp+"-\r\n";
                                        out[s].write(temp);
                                        out[s].flush();
                                        tout[s].write(temp1+"\r\n"+thm.get(temp1)+"\r\n");
                                        tout[s].flush();
                                        t.clear();
                                
        }
        
        file_list++;
        File file = new File("Words_Postings/"+"File_List_"+file_list);
        file.mkdir(); 
        for(int i=0;i<35;i++){
              file=new File("Words_Postings/"+"File_List_"+file_list+"/File_"+i+".txt");
              file.createNewFile();
              file=new File("Words_Postings/"+"File_List_"+file_list+"/TempFile_"+i+".txt");
              file.createNewFile();
         }
        
        for(int i=0;i<35;i++){
            out[i].close();
            tout[i].close();
        }
        
        thm.clear();
        hm.clear();
        System.gc();
        
    }
    
    public int Get_Doc_Frequency(String word) throws FileNotFoundException, IOException{
        
         BufferedReader br1;
         int result=0;
         String temp1;
         String temp2;
         
        
            br1 = new BufferedReader(new FileReader("Words_Postings/File_"+FileNameIndexHm.get(word.substring(0,1))+".txt"));
            temp1=br1.readLine();
            temp2=br1.readLine();
            while(temp1!=null){
             
              if(temp1.compareTo(word)==0){
                  return Integer.valueOf(temp2);
              }
              temp1=br1.readLine();
              temp2=br1.readLine();
              
            }
            br1.close();   
            
        return result;  
        
    }
    
}

    
    
    
    
    
    
