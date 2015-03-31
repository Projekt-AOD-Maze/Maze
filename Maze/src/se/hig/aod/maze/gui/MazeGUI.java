package se.hig.aod.maze.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import se.hig.aod.maze.models.MazeModel;
import se.hig.aod.maze.views.LabyrintView;

public class MazeGUI extends JFrame
{
	private MazeModel mazeModel;
	private JPanel topPanel;
	private LabyrintView labyrintView;
	private JButton generateButton, findPathButton, clearButton;
	

	public MazeGUI(MazeModel mazeModel)
	{
		super("Amazing Maze");
		this.mazeModel = mazeModel;
		labyrintView = new LabyrintView(mazeModel);
		
		topPanel = new JPanel();
		generateButton = new JButton("Generate");
		findPathButton = new JButton("Find Path");
		clearButton = new JButton("Clear");
		topPanel.add(generateButton);
		topPanel.add(findPathButton);
		topPanel.add(clearButton);
		
		setLayout(new BorderLayout());
		getContentPane().add(topPanel, BorderLayout.PAGE_START);
		getContentPane().add(labyrintView, BorderLayout.CENTER);
		
		pack();
		setResizable(false);
		
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
			System.out.println("UPDATE OBSERVER");
			switch (message.toString())
			{
				case "update":
					
					labyrintView.update();
					
					break;

				default:
					break;
			}		
		}
	}
	
	public void setWindowListener(WindowAdapter adapter)
	{
		addWindowListener(adapter);
	}
	
	public void setGenerateButtonLabel(String label)
	{
		generateButton.setText(label);
	}

	public void setGenerateLabyrinthListener(AbstractAction generateLabyrinthListener)
	{
		generateButton.addActionListener(generateLabyrinthListener);
	}

	public void setFindPathListener(AbstractAction findPathListener)
	{
		findPathButton.addActionListener(findPathListener);
		
	}
	
	public void setClearListener(AbstractAction clearListener)
	{
		clearButton.addActionListener(clearListener);
		
	}

	
}
