package org.usfirst.frc.team4645.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous extends CommandGroup {

	DriverStation dStation;
	int location;
	String info;
	String switchPos;
	String scalePos;
	DriverStation.Alliance alliance;
	
	public Autonomous() {
		// Add Commands here:
		// e.g. addSequential(new Command1());
		//	  addSequential(new Command2());
		// these will run in order.

		// To run multiple commands at the same time,
		// use addParallel()
		// e.g. addParallel(new Command1());
		//	  addSequential(new Command2());
		// Command1 and Command2 will run in parallel.

		// A command group will require all of the subsystems that each member
		// would require.
		// e.g. if Command1 requires chassis, and Command2 requires arm,
		// a CommandGroup containing them would require both the chassis and the
		// arm.
		
		dStation = DriverStation.getInstance();
		location = dStation.getLocation();
		info = dStation.getGameSpecificMessage();
		switchPos = info.substring(0,1);
		scalePos = info.substring(1,2);
		alliance = dStation.getAlliance();
		
		if (location == 0) 
		{
			
			addSequential(new MoveWithUltrasonic(true));
			addSequential(new MoveWithUltrasonic(false));
			addSequential(new Rotate(90));
			
			if (switchPos.equalsIgnoreCase("L")) {
				
				atLeftSwitch();
				
			} 
			else {
				
				if (scalePos.equalsIgnoreCase("L")) {
					
					addSequential(new MoveWithColorSensor(alliance));
					addSequential(new Rotate(-90));
					addSequential(new OuttakeCommand());
					addSequential(new Rotate(90));
					moveRightOuttake();
					
					
					
				} else {
					moveRightOuttake();
					outtakeRotate();
				}
			}
			
		}
		
		else if (location == 1) {
			
			addSequential(new MoveWithEncoders(122));
			if (switchPos.equalsIgnoreCase("L")) {
				addSequential(new Rotate(-90));
				addSequential(new MoveWithEncoders(335));
				addSequential(new Rotate(90));
				atLeftSwitch();
			} else {
				addSequential(new Rotate(90));
				addSequential(new MoveWithEncoders(335));
				addSequential(new Rotate(-90));
				atRightSwitch();
				
			}
			
		} else {
			
			addSequential(new MoveWithUltrasonic(true));
			addSequential(new MoveWithUltrasonic(false));
			addSequential(new Rotate(-90));
			if (switchPos.equalsIgnoreCase("L")) {
				if (scalePos.equalsIgnoreCase("L")) {
					moveLeftOuttake();
					outtakeRotate();
					
				} else {
					addSequential(new MoveWithColorSensor(alliance));
					addSequential(new Rotate(90));
					addSequential(new OuttakeCommand());
					addSequential(new Rotate(-90));
					moveLeftOuttake();
				}
			} else {
				atRightSwitch();
				
			}
			
		}
		
		
		
	}
	
	private void atLeftSwitch() {
		addSequential(new MoveWithColorSensor(alliance));
		addSequential(new Rotate(90));
		addSequential(new OuttakeCommand());
		
		if (scalePos.equalsIgnoreCase("L")) {
			outtakeRotate();
		} else {
			addSequential(new Rotate(-90));
			addSequential(new MoveWithColorSensor(alliance));
			addSequential(new MoveWithColorSensor(DriverStation.Alliance.Invalid));
			addSequential(new MoveWithColorSensor(alliance));
			addSequential(new Rotate(-90));
			outtakeRotate();
		}
		
	}
	
	private void atRightSwitch() {
		addSequential(new MoveWithColorSensor(alliance));
		addSequential(new Rotate(-90));
		addSequential(new OuttakeCommand());
		
		if (scalePos.equalsIgnoreCase("L")) {
			addSequential(new Rotate(90));
			addSequential(new MoveWithColorSensor(alliance));
			addSequential(new MoveWithColorSensor(DriverStation.Alliance.Invalid));
			addSequential(new MoveWithColorSensor(alliance));
			addSequential(new Rotate(90));
			outtakeRotate();
		} else {
			
			outtakeRotate();
		}
		
	}
	
	private void moveLeftOuttake() {
		addSequential(new MoveWithColorSensor(alliance));
		addSequential(new Rotate(-90));
		addSequential(new OuttakeCommand());
		
	}
	
	private void moveRightOuttake() {
		addSequential(new MoveWithColorSensor(alliance));
		addSequential(new Rotate(90));
		addSequential(new OuttakeCommand());
	}
	
	private void outtakeRotate() {
		addSequential(new IntakeCommand());
		addSequential(new Rotate(180));
		addSequential(new OuttakeCommand());
	}
}
