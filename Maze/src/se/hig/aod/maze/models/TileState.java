package se.hig.aod.maze.models;

import java.awt.Color;

public enum TileState
{
	BLOCKED(Color.BLACK), VISITED(Color.BLUE), GOAL(Color.GREEN), START(Color.RED), PATH(Color.WHITE), SOLVED_PATH(Color.YELLOW);
	
	private Color color;
	
	private TileState(Color color)
	{
		this.color = color;
	}

	public Color getColor()
	{
		return color;
	}
	
};
