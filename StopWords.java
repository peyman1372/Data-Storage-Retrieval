package datastorage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
/**
 *
 * @author Vahid
 */


public class StopWords {
    Map stopHash = new HashMap();
    ArrayList stopArray = new ArrayList();
    LinkedList stopList = new LinkedList();
    BinaryTree btree = new BinaryTree();
    
    public void loadStopWordsToHash(String fileName) throws FileNotFoundException, IOException{
        BufferedReader readLine = new BufferedReader(new FileReader(fileName));
        String line = readLine.readLine();
        while (line != null) {
            stopHash.put(line, null);
            line = readLine.readLine();
        }
    }

    public void deletStopWordsWithHash(String fileName , String output) throws FileNotFoundException, IOException{
        BufferedReader inputFile = new BufferedReader(new FileReader(fileName));
        BufferedWriter writeToFile = new BufferedWriter(new FileWriter(output));
        String line = inputFile.readLine();
        while(line != null){
            for (String retval: line.split(" ")){
                if(stopHash.containsKey(retval)){
                    line = line.replaceAll(retval,"");
                }
            }  
            writeToFile.write(line);
            writeToFile.newLine();
            line = inputFile.readLine();
        }      
    }
    
    public void loadStopWordsToSet(String fileName) throws FileNotFoundException, IOException{
        BufferedReader readLine = new BufferedReader(new FileReader(fileName));
        String line = readLine.readLine();
        while (line != null) {
            stopArray.add(line);
            line = readLine.readLine();
        }
    }
    
    public void deletStopWordsWithSet(String fileName , String output) throws FileNotFoundException, IOException{
        BufferedReader inputFile = new BufferedReader(new FileReader(fileName));
        BufferedWriter writeToFile = new BufferedWriter(new FileWriter(output));
        String line = inputFile.readLine();
        while(line != null){
            for (String retval: line.split(" ")){
                if(stopArray.contains(retval)){
                    line = line.replaceAll(retval,"");
                }
            }  
            writeToFile.write(line);
            line = inputFile.readLine();
        }      
    }
        
    public void loadStopWordsToLinkedList(String fileName) throws FileNotFoundException, IOException{
        BufferedReader readLine = new BufferedReader(new FileReader(fileName));
        String line = readLine.readLine();
        while (line != null) {
            stopList.add(line);
            line = readLine.readLine();
        }
    }

    public void deletStopWordsWithLinkedList(String fileName , String output) throws FileNotFoundException, IOException{
        BufferedReader inputFile = new BufferedReader(new FileReader(fileName));
        BufferedWriter writeToFile = new BufferedWriter(new FileWriter(output));
        String line = inputFile.readLine();
        while(line != null){
            for (String retval: line.split(" ")){
                if(stopList.contains(retval)){
                    line = line.replaceAll(retval,"");
                }
            }  
            writeToFile.write(line);
            line = inputFile.readLine();
        }      
    }
        
    public void loadStopWordsToTree(String fileName) throws FileNotFoundException, IOException{
        BufferedReader inputFile = new BufferedReader(new FileReader(fileName));
        String line = inputFile.readLine();
        while (line != null)
        {
            btree.add(line, btree.getRoot());
            line = inputFile.readLine();
        }
    }
    
    public void deletStopWordsWithTree(String fileName , String output) throws FileNotFoundException, IOException{
        BufferedReader inputFile = new BufferedReader(new FileReader(fileName));
        BufferedWriter writeToFile = new BufferedWriter(new FileWriter(output));
        String line = inputFile.readLine();
        while(line != null){
            for (String retval: line.split(" ")){
                if(btree.contains(retval , btree.getRoot())){
                    line = line.replaceAll(retval,"");
                }
            }  
            writeToFile.write(line);
            line = inputFile.readLine();
        }      
    }
}

