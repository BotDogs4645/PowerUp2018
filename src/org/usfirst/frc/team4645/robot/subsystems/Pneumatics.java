package org.usfirst.frc.team4645.robot.subsystems;

import org.usfirst.frc.team4645.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Pneumatics extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	//Creates solenoid object
	
		DoubleSolenoid solenoid1 = new DoubleSolenoid(RobotMap.leftPiston1, RobotMap.leftPiston2);
		DoubleSolenoid solenoid2 = new DoubleSolenoid(RobotMap.rightPiston1, RobotMap.rightPiston2);
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void out() {
    	solenoid1.set(DoubleSolenoid.Value.kForward);
    	solenoid2.set(DoubleSolenoid.Value.kForward);
    	SmartDashboard.putString("Pnuematics","Out");
    }
    
    public void in() 
    {
    	solenoid1.set(DoubleSolenoid.Value.kReverse);
    	solenoid2.set(DoubleSolenoid.Value.kReverse);
    	SmartDashboard.putString("Pnuematics","In");
    }
    
    public void rest() {
    	solenoid1.set(DoubleSolenoid.Value.kOff);
    	solenoid2.set(DoubleSolenoid.Value.kOff);
    }

}

