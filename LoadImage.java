import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class LoadImage 
{
	String fileName;
	Graphics2D g2d;
	BufferedImage img, scaledImg;
	JLabel imgLabel;
	int frameX, frameY, x, y, posX, posY, newWidth, newHeight;
	double scaleFactor;
	boolean high;
	
	public LoadImage(String fileName, int x, int y, int frameX, int frameY, double scaleFactor) throws IOException 
	{
		this.fileName=fileName;
		this.x=x;
		this.y=y;
		this.frameX=frameX;
		this.frameY=frameY;
		this.scaleFactor=scaleFactor;
		setImage();
		
	}
	public LoadImage(String fileName, int x, int y, int frameX, int frameY, double scaleFactor, boolean high) throws IOException 
	{
		this.high=high;
		this.fileName=fileName;
		this.x=x;
		this.y=y;
		this.frameX=frameX;
		this.frameY=frameY;
		this.scaleFactor=scaleFactor;
		setImage();
		
	}
	public void setImage() throws IOException 
	{
		
		// Load the image
        img = ImageIO.read(new File(fileName));

        // Scale the image to 80% of its original size
        //scaleFactor = 0.5;
        newWidth = (int) (img.getWidth() * scaleFactor);
        newHeight = (int) (img.getHeight() * scaleFactor);

        // Create a new BufferedImage to hold the scaled image
        scaledImg = new BufferedImage(newWidth, newHeight, img.getType());

        // Get Graphics2D object for drawing
        g2d = scaledImg.createGraphics();

        // Draw the original image scaled to the new size
        g2d.drawImage(img, 0, 0, newWidth, newHeight, null);
        g2d.dispose();

        // Calculate the position to center the image in the frame
        posX = (frameX - newWidth) / 2 + x;
        posY = (frameY - newHeight) / 2 + y;

	}
	public void setJLabel() 
	{
		
		imgLabel = new JLabel(new ImageIcon(getImage()));
		imgLabel.setOpaque(false);
        imgLabel.setBounds(posX, posY, newWidth, newHeight);
	}
	public BufferedImage getImage() 
	{
		return scaledImg;
	}
	public JLabel getJLabel() 
	{
		setJLabel();
		return imgLabel;
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
