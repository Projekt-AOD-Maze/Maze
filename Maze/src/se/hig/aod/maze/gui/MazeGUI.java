package se.hig.aod.maze.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import se.hig.aod.maze.models.MazeModel;
import se.hig.aod.maze.views.LabyrintView;

public class MazeGUI extends JFrame
{
	private MazeModel mazeModel;
	private JPanel mainPanel, topPanel;
	private LabyrintView labyrintView;
	private JButton generateButton, findPathButton;
	

	public MazeGUI(MazeModel mazeModel)
	{
		super("Amazing Maze");
		this.mazeModel = mazeModel;
		mainPanel = new JPanel();
		labyrintView = new LabyrintView();
		
		topPanel = new JPanel();
		generateButton = new JButton("Generate");
		findPathButton = new JButton("Find Path");
		topPanel.add(generateButton);
		topPanel.add(findPathButton);
		
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(labyrintView, BorderLayout.CENTER);
		
		getContentPane().add(mainPanel);
		setResizable(false);
		setSize(new Dimension(800,600));
		setLocationRelativeTo(null);
		setVisible(true);
		setObserver();
	}
	
	private void setObserver()
	{
		mazeModel.addObserver(new MazeObserver());
	}
	
	private class MazeObserver implements Observer
	{

		@Override
		public void update(Observable observable, Object message)
		{
			switch (message.toString())
			{
				case "repaint":
					
					labyrintView.repaint();
					
					break;

				default:
					break;
			}		
		}
		
	}
	
}
