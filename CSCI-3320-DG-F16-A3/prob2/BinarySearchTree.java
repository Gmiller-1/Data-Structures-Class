
public class BinarySearchTree 
{
	/** The tree root. */
    private BinaryNode<Integer> root;
    
	// Internal static class for the tree's nodes
	private static class BinaryNode<Integer>
    {
		
		Integer element;            // The data in the node
	    BinaryNode<Integer> left;   // Left child
	    BinaryNode<Integer> right;  // Right child
	    
	    
            // Constructors
        BinaryNode( Integer nodeElement )
        {
            this( nodeElement, null, null );
        }

        BinaryNode( Integer nodeElement, BinaryNode<Integer> lt, BinaryNode<Integer> rt )
        {
            element  = nodeElement;
            left     = lt;
            right    = rt;
        }
    }
	
	public BinarySearchTree()
	{
		root = null;
	}
	
	// return true if empty, false otherwise
	public boolean isEmpty()
	{
		return root == null;
	}
	
	// public method for insert
	public void insert(Integer x)
	{
		root = insert(x, root);
	}
	
	// private method for insert
	private BinaryNode<Integer> insert(Integer x, BinaryNode<Integer> t)
	{
		if(t == null)
		{
			return new BinaryNode<>(x, null, null);
		}
		
		int compareResult = x.compareTo(t.element);
		
		if(compareResult < 0)
		{
			t.left = insert(x, t.left);
		}
		else if(compareResult > 0)
		{
			t.right = insert(x, t.right);
		}
		else
			;
		
		return t;
	}
	
	//public method for printTree
	public void printTree()
	{
		if(isEmpty())
		{
			System.out.println("Empty Tree");
		}
		else
		{
			printTree(root);
		}
	}
	
	// private method for printTree
	private void printTree(BinaryNode<Integer> t)
	{
		if(t != null)
		{
			printTree(t.left);
			System.out.println(t.element);
			printTree(t.right);
		}
	}
	
	// public method for printing number of leaves
	public int numLeaves()
	{
		return numLeaves(root);
	}
	
	// private method for printing number of leaves
	private int numLeaves(BinaryNode<Integer> t)
	{
		if(t == null)
		{
			return 0;
		}
		if(t.left == null && t.right == null)
		{
			return 1;
		}
		else
		{
			return numLeaves(t.left) + numLeaves(t.right);
		}
	}
	
	public int numOneChildNodes()
	{
		return numOneChildNodes(root);
	}
	
	private int numOneChildNodes(BinaryNode<Integer> t)
	{
		if(t == null || numChildren(t) == 0)
		{
			return 0;
		}
		if(numChildren(t) == 1)
		{
			return 1 + numOneChildNodes(t.left) + numOneChildNodes(t.right);
		}
		if(numChildren(t) == 2)
		{
			return numOneChildNodes(t.left) + numOneChildNodes(t.right);
		}
		return 0;
	}
	
	public int numTwoChildrenNodes()
	{
		return numTwoChildrenNodes(root);
	}
	
	private int numTwoChildrenNodes(BinaryNode<Integer> t)
	{
		if(t == null)
		{
			return 0;
		}
		if(t.left != null && t.right != null)
		{
			return 1 + numTwoChildrenNodes(t.left) + numTwoChildrenNodes(t.right);
		}
		return numTwoChildrenNodes(t.left) + numTwoChildrenNodes(t.right);
	}
	
	public int numChildren(BinaryNode<Integer> t)
	{
		int count = 0;
		if(t.left != null)
		{
			count++;
		}
		if(t.right != null)
		{
			count++;
		}
		return count;
	}
	
	
	// prints level order of binary search tree
	public void levelOrder()
	{
		Queue<Integer> queue = new Queue<Integer>();
		
		int levelNodes = 0;
		
		if(root == null) 
		{
			return;
		}
		queue.enqueue(root.element);
		
		while(!queue.isEmpty())
		{
			levelNodes = queue.lengthIs();
			while(levelNodes > 0)
			{
				BinaryNode node = new BinaryNode(queue.dequeue(), null, null);
				System.out.print(" " + node.element);
				
				if(node.left != null)
				{
					queue.enqueue((Integer) node.left.element);
				}
				if(node.right != null)
				{
					queue.enqueue((java.lang.Integer) node.right.element);
				}
				levelNodes--;
			}
			System.out.println();
		}
	}
	
	
}








































