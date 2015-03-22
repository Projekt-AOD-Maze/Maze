package se.hig.aod.maze;

import se.hig.aod.maze.gui.MazeGUI;
import se.hig.aod.maze.models.MazeModel;

public class Maze
{

	public static void main(String[] args)
	{
		
		new Maze();
	}

	public Maze()
	{
		new MazeGUI(new MazeModel());
	}
	
	

}
