package com.tutorial.main;
import java.util.Random;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;
public class Player extends GameObject{

	Random r = new Random(); 
	Handler handler;
	
	public Player(int x, int y, ID id, Handler handler ) {
		super(x, y, id);
		this.handler = handler;
		
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		x= Game.clamp(x, 0, Game.WIDTH - 45); // So that the object(Player) does not go beyond the screen
		y= Game.clamp(y, 0, Game.HEIGHT - 70);
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.yellow, 32, 32, 0.05f, handler));
		
		collision();
		
	}

	private void collision() {  //HEALTH METER
		for(int i = 0; i < handler.object.size(); i++) {
			// LOOP running through all the objects in the game
			
			GameObject tempObject = handler.object.get(i);/* this temporary object is getting 
															each instance of OUR FOR-LOOP*/ 
			
			if(tempObject.getId() == ID.BasicEnemy){
				if(getBounds().intersects(tempObject.getBounds())) {
			/*getBounds = OUR PLAYER(Rectangle) intersects with the (getBounds of enemy object)*/
					
			//collision code
					HUD.HEALTH -=2;
					
				}
			}
			
		}
	}

	public void render(Graphics g) {
	    g.setColor(Color.black);
		g.fillRect(x, y, 32, 32);
	}
	
	
}
