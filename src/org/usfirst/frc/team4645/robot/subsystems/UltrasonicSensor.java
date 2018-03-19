package org.usfirst.frc.team4645.robot.subsystems;

import org.usfirst.frc.team4645.robot.RobotMap;
//import org.usfirst.frc.team4645.robot.commands.DetectDistance;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class UltrasonicSensor extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private AnalogInput dSensor1 = new AnalogInput(RobotMap.ultrasonicChannel1); //Create analog input object
	private AnalogInput dSensor2 = new AnalogInput(RobotMap.ultrasonicChannel2);
	AnalogInput[] dSensors = {dSensor1, dSensor2};
	public double getDistance(int port) {
		double voltage = dSensors[port].getVoltage(); //Analog voltage from distance sensor
		
		double rangemm = ((voltage*1000)/4.88)*5; //Voltage scaling from sensor documentation
		double rangecm = (rangemm/10); //Convert mm to cm
		
		return rangecm;

	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//setDefaultCommand(new DetectDistance());
    }
}

