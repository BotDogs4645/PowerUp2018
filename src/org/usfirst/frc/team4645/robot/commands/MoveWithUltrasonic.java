package org.usfirst.frc.team4645.robot.commands;

import org.usfirst.frc.team4645.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MoveWithUltrasonic extends Command {

	boolean moveUntil;
	
    public MoveWithUltrasonic(boolean pMoveUntil) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.tankDriveSubsystem);
    	requires(Robot.kUltrasonic);
    	moveUntil = pMoveUntil; 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.tankDriveSubsystem.move(0.3); //Move tank drive at 0.3
    	SmartDashboard.putNumber("Distance", Robot.kUltrasonic.getDistance());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (moveUntil) {
    		return (34 >= Robot.kUltrasonic.getDistance()); //Finish when distance is less than 31 cm
    
    	} else {
    		return (34 < Robot.kUltrasonic.getDistance()); //Finish when distance is greater than 32 cm
    	}
    	//30 cm is the minimum value the ultrasonic sensor can return
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.tankDriveSubsystem.stop(); //stop tank drive
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
