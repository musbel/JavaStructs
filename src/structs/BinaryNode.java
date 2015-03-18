package structs;

public class BinaryNode<V>
{
	V value;
	BinaryNode<V> left;
	BinaryNode<V> right;
	
	public BinaryNode( V value )
	{
		this.value = value;
		left = null;
		right = null;
	}
	
	public V getValue()
	{
		return value;
	}
	
	public void printInOrder()
	{
		if ( left != null )
		{
			left.printInOrder();
		}
		
		System.out.println( value );
		
		if ( right != null )
		{
			right.printInOrder();
		}
	}
	
	public void printPreOrder()
	{
		System.out.println( value );

		if ( left != null )
		{
			left.printInOrder();
		}
		
		if ( right != null )
		{
			right.printInOrder();
		}
	}
	
	public void printPostOrder()
	{
		if ( left != null )
		{
			left.printInOrder();
		}
		
		if ( right != null )
		{
			right.printInOrder();
		}
		
		System.out.println( value );
	}
}
