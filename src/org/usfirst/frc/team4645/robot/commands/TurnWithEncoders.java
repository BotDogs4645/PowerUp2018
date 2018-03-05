package org.usfirst.frc.team4645.robot.commands;

import org.usfirst.frc.team4645.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TurnWithEncoders extends Command 
{
	private double angle;
	private PIDController leftPID;
	private PIDController rightPID;
	

    public TurnWithEncoders(double pAngle) 
    {
	    requires(Robot.tankDriveSubsystem); 
	    
	    angle = pAngle;

    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    		Robot.tankDriveSubsystem.setEncoderPositions(0);
    		double setpoint = (angle * 28)/360; //Change robot width!!
    		Robot.tankDriveSubsystem.setLeftEncoderSetpoint(setpoint);
    		Robot.tankDriveSubsystem.setRightEncoderSetpoint(-setpoint);
    		
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		SmartDashboard.putString("Turn with encoders:", "running");
    		
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
    		return (rightPID.onTarget() && leftPID.onTarget());//Robot.tankDriveSubsystem.encodersOnTarget();
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    		rightPID.disable();
    		leftPID.disable();
		Robot.tankDriveSubsystem.stop();
		SmartDashboard.putString("Turn with encoders:", "end");    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    }
}