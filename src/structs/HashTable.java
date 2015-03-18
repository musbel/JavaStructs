package structs;

import structs.HashNode;

public class HashTable<K,V>
{
	private HashNode<K,V>[] entries;
	private int hashSize;
	
	@SuppressWarnings( "unchecked" )
	public HashTable( int hashSize )
	{
		this.hashSize = hashSize;
		entries = new HashNode[hashSize];
	}
	
	private int getIndex( K key )
	{
		return key.hashCode() % hashSize;
	}
	
	public void add( K key, V value )
	{
		int hash = getIndex( key );
		HashNode<K,V> entry = new HashNode<K,V>( key, value, entries[hash], hash );
		entries[hash] = entry;
	}
	
	public V get( K key )
	{
		int hash = getIndex( key );
		
		for ( HashNode<K,V> entry = entries[hash]; entry != null; entry = entry.next )
		{
			if ( entry.key == key )
			{
				return entry.value;
			}
		}
		
		return null;
	}
	
	public boolean remove( K key )
	{
		int hash = getIndex( key );
		HashNode<K,V> prev = null;
		
		for ( HashNode<K,V> entry = entries[hash]; entry != null; entry = entry.next )
		{
			if ( entry.hash == hash && entry.key == key )
			{
				if ( prev != null )
				{
					prev.next = entry.next;
				}
				else
				{
					entries[hash] = entry.next;
				}
				
				return true;
			}
			
			prev = entry;
		}
		
		
		
		return false;
	}
	
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		
		for ( int i = 0; i < hashSize; ++i )
		{
			builder.append( "Hash[" + i + "]\n" );
			for ( HashNode<K,V> entry = entries[i]; entry != null; entry = entry.next )
			{
				builder.append( " - key[" + entry.key + "] = " + entry.value + "\n" );
			}
		}
		
		return builder.toString();
	}
}
