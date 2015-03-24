package se.hig.aod.maze.generation;

import se.hig.aod.maze.models.TileModel;
import se.hig.aod.maze.models.TileState;

public enum Direction
{
	LEFT((x, y,tiles) ->{
		
		System.out.println("LEFT");
		
		if(isNotTileValid(--x,y,tiles)) return false;
		if(isNotTileValid(--x,y,tiles)) return false;
		if(isNotTileValid(x,--y,tiles)) return false;
		if(isNotTileValid(x, y + 2,tiles)) return false;
		
		return true;
		
	}), UP((x, y,tiles) ->{
		
		System.out.println("UP");
		if(isNotTileValid(x,++y,tiles)) return false;
		if(isNotTileValid(x,++y,tiles)) return false;
		if(isNotTileValid(++x,y,tiles)) return false;
		if(isNotTileValid(x - 2, y,tiles)) return false;
		
		return true;
		
	}), RIGHT((x, y,tiles) ->{
		
		if(isNotTileValid(++x,y,tiles)) return false;
		if(isNotTileValid(++x,y,tiles)) return false;
		if(isNotTileValid(x,--y,tiles)) return false;
		if(isNotTileValid(x, y + 2,tiles)) return false;
		
		return true;
		
	}), DOWN((x, y,tiles) ->{
		
		if(isNotTileValid(x,--y,tiles)) return false;
		if(isNotTileValid(x,--y,tiles)) return false;
		if(isNotTileValid(++x,y,tiles)) return false;
		if(isNotTileValid(x - 2, y,tiles)) return false;
		return true;
		
	});
	
	static boolean isNotTileValid(int x , int y, TileModel[][] tiles)
	{	
		
		if(x >= tiles.length || y >=tiles[0].length) return true;
		if(x <= 0 || y <=0 ) return true;
		if(tiles[x][y].getState() != TileState.BLOCKED) return true;
		return false;
	}
	
	
	private DirectionCheck directionCheck;
	
	Direction(DirectionCheck directionCheck)
	{
		this.directionCheck = directionCheck;
	}
	
	public boolean isValid(int x, int y, TileModel[][] tiles)
	{
		return directionCheck.isValid(x, y, tiles);
	}
	
	interface DirectionCheck
	{
		boolean isValid(int x, int y, TileModel[][] tiles);
	}
}
