package org.usfirst.frc.team4645.robot.subsystems;

import org.usfirst.frc.team4645.robot.Robot;
import org.usfirst.frc.team4645.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
//import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class LiftSubsystem extends PIDSubsystem {
	public WPI_TalonSRX liftMotor = new WPI_TalonSRX(RobotMap.lift);


	
	public LiftSubsystem()
	{
		super("lifting", 0.0001 , 0.0000001, 00);
		//setContinuous(false);
		setAbsoluteTolerance(100);
		
		getPIDController().setContinuous(false);
		liftMotor.setSensorPhase(false); // set led green when going positive direction
		setEncoderPosition(0);
		
		
	}

    public void initDefaultCommand() {

    }
    
    public void init()
    
    {
		//Was in init
		setOutputRange(-0.4, 0.7);
		liftMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 10);
		liftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 10);
		liftMotor.setInverted(false); //should go counter clockwise
    	
    }
    

    
    public void liftUp()
    {
    	liftMotor.set(-.3);
    	
    }
    	
    public void liftDown()
    {
    	liftMotor.set(.3);
    	
    }
    	
    public void liftStop()
    {
    	liftMotor.stopMotor();
    	
    }

    public void setEncoderPosition(int pos) 
    { 
    	liftMotor.setSelectedSensorPosition(pos, 0, 0);
    }
    
    public void setTargetPosition(double pos) {
    		getPIDController().setSetpoint(pos);
    }

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		SmartDashboard.putNumber("PID input(lift encoder)", liftMotor.getSelectedSensorPosition(0));
		return liftMotor.getSelectedSensorPosition(0);

	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		liftMotor.pidWrite(output);
		SmartDashboard.putNumber("PID output(lift power)", output);
		
	}
}


