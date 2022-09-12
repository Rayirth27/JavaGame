/**
 * 
 */
package com.tutorial.main;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

class Window extends Canvas{
		
	private static final long serialVersionUID= -24084060533728354L;
	
	public Window(int width, int height, String title, Game game){
		JFrame frame= new JFrame(title); //Frame of our window
		
		frame.setPreferredSize(new Dimension(width, height));	//
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new  Dimension(width, height));
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cross button on the top-right corner
		frame.setResizable(false); //To resize the window
		frame.setLocationRelativeTo(null); //Usually the screen would start from top-ledt but since (HERE) its a NO(null) thus it will start from the middle
		frame.add(game); // here we are adding the Game class into our frame
		frame.setVisible(true); // TO actually see the frame
		game.start(); // calling the start method in the Game class
	}
}

