package org.usfirst.frc.team4645.robot.subsystems;

import org.usfirst.frc.team4645.robot.commands.GetBatteryVoltage;
import org.usfirst.frc.team4645.robot.commands.ManagePower;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PowerManagement extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	PowerDistributionPanel pdp = new PowerDistributionPanel();
	
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

    public void initDefaultCommand() { 
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ManagePower());
    }
}

