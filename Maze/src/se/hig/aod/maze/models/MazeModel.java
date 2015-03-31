package se.hig.aod.maze.models;

import java.util.Observable;

public class MazeModel extends Observable
{
	private TileModel[][] tiles;
	public static final int SIZE = 50;
	
	
	public MazeModel()
	{
		
		tiles = new TileModel[SIZE][SIZE];
		resetLabyrinth();
	}

	public void updateLabyrinth(String message)
	{
		setChanged();
		notifyObservers(message);
	}
	
	public void resetLabyrinth()
	{
		for (int x = 0; x < tiles.length; x++)
		{

			for (int y = 0; y < tiles[x].length; y++)
			{
				TileModel tileModel = new TileModel(x,y,TileState.BLOCKED);
				tiles[x][y] = tileModel;
			}
		}
		updateLabyrinth("update");
	}



	public TileModel[][] getTiles()
	{
		return tiles;
	}



	public void setTiles(TileModel[][] tiles)
	{
		this.tiles = tiles;
	}
	
	

}
