package org.usfirst.frc.team4645.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous extends CommandGroup {

	//Initialize variables
	
	DriverStation dStation;
	int startLocation;
	String info;
	String switchPos;
	String scalePos;
	DriverStation.Alliance alliance;
	boolean scoredSwitch;
	boolean scoredScale;
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
		startLocation = dStation.getLocation(); //1 is left, 2 is center, 3 is right
		info = dStation.getGameSpecificMessage(); //Three character string
		switchPos = info.substring(0,1); //First character is switch position
		scalePos = info.substring(1,2); //Second character is scale position
		alliance = dStation.getAlliance(); //Alliance color as an frc enum
		scoredSwitch = false; //Have scored in switch
		scoredScale = false; //Have scored in scale
		
		
		
		//Robot begins facing forward
		
		if (startLocation == 2) { //if starting at the center
			addSequential(new MoveWithEncoders(131)); //Move 131 inches forward, possibly change this value
			if (switchPos.equals("L")) { //Check switch position
				startLocation = 1; 
			} else {
				startLocation = 3;
			}
			//When starting at center, the robot will move to the location where the scale is and run the code for that side
			turnAngle = 90*(startLocation-2)*(-1); //90 if at location 1, -90 if at location 3
			addSequential(new Rotate(-turnAngle)); //turn right or left, whichever side alliance switch is on
			addSequential(new MoveWithEncoders(335)); //Move 335 inches to that side, possibly change this value
			addSequential(new Rotate(turnAngle)); //turn to face center of field
			leftAndRightAuto(); //Run code for left and right starting positions
		} else {
			
			leftAndRightAuto(); //Run code for left and right starting positions
			
		}
		
		
	}
	
	private void leftAndRightAuto() {
		turnAngle = 90*(startLocation-2)*(-1); //90 if at location 1, -90 if at location 3
		
		addSequential(new MoveWithUltrasonic(true)); //Move up to switch
		addSequential(new MoveWithUltrasonic(false)); //Move past switch
		addSequential(new Rotate(turnAngle)); //Turn to face center of field
		addSequential(new MoveWithColorSensor(alliance)); //Move up to tape, positioning between switch and scale		
		checkSwitchAndScale(startLocation);
		
		if (!scoredSwitch || !scoredScale) { //If we haven't scored both, move to the other switch and scale and check them
			addSequential(new MoveWithColorSensor(alliance)); //Move up to next colored tape
			checkSwitchAndScale(-(startLocation-2) + 2); //Check that side of the switch and scale and score
		}
	}
	
	private void checkSwitchAndScale(int checkLocation) {
		if ((switchPos.equals("L") && checkLocation == 0) || (switchPos.equals("R") && checkLocation == 3)) {
			//Check if the switch next to robot is alliance
			scoreSwitch();
		}
		if ((scalePos.equals("L") && checkLocation == 0) || (scalePos.equals("R") && checkLocation == 3)) {			
			//Check if the scale next to robot is alliance
			scoreScale();
		}
	}
	
	private void scoreSwitch() {
		addSequential(new Rotate(turnAngle)); //Turn towards switch
		//lift
		//Move forward
		addSequential(new MoveWithEncoders(1)); //PLACEHOLDER NUMBER CHANGE THIS

		addSequential(new OuttakeCommand()); //Outtake into switch
		scoredSwitch = true;
		//Move back
		addSequential(new MoveWithEncoders(-1)); //PLACEHOLDER NUMBER CHANGE THIS

		addSequential(new IntakeCommand()); //Intake cube in front of the switch
		addSequential(new Rotate(-turnAngle)); //Rotate towards center of field
	}
	
	private void scoreScale() {
		addSequential(new Rotate(-turnAngle)); //Turn towards scale
		addSequential(new MoveWithEncoders(1)); //PLACEHOLDER NUMBER CHANGE THIS
		//move forward
		//add lift command
		addSequential(new OuttakeCommand()); //Outtake into scale
		scoredScale = true;
		//Move back
		addSequential(new Rotate(90)); //Rotate towards center of field
	}
	
	
	
	
	
}
