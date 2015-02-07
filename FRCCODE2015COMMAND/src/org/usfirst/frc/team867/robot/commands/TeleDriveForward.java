package org.usfirst.frc.team867.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team867.robot.subsystems.DriveTrain;
import org.usfirst.frc.team867.robot.driverIO;


/**
 * 
 * @author Aaron
 * Receives data from controller and pipes it to motors 
 * 
 */
public class TeleDriveForward extends Command 
{
	driverIO control = new driverIO();

	DriveTrain drive = new DriveTrain();
	
    public TeleDriveForward() 
    {
        requires(drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	drive.DriveInit(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	drive.Drive(control.getX(), control.getY(), 0, control.getSlow()); //insert controller values
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	drive.Drive(0,0,0,0); //stop all motors
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	end();
    }
    
}
