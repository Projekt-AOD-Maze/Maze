package se.hig.aod.maze.generation;

import java.util.Collections;
import java.util.Random;

import se.hig.aod.maze.models.TileModel;
import se.hig.aod.maze.models.TileState;

public class MazeGenerator implements Runnable
{
	private TileModel[][] tiles;
	private int startX, startY;
	private Random random = new Random();
	
	
	
	public MazeGenerator(int startX, int startY, TileModel[][] tiles)
	{
		super();
		this.tiles = tiles;
		this.startX = startX;
		this.startY = startY;
		
		

		
	}


	@Override
	public void run()
	{
		checkNext(startX, startY);
		
		tiles[startX][startY].setState(TileState.GOAL);
		
	}

	private void checkNext(int x , int y)
	{
		try
		{
			Thread.sleep(50);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		tiles[x][y].setState(TileState.VISITED);
		Direction [] directions = ShuffleArray(Direction.values());
		for (int i = 0; i < directions.length; i++)
		{
			if(directions[i].isValid(x, y, tiles))
			{
				switch (directions[i])
				{
					case DOWN:
							y--;
						break;
					case LEFT:
							x--;
						break;
					case UP:
							y++;
						break;
					case RIGHT:
							x++;
						break;

					default:
						break;
				}
				System.out.println(x+ "," + y);
				checkNext(x , y);
			}
			
		}
		tiles[x][y].setState(TileState.PATH);
	}
	
	private Direction[] ShuffleArray(Direction[] array)
	{
	    int index;
	    Direction temp;
	    for (int i = array.length - 1; i > 0; i--)
	    {
	        index = random.nextInt(i + 1);
	        temp = array[index];
	        array[index] = array[i];
	        array[i] = temp;
	    }
	    return array;
	}




}
