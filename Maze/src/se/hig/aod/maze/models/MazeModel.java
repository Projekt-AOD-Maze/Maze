package se.hig.aod.maze.models;

import java.util.Observable;

import javax.swing.JLabel;

public class MazeModel extends Observable
{
	private TileModel[][] tiles;
	
	
	
	public MazeModel()
	{
		
		int size = 50;
		
		tiles = new TileModel[size][size];
		resetLabyrinth();
		
	}



	public void updateLabyrinth(String message)
	{
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
		
//			tiles[24][24].setState(TileState.GOAL);
//		for (int i = 0; i < tiles.length; i++)
//		{
//			tiles[4][i].setState(TileState.GOAL);
//			
//		}
//		tiles[3][8].setState(TileState.GOAL);
//		tiles[5][8].setState(TileState.GOAL);
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
