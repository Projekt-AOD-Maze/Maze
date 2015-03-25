package se.hig.aod.maze.models;

import java.util.Observable;

import javax.swing.JLabel;

public class MazeModel extends Observable
{
	private TileModel[][] tiles;
	public static final int SIZE = 20;
	
	
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
				TileModel tileModel = new TileModel(TileState.BLOCKED);
				
//				tileModel.add(new JLabel(x + "," + y));
				
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
