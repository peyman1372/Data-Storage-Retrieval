/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastorage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie
{
   public TrieNode root;
   public int [] count=new int[35];
   public HashMap<String,Integer> hm;
   
   /**
    * Constructor
    */
   public Trie(HashMap<String,Integer> hm)
   {
	   
      this.hm=hm;
      root = new TrieNode(hm);
      for(int i=0;i<35;i++){
          count[i]=0;
      }
   }
   
   
   /**
    * Adds a word to the Trie
    * @param word
    */
   public void addWord(String word,long frequency)
   {       

      root.addWord(word.toLowerCase(),frequency);
      if(hm.get(word.substring(0,1))!=null){
         count[hm.get(word.substring(0,1))]++;  
      }
   }
   
   /**
    * Get the words in the Trie with the given
    * prefix
    * @param prefix
    * @return a List containing String objects containing the words in
    *         the Trie with the given prefix.
    */
   
   public List getWords(String prefix)
   {
      //Find the node which represents the last letter of the prefix
      TrieNode lastNode = root;
      for (int i=0; i<prefix.length(); i++)
      {
      lastNode = lastNode.getNode(prefix.substring(i,i+1));
      
      //If no node matches, then no words exist, return empty list
      if (lastNode == null) return new ArrayList();      
      }
      
      //Return the words which eminate from the last node
      return lastNode.getWords();
   }
   public String getWord(String word)
   {
      //Find the node which represents the last letter of the prefix
      TrieNode lastNode = root;
      for (int i=0; i<word.length(); i++)
      {
         
      lastNode = lastNode.getNode(word.substring(i,i+1));
      
      //If no node matches, then no words exist, return empty list
      if (lastNode == null) return null;      
      }
      //Return the words which eminate from the last node
      return lastNode.getWord();
   }
     public void updateWord(String word,long ff)
   {
      //Find the node which represents the last letter of the prefix
      TrieNode lastNode = root;
      for (int i=0; i<word.length(); i++)
      {
        lastNode = lastNode.getNode(word.substring(i,i+1));
      //If no node matches, then no words exist, return empty list
      if (lastNode == null) return ; 
      }
      lastNode.updateWord(ff);
   }
    
   public long getF(String word)
   {
      //Find the node which represents the last letter of the prefix
      TrieNode lastNode = root;
      for (int i=0; i<word.length(); i++)
      {
      lastNode = lastNode.getNode(word.substring(i,i+1));
      
      //If no node matches, then no words exist, return empty list
      if (lastNode == null) return -1;      
      }
      //Return the words which eminate from the last node
      return lastNode.getF();
   }
    public List getFs(String prefix)
   {
      //Find the node which represents the last letter of the prefix
      TrieNode lastNode = root;
      for (int i=0; i<prefix.length(); i++)
      {
      lastNode = lastNode.getNode(prefix.substring(i,i+1));
      
      //If no node matches, then no words exist, return empty list
      if (lastNode == null) return new ArrayList();      
      }
      
      //Return the words which eminate from the last node
      return lastNode.getFs();
   }
    
}