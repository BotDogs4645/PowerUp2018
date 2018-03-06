package org.usfirst.frc.team4645.robot.subsystems;

import org.usfirst.frc.team4645.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClimbSubsystem extends Subsystem {
	private  WPI_TalonSRX motorClimb1 = new WPI_TalonSRX(RobotMap.climb1);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    	public void climbUp()
        {
        	motorClimb1.set(-.3);
        	
        }
    	public void climbDown()
        {
        	motorClimb1.set(.3);
        	
        }
    	public void climbStop()
        {
        	motorClimb1.set(0);
        	
        }
    }

