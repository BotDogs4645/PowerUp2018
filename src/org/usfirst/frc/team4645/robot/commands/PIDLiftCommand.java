package org.usfirst.frc.team4645.robot.commands;

import org.usfirst.frc.team4645.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class PIDLiftCommand extends Command {
	
	private double height;
	private PIDController liftPID;

    public PIDLiftCommand(double pheight) 
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	    requires(Robot.liftSubsystem);
	    liftPID = Robot.liftSubsystem.getPIDController();    	
    		height = pheight; //change to inches

    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
		Robot.liftSubsystem.init();
		Robot.liftSubsystem.setEncoderPosition(0);
		SmartDashboard.putString("PID lift", "initializing");
		liftPID.setSetpoint(height);
		//SmartDashboard.putNumber("lift target distance", height);
		liftPID.enable();    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    		
    		SmartDashboard.putString("PID lift", "execute");
    		SmartDashboard.putNumber("PID lift encoder", Robot.liftSubsystem.liftMotor.get());
    		/*if (liftPID.onTarget() && liftPID.isEnabled()) {
    			liftPID.disable();
    		} else if (!liftPID.onTarget() && !liftPID.isEnabled()) {
    			liftPID.enable();
    		}*/
    		
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
    		//SmartDashboard.putString("PID lift", "end");
    		return liftPID.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() 
    {
		liftPID.disable();
		Robot.liftSubsystem.liftStop();
		SmartDashboard.putString("PID lift", "end");    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    		
    	
    }
}
