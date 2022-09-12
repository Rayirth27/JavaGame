package com.tutorial.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {	/*maintain all the objects in the room... to process each of the objects in the screen individually
						and render them on the screen*/
	
	LinkedList<GameObject> object = new LinkedList<GameObject>(); /* to create list of our game objects from our GAME,
	 															because we don't know how many game objects we're going to have.*/
	public void tick()
	{
		for(int i=0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);/* resetting our temporary object to "object.get()"--[which is a function in 
													LinkedList to get the object in the list at the index "i" ]  */
			 tempObject.tick();
			
		}
		  
	}
	
	public void render(Graphics g)
	{
		for(int i=0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
	}
}
	public void addObject(GameObject object) { /* To add the objects to the list*/
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {/* To remove the objects from the list*/
		this.object.remove(object);
	}
	}