package org.usfirst.frc.team4645.robot.subsystems;

import org.usfirst.frc.team4645.robot.commands.GetBatteryVoltage;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PowerManagement extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void getBatteryVoltage() {
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new GetBatteryVoltage());
    }
}

