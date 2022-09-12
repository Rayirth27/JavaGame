package com.tutorial.main;

import java.awt.Color;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;
public class Game extends Canvas implements Runnable{  
	
	private static final long serialVersionUID = 1550691097823471818L;
	
	public static final int WIDTH= 640, HEIGHT=WIDTH/12*9;
	
	private Thread thread;
	private boolean running=false;
	
	private Random r;
	private Handler handler;
	private HUD hud;
	
	public Game() {
		
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler)); //tells the game "HEY we'll be sending keys so do LISTEN!"
		
		new Window(WIDTH, HEIGHT, "Ray's First Attempt!",this);
		
		hud = new HUD();
		//om mama 
		r = new Random();
		
		
		handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player, handler)); /*To create 
											the object in the GAME.. PLAY AROUND WITH THE VALUES*/
		for(int i =1; i <= 5; i++)
		handler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy, handler));
	
	}
	public synchronized void start() {
		thread =new Thread(this); 
		thread.start();
		running=true; //(HERE)running says that,is it running or NOT?, that is, is the Thread ON or NOT?
	}
	
	public synchronized void stop(){ // try and catch in brief work like if-else.. if its working (then in try) if not (then in catch)
		try{
			thread.join();// it is just killing off the thread it's stopping it
			running=false;
		}catch(Exception e) {
			e.printStackTrace();// Run and err bug and tell us why it couldn't produce a result
		}
	}
	public void run() { // Heartbeat Of the Game( GAME LOOP )
		this.requestFocus(); /* you don;t need to click on the program's screen to work on it
							as soon as the program runs the working of keyboard shifts 
								to the program*/
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() {
		handler.tick();
		hud.tick();
	}
	
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);

		hud.render(g);
		
		g.dispose();
		bs.show();
	}

	public static int clamp(int var, int min, int max) { /* So that the object(Player) 
															does not go beyond the screen
															IN SHORT IT IS A -
															STAY WITHIN THE LIMTS FUCTION!*/
		if(var >= max)
			return var = max;
		else
			if( var <= min)
				return var = min;
			else
				return var;
	}  

	public static void main(String args[]) {
		new Game();
	}
	}
