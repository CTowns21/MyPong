//Name - Carson Towns
//Date - 1/30/17
//Class - CompSci2
//Lab  - Pong

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

public class PaddleTestTwo extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private boolean[] keys;	

	public PaddleTestTwo()
	{
		//set up all game variables


		ball = new Ball();
		
		
		
		leftPaddle = new Paddle(10,200);
		
		
		
		
		rightPaddle = new Paddle(700,200);
		
		
		


		keys = new boolean[5];


		setBackground(Color.WHITE);
		setVisible(true);

		this.addKeyListener(this);
		new Thread(this).start();
	}
	
	public void update(Graphics window)
	{
		paint(window);
	}

	public void paint(Graphics window)
	{
		ball.moveAndDraw(window);
		leftPaddle.draw(window);
		rightPaddle.draw(window);

		if(!(ball.getX()>=10 && ball.getX()<=735))
		{
			ball.setXSpeed(-ball.getXSpeed());
		}

		if(!(ball.getY()>=10 && ball.getY()<=510))
		{
			ball.setYSpeed(-ball.getYSpeed());
		}

		if(keys[0] == true)
		{
			leftPaddle.moveUpAndDraw(window);
		}
		if(keys[1] == true)
		{
			leftPaddle.moveDownAndDraw(window);

		}
		if(keys[2] == true)
		{
			rightPaddle.moveUpAndDraw(window);
		}
		if(keys[3] == true)
		{
			rightPaddle.moveDownAndDraw(window);
		}
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'Z' : keys[1]=true; break;
			case 'I' : keys[2]=true; break;
			case 'M' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'Z' : keys[1]=false; break;
			case 'I' : keys[2]=false; break;
			case 'M' : keys[3]=false; break;
		}
	}

	public void keyTyped(KeyEvent e)
	{
		
	}
	
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