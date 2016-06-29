package datastorage;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrieNode
{
   public TrieNode parent=null;
   public TrieNode[] children=null;
   public boolean isLeaf;     //Quick way to check if any children exist
   public boolean isWord;     //Does this node represent the last character of a word
   public String character;
   public HashMap<String,Integer> hm;
   //public long DocFs;
   public long frequency;
   
   //The character this node represents

   /**
    * Constructor for top level root node.
    */
   public TrieNode(HashMap<String,Integer> hm)
   {
      children = new TrieNode[35];
      for(int i=0;i<35;i++){
          children[i]=null;
      }
      isLeaf = true;
      isWord = false;
      this.hm=hm;
   }

   /**
    * Constructor for child node.
    */
   public TrieNode(String character,HashMap<String,Integer> hm)
   {
      this(hm);
      this.character = character;
   }
   
   
   
   /**
    * Adds a word to this node. This method is called recursively and
    * adds child nodes for each successive letter in the word, therefore
    * recursive calls will be made with partial words.
    * @param word the word to add
    */
   public void addWord(String word,long ffrequency)
   {
      isLeaf = false;
      if(hm.get(word.substring(0,1))!=null){
      int charPos =hm.get(word.substring(0,1));
      
      if (children[charPos] == null)
      {
      children[charPos] = new TrieNode(word.substring(0,1),hm);
      children[charPos].parent = this;
      }
      
      if (word.length() > 1)
      {
      children[charPos].addWord(word.substring(1),ffrequency);
      }
      else
      {
      children[charPos].isWord = true;
      //children[charPos].DocFs=docfs;
      children[charPos].frequency=ffrequency;
      }
      }
   }
   
   /**
    * Returns the child TrieNode representing the given char,
    * or null if no node exists.
    * @param c
    * @return
    */
   public TrieNode getNode(String chr)
   {
   
      if(hm.get(chr)==null){
         return null;
      }
   
        return children[hm.get(chr)];
       
       
       
    
   }
   
   /**
    * Returns a List of String objects which are lower in the
    * hierarchy that this node.
    * @return
    */
   public List getWords()
   {
      //Create a list to return
      List<String> list = new ArrayList();
      
      //If this node represents a word, add it
      if (isWord)
      {
      list.add(toString());
      
      }
      
      //If any children
      if (!isLeaf)
      {
      //Add any words belonging to any children
      for (int i=0; i<children.length; i++)
      {
         if (children[i] != null)
         {
            list.addAll(children[i].getWords());
         }
      }
      

     }

return list; 

}
public String getWord()
{
      if (isWord)
      {
      return toString();
      }
      return null;
}
public void updateWord(long ff)
{
      if (isWord)
      {
         // DocFs=docfs;
          frequency=ff;
      }
      
}



public long getF()
   {
      if (isWord)
      {
      return frequency;
      }
      return -1;
}


 public List getFs()
   {
      //Create a list to return
      List<Long> list = new ArrayList();
      
      //If this node represents a word, add it
      if (isWord)
      {
      list.add(this.frequency);
      
      //return list;
      }
      
      //If any children
      if (!isLeaf)
      {
      //Add any words belonging to any children
      for (int i=0; i<children.length; i++)
      {
         if (children[i] != null)
         {
            list.addAll(children[i].getFs());
         }
      }

     }

return list; 

}
  
   @Override
   public String toString(){
if (parent == null)

{ 
     return "";
}

else

{
     return parent.toString() + character;
}

} 
   
}
                