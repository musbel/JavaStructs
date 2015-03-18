package structs;

public class HashNode<K,V>
{
	K key;
	V value;
	HashNode<K,V> next;
	int hash;
	
	HashNode( K key, V value, HashNode<K,V> next, int hash )
	{
		this.key = key;
		this.value = value;
		this.next = next;
		this.hash = hash;
	}
}
