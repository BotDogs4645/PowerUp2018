package org.usfirst.frc.team4645.robot.subsystems;
import org.usfirst.frc.team4645.robot.OI;
import org.usfirst.frc.team4645.robot.RobotMap;
import org.usfirst.frc.team4645.robot.commands.DriveCommand;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class TankDrive extends Subsystem 
{

	//all motors are assigned to either left or right gearbox	
	public WPI_TalonSRX motorL1 = new WPI_TalonSRX(RobotMap.left1);
	public WPI_TalonSRX motorL2 = new WPI_TalonSRX(RobotMap.left2);
	public  WPI_TalonSRX motorL3 = new WPI_TalonSRX(RobotMap.left3);
	
	public WPI_TalonSRX motorR1 = new WPI_TalonSRX(RobotMap.right1);
	public WPI_TalonSRX motorR2 = new WPI_TalonSRX(RobotMap.right2);
	public WPI_TalonSRX motorR3 = new WPI_TalonSRX(RobotMap.right3);
	
	//robotDrive only assigned to motorL1 & motorR1 
	DifferentialDrive robotDrive = new DifferentialDrive(motorL1, motorR1);

    public void initDefaultCommand() 
    {

    		setDefaultCommand(new DriveCommand());
    }
    
    public void init()
    {
    		//motors on "middle" gear are slaved and inverted with motor on "top" gear
		motorL2.follow(motorL1);
		motorL3.follow(motorL1);
		motorL2.setInverted(true);
		motorL3.setInverted(true);
			
		motorR2.follow(motorR1);
		motorR3.follow(motorR1);
		motorR2.setInverted(true);
		motorR3.setInverted(true);
    }
    
    public void driveWithJoystick()
    {
		double forward = OI.joystick1.getY();
		double turn = OI.joystick1.getZ();

		/* deadband */
		if (Math.abs(forward) < 0.20) 
		{
			/* within 20% joystick, make it zero */
			forward = 0;
		}
		
		if (Math.abs(turn) < 0.20) 
		{
			/* within 20% joystick, make it zero */
			turn = 0;
		}
		
		SmartDashboard.putNumber("JoyY:",  forward);
		SmartDashboard.putNumber("Turn", turn);		
	
		robotDrive.arcadeDrive(forward, turn);		
	}
  
    	
    public void stop()
    {
		motorL1.set(0);
		motorR1.set(0);

	}
    
}