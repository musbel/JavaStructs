package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import structs.BinarySearchTree;

public class BinaryTreeTests
{
	BinarySearchTree<Integer> tree;
	
	@Before
	public void setUp() throws Exception
	{
		tree = new BinarySearchTree<Integer>();
		
		tree.add( 4 );
		tree.add( 2 );
		tree.add( 7 );
		tree.add( 9 );
		tree.add( 8 );
		tree.add( 3 );
		tree.add( 12 );
		tree.add( 6 );
		
		tree.printInOrder();
	}
	
	@Test
	public void testSize()
	{
		assertEquals( 8, tree.size() );
	}

	@Test
	public void testMinDepth()
	{
		assertEquals( 2, tree.minDepth( tree.getRoot() ) );
	}
	
	@Test
	public void testMaxDepth()
	{
		assertEquals( 3, tree.maxDepth( tree.getRoot() ) );
	}
	
	@Test
	public void testIsBalanced()
	{
		assertTrue( tree.isBalanced() );
	}
	
	@Test
	public void testLeftMost()
	{
		assertEquals( 2, tree.leftMostNode( tree.getRoot() ).getValue().intValue() );
	}
	
	@Test
	public void testRightMost()
	{
		assertEquals( 12, tree.rightMostNode( tree.getRoot() ).getValue().intValue() );
	}

	@Test
	public void testIsBst()
	{
		assertTrue( tree.isBst( tree.getRoot() ) );
	}
}
