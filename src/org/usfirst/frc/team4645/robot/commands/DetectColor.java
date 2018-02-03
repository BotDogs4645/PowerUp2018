package org.usfirst.frc.team4645.robot.commands;

import org.usfirst.frc.team4645.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DetectColor extends Command {

    public DetectColor() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kColorSensor);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.kColorSensor.setAcive();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	 Robot.kColorSensor.getColor();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.kColorSensor.setPassive();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}