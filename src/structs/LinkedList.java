package structs;

public class LinkedList<V>
{
	private Node<V> head;
	private Node<V> tail;
	
	public LinkedList()
	{
		head = new Node<V>( null );
		tail = head;
	}
	
	public Node<V> add( V value )
	{
		Node<V> node = new Node<V>( value ); 
		node.prev = tail;
		tail.next = node;
		tail = tail.next;
		return node;
	}
	
	public Node<V> find( V value )
	{
		Node<V> curr = head;
		while( curr.next != null )
		{
			curr = curr.next;
			if ( curr.value == value )
			{
				return curr;
			}
		}
		
		return null;
	}
	
	public void remove( Node<V> node )
	{
		if ( node == null ) return;
		
		Node<V> prev = node.prev;
		prev.next = node.next;
		if ( node.next != null )
		{
			node.next.prev = prev;
		}
		
		node = null;
	}
	
	public void remove( V value )
	{
		remove( find( value ) );
	}
	
	public int size()
	{
		int counter = 0;
		
		Node<V> curr = head;
		while ( curr.next != null )
		{
			curr = curr.next;
			counter++;
		}
		
		return counter;
	}
	
	public void clear()
	{
		Node<V> curr = head;
		while ( curr.next != null )
		{
			curr = curr.next;
			remove( curr );
		}		
	}
	
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append( "head" );
		
		Node<V> curr = head;
		while ( curr.next != null )
		{
			curr = curr.next;
			builder.append( " -> " + curr.value );
		}
		
		return builder.toString();
	}

	public String toStringReverse()
	{
		StringBuilder builder = new StringBuilder();
		builder.append( "tail" );
		
		Node<V> curr = tail;
		while ( curr.prev != null )
		{
			curr = curr.prev;
			builder.append( " -> " + curr.value );
		}
		
		return builder.toString();
	}
}
