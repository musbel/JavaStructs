package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import structs.LinkedList;
import structs.Node;

public class LinkedListTest
{
	LinkedList<String> list;
	Node<String> mazda;
	
	@Before
	public void setUp() throws Exception
	{
		list = new LinkedList<String>();
		
		list.add( "BMW" );
		list.add( "Mercedes" );
		list.add( "Porsche" );
		mazda = list.add( "Mazda" );
		list.add( "Ford" );		

		System.out.println( list.toString() );
		System.out.println( list.toStringReverse() );
}
	
	@Test
	public void testSize()
	{		
		assertEquals( 5, list.size() );
	}
	
	@Test
	public void testFind()
	{
		assertNotNull( list.find( "Ford" ) );
		assertNotNull( list.find( "Mazda" ) );
		assertNull( list.find( "Jaguar" ) );
	}
	
	@Test
	public void testRemove()
	{
		list.remove( mazda );
		list.remove( "Ford" );
		System.out.println( list.toString() );
		
		assertNull( list.find( "Mazda" ) );
		assertNull( list.find( "Ford" ) );
		assertNotNull( list.find( "Porsche" ) );
		
		assertEquals( 3, list.size() );
		
		list.clear();
		assertEquals( 0, list.size() );
	}
	
	@Test
	public void testClear()
	{
		list.clear();
		assertEquals( 0, list.size() );
	}
}
