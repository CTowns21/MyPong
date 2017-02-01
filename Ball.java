//Name - Carson Towns
//Date - 1/30/17
//Class - CompSci2
//Lab  - Pong

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200,200);
		setXSpeed(3);
		setYSpeed(1);
	}

	public Ball(int x, int y)
	{
		super(x,y);
		setXSpeed(3);
		setYSpeed(1);
	}
	public Ball(int x, int y, int width, int height)
	{
		super(x,y,width,height);
		setXSpeed(3);
		setYSpeed(1);
	}
	public Ball(int x, int y, int width, int height, Color color)
	{
		super(x,y,width,height,color);
		setXSpeed(3);
		setYSpeed(1);
	}
	public Ball(int x, int y, int width, int height, Color color, int xSpd, int ySpd)
	{
		super(x,y,width,height,color);
		setXSpeed(xSpd);
		setYSpeed(ySpd);
	}
	
	public boolean didCollideLeft(Object obj)
	{
		if((getX()>=((Locatable) obj).getX()&&getX()<=((Locatable) obj).getX()+((Block) obj).getWidth())&&
			    (getY()>=((Locatable) obj).getY()-getHeight()&&getY()<=((Locatable) obj).getY()+((Block) obj).getHeight()))
			return true;
		else
			return false;
	}
	public boolean didCollideRight(Object obj)
	{
		if((getX()+ getWidth()>=((Locatable) obj).getX()&&getX() + getWidth() <=((Locatable) obj).getX()+((Block) obj).getWidth())&&
			    (getY()>=((Locatable) obj).getY()-getHeight()&&getY()<=((Locatable) obj).getY()+((Block) obj).getHeight()))
			return true;
		else
			return false;
	}
	public boolean didCollideTop(Object obj)
	{
		if((getX()>=((Locatable) obj).getX()+10-getWidth()&&getX()<=((Locatable) obj).getX()-10+getWidth())&&
			    (getY()>=((Locatable) obj).getY()&&getY()<=((Locatable) obj).getY()+((Block) obj).getHeight()))
					return true;
		else
			return false;
	}
	public boolean didCollideBottom(Object obj)
	{
		if((getX()>=((Locatable) obj).getX()+10-getWidth()&&getX()<=((Locatable) obj).getX()-10+getWidth())&&
			    (getY()+ getHeight()>=((Locatable) obj).getY()&&getY()+ getHeight()<=((Locatable) obj).getY()+((Block) obj).getHeight()))
					return true;
		else
			return false;
	}
	
	public void setPos(Graphics window, int x, int y)
	   {
		window.setColor(Color.WHITE);
	    window.fillRect(getX(), getY(), getWidth(), getHeight());
	    setPos(x,y);
	   }
	
	
	
	
	
	
	
	   
   public void setXSpeed(int x)
   {
	   xSpeed = x;
   }
   public void setYSpeed(int y)
   {
	   ySpeed = y;
   }
   

   public void moveAndDraw(Graphics window)
   {
	      window.setColor(Color.WHITE);
	      window.fillRect(getX(), getY(), getWidth(), getHeight());


      setX(getX()+xSpeed);
	  setY(getY()+ySpeed);

	  window.setColor(getColor());
      window.fillRect(getX(), getY(), getWidth(), getHeight());
   }
   
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;

		return false;
	}   

   public int getXSpeed()
   {
	   return xSpeed;
   }
   public int getYSpeed()
   {
	   return ySpeed;
   }

   public String toString()
   {
	   return super.toString()+ " " + xSpeed + " " + ySpeed;
   }
}