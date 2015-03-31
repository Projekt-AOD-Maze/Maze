package se.hig.aod.maze.generation;

import java.util.Random;
import java.util.Stack;

import se.hig.aod.maze.models.TileModel;
import se.hig.aod.maze.models.TileState;
import se.hig.aod.maze.util.SoundUtil;

public class MazeGenerator implements Runnable
{
	private TileModel[][] tiles;
	private int startX, startY;
	private Random random = new Random();
	private boolean pause, stop;
	private boolean active = true;
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
		while (active)
		{
			if (!stop)
			{
				findPath();
				stop = true;
				stack = new Stack<TileModel>();
			}
			currentCell = tiles[startX][startY];
			sleep(250);
		}

	}

	private void findPath()
	{
		while (pause)
			sleep(50);

		if (stop)
			return;

		currentCell.setState(TileState.VISITED);
		boolean wayFound = false;
		Direction[] directions = shuffleArray(Direction.values());
		for (int i = 0; i < directions.length; i++)
		{
			if (stop)
				return;
			if (directions[i].isValid(currentCell.getXPos(), currentCell.getYPos(), tiles))
			{
				sleep(25);
				currentDirection = directions[i];
				wayFound = true;
				break;
			}
		}

		if (wayFound)
		{
			stack.push(currentCell);
			currentCell = getTileFromDirection(currentDirection);
			findPath();
		}
		else if(!stack.isEmpty())
		{
			currentCell.setState(TileState.PATH);
			currentCell = stack.pop();
			new SoundUtil().playPopStackSound();
			findPath();
		}

		else
			tiles[startX][startY].setState(TileState.GOAL);
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

	private Direction[] shuffleArray(Direction[] array)
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
		currentCell = tiles[startX][startY];
		currentCell.setState(TileState.BLOCKED);
	}

	public void setActive(boolean active)
	{
		stop = true;
		pause = false;
		this.active = active;
	}


}
