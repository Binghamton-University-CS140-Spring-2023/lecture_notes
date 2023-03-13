class Node
{
	int keyVal;
	public Node left;
	public Node right;
	public Node parent;

	public Node(int k, Node l, Node r, Node p)
	{
		keyVal = k;
		left = l;
		right = r;
		parent = p;
	}

	public Node(int k)
	{
		keyVal = k;
		left = null;
		right = null;
		parent = null;
	}
}

class BST
{
	private Node root;

	private void insertNodeHelper(Node r, Node z)
	{
		//This needs to go in the left subtree
		if(z.keyVal < r.keyVal)
		{
			//if the left is null...
			//we found where we need to insert z
			if(r.left == null)
			{
				r.left = z;
				z.parent = r;
			}
			//we have a left subtree...
			//recursively insert z into the left subtree
			else
			{
				insertNodeHelper(r.left, z);
			}
		}
		//this needs to go in thge right subtrree
		else if(z.keyVal > r.keyVal)
		{
			//if the right is null...
			//we found where we need to insert z
			if(r.right == null)
			{
				r.right = z;
				z.parent = r;
			}
			//we have a right subtree...
			//recursively insert z into the right subtree
			else
			{
				insertNodeHelper(r.right, z);
			}	
		}
	}

	public void insertNode(Node z)
	{
		if(root == null)
		{
			root = z;
		}
		else
		{
			insertNodeHelper(root, z);
		}
	}

	public void inOrderHelper(Node r)
	{
		if(r.left != null)
		{
			inOrderHelper(r.left);
		}
		if(r != null)
		{
			System.out.println(r.keyVal);
		}
		if(r.right != null)
		{
			inOrderHelper(r.right);
		}
	}

	public void inOrderTraversal()
	{
		inOrderHelper(root);
	}
}

class Driver
{
	public static void main(String[] args)
	{
		BST bst = new BST();

		bst.insertNode(new Node(35));
		bst.insertNode(new Node(46));
		bst.insertNode(new Node(24));
		bst.insertNode(new Node(12));
		bst.insertNode(new Node(3));

		bst.inOrderTraversal();


	}
}