package org.usfirst.frc.team867.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team867.robot.driverIO;
import org.usfirst.frc.team867.robot.commands.TeleDriveForward;
import org.usfirst.frc.team867.robot.commands.TeleDriveCW;
import org.usfirst.frc.team867.robot.commands.TeleDriveCCW;
import org.usfirst.frc.team867.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.buttons.Button;

/**
 *
 */
public class TeleDriveManager extends Command {

	driverIO control = new driverIO();
	TeleDriveForward drive = new TeleDriveForward();
	
    public TeleDriveManager() 
    {
        requires(new DriveTrain());
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	Button CW = control.getCW();
    	Button CCW = control.getCCW();
    	
    	CW.whileHeld(new TeleDriveCW());
    	CCW.whileHeld(new TeleDriveCCW());
    	drive.start();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	drive.interrupted();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	end();
    }
}
