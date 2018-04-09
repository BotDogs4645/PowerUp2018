package org.usfirst.frc.team4645.robot.commands;

import org.usfirst.frc.team4645.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnWithTime extends Command {
	Timer time = new Timer();
	private double lSpeed;
	private double rSpeed;
	private double delay;
    public TurnWithTime(double leftSpeed, double rightSpeed, double time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	lSpeed = leftSpeed;
    	rSpeed = rightSpeed;
    	delay = time;
    	requires(Robot.tankDriveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	time.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.tankDriveSubsystem.moveRight(rSpeed);
    	Robot.tankDriveSubsystem.moveLeft(lSpeed);
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
    protected void end() {
    	Robot.tankDriveSubsystem.move(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}