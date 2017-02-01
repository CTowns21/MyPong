//Name -
//Date -
//Class -
//Lab  - 

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Block leftGoal;
	private Block rightGoal;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private boolean[] keys;
	private BufferedImage back;
	private String leftScore;
	private String rightScore;
	private int rScore = 0;
	private int lScore = 0;

	public Pong()
	{
		leftGoal = new Block(10,175,10,150,Color.RED);
		rightGoal = new Block(750,175,10,150,Color.RED);
		ball = new Ball();
		leftPaddle = new Paddle(10,200);
		rightPaddle = new Paddle(700,200);

		keys = new boolean[8];

    
    	setBackground(Color.WHITE);
		setVisible(true);
		
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	
   public void update(Graphics window){
	   paint(window);
   }

   public void paint(Graphics window)
   {
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		leftScore = "Left Paddle = " + lScore;
		rightScore = "Right Paddle = " + rScore;
		
		graphToBack.drawString(leftScore, 10, 10);
		graphToBack.drawString(rightScore, 650, 10);
		

		if(ball.didCollideLeft(leftGoal))
		{
			graphToBack.setColor(Color.WHITE);
			rightScore = "Right Paddle = " + rScore;
			graphToBack.drawString(rightScore, 650, 10);
			rScore ++;
			ball.setPos(graphToBack, 375, 300);
			rightScore = "Right Paddle = " + rScore;
			graphToBack.drawString(rightScore, 650, 10);
		}
		if(ball.didCollideRight(rightGoal))
		{
			graphToBack.setColor(Color.WHITE);
			leftScore = "Left Paddle = " + lScore;
			graphToBack.drawString(leftScore, 10, 10);
			lScore ++;
			ball.setPos(graphToBack, 375, 300);
			leftScore = "Left Paddle = " + lScore;
			graphToBack.drawString(leftScore, 10, 10);
		}
		
		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);	
		leftGoal.draw(graphToBack);
		rightGoal.draw(graphToBack);

		
		//see if the ball hits the top or bottom wall 
		if(!(ball.getY()>=10 && ball.getY()+ball.getHeight()<=580))
		{
			ball.setYSpeed(ball.getYSpeed()*-1);
		}



		//see if the ball hits the left paddle
		if((ball.didCollideLeft(leftPaddle))||(ball.didCollideRight(rightPaddle))||(ball.getX()<=0)||(ball.getX()>=800-ball.getWidth()))
		{
			ball.setXSpeed(ball.getXSpeed()*-1);
		}
		
		
		
		if(ball.didCollideTop(rightPaddle)||ball.didCollideTop(leftPaddle)||ball.didCollideBottom(rightPaddle)||ball.didCollideBottom(leftPaddle))
		{
			ball.setYSpeed(ball.getYSpeed()*-1);
		}
		
		


		//see if the paddles need to be moved
		if(keys[0] == true)
		{
			leftPaddle.moveUpAndDraw(graphToBack);
		}
		if(keys[1] == true)
		{
			leftPaddle.moveDownAndDraw(graphToBack);

		}
		if(keys[2] == true)
		{
			rightPaddle.moveUpAndDraw(graphToBack);
		}
		if(keys[3] == true)
		{
			rightPaddle.moveDownAndDraw(graphToBack);
		}
		if(keys[4] == true)
		{
			leftPaddle.moveLeftAndDraw(graphToBack);
		}
		if(keys[5] == true)
		{
			leftPaddle.moveRightAndDraw(graphToBack);
		}
		if(keys[6] == true)
		{
			rightPaddle.moveLeftAndDraw(graphToBack);
		}
		if(keys[7] == true)
		{
			rightPaddle.moveRightAndDraw(graphToBack);
		}
		
		
		
		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'S' : keys[1]=true; break;
			case 'I' : keys[2]=true; break;
			case 'K' : keys[3]=true; break;
			case 'A' : keys[4]=true; break;
			case 'D' : keys[5]=true; break;
			case 'J' : keys[6]=true; break;
			case 'L' : keys[7]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'S' : keys[1]=false; break;
			case 'I' : keys[2]=false; break;
			case 'K' : keys[3]=false; break;
			case 'A' : keys[4]=false; break;
			case 'D' : keys[5]=false; break;
			case 'J' : keys[6]=false; break;
			case 'L' : keys[7]=false; break;
		}
	}

	public void keyTyped(KeyEvent e){}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}	
}