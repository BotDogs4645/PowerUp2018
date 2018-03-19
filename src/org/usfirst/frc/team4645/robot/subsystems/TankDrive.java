
package org.usfirst.frc.team4645.robot.subsystems;
import org.usfirst.frc.team4645.robot.OI;
import org.usfirst.frc.team4645.robot.sources.LeftPIDSource;
import org.usfirst.frc.team4645.robot.sources.RightPIDSource;
import org.usfirst.frc.team4645.robot.RobotMap;
import org.usfirst.frc.team4645.robot.commands.DriveCommand;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.PIDController;


public class TankDrive extends Subsystem 
{
	
	public WPI_TalonSRX motorL1 = new WPI_TalonSRX(RobotMap.left1);
	public WPI_TalonSRX motorL2 = new WPI_TalonSRX(RobotMap.left2);
	public WPI_TalonSRX motorL3 = new WPI_TalonSRX(RobotMap.left3);
	
	public WPI_TalonSRX motorR1 = new WPI_TalonSRX(RobotMap.right1);
	public WPI_TalonSRX motorR2 = new WPI_TalonSRX(RobotMap.right2);
	public WPI_TalonSRX motorR3 = new WPI_TalonSRX(RobotMap.right3);
	
	DifferentialDrive robotDrive = new DifferentialDrive(motorL1, motorR1);
	
	private LeftPIDSource leftPIDSource = new LeftPIDSource();
	private RightPIDSource rightPIDSource = new RightPIDSource();

	//Sets PID values (kp, ki, kd, PIDSource, PIDOutput)
	public PIDController leftEncoderPID = new PIDController(0.004,0,0, leftPIDSource ,motorL1);
	public PIDController rightEncoderPID = new PIDController(0.004,0,0, rightPIDSource ,motorR1);

    public void initDefaultCommand() 
    {

    		setDefaultCommand(new DriveCommand());
    }
    
	public TankDrive()
	{
		//super("drivetrain", 0.04, 00.1, 0.000);//0.004 worked for awhile
		/*
		setAbsoluteTolerance(100); //sets absolute error which is considered tolerable
		getPIDController().setContinuous(false);//sets max & min values as constraints ALWAYS SET AS FALSE
		motorL1.setSensorPhase(true);
		motorR1.setSensorPhase(true);
		*/		
	}    
      
    public void init()
    {
    		//setOutputRange(-0.2, 0.2);
    		//motors on "middle" gear are slaved and inverted with motor on top gear
		motorL2.follow(motorL1);
		motorL3.follow(motorL1);
		motorL2.setInverted(true);
		motorL3.setInverted(true);
			
		motorR2.follow(motorR1);
		motorR3.follow(motorR1);
		motorR2.setInverted(true);
		motorR3.setInverted(true);	
    }
    
    public void configureEncoders()//apply to where init() is used
    {
		//Sets the period of the given status frame(20ms) to 1 ms and the timeout value to 10ms 
		motorR1.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 10);		
		motorL1.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 10);
		
		//selects the optical encoder, sets it as a closed loop, and sets timeout to 10ms
		motorR1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);	
		motorL1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);  
		
		motorL1.setSensorPhase(true);
		motorR1.setSensorPhase(true);
		
		leftEncoderPID.setContinuous(false);
		rightEncoderPID.setContinuous(false);
		
		leftEncoderPID.setAbsoluteTolerance(100);
		rightEncoderPID.setAbsoluteTolerance(100);
    }    
    
    public void driveWithJoystick()
    {
		double forward = (OI.joystick1.getY());
		double turn = -(OI.joystick1.getZ()); //make negative?

		/* deadband */
		
		if ((Math.abs(forward) < 0.30) && (Math.abs(turn) < 0.30)) 
		{
			SmartDashboard.putNumber("Motor power w/ joystick", motorL1.get());
			/* within 10% joystick, make it zero */
			stop();			
		}

		else 
		{
			SmartDashboard.putNumber("JoyY:",  forward);
			SmartDashboard.putNumber("Turn", turn);
			SmartDashboard.putNumber("Motor power w/ joystick", motorL1.get());

			robotDrive.arcadeDrive(forward, turn);
			SmartDashboard.putNumber("Left Sensor Velocity(joystick command)", getLeftVelocity() );
		}
	}
    
    
    public void setOutputRange(double speed)
    {
    		leftEncoderPID.setOutputRange(-speed, speed);
    		rightEncoderPID.setOutputRange(-speed, speed);
    }
    
    public void enablePIDS()
    { 
    		rightEncoderPID.enable();
    		leftEncoderPID.enable();
    }
    
    public void disablePIDS()
    { 
    		rightEncoderPID.disable();
    		leftEncoderPID.disable();
    }    
    
	public double getLeftPosition() 
	{
		return motorL1.getSelectedSensorPosition(0);	
	}
	
	public double getRightPosition() 
	{
		return motorR1.getSelectedSensorPosition(0);	
	}	
	
	public double getLeftVelocity() 
	{
		return motorL1.getSelectedSensorVelocity(0);	
	}	
	
	public double getRightVelocity() 
	{
		return motorR1.getSelectedSensorVelocity(0);	
	}	
	
    public void move(double speed) 
    {
    		motorL1.set(-speed);
    		motorR1.set(speed);
    }
	
    public void stop()
    {
		motorL1.set(0);
		motorR1.set(0);
	}
    
    public void setEncoderPositions(int pos) 
    {
    		motorL1.setSelectedSensorPosition(pos, 0, 0);
    		motorR1.setSelectedSensorPosition(pos, 0, 0);
    }
    
    public void setRightEncoderSetpoint(double setpoint) 
    {
    		rightEncoderPID.setSetpoint(setpoint);
    }
    
    public void setLeftEncoderSetpoint(double setpoint) 
    {
		leftEncoderPID.setSetpoint(setpoint);
    }		    
    
	/*

	@Override
	protected void usePIDOutput(double output) 
	{
		//if (getPIDController().isEnable())
		// TODO Auto-generated method stub
			
			motorL1.pidWrite(output);
			motorR1.pidWrite(output);
			SmartDashboard.putNumber("PID output", output);
			
			SmartDashboard.putNumber("Motor output", motorL1.get());
			
			
		
	}  
	
	 */

}