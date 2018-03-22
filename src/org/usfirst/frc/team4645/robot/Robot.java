package org.usfirst.frc.team4645.robot;
import org.usfirst.frc.team4645.robot.subsystems.LiftSubsystem;
import org.usfirst.frc.team4645.robot.commands.Autonomous;
import org.usfirst.frc.team4645.robot.subsystems.ClimbSubsystem;
import org.usfirst.frc.team4645.robot.subsystems.ColorSensor;
import org.usfirst.frc.team4645.robot.subsystems.IntakeSystem;
import org.usfirst.frc.team4645.robot.subsystems.Pneumatics;
import org.usfirst.frc.team4645.robot.subsystems.TankDrive;
import org.usfirst.frc.team4645.robot.subsystems.UltrasonicSensor;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot 
{
	
	public static final Pneumatics pneumaticsSubsystem= new Pneumatics();
	public static final TankDrive tankDriveSubsystem = new TankDrive();
	public static final IntakeSystem kIntakeSystem= new IntakeSystem();
	public static final LiftSubsystem liftSubsystem= new LiftSubsystem();
	public static final UltrasonicSensor kUltrasonic = new UltrasonicSensor();
	public static final ColorSensor kColorSensor = new ColorSensor();
	public static final ClimbSubsystem climbingSystem= new ClimbSubsystem();
	
	
	
	public static OI oi;

	Command autonomousCommand = new Autonomous();
	SendableChooser<Command> chooser = new SendableChooser<>();
	
	NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");


	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() 
	{
		oi = new OI();
		chooser.addObject("My Auto", new Autonomous());
		SmartDashboard.putData("Auto mode", chooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() 
	{

	}

	@Override
	public void disabledPeriodic() 
	{
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() 
	{
		//autonomousCommand = new Autonomous();
		//autonomousCommand = chooser.getSelected();
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() 
	{
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() 
	{
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() 
	{
		Scheduler.getInstance().run();
		
		NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
		
		NetworkTableEntry led = table.getEntry("ledMode");
		double ledNum = led.getDouble(0);
		
		
		/*NetworkTableEntry tx = table.getEntry("tx");
		NetworkTableEntry ty = table.getEntry("ty");
		NetworkTableEntry ta = table.getEntry("ta");
		NetworkTableEntry tv = table.getEntry("tv");
		NetworkTableEntry ts = table.getEntry("ts");
		NetworkTableEntry tl = table.getEntry("tl");
		
		double x = tx.getDouble(0);
		double y = ty.getDouble(0);
		double area = ta.getDouble(0);
		double v = tv.getDouble(0);
		double s = ts.getDouble(0);
		double l = tl.getDouble(0);
		
		SmartDashboard.putNumber("Whether the limelight has any valid targets (0 or 1)",v);
		SmartDashboard.putNumber("Horizontal Offset From Crosshair To Target (-27 degrees to 27 degrees)",x);
		SmartDashboard.putNumber("Vertical Offset From Crosshair To Target (-20.5 degrees to 20.5 degrees)",y);
		SmartDashboard.putNumber("Target Area (0% of image to 100% of image)",area);
		SmartDashboard.putNumber("Skew or rotation (-90 degrees to 0 degrees)",s);
		SmartDashboard.putNumber("The pipelines latency contribution (ms) Add at least 11ms for image capture latency.",l);*/
		
		
		
		table.getEntry("ledMode").setNumber(1);
		SmartDashboard.putNumber("led", ledNum);
		
		
		
		
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() 
	{
		
	}
}