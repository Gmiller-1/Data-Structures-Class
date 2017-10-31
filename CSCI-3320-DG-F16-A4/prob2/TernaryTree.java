import java.util.LinkedList;
import java.util.Queue;

public class TernaryTree 
{
	// The tree root //
	private TernaryNode nodeRoot;
	// Size of tree  //
	private int size; 
	
	// Internal static class for the trees nodes
	private static class TernaryNode
	{
		// Data members
		private char key;
		public TernaryNode left, middle, right;
		public int val;
		
		// Constructors
		TernaryNode(char element)
		{
			this(element,null,null,null);
		}
		
		TernaryNode(char element, TernaryNode lt,TernaryNode mid, TernaryNode rt)
		{
			key = element;
			left = lt;
			middle = mid;
			right = rt;
		}
		
	}
	
	////
	/// Constructor for tree
	//
	public TernaryTree()
	{
		this.nodeRoot = null;
	}
	
	////
	/// public method to call private insert method
	//
	public void insert(String s, int val)
	{
		if(!contains(s))
		{
			size++;
		}
		nodeRoot = insert(nodeRoot, s, val, 0);
	}
	
	////
	/// Method to insert new string in tree
	//
	private TernaryNode insert(TernaryNode node, String s, int val, int num) 
	{ 
        char c = s.charAt(num);
        
        if(node == null) 
        { 
            node = new TernaryNode(c); 
            node.key = c; 
        } 
        if(c < node.key) 
        {
        	node.left = insert(node.left, s, val, num); 
        }
        else if(c > node.key)        
        {
        	node.right = insert(node.right, s, val, num); 
        }
        else if(num < s.length() - 1) 
        {
        	node.middle = insert(node.middle, s, val, num + 1);
        }
        else
        {
        	node.val = val; 
        }
        return node;
	}
	
	////
	/// returns true if node contains key
	//
	public boolean contains(String key)
	{
		return fetch(key) != 0;
	}
	
	////
	/// public method to call private fetch method
	//
	public int fetch(String s)
	{
		TernaryNode n = fetch(nodeRoot, s, 0);
		if(n == null)
		{
			return 0; // nothing found, tree empty
		}
		return n.val;
		
	}
	
	////
	/// private method for fetching a string from the tree
	// 
	private TernaryNode fetch(TernaryNode node, String s, int num)
	{
		if(node == null)
		{
			return null;
		}
		
		char c = s.charAt(num);
		
		if(c < node.key)
		{
			return fetch(node.left, s, num);
		}
		else if(c > node.key)
		{
			return fetch(node.right, s, num);
		}
		else if(num < s.length() - 1)
		{
			return fetch(node.middle, s, num + 1);
		}
		else
		{
			return node;
		}
	}
	
	////
	/// Returns true if tree is empty
	// 
	public boolean isEmpty()
	{
		return nodeRoot == null;
	}
	
	//// 
	/// public method to call private print method
	//
	public void levelOrderPrint()
	{
		if(isEmpty())
		{
			System.out.println("Tree is empty");
		}
		else
		{
			levelOrderPrint(nodeRoot);
		}
	}
	
	////
	/// Print the tree in level order format
	//
	private void levelOrderPrint(TernaryNode node)
	{
		Queue<TernaryNode> currentLevel = new LinkedList<TernaryNode>();
		Queue<TernaryNode> nextLevel = new LinkedList<TernaryNode>();
		
		currentLevel.add(nodeRoot);
		
		while(!currentLevel.isEmpty())
		{
			TernaryNode temp = currentLevel.poll();
			System.out.print(temp.key + " ");
			
			if(temp.left != null)
			{
				nextLevel.add(temp.left);
			}
			if(temp.middle != null)
			{
				nextLevel.add(temp.middle);
			}
			if(temp.right != null)
			{
				nextLevel.add(temp.right);
			}
			if(currentLevel.isEmpty())
			{
				System.out.println();
			
			
				while(!nextLevel.isEmpty())
				{
					TernaryNode nextTemp = nextLevel.poll();
					System.out.print(nextTemp.key + " ");
					
					if(nextTemp.left != null)
					{
						currentLevel.add(nextTemp.left);
					}
					if(nextTemp.middle != null)
					{
						currentLevel.add(nextTemp.middle);
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
























