package se.hig.aod.maze.models;

import java.util.Observable;

public class MazeModel extends Observable
{
	
	public void updateLabyrinth(String message)
	{
		notifyObservers(message);
	}

}
