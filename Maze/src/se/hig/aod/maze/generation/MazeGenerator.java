package se.hig.aod.maze.generation;

import java.util.Collections;
import java.util.Random;
import java.util.Stack;

import se.hig.aod.maze.models.TileModel;
import se.hig.aod.maze.models.TileState;

public class MazeGenerator implements Runnable
{
	private TileModel[][] tiles;
	private int startX, startY;
	private Random random = new Random();
	private boolean pause, stop;
	TileModel currentCell;
	Direction currentDirection;
	Stack<TileModel> stack;

	public MazeGenerator(int startX, int startY, TileModel[][] tiles)
	{
		super();
		this.tiles = tiles;
		this.startX = startX;
		this.startY = startY;
		pause = true;
		currentCell = tiles[startX][startY];

		stack = new Stack<TileModel>();
	}

	@Override
	public void run()
	{
		while (true)
		{
			if (!stop)
			{
				// checkNext(startX, startY);
				stackBasedNext();
				tiles[startX][startY].setState(TileState.GOAL);
				stop = true;
				stack = new Stack<TileModel>();
			}
			
			currentCell = tiles[startX][startY];
			sleep(250);
		}

	}

	private void stackBasedNext()
	{
		while (pause)
		{
			sleep(50);
		}
		if (stop)
			return;

		System.out.println(currentCell.getXPos() + "," + currentCell.getYPos());
		currentCell.setState(TileState.VISITED);
		boolean wayFound = false;
		Direction[] directions = ShuffleArray(Direction.values());
		for (int i = 0; i < directions.length; i++)
		{
			if (stop)
				return;
			if (directions[i].isValid(currentCell.getXPos(), currentCell.getYPos(), tiles))
			{
				currentDirection = directions[i];
				wayFound = true;
				break;
			}
		}

		sleep(10);
		if (wayFound)
		{
			stack.push(currentCell);
			currentCell = getTileFromDirection(currentDirection);
			stackBasedNext();
		}
		else if(!stack.isEmpty())
		{
			currentCell.setState(TileState.PATH);
			currentCell = stack.pop();
			stackBasedNext();
		}else{
			System.out.println("done");
		}
	}

	private TileModel getTileFromDirection(Direction direction)
	{
		switch (direction)
		{
			case DOWN:
				return tiles[currentCell.getXPos()][currentCell.getYPos() + 1];
			case LEFT:
				return tiles[currentCell.getXPos() - 1][currentCell.getYPos()];
			case UP:
				return tiles[currentCell.getXPos()][currentCell.getYPos() - 1];
			case RIGHT:
				return tiles[currentCell.getXPos() + 1][currentCell.getYPos()];

		}
		return null;
	}

	private void checkNext(int x, int y)
	{

		// while(pause)
		// {
		// sleep(50);
		// }
		// if(stop)return;
		//
		// tiles[x][y].setState(TileState.VISITED);
		// sleep(50);
		// Direction [] directions = ShuffleArray(Direction.values());
		// for (int i = 0; i < directions.length; i++)
		// {
		// if(stop)return;
		// if(directions[i].isValid(x, y, tiles))
		// {
		// switch (directions[i])
		// {
		// case DOWN:
		// y++;
		// break;
		// case LEFT:
		// x--;
		// break;
		// case UP:
		// y--;
		// break;
		// case RIGHT:
		// x++;
		// break;
		//
		// default:
		// break;
		// }
		// System.out.println(x+ "," + y);
		// checkNext(x , y);
		// }
		//
		// }
		//
		// sleep(50);
		// tiles[x][y].setState(TileState.PATH);
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
