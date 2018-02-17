package org.usfirst.frc.team4645.robot.subsystems;


import org.usfirst.frc.team4645.robot.commands.GetBatteryVoltage;
import org.usfirst.frc.team4645.robot.commands.ManagePower;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PowerManagement extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public PowerDistributionPanel pdp = new PowerDistributionPanel();
	
	public double[] voltageList = new double[16];
	
	public double getBatteryVoltage() {
		return pdp.getVoltage();
	}
	
	public int maxCurrent() {
		int max = 0;
		for (int i = 0; i <= 15; i ++) {
			if (pdp.getCurrent(i) >= pdp.getCurrent(max)) {
				max = i;
			}
		}
		return max;
	}

	public void displayCurrents() {
		
		for (int i = 0; i <= 15; i++) {
			SmartDashboard.putNumber("Current " + i, pdp.getCurrent(i));
		}
	}
	
	public void updateCurrentOrder() {
		for (int i = 0; i <= 15; i++) {
			voltageList[i] = pdp.getCurrent(i);
		}
		java.util.Arrays.sort(voltageList);
	}
	
    public void initDefaultCommand() { 
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ManagePower());
    }
}

