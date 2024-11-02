# Traffic Light Simulator
This Traffic Ligh Simulator is a GUI, showcases the concept of sequential logic. 
The user can click on the Toggle, to which the simulator will highlight the lines 
that are actively ON (Green) or OFF(black).

## How To use
•	Download all the files to your IDE. (Java is required)

•	The initial state of the traffic light is red.

•	The Clock (rising edge) alternates every 1 second and updates the value of the D Flip Flop.

   ![image](https://github.com/user-attachments/assets/38bcac22-07e7-4691-9400-9ecb63297f3a)
 
•	To get it to the next state click on the Toggle. It will turn green when ON and black when OFF.

   ![image](https://github.com/user-attachments/assets/fa691ca1-9f50-414d-b47b-2cb8a9046ed4)
 
•	When you first click the Toggle it will turn ON. When the Clock cycles ON the value on the 
  D Flip Flop will update. 

•	There will a transition period, when the previous light and the next light will both be ON. 
  When the Clock cycles ON again only the next light will stay ON; and will stay there until the 
  Toggle is clicked again.
  
  ![image](https://github.com/user-attachments/assets/e15841fa-22b8-44e3-8084-70383153ccd1)
  ![image](https://github.com/user-attachments/assets/1806f138-d87b-452a-aeae-4ce500d9e60d)
  ![image](https://github.com/user-attachments/assets/59590516-6dfb-4973-8c45-ab7e9df05b29)

•	Each time there is a change in the system the line circuits will turn ON or OFF depending on the next state.
