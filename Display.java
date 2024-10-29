import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.*;

public class Display 
{
    JFrame frame;
    JLabel trafficLabel,dff1Label, dff2Label, andLabel;

    int x, y;

    LoadImage tL,dff1, dff2,clk,andGO1,andGI1, andGI2, andGI3,andGI4, andGI5, andGI6, orGI1, orGI2;
    drawLines ff1t, ff2t,ff1And, ff2And, ffAndT, andT, ff1Supply, ff2Supply;
    drawLines ff1SupplyAnd1, ff1SupplyAnd2, ff1SupplyAnd3,ff1SupplyAnd4, ff1SupplyAnd5;
    drawLines ff2SupplyAnd1, ff2SupplyAnd3,ff2SupplyAnd4, ff2SupplyAnd6;
    drawLines And1ToOr1,And2ToOr1,And3ToOr1,And4ToOr2,And5ToOr2,And6ToOr2;
    drawLines Or1ToFf1, Or2ToFf2;
    drawLines toggle, clock, toggleToAnd1, toggleToAnd2, toggleToAnd4, toggleToAnd5, toggleToAnd6;
    drawLines redLight, greenLight, yellowLight;
    
    public Display() 
    {
    	frame = new JFrame("TrafficLight");
        x = 1000; // Set the frame width
        y = 600; // Set the frame height
    }

    public void draw() throws IOException 
    {
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(x, y);
     // Use null layout to allow setting custom bounds
        frame.setLayout(null);
        
        //loading image
        tL = new LoadImage("trafficlight2.png",400,0,x,y,0.95);
        dff1 = new LoadImage("dflipflop.png",-50,-100,x,y,0.2,false);
        dff2 = new LoadImage("dflipflop.png",-50,100,x,y,0.2,false);
        andGO1 = new LoadImage("andGate.png",200,-50,x,y,0.08);
       // andGO2 = new LoadImage("andGate.png",200,70,x,y,0.08);
        andGI1 = new LoadImage("andGate.png",-300,-200,x,y,0.08);
        andGI2 = new LoadImage("andGate.png",-300,-150,x,y,0.08);
        andGI3 = new LoadImage("andGate.png",-300,-100,x,y,0.08);
        andGI4 = new LoadImage("andGate.png",-300,130,x,y,0.08);
        andGI5 = new LoadImage("andGate.png",-300,80,x,y,0.08);
        andGI6 = new LoadImage("andGate.png",-300,30,x,y,0.08);
        orGI1 = new LoadImage("orGate.png",-180,-125,x,y,0.20);
        orGI2 = new LoadImage("orGate.png",-180,70,x,y,0.20);

        ff1t = new drawLines(471,168,807,168,807,168,807,242,807,242,879,242, "triangle");
        ff2t = new drawLines(471,429,807,429,807,429,807,292,807,292,879,292,"");
        ff1And = new drawLines(681,239,557,239,557,239,557,169,557,169,690,169,"connector", 553,165);
        ff2And = new drawLines(691,429,557,429,557,429,557,263,557,263,680,263,"connector","inverter",552,425,670,258);
        andT = new drawLines(723,244,773,244,773,244,773,331,773,331,890,331,"");
        ff1Supply = new drawLines(600,168,600,35,600,35,140,35,140,35,140,450,"connector", 595,165);
        ff2Supply = new drawLines(600,429,600,480,600,480,120,480,120,480,120,35,"connector", 595,425);
        //flip flop 1 supply line to AND gate 1,2,3,4,5,6
        ff1SupplyAnd1 = new drawLines(140,85, 180,85,"connector", "inverter",137,80,177,80);
        ff1SupplyAnd2 = new drawLines(140,135, 180,135,0,0,0,0,0,0,0,0,"connector",137,130);
        ff1SupplyAnd3 = new drawLines(140,185, 180,185,0,0,0,0,0,0,0,0,"connector",137,180);
        ff1SupplyAnd4 = new drawLines(140,315, 180,315,0,0,0,0,0,0,0,0,"connector",137,310);
        ff1SupplyAnd5 = new drawLines(140,365, 180,365,"connector", "inverter",137,360,177,360);
        
        //flip flop 2 supply line to AND gate 1,2,3,4,5,6
        ff2SupplyAnd1 = new drawLines(120,115, 180,115,0,0,0,0,0,0,0,0,"connector",117,110);
        ff2SupplyAnd3 = new drawLines(120,215, 180,215,"connector", "inverter",117,210,175,210);
        ff2SupplyAnd4 = new drawLines(120,345, 180,345,"connector", "inverter",117,340,177,340);
        ff2SupplyAnd6 = new drawLines(120,440, 180,440,0,0,0,0,0,0,0,0,"connector",117,435);
        
        //And gates to Or gate lines
        And1ToOr1 = new drawLines(225,95,285,95,285,95,285,155,285,155,310,155,"");
        And2ToOr1 = new drawLines(225,150,265,150,265,150,265,172,265,172,312,172,"");
        And3ToOr1 = new drawLines(225,200,285,200,285,200,285,185,285,185,310,185,"");
        And4ToOr2 = new drawLines(225,325,285,325,285,325,285,350,285,350,310,350,"");
        And5ToOr2 = new drawLines(225,375,285,375,285,375,285,365,285,365,312,365,"");
        And6ToOr2 = new drawLines(225,430,275,430,275,430,275,385,275,385,310,385,"");
  
        //OR gate 1 and 2 to flip flop 1 and 2
        Or1ToFf1 = new drawLines(350,172,413,172,"","",0,0,0,0);
        Or2ToFf2 = new drawLines(350,365,413,365,"","",0,0,0,0);
        
        //draw toggle and clock
        toggle = new drawLines(50,50,70,50,60,50,60,80,45,45,75,45,75,45,75,85,75,85,45,85,45,85,45,45, "toggle",false);
        clock = new drawLines("clock",false);
        
        //Toggle to AND gate 1,2,4,5,6
        toggleToAnd1 = new drawLines(92,100,180,100,"connector","inverter",85,95,177,95);
        toggleToAnd2 = new drawLines(92,148,180,148,0,0,0,0,0,0,0,0,"connector",85,143);
        toggleToAnd4 = new drawLines(92,330,180,330,"connector","inverter",85,325,177,325);
        toggleToAnd5 = new drawLines(92,381,180,381,0,0,0,0,0,0,0,0,"connector",85,376);
        toggleToAnd6 = new drawLines(92,427,180,427,0,0,0,0,0,0,0,0,"connector",85,422);
        
        //traffic light circles
        redLight = new drawLines(890,224,"lights","red", true);
        greenLight = new drawLines(890,315,"lights","gray", true);
        yellowLight = new drawLines(890,268,"lights","gray", true);
        
       
        //adding label image to Frame
        frame.add(redLight);
        frame.add(greenLight);
        frame.add(yellowLight);
        frame.add(tL.getJLabel());
        frame.add(dff1.getJLabel());
        frame.add(dff2.getJLabel());
        frame.add(andGO1.getJLabel());
        frame.add(andGI1.getJLabel());
        frame.add(andGI2.getJLabel());
        frame.add(andGI3.getJLabel());
        frame.add(andGI4.getJLabel());
        frame.add(andGI5.getJLabel());
        frame.add(andGI6.getJLabel());
        frame.add(orGI1.getJLabel());
        frame.add(orGI2.getJLabel());
        frame.add(clock);
        frame.add(ff1t);
        frame.add(ff2t);
        frame.add(ff1And);
        frame.add(ff2And);
        frame.add(andT);
        frame.add(ff1Supply);
        frame.add(ff2Supply);
        frame.add(ff1SupplyAnd1);
        frame.add(ff1SupplyAnd2);
        frame.add(ff1SupplyAnd3);
        frame.add(ff1SupplyAnd4);
        frame.add(ff1SupplyAnd5);
        
        frame.add(ff2SupplyAnd1);
        frame.add(ff2SupplyAnd3);
        frame.add(ff2SupplyAnd4);
        frame.add(ff2SupplyAnd6);
        
        frame.add(And1ToOr1);
        frame.add(And2ToOr1);
        frame.add(And3ToOr1);
        frame.add(And4ToOr2);
        frame.add(And5ToOr2);
        frame.add(And6ToOr2);
        
        frame.add(Or1ToFf1);
        frame.add(Or2ToFf2);
        
        //toggle
        frame.add(toggle);
        frame.add(toggleToAnd1);
        frame.add(toggleToAnd2);
        frame.add(toggleToAnd4);
        frame.add(toggleToAnd5);
        frame.add(toggleToAnd6);

        frame.setVisible(true);
    }
   public JFrame getFrame() 
   {
	   return frame;
   }
 
}

