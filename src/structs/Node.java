package structs;

public class Node<V>
{
	V value;
	Node<V> prev;
	Node<V> next;
	
	public Node( V value )
	{
		this.value = value;
		next = null;
		prev = null;
	}
}
