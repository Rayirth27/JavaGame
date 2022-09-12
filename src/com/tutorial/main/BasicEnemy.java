package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject{

	private Handler handler;
	
	public BasicEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);

		this.handler = handler;
		
		velX = 5;
		velY = 5;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 16, 16);
	}
	
	public void tick() {
		x+= velX;
		y+= velY;
		

		if(y <= 0 || y >= Game.HEIGHT-32) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH-16 ) velX *= -1;/* helping the object to revert back 
								after it hits the ceiling by changing its sign*/												 
	
		handler.addObject(new Trail(x, y, ID.Trail, Color.red, 16, 16, 0.02f, handler));
		handler.addObject(new Trail(x, y, ID.Trail, Color.blue, 16, 16, 0.02f, handler));
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 16, 16);
	}

}
