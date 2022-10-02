package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
public class HUD {

	public static int HEALTH = 100;
	private int greenValue = 255; //red-green-blue(rgb) values go from (BLACK)0 to 255.
	
	public void tick() {
		HEALTH = Game.clamp( HEALTH, 0, 100);// SO THAT THE HEATH does not go beyond the meter
		greenValue = Game.clamp(greenValue, 0, 255);
		
		greenValue = HEALTH*2; 
	}
	
	public void render(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(15 , 15, 200, 32); 
		g.setColor(new Color(75, greenValue, 0));
		g.fillRect(15 , 15, HEALTH* 2, 32);
		g.setColor(Color.white);
		g.drawRect(15 , 15, 200, 32);
	}
}
