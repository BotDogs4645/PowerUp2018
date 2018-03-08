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
	private  WPI_TalonSRX liftMotor = new WPI_TalonSRX(RobotMap.lift);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public LiftSubsystem()
	{
		super("lifting", 0.04, 0.001, 0);
		getPIDController().setContinuous(false);
		setAbsoluteTolerance(100);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void init()
    {
    		setOutputRange(-0.7, 0.7);
		liftMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 10);
		liftMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
		liftMotor.setSensorPhase(true);
		liftMotor.setInverted(true); //should go counter clockwise
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


