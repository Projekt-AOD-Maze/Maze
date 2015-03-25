package se.hig.aod.maze.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TileModelTest
{
	TileModel[][] testTiles;
	
	@Before
	public void setUp() throws Exception
	{
		testTiles = new TileModel[3][3];
		allBlack();
	}

	@Test
	public void test()
	{
		for (int x = 0; x < testTiles.length; x++)
		{
			TileModel[] tileModels = testTiles[x];
			for (int y = 0; y < tileModels.length; y++)
			{
				assertEquals(new Integer(x), new Integer(testTiles[x][y].getXPos()));
				assertEquals(new Integer(y), new Integer(testTiles[x][y].getYPos()));
			}
		}
	}
	
	private void allBlack()
	{
		for (int x = 0; x < testTiles.length; x++)
		{

			for (int y = 0; y < testTiles[x].length; y++)
			{
				TileModel tileModel = new TileModel(x,y,TileState.BLOCKED);
				
				
				testTiles[x][y] = tileModel;
			}
		}
	}

}
