package org.usfirst.frc.team4645.robot.commands;

import org.usfirst.frc.team4645.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveWithColorSensor extends Command {

    public MoveWithColorSensor() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.tankDriveSubsystem);
    	requires(Robot.kColorSensor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.tankDriveSubsystem.move(0.3);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	int[] colors = Robot.kColorSensor.getColor();
    	DriverStation.Alliance alliance = DriverStation.getInstance().getAlliance();
    	if (alliance == DriverStation.Alliance.Invalid) {
    		return (colors[3] == 3);
    	} else if (alliance == DriverStation.Alliance.Blue) {
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
