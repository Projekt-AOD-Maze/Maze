package se.hig.aod.maze.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import javax.swing.AbstractAction;
import se.hig.aod.maze.generation.MazeGenerator;
import se.hig.aod.maze.gui.MazeGUI;
import se.hig.aod.maze.models.MazeModel;

public class MazeController
{
	private MazeModel mazeModel;
	private MazeGUI mazeGUI;
	private MazeGenerator generator; 
	private Thread thread;
	private ButtonStrategy buttonStrategy;
	
	public MazeController(MazeModel mazeModel, MazeGUI mazeGUI)
	{
		super();
		this.mazeModel = mazeModel;
		this.mazeGUI = mazeGUI;
		generator = new MazeGenerator(12, 12, mazeModel.getTiles());
		thread = new Thread(generator);
		thread.start();
		setListeners();
		buttonStrategy = new GenerateStrategy();
		
	}
	
	public void setListeners()
	{
		mazeGUI.setGenerateLabyrinthListener(new GenerateLabyrinthListener());
		mazeGUI.setFindPathListener(new FindPathListener());
		mazeGUI.setClearListener(new ClearListener());
		mazeGUI.setWindowListener(new OnExitListener());
	}
	
	private class GenerateLabyrinthListener extends AbstractAction
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			
			System.out.println("Generate Labyrinth");
			
			
			buttonStrategy.execute(generator, mazeGUI, MazeController.this);
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
			mazeGUI.setGenerateButtonLabel("Generate");
			buttonStrategy = new GenerateStrategy();
			
			generator.setStop(true);
			generator.setPause(false);
			mazeModel.resetLabyrinth();
			
			
			
		}
		
	}
	
	private class PlayStrategy implements ButtonStrategy
	{	
		@Override
		public void execute(MazeGenerator generator, MazeGUI gui, MazeController controller)
		{
			generator.setPause(false);
			gui.setGenerateButtonLabel("Pause");
			buttonStrategy = new PauseStrategy();
			
		}
		
	}
	private class PauseStrategy implements ButtonStrategy
	{	
		@Override
		public void execute(MazeGenerator generator, MazeGUI gui, MazeController controller)
		{
			System.out.println("Pause");
			generator.setPause(true);
			gui.setGenerateButtonLabel("Play");
			buttonStrategy = new PlayStrategy();
			
		}
		
	}
	private class GenerateStrategy implements ButtonStrategy
	{	
		@Override
		public void execute(MazeGenerator generator, MazeGUI gui, MazeController controller)
		{
			System.out.println("Generate");
			generator.setPause(false);
			generator.setStop(false);
			gui.setGenerateButtonLabel("Pause");
			buttonStrategy = new PauseStrategy();
			
		}
	}

	private class OnExitListener extends WindowAdapter
	{
		@Override
    public void windowClosing(WindowEvent arg0)
    {
			generator.setActive(false);
    }
	}
	
	private interface ButtonStrategy
	{
		void execute(MazeGenerator generator, MazeGUI gui, MazeController controller);

	}
	
}
