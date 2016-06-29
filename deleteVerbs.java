/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastorage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author zahed
 */
public class deleteVerbs {
    
    public void readFromfile(String fileName , String output) throws FileNotFoundException, IOException{
        BufferedReader bReader = new BufferedReader(new FileReader(fileName));
        BufferedWriter writeToFile = new BufferedWriter(new FileWriter(output));
        String line;
        while((line = bReader.readLine()) != null){
            for (String retval: line.split(" ")){
                writeToFile.write(delete(retval) + " ");
            } 
            writeToFile.newLine();
        }
    }
    
    public String delete(String verb){
        String[] words = verb.split("");
        if (words.length > 3) {
            if("م".equals(words[words.length -1 ])){
                if (null != words[words.length -2 ]) switch (words[words.length -2 ]) {
                    case "ی":
                        if("ا".equals(words[words.length -3 ])){
                            words[words.length -3 ] = "" ;
                        }
                        words[words.length -2 ] = "" ;
                        words[words.length -1 ] = "" ;
                        break;
                    case "ا":
                        words[words.length -2 ] = "" ; 
                        words[words.length -1 ] = "" ;
                        break;
                    default:
                        words[words.length -1 ] = "" ;
                        break;
                }
            }
            if("ی".equals(words[words.length -1 ])){
                if("ا".equals(words[words.length -2 ])){
                    words[words.length -2 ] = "" ;
                    words[words.length -1 ] = "" ;
                }
                else{
                    words[words.length -1 ] = "" ;
                }
            }
            
            if("د".equals(words[words.length -1 ])){
                if(null != words[words.length -2 ])switch (words[words.length -2 ]) {
                    case "ت":
                        words[words.length -2 ] = "" ;
                        words[words.length -1 ] = "" ;
                        break;
                    case "ن":
                        if("ا".equals(words[words.length -3 ])){
                            words[words.length -3 ] = "" ;
                        }
                        words[words.length -2 ] = "" ;
                        words[words.length -1 ] = "" ;
                        break;
                    case "ی":
                        if("ا".equals(words[words.length -3 ])){
                            words[words.length -3 ] = "" ; 
                        }
                        words[words.length -2 ] = "" ;
                        words[words.length -1 ] = "" ;
                        break;
                    default:
                        words[words.length -1 ] = "" ;
                        break;
                }
            }
            
            if("ت".equals(words[words.length -1 ])){
                if("س".equals(words[words.length -2 ])) {
                    if("ا".equals(words[words.length -3 ])){
                        words[words.length -3 ] = "" ;
                    }
                    words[words.length -2 ] = "" ;
                    words[words.length -1 ] = "" ;
                }
            }
            
            if("ه".equals(words[words.length -1 ])){
                words[words.length -1 ] = "" ;
            }
            
            if (words.length > 4) {
            	if("*".equals(words[words.length -1 ]) || "؛".equals(words[words.length -1 ]) || "!".equals(words[words.length -1 ]) || "؟".equals(words[words.length -1 ]) || ".".equals(words[words.length -1 ]) || ",".equals(words[words.length -1 ]) || ":".equals(words[words.length -1 ]) || "(".equals(words[words.length -1 ]) || ")".equals(words[words.length -1 ])){
            		if("م".equals(words[words.length -2 ])){
            			if (null != words[words.length -3 ]) switch (words[words.length -3 ]) {
            			case "ی":
            				if("ا".equals(words[words.length -4 ])){
            					words[words.length -4 ] = "" ;
            				}
            				words[words.length -3 ] = "" ;
            				words[words.length -2 ] = "" ;
            				break;
            			case "ا":
            				words[words.length -3 ] = "" ; 
            				words[words.length -2 ] = "" ;
            				break;
            			default:
            				words[words.length -2 ] = "" ;
            				break;
            			}
            		}
            		if("ی".equals(words[words.length -2 ])){
            			if("ا".equals(words[words.length -3 ])){
            				words[words.length -3 ] = "" ;
            				words[words.length -2 ] = "" ;
            			}
            			else{
            				words[words.length -2 ] = "" ;
            			}
            		}
            		
            		if("د".equals(words[words.length -2 ])){
            			if(null != words[words.length -3 ])switch (words[words.length -3 ]) {
            			case "ت":
            				words[words.length -1 ] = "" ;
            				words[words.length -2 ] = "" ;
            				break;
            			case "ن":
            				if("ا".equals(words[words.length -4 ])){
            					words[words.length -4 ] = "" ;
            				}
            				words[words.length -3 ] = "" ;
            				words[words.length -2 ] = "" ;
            				break;
            			case "ی":
            				if("ا".equals(words[words.length -4 ])){
            					words[words.length -4 ] = "" ; 
            				}
            				words[words.length -3 ] = "" ;
            				words[words.length -2 ] = "" ;
            				break;
            			default:
            				words[words.length -2 ] = "" ;
            				break;
            			}
            		}
            		
            		if("ت".equals(words[words.length -2 ])){
            			if("س".equals(words[words.length -3 ])) {
            				if("ا".equals(words[words.length -4 ])){
            					words[words.length -4 ] = "" ;
            				}
            				words[words.length -3 ] = "" ;
            				words[words.length -2 ] = "" ;
            			}
            		}
            		
            		if("ه".equals(words[words.length -2 ])){
                        words[words.length -2 ] = "" ;
                    }
            		
            		words[words.length -1 ] = "" ;
            	}
				
			}
            
        }
        
        verb = "";
        for (String word : words) {
            verb += word;
        } 
        return verb ;
    }
}
