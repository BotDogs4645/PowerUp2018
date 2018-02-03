package org.usfirst.frc.team4645.robot.commands;
import org.usfirst.frc.team4645.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;


public class DriveCommand extends Command
{	

    public DriveCommand() 
    {
    	requires(Robot.tankDriveSubsystem);
    }

    protected void initialize() 
    {
    	Robot.tankDriveSubsystem.init();
    }

    protected void execute() 
    {	
    	Robot.tankDriveSubsystem.driveWithJoystick();
    }

    protected boolean isFinished() 
    {
    	return false;
    }

    protected void end() 
    {
    	
    }

    protected void interrupted() 
    {
    	Robot.tankDriveSubsystem.stop();	
    }
}
