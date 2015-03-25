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
	private boolean pause, stop;
	
	
	
	public MazeGenerator(int startX, int startY, TileModel[][] tiles)
	{
		super();
		this.tiles = tiles;
		this.startX = startX;
		this.startY = startY;
		pause = true;
	}


	@Override
	public void run()
	{
		while (true)
		{
			if(!stop)
			{
				checkNext(startX, startY);
				tiles[startX][startY].setState(TileState.GOAL);	
			}
			
			
			sleep(250);
		}
		
		
	}

	private void checkNext(int x , int y)
	{
		while(pause)
		{
			sleep(50);
		}
		if(stop)return;
		
		tiles[x][y].setState(TileState.VISITED);
		sleep(50);
		Direction [] directions = ShuffleArray(Direction.values());
		for (int i = 0; i < directions.length; i++)
		{
			if(stop)return;
			if(directions[i].isValid(x, y, tiles))
			{
				switch (directions[i])
				{
					case DOWN:
							y++;
						break;
					case LEFT:
							x--;
						break;
					case UP:
							y--;
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

		sleep(50);
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
	
	private void sleep(int ms)
	{
		try
		{
			Thread.sleep(ms);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}


	public boolean isPause()
	{
		return pause;
	}


	public void setPause(boolean pause)
	{
		this.pause = pause;
	}


	public boolean isStop()
	{
		return stop;
	}


	public void setStop(boolean stop)
	{
		this.stop = stop;
	}




}
