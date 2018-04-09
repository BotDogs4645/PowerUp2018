package org.usfirst.frc.team4645.robot.commands;
import org.usfirst.frc.team4645.robot.OI;
import org.usfirst.frc.team4645.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class DriveCommand extends Command
{	

    public DriveCommand() 
    {
    		requires(Robot.tankDriveSubsystem);
    }

    protected void initialize() 
    {
    		Robot.tankDriveSubsystem.init();
    		SmartDashboard.putString("tank drive", "init");
    }

    protected void execute() 
    {	
    		Robot.tankDriveSubsystem.driveWithJoystick();
    		SmartDashboard.putNumber("joystick1 throttle", OI.joystick1.getThrottle());
    		SmartDashboard.putString("tank drive", "exec");
    	
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
