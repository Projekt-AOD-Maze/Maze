package se.hig.aod.maze.models;

import javax.swing.JPanel;

public class TileModel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private TileState state;
	
	private int xPos, yPos;

	public TileModel(int x, int y, TileState state)
	{
		super();
		setState(state);
		setXPos(x);
		setYPos(y);
	}

	

	public int getXPos()
	{
		return xPos;
	}



	public void setXPos(int xPos)
	{
		this.xPos = xPos;
	}



	public int getYPos()
	{
		return yPos;
	}



	public void setYPos(int yPos)
	{
		this.yPos = yPos;
	}



	public TileState getState()
	{
		return state;
	}

	public void setState(TileState state)
	{
		this.state = state;
		setBackground(state.getColor());
	}
	
}
