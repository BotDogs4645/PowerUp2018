package org.usfirst.frc.team4645.robot.commands;

import org.usfirst.frc.team4645.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class EncoderCommand extends Command {

    public EncoderCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.encoderSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.encoderSubsystem.initEncoder();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Runs motor while getting velocity and position
    Robot.encoderSubsystem.runEncoderMotor();
    Robot.encoderSubsystem.getEncoderVelocity();
    Robot.encoderSubsystem.getEncoderPosition();

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
