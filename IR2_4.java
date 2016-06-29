package datastorage;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Iterator;


public class IR2_4{
    
        public  int Num_Of_Docs=0; 
        public  File OutputFile;
        public  HashMap<String,Integer> FileNameIndexHm=new HashMap<>();
        private  Integer t;

    public void Run() throws UnsupportedEncodingException, IOException {
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
           File file = new File("Docs_Words");
           file.mkdirs();
       
           HashMap<String, Integer> hashmap= new HashMap<>();
          
           String string;
           int i;
           int j;
           boolean b;
           int tmp;
           byte [] WordBuffer=new byte[200];
           int buffersize=1024*256;   
	   byte [] buffer=new byte[buffersize];	 
          
                   
           String InputFileName="final.txt";
                   //"OutputFile_After_Stemming_Verbs.txt";
                 
           
           b=false;
           String temp;
           tmp=0;
           boolean c=false;
   	   FileInputStream f1 = new FileInputStream(InputFileName);
   	   FileChannel ch1 = f1.getChannel();
   	   MappedByteBuffer mb1 = ch1.map( FileChannel.MapMode.READ_ONLY,0L, ch1.size( ) );
   	   Writer out;
           int max=0;
   	 
           
           while(mb1.hasRemaining()){ 
              
               
   	        int nGet = Math.min( mb1.remaining( ),buffersize);
                mb1.get(buffer,0,nGet);        
                if(!b){
                    i=0;
                    j=nGet;
                }
                else{    
                    i=0;
                    j=nGet;
                }
                b=true;     
   	        for(int k=i;k<j;k++){
                       
                       if((((buffer[k] & 0xFF)>0x7e))||((buffer[k] & 0xFF)==0x3c)||((buffer[k] & 0xFF)==0x3e)){
                           
                            WordBuffer[tmp++]=buffer[k];
                            
                        }
                    else{
                           if(tmp<=0){
                               continue;
                           }
                           string=new String(WordBuffer,0,tmp,"utf-8"); 
                           
                    	   if((tmp==12)&&(string.equals("<مقاله>"))){
                               max=0;
                               OutputFile=new File("Docs_Words/Doc_Word_"+Num_Of_Docs+".txt");
                               OutputFile.createNewFile();
                               out=new BufferedWriter(new OutputStreamWriter(
                                                  new FileOutputStream(OutputFile), "UTF8")); 
                                
                               Iterator<String> it = hashmap.keySet().iterator();
                               while (it.hasNext())
                               {
                                    temp=it.next();
                                    t=hashmap.get(temp);
                                    out.write(temp+"\r\n"+t+"\r\n");
                                    out.flush();
                                    if(t>max){
                                        max=t;
                                    }
                                    
                               }
                               out.close();
                               OutputFile=new File("Docs_Words/Doc_Word_Max_"+Num_Of_Docs+".txt");
                               OutputFile.createNewFile();
                               out=new BufferedWriter(new OutputStreamWriter(
                                                  new FileOutputStream(OutputFile), "UTF8"));
                               out.write(max+"\r\n");
                               out.flush();
                               out.close();
                               Num_Of_Docs++;
                               hashmap.clear();
                               
                               tmp=0;
                           }
                                       
                           else if(tmp>0){
                             if((string.indexOf(">")!=-1)||(string.indexOf("<")!=-1)||(FileNameIndexHm.get(string.substring(0,1))==null)){  
                                 
                             }
                             else{
                             if(hashmap.containsKey(string)){
                                 hashmap.put(string,hashmap.get(string)+1);
                              }
                              else{
                                  hashmap.put(string,1);
                              }
                             }
                              tmp=0; 
                           }
                          
                              
                   } 
              }
    
        }
           
        if(tmp>0){
             string=new String(WordBuffer,0,tmp,"utf-8"); 
             
             if((tmp==12)&&(string.equals("<مقاله>"))){
                 max=0;
                               OutputFile=new File("Docs_Words/Doc_Word_"+Num_Of_Docs+".txt");
                               OutputFile.createNewFile();
                               out=new BufferedWriter(new OutputStreamWriter(
                                                  new FileOutputStream(OutputFile), "UTF8")); 
                                
                               Iterator<String> it = hashmap.keySet().iterator();
                               while (it.hasNext())
                               {
                                    temp=it.next();
                                    t=hashmap.get(temp);
                                   out.write(temp+"\r\n"+t+"\r\n");
                                    out.flush();
                                    if(t>max){
                                        max=t;
                                    }
                               }
                               out.close();
                               OutputFile=new File("Docs_Words/Doc_Word_Max_"+Num_Of_Docs+".txt");
                               OutputFile.createNewFile();
                               out=new BufferedWriter(new OutputStreamWriter(
                                                  new FileOutputStream(OutputFile), "UTF8"));
                               out.write(max+"\r\n");
                               out.flush();
                               out.close();
                               hashmap.clear();             
                             
                             
            }
                                          
            else{
                 
                 if((string.indexOf(">")!=-1)||(string.indexOf("<")!=-1)||(FileNameIndexHm.get(string.substring(0,1))==null)){  
                                 
                             }
                 else{
                    if(hashmap.containsKey(string)){
                                 hashmap.put(string,hashmap.get(string)+1);
                              }
                              else{
                                  hashmap.put(string,1);
                              }  
                 }
            }
            
        }  
        if(hashmap.size()>0){
            max=0;
                               OutputFile=new File("Docs_Words/Doc_Word_"+Num_Of_Docs+".txt");
                               OutputFile.createNewFile();
                               out=new BufferedWriter(new OutputStreamWriter(
                                                  new FileOutputStream(OutputFile), "UTF8")); 
                                
                               Iterator<String> it = hashmap.keySet().iterator();
                               while (it.hasNext())
                               {
                                    temp=it.next();
                                    t=hashmap.get(temp);
                                    out.write(temp+"\r\n"+t+"\r\n");
                                    out.flush();
                                    if(t>max){
                                        max=t;
                                    }
                               }
                               out.close();
                               OutputFile=new File("Docs_Words/Doc_Word_Max_"+Num_Of_Docs+".txt");
                               OutputFile.createNewFile();
                               out=new BufferedWriter(new OutputStreamWriter(
                                                  new FileOutputStream(OutputFile), "UTF8"));
                               out.write(max+"\r\n");
                               out.flush();
                               out.close();
                               hashmap.clear(); 
        }
           
      OutputFile=new File("Docs_Words/Doc_Count.txt");
                               OutputFile.createNewFile();  
      out=new BufferedWriter(new OutputStreamWriter(
                                                  new FileOutputStream(OutputFile), "UTF8")); 
      out.write(Num_Of_Docs+"\r\n");
      out.close();
      
    }
}

    
    
    
    
    
    
