package se.hig.aod.maze.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JPanel;

import se.hig.aod.maze.models.MazeModel;
import se.hig.aod.maze.models.TileModel;

public class LabyrintView extends JPanel
{
	private static final long serialVersionUID = 1L;

	private MazeModel mazeModel;
	
	public LabyrintView(MazeModel mazeModel)
	{
		this.mazeModel = mazeModel;
		
		setPreferredSize(new Dimension(600,600));
		setBackground(Color.PINK);
		
		 setLayout(new GridLayout(MazeModel.SIZE,MazeModel.SIZE));
		 
		 update();
	}

	public void update()
	{
		System.out.println("I like to update my LabyrinthView");
		removeAll();
		TileModel[][] tiles = mazeModel.getTiles();
		
		for (int x = 0; x < tiles.length; x++)
		{

			for (int y = 0; y < tiles[x].length; y++)
			{
				add(tiles[x][y]);
			}
		}
		revalidate();
	}
	
}
