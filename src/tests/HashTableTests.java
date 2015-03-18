package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import structs.HashTable;

public class HashTableTests
{
	private HashTable<String, String> table;
	
	@Before
	public void setUp() throws Exception
	{
		table = new HashTable<String, String>( 5 );
		
		table.add( "Ricky", "Gervais" );
		table.add( "Ted", "Dansen" );
		table.add( "Bruce", "Willis" );
		table.add( "Tom", "Hanks" );
		table.add( "Karl", "Pilkington" );
		table.add( "Jerry", "Seinfeld" );
		table.add( "Adam", "Sandler" );
		
		System.out.println( table.toString() );
	}

	@Test
	public void test()
	{
		assertEquals( "Gervais", table.get( "Ricky" ) );
		assertEquals( "Willis", table.get( "Bruce" ) );
		assertEquals( "Dansen", table.get( "Ted" ) );
		assertEquals( "Hanks", table.get( "Tom" ) );
		assertNull( table.get( "Tod" ) );
		
		assertTrue( table.remove( "Ted" ) );
		assertNull( table.get( "Ted" ) );
		
		System.out.println( table.toString() );
	}

}
