import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class drawLines extends JPanel
{
	int posX, posY, posX2, posY2,width, height,width2, height2, x33, y33;
    JPanel line;
    String str, str2, col;
    int x, y, w, h, x2, y2, w2, h2, x3, y3, w3, h3, connectorX, connectorY, inverterX, inverterY;
    int toggleX, toggleY, toggleW, toggleH, toggleX2, toggleY2, toggleW2, toggleH2;
    int toggleX3, toggleY3, toggleW3, toggleH3, toggleX4, toggleY4, toggleW4, toggleH4;
    int toggleX5, toggleY5, toggleW5, toggleH5,toggleX6, toggleY6, toggleW6, toggleH6;
    int circleX, circleY;
    
    boolean high;
    	
    //constructor for draw lines with triangle
    public drawLines(int x, int y, int w, int h, int x2, int y2, int w2, int h2, int x3, int y3, int w3, int h3, String str) 
    {
    	this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
        this.x2=x2;
        this.y2=y2;
        this.w2=w2;
        this.h2=h2;
        this.x3=x3;
        this.y3=y3;
        this.w3=w3;
        this.h3=h3;
        this.str=str;
        this.connectorX=x;
        this.connectorY=y;
        this.setOpaque(false);
        this.setBounds(0,0,1000,600);
    }
    //constructor for draw lines with connectors
    public drawLines(int x, int y, int w, int h, int x2, int y2, int w2, int h2, int x3, int y3, int w3, int h3, String str, int connectorX, int connectorY) 
    {
    	this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
        this.x2=x2;
        this.y2=y2;
        this.w2=w2;
        this.h2=h2;
        this.x3=x3;
        this.y3=y3;
        this.w3=w3;
        this.h3=h3;
        this.str=str;
        this.connectorX=connectorX;
        this.connectorY=connectorY;
        this.setOpaque(false);
        this.setBounds(0,0,1000,600);
    }
    //constructor for draw lines with connectors and inverter
    public drawLines(int x, int y, int w, int h, int x2, int y2, int w2, int h2, int x3, int y3, int w3, int h3, String str, String str2, int connectorX, int connectorY,int inverterX, int inverterY) 
    {
    	this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
        this.x2=x2;
        this.y2=y2;
        this.w2=w2;
        this.h2=h2;
        this.x3=x3;
        this.y3=y3;
        this.w3=w3;
        this.h3=h3;
        this.str=str;
        this.str2=str2;
        this.connectorX=connectorX;
        this.connectorY=connectorY;
        this.inverterX=inverterX;
        this.inverterY=inverterY;
        this.setOpaque(false);
        this.setBounds(0,0,1000,600);
    }
    //draw lines with connectors and inverter from supply line flip flop 1 and 2
    public drawLines(int x, int y, int w, int h, String str, String str2, int connectorX, int connectorY,int inverterX, int inverterY) 
    {
    	this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
        this.str=str;
        this.str2=str2;
        this.connectorX=connectorX;
        this.connectorY=connectorY;
        this.inverterX=inverterX;
        this.inverterY=inverterY;
        this.setOpaque(false);
        this.setBounds(0,0,1000,600);
    }
    //constructor for toggle
    public drawLines(int toggleX, int toggleY, int toggleW, int toggleH, int toggleX2, int toggleY2, int toggleW2, int toggleH2,
                             int toggleX3, int toggleY3, int toggleW3, int toggleH3,int toggleX4, int toggleY4, int toggleW4, int toggleH4,
                             int toggleX5, int toggleY5, int toggleW5, int toggleH5,int toggleX6, int toggleY6, int toggleW6, int toggleH6, String toggle, boolean high) 
    {
    	this.toggleX=toggleX;
    	this.toggleY=toggleY;
    	this.toggleW=toggleW;
    	this.toggleH=toggleH;
    	this.toggleX2=toggleX2;
    	this.toggleY2=toggleY2;
    	this.toggleW2=toggleW2;
    	this.toggleH2=toggleH2;
    	this.toggleX3=toggleX3;
    	this.toggleY3=toggleY3;
    	this.toggleW3=toggleW3;
    	this.toggleH3=toggleH3;
    	this.toggleX4=toggleX4;
    	this.toggleY4=toggleY4;
    	this.toggleW4=toggleW4;
    	this.toggleH4=toggleH4;
    	this.toggleX5=toggleX5;
    	this.toggleY5=toggleY5;
    	this.toggleW5=toggleW5;
    	this.toggleH5=toggleH5;
    	this.toggleX6=toggleX6;
    	this.toggleY6=toggleY6;
    	this.toggleW6=toggleW6;
    	this.toggleH6=toggleH6;
    	this.str=toggle;
    	this.high=high;
    	this.setOpaque(false);
        this.setBounds(0,0,1000,600);
    }
    //draw traffic lights
    public drawLines(int circleX, int circleY, String str, String col, boolean high) 
    {
    	this.high=high;
    	this.col=col;
    	this.circleX=circleX;
    	this.circleY=circleY;
    	this.str=str;
    	this.setOpaque(false);
        this.setBounds(0,0,1000,600);
    }
    //draw clock constructor
    public drawLines(String str, boolean high) 
    {
    	this.str=str;
    	this.high=high;
    	this.setOpaque(false);
    	this.setBounds(300, 200, 1000, 600);
    }
    @Override
    protected void paintComponent(Graphics g) 
    {
    	super.paintComponent(g);
    	Graphics2D g2d = (Graphics2D) g;
    	g2d.setStroke(new BasicStroke(2));
    	g2d.setColor(setColor(col));
    	
    	g2d.drawLine(x, y, w, h);
    	g2d.drawLine(x2, y2, w2, h2);
    	g2d.drawLine(x3, y3, w3, h3);
    	if(str == "connector" && str2 == "inverter")
        {
    		int diameter = 10;
    		g2d.setColor(Color.black);
    		g2d.drawOval(connectorX, connectorY, diameter, diameter);
    		g2d.fillOval(connectorX, connectorY, diameter, diameter);
    		
    		g2d.setColor(Color.gray);
    		g2d.drawOval(inverterX, inverterY, diameter, diameter);
    		g2d.fillOval(inverterX, inverterY, diameter, diameter);
    		if(high==true) 
    		{
    			g2d.setColor(Color.green);
    			g2d.drawOval(inverterX, inverterY, diameter, diameter);
        		g2d.fillOval(inverterX, inverterY, diameter, diameter);
    		}
        }	
    	else if(str == "triangle")
        {
    		int[] x = {700,700,725};
    		int[] y = {155,185,170};
    		g2d.drawPolygon(x,y,3);
    		if(high == true) 
    		{
    			g2d.setColor(Color.green);
    			g2d.drawPolygon(x,y,3);
    			
    		}
        }
        else if(str == "inverter")
        {
        	int diameter = 10;
        	g2d.setColor(Color.gray);
        	g2d.drawOval(inverterX, inverterY, diameter, diameter);
        	g2d.fillOval(inverterX, inverterY, diameter, diameter);
        }
        else if(str == "connector")
        {
        	int diameter = 10;
        	g2d.setColor(Color.black);
        	g2d.drawOval(connectorX, connectorY, diameter, diameter);
        	g2d.fillOval(connectorX, connectorY, diameter, diameter);
        }
        else if(str == "toggle")
        {
        	if(high == true) 
        	{
        		g2d.setColor(setColor("green"));
               	//drawing T          	
            	g2d.drawLine(toggleX,toggleY,toggleW,toggleH);
            	g2d.drawLine(toggleX2,toggleY2,toggleW2,toggleH2);
            	//drawing supply line
            	g2d.drawLine(toggleW3, (toggleH3+toggleH4)/2, toggleW3+15, (toggleH3+toggleH4)/2);
            	g2d.drawLine(toggleW3+15, (toggleH3+toggleH4)/2, toggleW3+15, (toggleH3+toggleH4)+345);
        	}
        	else 
        	{
        		//drawing t
        		g2d.setColor(Color.black);     	
            	g2d.drawLine(toggleX,toggleY,toggleW,toggleH);
            	g2d.drawLine(toggleX2,toggleY2,toggleW2,toggleH2);
            	//drawing supply line
            	g2d.drawLine(toggleW3, (toggleH3+toggleH4)/2, toggleW3+15, (toggleH3+toggleH4)/2);
            	g2d.drawLine(toggleW3+15, (toggleH3+toggleH4)/2, toggleW3+15, (toggleH3+toggleH4)+345);
        	}
        	//box
        	g2d.setColor(Color.black); 
        	g2d.drawLine(toggleX3,toggleY3,toggleW3,toggleH3);
        	g2d.drawLine(toggleX4,toggleY4,toggleW4,toggleH4);
        	g2d.drawLine(toggleX5,toggleY5,toggleW5,toggleH5);
        	g2d.drawLine(toggleX6,toggleY6,toggleW6,toggleH6);
        	
        }
        else if(str == "lights")
        {
        	if(col == "red" && high == true)
        	{
        		int diameter = 40;
        		g2d.setColor(setColor(col));
        		g2d.drawOval(circleX, circleY, diameter, diameter);
        		g2d.fillOval(circleX, circleY, diameter, diameter);
        		
        	}
        	else if(col == "green" && high == true)
        	{
        		int diameter = 40;
        		g2d.setColor(setColor(col));
        		g2d.drawOval(circleX, circleY, diameter, diameter);
        		g2d.fillOval(circleX, circleY, diameter, diameter);       		
        	}
        	else if(col == "yellow" && high == true)
        	{
        		int diameter = 40;
        		g2d.setColor(setColor(col));
        		g2d.drawOval(circleX, circleY, diameter, diameter);
        		g2d.fillOval(circleX, circleY, diameter, diameter);       		
        	}
        }
        else if(str == "clock")
        {
			if(high == true)
			{
	        	//clock
				g2d.setColor(Color.green);
	            g2d.drawLine(50, 100, 70, 100);
	            g2d.drawLine(70, 50, 70, 100);
	            g2d.drawLine(70, 50, 90, 50);
	            //square box
	            g2d.drawLine(40, 110, 100, 110);
	            g2d.drawLine(100, 110, 100, 40);
	            g2d.drawLine(100, 40, 40, 40);
	            g2d.drawLine(40, 40, 40, 110);
	            //feed line
	            g2d.drawLine(70, 40, 70, 0);
	            g2d.drawLine(70, 0, 115, 0);
	            g2d.drawLine(70, 110, 70, 200);
	            g2d.drawLine(70, 200, 115, 200);
			}
			else 
			{
				//clock
    			g2d.setColor(Color.black);
                g2d.drawLine(50, 50, 70, 50);
                g2d.drawLine(70, 50, 70, 100);
                g2d.drawLine(70, 100, 90, 100);
                //square box
                g2d.drawLine(40, 110, 100, 110);
                g2d.drawLine(100, 110, 100, 40);
                g2d.drawLine(100, 40, 40, 40);
                g2d.drawLine(40, 40, 40, 110);
                //feed line
                g2d.drawLine(70, 40, 70, 0);
                g2d.drawLine(70, 0, 115, 0);
                g2d.drawLine(70, 110, 70, 200);
                g2d.drawLine(70, 200, 115, 200); 
			}
        }
        
    }
    public Color setColor( String col) 
    {
    	this.col=col;
    	if(col == "green")
    	{
    		return (Color) Color.green;
    	}
    	else if(col=="red")
    	{
    		return (Color) Color.red;
    	}
    	else if(col=="yellow")
    	{
    		return (Color) Color.yellow;
    	}
    	else if(col=="gray")
    	{
    		return (Color) Color.gray;
    	}
    	else 
    	{
    		return (Color) Color.black;
    	}
    }
    public void setHigh(boolean high) 
    {
    	this.high=high;
    }
    public boolean getHigh() 
    {
    	return high;
    }

}
