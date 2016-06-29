
/**
 *
 * @author Vahid
 */
package datastorage;
public class BinaryTree
{
	private Node root;

	public void add(String word, Node root)
	{
            Node temp = new Node(word);
            if (null == root)
            {
                this.root = temp;
            }
            else
            {
                Node p = getRoot();
                Node prev = getRoot();
                while (p != null)
                {
                    prev = p;
                    int cmpP = word.compareTo(p.value);
                    if (cmpP < 0)
                    {
                        p = p.left;
                    }
                    else
                    {
                        p = p.right;
                    }
                }
                int cmpPrev = word.compareTo(prev.value);
                if (cmpPrev > 0)
                {
                    prev.right = temp;
                }
                else
                {
                    prev.left = temp;
                }
            }
	}
	public void inOrder(Node binTree)
	{
		if (binTree != null)
		{
			inOrder(binTree.left);
			System.out.println(binTree.value);
			inOrder(binTree.right);
                }
	}
	public boolean contains(String word , Node root){
            Node temp = new Node(word);
            if (null == root)
            {
                return false;
            }
            else
            {
                Node p = getRoot();
                Node prev = getRoot();
                while (p != null)
                {
                    prev = p;
                    int cmpP = word.compareTo(p.value);
                    if (cmpP < 0)
                    {
                        p = p.left;
                    }
                    else if (cmpP > 0)
                    {
                        p = p.right;
                    }
                    else if ( cmpP == 0)
                    {
                        return true;
                    }
                }
                int cmpPrev = word.compareTo(prev.value);
                return cmpPrev == 0;
            }
        }

    /**
     * @return the root
     */
    public Node getRoot() {
        return this.root;
    }
}