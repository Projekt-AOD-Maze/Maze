package se.hig.aod.maze.models;

import javax.swing.JPanel;

public class TileModel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private TileState state;

	public TileModel(TileState state)
	{
		super();
		setState(state);
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
