package org.usfirst.frc.team4645.robot.commands;

import org.usfirst.frc.team4645.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class LiftSetTarget extends Command {

	double height;
	PIDController liftPID;
	
    public LiftSetTarget(double pHeight) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    		requires(Robot.liftSubsystem);
    		height = pHeight; //change to inches
    		liftPID = Robot.liftSubsystem.getPIDController();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    		//Robot.liftSubsystem.init();
    		Robot.liftSubsystem.init();
    		//Robot.liftSubsystem.setEncoderPosition(0);
    		//Robot.liftSubsystem.setTargetPosition(height);
    		SmartDashboard.putString("LiftSetTarget ", "initializing");
    		
    		liftPID.setSetpoint(height);
    		liftPID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		SmartDashboard.putString("LiftSetTarget ", "executing");
    		SmartDashboard.putNumber("LiftSetTarget position", height);
    		//SmartDashboard.putNumber("LiftSetTarget position", height);
    		
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //return liftPID.onTarget();
    	
    	
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	SmartDashboard.putString("LiftSetTarget ", "end");
    
    	liftPID.disable();
    	//add stop?
    	
    }
 
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}