import javax.swing.JFrame;

public class booleanLogic 
{
	boolean flipFlop1, flipFlop2,clock,orOutput1,toggle;
	JFrame frame;
	Display dFrame;
	
	//state after entering a loop
	public booleanLogic(boolean flipFlop1, boolean flipFlop2, boolean toggle, boolean clock, Display dFrame) 
	{
		this.dFrame=dFrame;
		this.flipFlop1=flipFlop1;
		this.flipFlop2=flipFlop2;
		this.toggle=toggle;
		this.clock=clock;
	}
	
	public void outputFlipFlop() 
	{
		
		//stay on red
		if(flipFlop1==false && flipFlop2==false && toggle ==false && clock==true) 
		{
			dFrame.yellowLight.setColor("gray");
			dFrame.yellowLight.repaint();
			dFrame.redLight.setColor("red");
			dFrame.redLight.repaint();
			
			dFrame.ff1t.setHigh(true);
			dFrame.ff1SupplyAnd1.setHigh(true);
			dFrame.ff1SupplyAnd5.setHigh(true);
			
			dFrame.ff2And.setHigh(true);
			dFrame.ff2SupplyAnd4.setHigh(true);
			
			dFrame.ff2SupplyAnd3.setHigh(true);	
			dFrame.toggleToAnd1.setHigh(true);
			dFrame.toggleToAnd4.setHigh(true);
			
			

		}
		//transition from red to yellow
		else if(flipFlop1==false && flipFlop2==false && toggle ==true && clock==true)
		{
			this.flipFlop1=false;
			this.flipFlop2=true;
			dFrame.redLight.setColor("red");
			dFrame.redLight.repaint();
			dFrame.yellowLight.setColor("yellow");
			dFrame.yellowLight.repaint();
			setFlipFlop1(flipFlop1);
			setFlipFlop2(flipFlop2);
			
			dFrame.ff2t.setColor("green");
			dFrame.ff2And.setColor("green");
			dFrame.ff2And.setHigh(false);
			dFrame.ff2Supply.setColor("green");
			dFrame.ff2SupplyAnd1.setColor("green");
			dFrame.ff2SupplyAnd4.setColor("green");
			dFrame.ff2SupplyAnd4.setHigh(false);
			dFrame.ff2SupplyAnd3.setColor("green");
			dFrame.ff2SupplyAnd3.setHigh(false);
			dFrame.ff2SupplyAnd6.setColor("green");
			
			dFrame.toggleToAnd1.setColor("green");
			dFrame.toggleToAnd1.setHigh(false);
			dFrame.toggleToAnd2.setColor("green");
			dFrame.toggleToAnd4.setColor("green");
			dFrame.toggleToAnd4.setHigh(false);
			dFrame.toggleToAnd5.setColor("green");
			dFrame.toggleToAnd6.setColor("green");
			
			dFrame.And5ToOr2.setColor("green");
			dFrame.And6ToOr2.setColor("green");
			
			dFrame.Or2ToFf2.setColor("green");
			
		}
		//stay on yellow
		else if(flipFlop1==false && flipFlop2==true && toggle ==true && clock==true)
		{

			dFrame.redLight.setColor("gray");
			dFrame.redLight.repaint();
			dFrame.yellowLight.setColor("yellow");
			dFrame.yellowLight.repaint();
			
			dFrame.ff1t.setHigh(false);
			
		}
		//transition yellow to green
		else if(flipFlop1==false && flipFlop2==true && toggle ==false && clock==true)
		{
			this.flipFlop1=true;
			this.flipFlop2=false;
			dFrame.yellowLight.setColor("yellow");
			dFrame.yellowLight.repaint();
			dFrame.greenLight.setColor("green");
			dFrame.greenLight.repaint();
			setFlipFlop1(flipFlop1);
			setFlipFlop2(flipFlop2);
			
			dFrame.ff1Supply.setColor("green");
			dFrame.ff2Supply.setColor("black");
			
			dFrame.ff1SupplyAnd1.setColor("green");
			dFrame.ff1SupplyAnd1.setHigh(false);
			dFrame.ff1SupplyAnd2.setColor("green");
			dFrame.ff1SupplyAnd3.setColor("green");
			dFrame.ff1SupplyAnd4.setColor("green");
			dFrame.ff1SupplyAnd5.setColor("green");
			dFrame.ff1SupplyAnd5.setHigh(false);
			dFrame.ff1And.setColor("green");
			dFrame.andT.setColor("green");
			
			dFrame.ff2t.setColor("black");
			dFrame.ff2And.setColor("black");
			dFrame.ff2And.setHigh(true);
			dFrame.ff2Supply.setColor("black");
			dFrame.ff2SupplyAnd1.setColor("black");
			dFrame.ff2SupplyAnd4.setColor("black");
			dFrame.ff2SupplyAnd4.setHigh(true);
			dFrame.ff2SupplyAnd3.setColor("black");
			dFrame.ff2SupplyAnd3.setHigh(true);
			dFrame.ff2SupplyAnd6.setColor("black");
			
			dFrame.toggleToAnd1.setColor("black");
			dFrame.toggleToAnd1.setHigh(true);
			dFrame.toggleToAnd2.setColor("black");
			dFrame.toggleToAnd4.setColor("black");
			dFrame.toggleToAnd4.setHigh(true);
			dFrame.toggleToAnd5.setColor("black");
			dFrame.toggleToAnd6.setColor("black");
			
			dFrame.And3ToOr1.setColor("green");
			dFrame.Or1ToFf1.setColor("green");
			
			dFrame.And5ToOr2.setColor("black");
			dFrame.And6ToOr2.setColor("black");
			dFrame.And4ToOr2.setColor("green");
			dFrame.Or2ToFf2.setColor("green");
			
		}
		//stay on green
		else if(flipFlop1==true && flipFlop2==false && toggle == false && clock==true)
		{

			dFrame.yellowLight.setColor("gray");
			dFrame.yellowLight.repaint();
			dFrame.greenLight.setColor("green");
			dFrame.greenLight.repaint();
			
		}
		//transition green to yellow
		else if(flipFlop1==true && flipFlop2==false && toggle == true && clock==true)
		{
			this.flipFlop1=true;
			this.flipFlop2=true;  
			dFrame.greenLight.setColor("green");
			dFrame.greenLight.repaint();
			dFrame.yellowLight.setColor("yellow");
			dFrame.yellowLight.repaint();
			setFlipFlop1(flipFlop1);
			setFlipFlop2(flipFlop2);
			
			dFrame.ff2Supply.setColor("green");
			
			dFrame.ff1SupplyAnd1.setColor("green");
			dFrame.ff1SupplyAnd1.setHigh(false);
			dFrame.ff1SupplyAnd2.setColor("green");
			dFrame.ff1SupplyAnd3.setColor("green");
			dFrame.ff1SupplyAnd4.setColor("green");
			dFrame.ff1SupplyAnd5.setColor("green");
			dFrame.ff1SupplyAnd2.setHigh(false);
			dFrame.ff1And.setColor("green");
			dFrame.andT.setColor("green");
			
			dFrame.ff2t.setColor("green");
			dFrame.ff2And.setColor("green");
			dFrame.ff2And.setHigh(false);
			dFrame.ff2Supply.setColor("green");
			dFrame.ff2SupplyAnd1.setColor("green");
			dFrame.ff2SupplyAnd4.setColor("green");
			dFrame.ff2SupplyAnd4.setHigh(false);
			dFrame.ff2SupplyAnd3.setColor("green");
			dFrame.ff2SupplyAnd3.setHigh(false);
			dFrame.ff2SupplyAnd6.setColor("green");
			
			dFrame.toggleToAnd1.setColor("green");
			dFrame.toggleToAnd1.setHigh(false);
			dFrame.toggleToAnd2.setColor("green");
			dFrame.toggleToAnd4.setColor("green");
			dFrame.toggleToAnd4.setHigh(false);
			dFrame.toggleToAnd5.setColor("green");
			dFrame.toggleToAnd6.setColor("green");
			
			dFrame.And2ToOr1.setColor("green");
			dFrame.And3ToOr1.setColor("black");
			dFrame.And4ToOr2.setColor("black");
			dFrame.And5ToOr2.setColor("black");
			dFrame.And6ToOr2.setColor("green");
			
			dFrame.andT.setColor("black");			
			
		}
		//stay on yellow
		else if(flipFlop1==true && flipFlop2==true && toggle ==true && clock==true)
		{

			dFrame.greenLight.setColor("gray");
			dFrame.greenLight.repaint();
			dFrame.yellowLight.setColor("yellow");

		}
		//transition yellow to red
		else if(flipFlop1==true && flipFlop2==true && toggle ==false && clock==true)
		{
			this.flipFlop1=false;
			this.flipFlop2=false; 
			dFrame.yellowLight.setColor("yellow");
			dFrame.yellowLight.repaint();
			dFrame.redLight.setColor("red");
			dFrame.redLight.repaint();
			setFlipFlop1(flipFlop1);
			setFlipFlop2(flipFlop2);
			
			dFrame.ff1Supply.setColor("black");
			dFrame.ff1SupplyAnd1.setColor("black");
			dFrame.ff1SupplyAnd1.setHigh(true);
			dFrame.ff1SupplyAnd2.setColor("black");
			dFrame.ff1SupplyAnd3.setColor("black");
			dFrame.ff1SupplyAnd4.setColor("black");
			dFrame.ff1SupplyAnd5.setColor("black");
			dFrame.ff1SupplyAnd2.setHigh(true);
			dFrame.ff1And.setColor("black");
			dFrame.andT.setColor("black");
			
			dFrame.ff2t.setColor("black");
			dFrame.ff2And.setColor("black");
			dFrame.ff2And.setHigh(true);
			dFrame.ff2Supply.setColor("black");
			dFrame.ff2SupplyAnd1.setColor("black");
			dFrame.ff2SupplyAnd4.setColor("black");
			dFrame.ff2SupplyAnd4.setHigh(true);
			dFrame.ff2SupplyAnd3.setColor("black");
			dFrame.ff2SupplyAnd3.setHigh(true);
			dFrame.ff2SupplyAnd6.setColor("black");
			
			dFrame.toggleToAnd1.setColor("black");
			dFrame.toggleToAnd1.setHigh(true);
			dFrame.toggleToAnd2.setColor("black");
			dFrame.toggleToAnd4.setColor("black");
			dFrame.toggleToAnd4.setHigh(true);
			dFrame.toggleToAnd5.setColor("black");
			dFrame.toggleToAnd6.setColor("black");
			
			dFrame.And2ToOr1.setColor("black");
			dFrame.And3ToOr1.setColor("black");
			dFrame.And4ToOr2.setColor("black");
			dFrame.And5ToOr2.setColor("black");
			dFrame.And6ToOr2.setColor("black");
			
			dFrame.Or1ToFf1.setColor("black");
			dFrame.Or2ToFf2.setColor("black");
			
			dFrame.andT.setColor("black");
		}

	}
	public void setClock(boolean clock) 
	{
		this.clock=clock;
		this.dFrame.clock.setHigh(clock);
		this.dFrame.clock.repaint();
		
	}
	public void setToggle(boolean toggle) 
	{
		this.toggle=toggle;
		this.dFrame.toggle.setHigh(toggle);
		this.dFrame.toggle.repaint();
	}
	public void setFlipFlop1(boolean flipFlop1) 
	{
		this.flipFlop1=flipFlop1;
		this.dFrame.dff1.setHigh(flipFlop1);
	}
	public void setFlipFlop2(boolean flipFlop2) 
	{
		this.flipFlop2=flipFlop2;
		this.dFrame.dff2.setHigh(flipFlop2);
	}
	public boolean getClock() 
	{
		return clock;
	}
	public boolean getToggle() 
	{
		return toggle;
	}
	public boolean getFlipFlop1() 
	{
		return flipFlop1;	
	}
	public boolean getFlipFlop2() 
	{
		return flipFlop2;
	}
	public Display getD() 
	{
		return (Display) dFrame;
	}

}


