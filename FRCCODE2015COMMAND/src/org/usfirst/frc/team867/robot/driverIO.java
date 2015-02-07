package org.usfirst.frc.team867.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Preferences;
import org.usfirst.frc.team867.robot.commands.TeleDriveManager;


/**
 * 
 * @author Andrew
 * @author Aaron
 * @version 3
 * 
 */
public class driverIO 
{
 
 Preferences prefs;
 Joystick joy;
 Button	drive;  // initiates safety button
 Button	reverse; // initiates reverse button
 Button pivotccw;// initiates counter-clockwise pivot button
 Button pivotcw; // initiates clockwise button 
 double joyxaxis;
 double	joyyaxis;
 double joyzaxis;
 double driverjoyslow; 
 double frontLeftMotor;
 double rearLeftMotor;
 double frontRightMotor;
 double rearRightMotor;
 
 	public driverIO()
 	{ 	
 		//initialize 
 		 joy = new Joystick(prefs.getInt("driverJoyPort", 0));
 		 drive = new JoystickButton(joy, prefs.getInt("driveButton", 1));  // initiates safety button
 		 reverse  = new JoystickButton(joy, prefs.getInt("reverseButton", 2)); // initiates reverse button
 		 pivotccw  = new JoystickButton(joy, prefs.getInt("ccwButton", 4));// initiates counter-clockwise pivot button
 		 pivotcw  = new JoystickButton(joy, prefs.getInt("cwButton", 5)); // initiates clockwise button 
 		 joyxaxis = joy.getRawAxis(0);
 		 joyyaxis = joy.getRawAxis(1);
 		 joyzaxis = joy.getRawAxis(2);
 		
 		
 		
 		drive.whileHeld(new TeleDriveManager());
 		frontLeftMotor = prefs.getInt("frontLeftMotor", 2);
 		rearLeftMotor = prefs.getInt("rearLeftMotor", 1);
 		frontRightMotor = prefs.getInt("frontRightMotor", 3);
 		rearRightMotor = prefs.getInt("rearRightMotor", 0);
 	}
 
  
 	public double getX()
 	{
 		return joyxaxis; 		
 	}
 
 	public double getY()
 	{
 		return joyyaxis;
 	}
 	
 	public double getSlow()
 	{
 		return driverjoyslow;
 	}
 
 	public Button getCW()
 	{
 		return pivotcw;
 	}
 	
 	public Button getCCW()
 	{
 		return pivotccw;
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
