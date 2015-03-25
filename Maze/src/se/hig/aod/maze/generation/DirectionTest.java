package se.hig.aod.maze.generation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import se.hig.aod.maze.models.TileModel;
import se.hig.aod.maze.models.TileState;

public class DirectionTest
{
	TileModel[][] testTiles;
	
	@Before
	public void setUp() throws Exception
	{
		testTiles = new TileModel[3][3];
		allBlack();
	}

	@Test
	public void testIsNotValid()
	{
		assertFalse(Direction.isNotTileValid(0, 0, testTiles));
		assertFalse(Direction.isNotTileValid(2, 2, testTiles));
		
		assertTrue(Direction.isNotTileValid(3, 2, testTiles));
		assertTrue(Direction.isNotTileValid(2, 3, testTiles));
		assertTrue(Direction.isNotTileValid(-1, 2, testTiles));
		assertTrue(Direction.isNotTileValid(1, -1, testTiles));
	}
	
	@Test
	public void testLeft()
	{
		assertTrue(Direction.LEFT.isValid(2, 1, testTiles));
		
		testTiles[0][0].setState(TileState.PATH);;
		assertFalse(Direction.LEFT.isValid(2, 1, testTiles));
		allBlack();
		
		testTiles[1][0].setState(TileState.PATH);;
		assertFalse(Direction.LEFT.isValid(2, 1, testTiles));
		allBlack();
		
		testTiles[0][1].setState(TileState.PATH);;
		assertFalse(Direction.LEFT.isValid(2, 1, testTiles));
		allBlack();
		
		testTiles[1][1].setState(TileState.PATH);;
		assertFalse(Direction.LEFT.isValid(2, 1, testTiles));
		allBlack();
		
		testTiles[0][2].setState(TileState.PATH);;
		assertFalse(Direction.LEFT.isValid(2, 1, testTiles));
		allBlack();
		
		testTiles[1][2].setState(TileState.PATH);;
		assertFalse(Direction.LEFT.isValid(2, 1, testTiles));
		allBlack();
		
	}
	
	@Test
	public void testUp()
	{
		assertTrue(Direction.UP.isValid(1, 2, testTiles));
		
		testTiles[0][0].setState(TileState.PATH);;
		assertFalse(Direction.UP.isValid(1, 2, testTiles));
		allBlack();
		testTiles[1][0].setState(TileState.PATH);;
		assertFalse(Direction.UP.isValid(1, 2, testTiles));
		allBlack();
		testTiles[2][0].setState(TileState.PATH);;
		assertFalse(Direction.UP.isValid(1, 2, testTiles));
		allBlack();
		testTiles[0][1].setState(TileState.PATH);;
		assertFalse(Direction.UP.isValid(1, 2, testTiles));
		allBlack();
		testTiles[1][1].setState(TileState.PATH);;
		assertFalse(Direction.UP.isValid(1, 2, testTiles));
		allBlack();
		testTiles[2][1].setState(TileState.PATH);;
		assertFalse(Direction.UP.isValid(1, 2, testTiles));
		allBlack();

		
	}
	
	@Test
	public void testRight()
	{
		assertTrue(Direction.RIGHT.isValid(0, 1, testTiles));
		
		testTiles[2][0].setState(TileState.PATH);;
		assertFalse(Direction.RIGHT.isValid(0, 1, testTiles));
		allBlack();		
		testTiles[2][1].setState(TileState.PATH);;
		assertFalse(Direction.RIGHT.isValid(0, 1, testTiles));
		allBlack();		
		testTiles[2][2].setState(TileState.PATH);;
		assertFalse(Direction.RIGHT.isValid(0, 1, testTiles));
		allBlack();		
		testTiles[1][0].setState(TileState.PATH);;
		assertFalse(Direction.RIGHT.isValid(0, 1, testTiles));
		allBlack();		
		testTiles[1][1].setState(TileState.PATH);;
		assertFalse(Direction.RIGHT.isValid(0, 1, testTiles));
		allBlack();		
		testTiles[1][2].setState(TileState.PATH);;
		assertFalse(Direction.RIGHT.isValid(0, 1, testTiles));
		allBlack();		
		
	}
	
	@Test
	public void testDown()
	{
		assertTrue(Direction.DOWN.isValid(1, 0, testTiles));
		
		testTiles[0][2].setState(TileState.PATH);;
		assertFalse(Direction.DOWN.isValid(1, 0, testTiles));
		allBlack();			
		testTiles[1][2].setState(TileState.PATH);;
		assertFalse(Direction.DOWN.isValid(1, 0, testTiles));
		allBlack();			
		testTiles[2][2].setState(TileState.PATH);;
		assertFalse(Direction.DOWN.isValid(1, 0, testTiles));
		allBlack();			
		testTiles[0][1].setState(TileState.PATH);;
		assertFalse(Direction.DOWN.isValid(1, 0, testTiles));
		allBlack();			
		testTiles[1][1].setState(TileState.PATH);;
		assertFalse(Direction.DOWN.isValid(1, 0, testTiles));
		allBlack();			
		testTiles[2][1].setState(TileState.PATH);;
		assertFalse(Direction.DOWN.isValid(1, 0, testTiles));
		allBlack();			
		
	}
	
	private void allBlack()
	{
		for (int x = 0; x < testTiles.length; x++)
		{

			for (int y = 0; y < testTiles[x].length; y++)
			{
				TileModel tileModel = new TileModel(TileState.BLOCKED);
				
				
				testTiles[x][y] = tileModel;
			}
		}
	}

}
