package org.usfirst.frc.team4645.robot.commands;

import org.usfirst.frc.team4645.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class MoveWithEncoders extends Command 
{
	public PIDController leftPID;
	public PIDController rightPID;
	
	double rightDistance;
	double leftDistance;
	
	double speed;

	//takes the distance the user wants to move as a parameter
    public MoveWithEncoders(double prightDistance, double pleftDistance, double pspeed) 
    {
    	
    	    requires(Robot.tankDriveSubsystem);
    	    
    	    rightDistance = prightDistance * 72; //there are 72 counts per inch
    	    leftDistance = pleftDistance * 72; //there are 72 counts per inch 
    	    speed=pspeed;
    }

    //slaves and inverts motors; configures optical encoders; 
    protected void initialize() 
    {
    		SmartDashboard.putString("MoveWithEncoders", "initializing");
    		Robot.tankDriveSubsystem.init(); //slaves motors
    		Robot.tankDriveSubsystem.configureEncoders(); 
    		Robot.tankDriveSubsystem.setEncoderPositions(0);
    		
    		Robot.tankDriveSubsystem.setRightEncoderSetpoint(rightDistance);
    		Robot.tankDriveSubsystem.setLeftEncoderSetpoint(leftDistance);
    		
    		SmartDashboard.putNumber("target rightDistance(inches)", rightDistance/72);
    		SmartDashboard.putNumber("target leftDistance(inches)", leftDistance/72);
    		
    		Robot.tankDriveSubsystem.setOutputRange(speed);
    		Robot.tankDriveSubsystem.enablePIDS();
    }

    protected void execute() 
    {
   
	    	SmartDashboard.putString("MoveWithEncoder", "executing");
	    	SmartDashboard.putNumber("Left PID Input", Robot.tankDriveSubsystem.getLeftPosition());
	    	SmartDashboard.putNumber("Right PID Input", Robot.tankDriveSubsystem.getRightPosition());
	    	SmartDashboard.putNumber("Left PID Output", Robot.tankDriveSubsystem.motorL1.get());
	    	SmartDashboard.putNumber("Right PID Output", Robot.tankDriveSubsystem.motorR1.get());	    	
	    	
	    	
	    //	SmartDashboard.putNumber("Velocity", Robot.tankDriveSubsystem.getLeftVelocity());
	    	
    }

   //motors stop running when the target position is reached
    protected boolean isFinished() 
    {    
    		return (Robot.tankDriveSubsystem.rightEncoderPID.onTarget() && Robot.tankDriveSubsystem.leftEncoderPID.onTarget());
    		
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    		Robot.tankDriveSubsystem.disablePIDS();
    		Robot.tankDriveSubsystem.stop();
    		SmartDashboard.putString("MoveWithEncoder", "end");
    		
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	
    }
    
}
