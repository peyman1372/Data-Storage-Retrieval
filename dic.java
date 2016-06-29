package datastorage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class dic {

	
	public static void main(String[] args) throws IOException, NumberFormatException, InvalidCommandException {
//		long startTime = System.nanoTime();

//		hash_dataInputStream hash_dataInputStream = new hash_dataInputStream();
		//mytrie mytrie= new mytrie("final.txt");
		//hash_buffereader hash = new hash_buffereader();

//		long endTime = System.nanoTime();
//IR2_4 ir2_4 = new IR2_4();
//ir2_4.Run();
//		IR3_4 ir3_4 = new IR3_4();
//		ir3_4.Run();
//		 System.out.println("Took "+(endTime - startTime) + " ns");
		//mytrie.Search_Total_Frequency("??????????");
//		String find ="??????????";
//		hash.Search_Total_Frequency(find);
//		StopWords stop = new StopWords();
//		stop.loadStopWordsToHash("StopWords.txt");
//		stop.deletStopWordsWithHash("Phase.txt", "PhaseWithoutStopWords.txt");
//      mytrie readFromfile = new mytrie("PhaseWithoutStopWords.txt");
//        deleteVerbs verbs = new deleteVerbs();
//        try {
//			verbs.readFromfile("PhaseWithoutStopWords.txt", "final.txt");
			IR2_4 ir2_4 = new IR2_4();
			ir2_4.Run();
			IR3_1 ir3_1 = new IR3_1();
			ir3_1.Run();
			IR3_4 ir3_4 = new IR3_4();
			ir3_4.Run();
                        KMeans kmeans = new KMeans(4808);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		// if there are too many arguments error
//        if(args.length > 1) {
//            System.err.println("Syntax error in call sequence, use:\n\tjava BplusTree");
//        }
//        else {
//            BPlusTree bPlus = new BPlusTree(100);
//        	// declare a reader on Standard in, incase the file reader fails
//            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//            
//            // create a new file to store output
//            BufferedWriter output = new BufferedWriter( new FileWriter(new File("output.txt")) );            
//            try {
//                in = new BufferedReader(new InputStreamReader(new FileInputStream("final.txt")));
//            } catch (FileNotFoundException e) {
//                System.err.println("Error: specified file not found (defaulting to standard input)");
//            }
//            
//            // get the degree of the B+Tree
////            bPlus.readDegree(100);
//        	
//            // declare a new command object
//            Command c = new Command(); 
////            
////            // continue executing commands until quit is reached
////            while(c.getCommand() != 'q') {
////                try {
////                	// read a command from input
//		            String line;
//		            int conter = 100;
//		            while((line = in.readLine()) != null && conter > 0){
//		                for (String retval: line.split(" ")){
//		                	c.readCommand(retval);
//		                    bPlus.executeCommand(c, output);
//		                } 
//		                conter --;
//		            }
//                    bPlus.printTree(output);
////					// execute the command
////                } 
////                catch (IOException e) {
////                    e.printStackTrace();
////                }
////                catch (InvalidCommandException e) {
////                    System.err.println(e.getMessage());
////                    System.out.println("Valid Query-Modes:\n\ti x - insert x into tree\n\ts x - find x in tree\n\tp   - print tree\n\tq   - quit");
////                }
////                catch (NumberFormatException e) {
////                	System.err.println("This type of command requires a integer operand");
////                    System.out.println("Valid Query-Modes:\n\ti x - insert x into tree\n\ts x - find x in tree\n\tp   - print tree\n\tq   - quit");
////                }
////                catch (Exception e) {
////                    e.printStackTrace();
////                    System.exit(-1);
////                }
////            }
//            
//            // close input and output
//            output.close();
//            in.close();
//            
//            // output.write("Exitting");
//            System.exit(0);
//        }
//		
	}
}