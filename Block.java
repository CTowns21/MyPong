//Name - Carson Towns
//Date - 1/30/17
//Class - CompSci2
//Lab  - Pong

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private Color color;

	public Block(int x, int y)
	{
		setPos(x,y);
		setWidth(50);
		setHeight(51);
		setColor(Color.BLUE);
	}
	public Block()
	{
		setX(50);
		setY(50);
		setWidth(50);
		setHeight(51);
		setColor(Color.RED);

	}
	public Block(int x, int y, int width, int height)
	   {
	       setX(x);
	       setY(y);
	       setWidth(width);
	       setColor(Color.MAGENTA);
	       setHeight(height);
	   }
   public Block(int x, int y, int width, int height, Color color)
   {
       setX(x);
       setY(y);
       setWidth(width);
       setColor(color);
       setHeight(height);
   }
   
   
   
   public void setColor(Color col)
   {
	   color = col;
   }
   public void setX(int x)
   {
	   xPos = x;
   }
   public void setY(int y)
   {
	   yPos = y;
   }
   public void setWidth(int w)
   {
	   width = w;
   }
   public void setHeight(int h)
   {
	   height = h;
   }
   public void setPos(int x, int y)
   {
	   xPos = x;
	   yPos = y;
   }
   
   
   public int getX()
   {
	   return xPos;
   }
   public int getY()
   {
	   return yPos;
   }
   public int getWidth()
   {
	   return width;
   }
   public int getHeight()
   {
	   return height;
   }
   public Color getColor()
   {
	   return color;
   }
   public void draw(Graphics window)
   {
      window.setColor(color);
      window.fillRect(getX(), getY(), getWidth(), getHeight());
   }

   public void draw(Graphics window, Color col)
   {


   }
   
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;

		return false;
	}   
   public String toString()
   {
	   return xPos + " " + yPos + " " +  width + " " + height + " " + color;
   }
}