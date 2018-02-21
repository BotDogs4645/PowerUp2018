package org.usfirst.frc.team4645.robot.commands;

import org.usfirst.frc.team4645.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MoveWithColorSensor extends Command {

	DriverStation.Alliance color;
	
    public MoveWithColorSensor(DriverStation.Alliance pColor) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.tankDriveSubsystem);
    	requires(Robot.kColorSensor);
    	color = pColor;
    }


    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.tankDriveSubsystem.move(-0.3);
    	SmartDashboard.putNumber("speed", Robot.tankDriveSubsystem.motorL1.get());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	int[] colors = Robot.kColorSensor.getColor();
    	if (color == DriverStation.Alliance.Invalid) {
    		return (colors[3] == 0);
    	} else if (color == DriverStation.Alliance.Blue) {
    		return (colors[3] == 3);
    	} else {
    		return (colors[3] == 10);
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.tankDriveSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
