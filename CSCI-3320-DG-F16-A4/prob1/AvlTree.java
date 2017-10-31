import java.util.LinkedList;
import java.util.Queue;

public class AvlTree 
{
	private AvlNode root;
	
	private static class AvlNode
	{
		// Data members
		public int key;
		public AvlNode left, right;
		public int height;  // can be -1,0,1
		
		// Constructors
		AvlNode(int element)
		{
			this(element,null,null);
		}
		
		AvlNode(int element, AvlNode lt, AvlNode rt)
		{
			key = element;
			left = lt;
			right = rt;
			height = 0;
		}
		
	}
	
	////
	/// Constructor for tree
	// 
	public AvlTree()
	{
		root = null;
	}
	
	////
	/// Returns true if tree is empty
	// 
	public boolean isEmpty()
	{
		return root == null;
	}
	
	////
	/// public method for findMax to call private method
	// 
	public int findMax()
	{
		if(isEmpty())
			return 0;
		return findMax(root).key;
	}
	
	////
	/// public method for findMin to call private method
	// 
	public int findMin()
	{
		if(isEmpty())
			return 0;
		return findMin(root).key;
	}
	
	////
	/// public method for remove to call private method
	// 
	public void remove(int r)
	{
		root = remove(r, root);
	}
	
	////
	/// public method for insert to call private method
	//
	public void insert(int i)
	{
		root = insert(i, root);
	}
	
	////
	/// public method for balance to call private method
	//
	public void balance()
	{
		balance(root);
	}
	
	////
	/// Find node with largest value in subtree
	//
	private AvlNode findMax(AvlNode element)
	{
		if(element == null)
		{
			return element;
		}
		
		while(element.right != null)
		{
			element = element.right;
		}
		return element;
	}
	
	////
	/// Find node with smallest value in subtree
	//
	private AvlNode findMin(AvlNode element)
	{
		if(element == null)
		{
			return element;
		}
		
		while(element.left != null)
		{
			element = element.left;
		}
		return element;
	}
	
	///
	// remove node from a subtree
	// 
	private AvlNode remove(Integer r, AvlNode rootNode)
	{
		
		if(rootNode == null)
		{
			return rootNode;  // item not found
		}
		int compare = r.compareTo(rootNode.key);

		if(compare < 0)
		{
			rootNode.left = remove(r, rootNode.left);
		}
		else if(compare > 0)
		{
			rootNode.right = remove(r, rootNode.right);
		}
		else if(rootNode.left != null && rootNode != null)
		{
			rootNode.key = findMin(rootNode.right).key;
			rootNode.right = remove(rootNode.key, rootNode.right);
		}
		else
		{
			rootNode = (rootNode.left != null) ? rootNode.left : rootNode.right;
		}
		return balance(rootNode);
	}
	
	////
	/// Inserts a new key (node) into the tree
	//
	private AvlNode insert(Integer i, AvlNode rootNode)
	{
		if(rootNode == null)
		{
			return new AvlNode(i, null, null);
		}
		
		int compare = i.compareTo(rootNode.key);
		
		if(compare < 0 )
		{
			rootNode.left = insert(i, rootNode.left);
		}
		else if(compare > 0)
		{
			rootNode.right = insert(i, rootNode.right);
		}
		else
			; // do nothing, duplicate
		return balance(rootNode);
	}
	
	///
	// data member for balance method
	// 
	private static final int ALLOWED_IMBALANCE = 1;
	
	////
	/// Returns an AVL balanced tree
	//
	private AvlNode balance(AvlNode node)
	{
		if(node == null)
		{
			return node;
		}
		
		if(height(node.left) - height(node.right) > ALLOWED_IMBALANCE)
		{
			if(height(node.left.left) >= height(node.left.right))
			{
				node = singleRotateLL(node);
			}
			else
			{
				node = doubleRotateLR(node);
			}
		}
		else
		{
			if(height(node.right) - height(node.left) > ALLOWED_IMBALANCE)
			{
				if(height(node.right.right) >= height(node.right.left))
				{
					node = singleRotateRR(node);
				}
				else
				{
					node = doubleRotateRL(node);
				}
			}
		}
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		return node;
	}
	
	////
	/// perform a single rotate on the tree node k2's Left child
	//
	private AvlNode singleRotateLL(AvlNode k2)
	{
	    AvlNode k1 = k2.left;
	    k2.left = k1.right;
	    k1.right = k2;
	    k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
	    k1.height = Math.max(height(k1.left), k2.height) + 1;
	    return k1;
	}
	
	//// 
	/// perform a single rotate on the tree node k1's Right child
	//
	private AvlNode singleRotateRR(AvlNode k1)
	{
		AvlNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max( height( k1.left ), height( k1.right ) ) + 1;
        k2.height = Math.max( height( k2.right ), k1.height ) + 1;
        return k2;
	}
	
	////
	/// perform a double rotate on the tree node k3's left child
	//
	private AvlNode doubleRotateLR( AvlNode k3 )
    {
        k3.left = singleRotateRR( k3.left );
        return singleRotateLL( k3 );
    }
	
	////
	/// perform a double rotate on the tree node k1's right child
	//
	private AvlNode doubleRotateRL( AvlNode k1 )
	{
	    k1.right = singleRotateLL( k1.right );
	    return singleRotateRR( k1 );
	}
	
	
	////
	/// Returns height of node t, if null returns -1
	//
	private int height(AvlNode t)
	{
		if(t == null)
		{
			return -1;
		}
		else return t.height;
	}
	
	////
	/// public method to call private levelOrderPrint
	//
	public void levelOrderPrint()
	{
		if(isEmpty())
		{
			System.out.println("Tree is empty");
		}
		else
		{
			levelOrderPrint(root);
		}
	}
	
	////
	/// Prints the tree in level order traversal
	//
	private void levelOrderPrint(AvlNode node)
	{
		Queue<AvlNode> currentLevel = new LinkedList<AvlNode>();
		Queue<AvlNode> nextLevel = new LinkedList<AvlNode>();
		
		currentLevel.add(node);
		
		while(!currentLevel.isEmpty())
		{				 							// new line for each level
			AvlNode temp = currentLevel.poll();  // remove from front of queue
			System.out.print(temp.key + " ");    // print current node
			
			if(temp.left != null)				 // add children of current node 
			{									 // to nextLevel queue
				nextLevel.add(temp.left);
			}
			if(temp.right != null)
			{
				nextLevel.add(temp.right);
			}
			if(currentLevel.isEmpty() )
			{
				System.out.println();
			
				while(!nextLevel.isEmpty())
				{
					AvlNode nextTemp = nextLevel.poll();
					
					System.out.print(nextTemp.key + " ");
				
					if(nextTemp.left != null)
					{
						currentLevel.add(nextTemp.left);
					}
					if(nextTemp.right != null)
					{
						currentLevel.add(nextTemp.right);
					}
					if(nextLevel.isEmpty())
					{
						System.out.println();
					}
				}
			}
		}
		
		System.out.println();
			
	}
	
	
}






















