package org.usfirst.frc.team4645.robot.subsystems;

import org.usfirst.frc.team4645.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClimbingSubsystem extends Subsystem {
	private  WPI_TalonSRX motorClimb1 = new WPI_TalonSRX(RobotMap.climb1);
	private WPI_TalonSRX motorClimb2 = new WPI_TalonSRX(RobotMap.climb2);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    	public void climbUp()
        {
        	motorClimb1.set(-.5);
        	motorClimb2.set(.5);
        	
        }
    	public void climbDown()
        {
        	motorClimb1.set(.5);
        	motorClimb2.set(-.5);
        	
        }
    	public void climbRest()
        {
        	motorClimb1.set(0);
        	motorClimb2.set(0);
        	
        }
    }


