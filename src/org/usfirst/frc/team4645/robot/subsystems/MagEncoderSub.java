package org.usfirst.frc.team4645.robot.subsystems;

import org.usfirst.frc.team4645.robot.RobotMap;
import org.usfirst.frc.team4645.robot.commands.EncoderCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.*;

/**
 *
 */
public class MagEncoderSub extends Subsystem 
{
	//Creating motor
	public WPI_TalonSRX motorForEncoder1 = new WPI_TalonSRX(RobotMap.encoderMotor1);
	// Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new EncoderCommand(4096));
    }
    public void initEncoder()
    {
    	//Sets the period of the given status frame.


    	motorForEncoder1.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0,1,10);
    	motorForEncoder1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute,0,10);
    }
    
    public void runEncoderMotor()
    {
    	motorForEncoder1.set(.1);
    	
    }
    
    public void restEncoderMotor()
    {
    	motorForEncoder1.set(0);
    }
    
    public void getEncoderVelocity()
    {
    	//Gets velocity per 100ms
    	double velocity= motorForEncoder1.getSelectedSensorVelocity(0);
    	
    	SmartDashboard.putNumber("Velocity:",velocity);
    	SmartDashboard.putNumber("speed", motorForEncoder1.get());


    }
    
    public double getEncoderPosition()
    {
    	//Raw sensor units
    	double position=motorForEncoder1.getSelectedSensorPosition(0);
    	SmartDashboard.putNumber("position:",position);
    	return position;

    }
    
    
    public void goToEncoderCount()
    {
    }
    }

    


