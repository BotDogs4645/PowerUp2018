package org.usfirst.frc.team4645.robot.commands;

import org.usfirst.frc.team4645.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveForwardTime extends Command {

	Timer time = new Timer();
	double delay;
	
    public DriveForwardTime(double time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.tankDriveSubsystem);
    	delay = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	time.start();
    	//timeDelay = Robot.autonomousDelay;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {  
    	//SmartDashboard.putNumber("autonomous delay seconds", timeDelay);
    	SmartDashboard.putNumber("current time", time.get());
    	Robot.tankDriveSubsystem.moveRight(-0.5);
    	Robot.tankDriveSubsystem.moveLeft(-0.55);
    	
    	
    	
    	
    	/*if (time.get() < timeDelay)
    	{
    		SmartDashboard.putString("autonomous status","not moving");
    		Robot.tankDriveSubsystem.move(0);
    	}
    	else 
    	{
    		Robot.tankDriveSubsystem.move(-.2);
    		SmartDashboard.putString("autonomous status","moving");
    	}*/
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (time.get() > delay)
    	{
    		return true;
    	}
    return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	Robot.tankDriveSubsystem.move(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
