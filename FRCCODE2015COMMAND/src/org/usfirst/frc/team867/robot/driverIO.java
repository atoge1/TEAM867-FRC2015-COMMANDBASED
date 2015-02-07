package org.usfirst.frc.team867.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team867.robot.commands.TeleDriveForward;


/**
 * 
 * @author Andrew
 * @author Aaron
 * @version 2
 * 
 */
public class driverIO 
{
 	
 Joystick joy;
 Button drive;
 Button reverse;
 Button pivotccw;
 Button pivotcw;
 double joyxaxis;
 double joyyaxis;
 double joyzaxis;
 double driverjoyslow;
 
 
 
 	public driverIO()
 	{
 		joy = new Joystick(0);
 		drive = new JoystickButton(joy, 1);  // initiates safety button
 		reverse  = new JoystickButton(joy, 2); // initiates reverse button
 		pivotccw  = new JoystickButton(joy, 4);// initiates counter-clockwise pivot button
 		pivotcw  = new JoystickButton(joy, 5); // initiates clockwise button 
 		joyxaxis = joy.getRawAxis(0);
 		joyyaxis = joy.getRawAxis(1);
 		joyzaxis = joy.getRawAxis(2);
 		driverjoyslow = joyzaxis;
 		
 		drive.whileHeld(TeleDriveForward);
 		
 		
 		
 	}
 
  
 	public double getX()
 	{
 		return joyxaxis; 		
 	}
 
 	public double getY()
 	{
 		return joyyaxis;
 	}
 
 
 
 
 	//// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}
