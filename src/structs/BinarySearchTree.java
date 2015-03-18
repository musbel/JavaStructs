package structs;

public class BinarySearchTree<V extends Comparable<V>>
{
	private BinaryNode<V> root;
	
	public BinarySearchTree()
	{
		root = null;
	}
	
	private BinaryNode<V> add( BinaryNode<V> node, V value )
	{
		if ( node == null )
		{
			node = new BinaryNode<V>( value );
			return node;
		}
		
		if ( value.compareTo( node.value ) == 0 )
		{
			return node;
		}
			
		if ( value.compareTo( node.value ) >= 0 ) 
		{
			node.right = add( node.right, value );
		}
		else
		{
			node.left = add( node.left, value );
		}
		
		return node;
	}
	
	public BinaryNode<V> add( V value )
	{
		root = add( root, value );
		return root;
	}
	
	public void printInOrder()
	{
		if ( root != null )
		{		
			root.printInOrder();
		}
	}
	
	public void printPreOrder()
	{
		if ( root != null )
		{		
			root.printPreOrder();
		}
	}
	
	public void printPostOrder()
	{
		if ( root != null )
		{		
			root.printPostOrder();
		}
	}
	
	public BinaryNode<V> getRoot()
	{
		return root;
	}
	
	public int minDepth( BinaryNode<V> node )
	{
		if ( node != null && ( node.left != null || node.right != null ) )
		{
			int left = minDepth( node.left );
			int right = minDepth( node.right );
			return 1 + Math.min( left, right );
		}
		
		return 0;
	}
	
	public int maxDepth( BinaryNode<V> node )
	{
		if ( node != null && ( node.left != null || node.right != null ) )
		{
			int left = maxDepth( node.left );
			int right = maxDepth( node.right );
			return 1 + Math.max( left, right );
		}
		
		return 0;
	}
	
	public boolean isBalanced()
	{
		if ( maxDepth( root ) - minDepth( root ) <= 1 )
		{
			return true;
		}
		
		return false;
	}
	
	public BinaryNode<V> leftMostNode( BinaryNode<V> node )
	{
		if ( node == null )
			return null;
		
		while( node.left != null )
		{
			node = node.left;
		}
		
		return node;
	}

	public BinaryNode<V> rightMostNode( BinaryNode<V> node )
	{
		if ( node == null )
			return null;
		
		while( node.right != null )
		{
			node = node.right;
		}
		
		return node;
	}

	public boolean isBst( BinaryNode<V> node )
	{
		if ( node == null )
			return true;

		if ( node.left != null && rightMostNode( node.left ).getValue().compareTo( node.getValue() ) > 0 )
			return false;
			
		if ( node.right != null && leftMostNode( node.right ).getValue().compareTo( node.getValue() ) < 0 )
			return false;
		
		if ( !isBst( node.left ) || !isBst( node.right ) )
			return false;
		
		return true;
	}
	
	private int size( BinaryNode<V> node )
	{
		if ( node != null )
		{
			return 1 + size( node.left ) + size( node.right );
		}
		
		return 0;
	}

	public int size()
	{
		return size( root );
	}
}
