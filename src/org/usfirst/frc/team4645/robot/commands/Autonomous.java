package org.usfirst.frc.team4645.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
//import org.usfirst.frc.team4645.robot.*;

/**
 *
 */
public class Autonomous extends CommandGroup {
	
	//Declare Variables
	
	/*
	DriverStation dStation;
	int startLocation;
	String info;
	String switchPos;
	String scalePos;
	DriverStation.Alliance alliance;
	*/
	
    public Autonomous() {
    	
    	//Initialize Variables
    	/*
    	dStation = DriverStation.getInstance();
    	startLocation = dStation.getLocation();
    	info = dStation.getGameSpecificMessage();
    	switchPos = info.substring(0,1);
    	scalePos = info.substring(1,2);
    	alliance = dStation.getAlliance();
    	*/
    	
    	
    	addSequential(new DriveForwardTime(1.25));//drive forward //1.7
    	
    	//addSequential(new TurnWithTime(0,0, 2));//wait
    	
    	
    	
    	
    	//Code for turning, comment out if we dont need to turn
    	/*
    	if (startLocation == 1 && switchPos.equalsIgnoreCase("L")) {
    		//Turn right
    		addSequential(new TurnWithTime(-0.5,0.5, 1.0));
    		
    	} else if (startLocation == 3 && switchPos.equalsIgnoreCase("R")) {
    		//Turn left
    		addSequential(new TurnWithTime(0.5,-0.5, 1.0));
    	}
    	
    	*/
    	//addSequential(new LiftSetTarget(20000));//lift
    	//addParallel(new WaitAndOuttake());//outtake
    	
    	
    	
    }
}
