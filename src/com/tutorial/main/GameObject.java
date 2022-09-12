package com.tutorial.main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {	//player object and enemy object both are called as GameObject
	
	protected int x,y;
	protected ID id; // identity
	protected int velX, velY; // to control the speed in the X-direction and Y-direction

	public GameObject(int x, int y, ID id) {/* constructor for the GameObject, when we will create an instance of this class
												whatever we set on the parameter, it will set the same data in the following variables*/
		this.x= x;
		this.y= y;
		this.id = id;
	}
	
	public abstract void tick(); //
	public abstract void render(Graphics  g);
	public abstract Rectangle getBounds(); // handle all the collisions
	
	public void setX(int x) { /*we can change the x position by calling this set x value and whatever we
	  						 put in this parameter it will set the value of the class variable using( this.x)*/
							//USE OF getters-and-setters
			this.x = x;
	}
	public void setY(int y) {
	 	this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setId(ID id) {
		this.id= id;;
	}
	public ID getId() {
		return id;
	}
	public void setVelX(int velX){ 
		this.velX= velX;
	}
	public void setVelY(int velY) {
		this.velY= velY;
	}
	public int getVelX() {
		return velX;
	}
	public int getVelY() {
		return velY;
	}
}