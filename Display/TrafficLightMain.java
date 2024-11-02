import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.Timer;

public class TrafficLightMain 
{
  public static void main(String[] args) throws IOException, InterruptedException 
  {
	  Display d = new Display();
	  d.draw();
	  boolean flipflop1 = d.dff1.getHigh(), flipflop2=d.dff2.getHigh(), togg=d.toggle.getHigh(), clk=d.clock.getHigh();
	  booleanLogic logic = new booleanLogic(flipflop1, flipflop2, togg, clk, d);

	  //adding mouseListener to d (display)
	  d.getFrame().addMouseListener(new MouseListener()
	  {
		  @Override
		  public void mouseClicked(MouseEvent e) 
		  {
			  
    		
			  //getting mouse position
			  int x = e.getX();
			  int y = e.getY();
			  //toggle area click		  
			  if (x >= 45 && x <= 85 && y >= 45 && y <= 130) 
			  {
				  //switches between green/black if clicked on High (true) sets the toggle to false
				  //and display the Low toggle (turns from green to black)
				  if(d.toggle.getHigh() == true) 
				  {
					  logic.setToggle(false);			  				  
					  logic.outputFlipFlop();					  
				  }
				  else
				  {
					  logic.setToggle(true);
					  logic.outputFlipFlop();				  
				  }
                
			  }

		  }
		  @Override
		  public void mousePressed(MouseEvent e) {}

		  @Override
		  public void mouseReleased(MouseEvent e) {}

		  @Override
		  public void mouseEntered(MouseEvent e) {}

		  @Override
		  public void mouseExited(MouseEvent e) {}
	  });
	  Timer clockTimer = new Timer(1000, event -> {
          boolean currentClock = logic.getClock();
          logic.setClock(!currentClock); // Toggle clock back and forth
          logic.outputFlipFlop();
          logic.dFrame.clock.repaint(); // Optionally repaint to show changes
      });
      clockTimer.start(); // Start the timer
	  
	  
  
  }
}