package se.hig.aod.maze.util;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundUtil
{
	public void playPopStackSound()
	{
		File soundFile = new File("pop.wav");
		AudioInputStream audioIn = null;
		Clip clip = null;
		try
		{
			audioIn = AudioSystem.getAudioInputStream(soundFile);
			clip = AudioSystem.getClip();
			clip.open(audioIn);
		} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e)
		{
			e.printStackTrace();
		}
		clip.start();
	}
}
