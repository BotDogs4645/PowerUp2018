package org.usfirst.frc.team4645.robot.subsystems;

import org.usfirst.frc.team4645.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
//import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class LiftSubsystem extends PIDSubsystem {
	private  WPI_TalonSRX liftMotor = new WPI_TalonSRX(RobotMap.climb1);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public LiftSubsystem()
	{
		super("climbing", 0, 0, 0);
		getPIDController().setContinuous(false);
		liftMotor.setSensorPhase(true);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void init()
    {
		liftMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 10);
		liftMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
    }
    	public void climbUp()
    {
    		liftMotor.set(-.3);
    	
    }
    	public void climbDown()
    {
    		liftMotor.set(.3);
    	
    }
    	
    	public void climbStop()
    {
    		liftMotor.set(0);
    	
    }

    public void setEncoderPosition(int pos) 
    {
    		liftMotor.setSelectedSensorPosition(pos, 0, 0);
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


