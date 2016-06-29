package datastorage;
/**
 *
 * @author Vahid
 */


public class Node {
    String value = "";
    int count = 0;
    Node left;
    Node right;

    Node(String word)
    {
            value = word;
            count++;
            left = null;
            right = null;
    }
    Node (String word, Node left1, Node right1)
    {
            value = word;
            count++;
            left = left1;
            right = right1;
    }
}
