package se.hig.aod.maze.controllers;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import se.hig.aod.maze.generation.MazeGenerator;
import se.hig.aod.maze.gui.MazeGUI;
import se.hig.aod.maze.models.MazeModel;

public class MazeController
{
	private MazeModel mazeModel;
	private MazeGUI mazeGUI;
	
	public MazeController(MazeModel mazeModel, MazeGUI mazeGUI)
	{
		super();
		this.mazeModel = mazeModel;
		this.mazeGUI = mazeGUI;
		
		setListeners();
		
	}
	
	public void setListeners()
	{
		mazeGUI.setGenerateLabyrinthListener(new GenerateLabyrinthListener());
		mazeGUI.setFindPathListener(new FindPathListener());
		mazeGUI.setClearListener(new ClearListener());
	}
	
	private class GenerateLabyrinthListener extends AbstractAction
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			
			System.out.println("Generate Labyrinth");
			
			new Thread(new MazeGenerator(12, 12, mazeModel.getTiles())).start();
		}
		
	}
	private class FindPathListener extends AbstractAction
	{
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Find Path");
		}
		
	}
	private class ClearListener extends AbstractAction
	{
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Clear");
			
		}
		
	}
	
}
