package org.usfirst.frc.team4645.robot.subsystems;

import org.usfirst.frc.team4645.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class UltrasonicSensor extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private AnalogInput dSensor = new AnalogInput(RobotMap.ultrasonicChannel); //Create analog input object
	
	public double getDistance() {
		double voltage = dSensor.getVoltage(); //Analog voltage from distance sensor
		
		double rangemm = ((voltage*1000)/4.88)*5; //Voltage scaling from sensor documentation
		double rangecm = (rangemm/10); //Convert mm to cm
		
		return rangecm;

	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//setDefaultCommand(new GetDistance());
    }
}

