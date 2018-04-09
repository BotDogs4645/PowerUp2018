package org.usfirst.frc.team4645.robot.subsystems;

import org.usfirst.frc.team4645.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Pneumatics extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	//Creates solenoid object
	
		//DoubleSolenoid solenoid = new DoubleSolenoid(RobotMap.leftPistonIn,RobotMap.leftPistonOut);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void out() {
    	/*solenoid.set(DoubleSolenoid.Value.kForward);
    	SmartDashboard.putString("Pnuematics","Out");*/
    }
    
    public void in() 
    {
    	/*solenoid.set(DoubleSolenoid.Value.kReverse);
    	SmartDashboard.putString("Pnuematics","In");*/
    }
    
    public void rest() {
    	//solenoid.set(DoubleSolenoid.Value.kOff);
    }

}

