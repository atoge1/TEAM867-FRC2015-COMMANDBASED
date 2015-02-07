package org.usfirst.frc.team867.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;



/**
 * 
 * @author Aaron
 * Base code for controlling mechanum wheels
 * 
 */

public class DriveTrain extends Subsystem 
{
    
	RobotDrive JTTR_BUG; //name of the robot
	
    public void initDefaultCommand() 
    {
    	
    }

    //sets motor ports
    public void DriveInit(int frontLeftMotor, int rearLeftMotor, int frontRightMotor, int rearRightMotor)
    {
    	JTTR_BUG = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
    }
    
    //receives speed and turn data to actuate motors
    public void Drive(double Xaxis, double Yaxis, double Rotation, double Speed)
    {
    	Speed = ((Speed + 1) * 4.5) + 1;
    	JTTR_BUG.mecanumDrive_Cartesian( Xaxis / Speed, Yaxis / Speed, Rotation, 0);
    }

}

