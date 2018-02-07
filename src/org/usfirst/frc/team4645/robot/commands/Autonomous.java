package org.usfirst.frc.team4645.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous extends CommandGroup {

	DriverStation dStation;
	int startLocation;
	String info;
	String switchPos;
	String scalePos;
	DriverStation.Alliance alliance;
	boolean scoredSwitch;
	boolean scoredScale;
	int robotLocation;
	int turnAngle;
	
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
		startLocation = dStation.getLocation();
		info = dStation.getGameSpecificMessage();
		switchPos = info.substring(0,1);
		scalePos = info.substring(1,2);
		alliance = dStation.getAlliance();
		scoredSwitch = false;
		scoredScale = false;
		robotLocation = startLocation;
		
		
		
		
		if (startLocation == 2) {
			addSequential(new MoveWithEncoders(122));
			if (switchPos.equals("L")) {
				startLocation = 1;
			} else {
				startLocation = 3;
			}
			turnAngle = 90*(startLocation-2)*(-1);
			addSequential(new Rotate(-turnAngle));
			addSequential(new MoveWithEncoders(335));
			addSequential(new Rotate(turnAngle));
			leftAndRightAuto();
		} else {
			
			leftAndRightAuto();
			
		}
		
		/*else {
			
			int turnAngle = 90*(location-2)*(-1); //90 if at location 1, -90 if at location 3
			
			addSequential(new MoveWithUltrasonic(true)); //Move up to switch
			addSequential(new MoveWithUltrasonic(false)); //Move past switch
			addSequential(new Rotate(turnAngle));
			addSequential(new MoveWithColorSensor(alliance));
			if ((switchPos.equals("L") && location == 0) || (switchPos.equals("R") && location == 3)) {
				addSequential(new Rotate(turnAngle));
				addSequential(new OuttakeCommand());
				addSequential(new IntakeCommand());
				if ((scalePos.equals("L") && location == 0) || (scalePos.equals("R") && location == 3)) {				
					addSequential(new Rotate(180));
					//add lift command
					addSequential(new OuttakeCommand());
				} else {
					addSequential(new Rotate(-turnAngle));
					addSequential(new MoveWithColorSensor(alliance));
					addSequential(new Rotate(-turnAngle));
					//Add lift command
					addSequential(new OuttakeCommand());
					
				}
			} else {
				
				
				
				if ((scalePos.equals("L") && location == 0) || (scalePos.equals("R") && location == 3)) {				
					addSequential(new Rotate(-turnAngle));
					//add lift command
					addSequential(new OuttakeCommand());
					addSequential(new Rotate(turnAngle));
					
				}
				addSequential(new MoveWithColorSensor(alliance));
				addSequential(new Rotate(turnAngle));
				addSequential(new OuttakeCommand());
				addSequential(new IntakeCommand());
				if (!((scalePos.equals("L") && location == 0) || (scalePos.equals("R") && location == 3))) {				
					addSequential(new Rotate(180));
					//add lift command
					addSequential(new OuttakeCommand());					
				}
			}
		}
		*/
	}
	
	private void scoreSwitch() {
		addSequential(new Rotate(turnAngle));
		addSequential(new OuttakeCommand());
		scoredSwitch = true;
		addSequential(new IntakeCommand());
		addSequential(new Rotate(-turnAngle));
	}
	
	private void scoreScale() {
		addSequential(new Rotate(-turnAngle));
		//add lift command
		addSequential(new OuttakeCommand());
		scoredScale = true;
		addSequential(new Rotate(90));
	}
	
	private void checkSwitchAndScale() {
		if ((switchPos.equals("L") && robotLocation == 0) || (switchPos.equals("R") && robotLocation == 3)) {
			scoreSwitch();
		}
		if ((scalePos.equals("L") && robotLocation == 0) || (scalePos.equals("R") && robotLocation == 3)) {				
			scoreScale();
		}
	}
	
	private void leftAndRightAuto() {
		turnAngle = 90*(startLocation-2)*(-1); //90 if at location 1, -90 if at location 3
		
		addSequential(new MoveWithUltrasonic(true)); //Move up to switch
		addSequential(new MoveWithUltrasonic(false)); //Move past switch
		addSequential(new Rotate(turnAngle));
		addSequential(new MoveWithColorSensor(alliance));
		
		checkSwitchAndScale();
		
		if (!scoredSwitch || !scoredScale) {
			addSequential(new MoveWithColorSensor(alliance));
			robotLocation = -(startLocation-2) + 2;
			checkSwitchAndScale();
		}
	}
	/*
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
		//Add lift command
		addSequential(new OuttakeCommand());
	}
	*/
}
