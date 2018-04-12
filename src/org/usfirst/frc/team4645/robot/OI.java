/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4645.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team4645.robot.commands.Autonomous;
import org.usfirst.frc.team4645.robot.commands.IntakeCommand;
import org.usfirst.frc.team4645.robot.commands.LiftSetTarget;
import org.usfirst.frc.team4645.robot.commands.OuttakeCommand;
import org.usfirst.frc.team4645.robot.commands.PneumaticsCommandIn;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI
{

	public static Joystick joystick1 = new Joystick(0);
	
	public static Joystick joystick2 = new Joystick(1);
	
	//JOYSTICK1
	Button driveTrainPneumatics = new JoystickButton(joystick1,3);
	Button winchPneumatics = new JoystickButton(joystick1,4);
	
	Button buttonIntake = new JoystickButton(joystick1,7);
	Button buttonOuttake = new JoystickButton(joystick1,8);
	
	//JOYSTICK2
	Button liftGround = new JoystickButton(joystick2, 3);
	Button liftSwitch = new JoystickButton(joystick2, 4);

	Button buttonClimbUp = new JoystickButton(joystick2,7);
	Button buttonClimbDown = new JoystickButton(joystick2,8);	
	
	//temporary buttons for testing purposes
	Button liftUp = new JoystickButton(joystick2, 10);
	Button liftDown = new JoystickButton(joystick2,9);
	
	
	

	
	
	public OI()
	{
	//	driveTrainPneumatics.whileHeld(new PneumaticsCommandIn());
	//	winchPneumatics.whileHeld(new PneumaticsCommandIn());
		
		buttonIntake.whileHeld(new IntakeCommand());
		buttonOuttake.whileHeld(new OuttakeCommand());
		
		buttonClimbUp.whenPressed(new Autonomous());
		
		
		
		//liftUp.whileHeld(new LiftCommandUp());
		//liftDown.whileHeld(new LiftCommandDown());
		
		liftGround.whenPressed(new LiftSetTarget(000));
		liftSwitch.whenPressed(new LiftSetTarget(23000));
		
		
	}

	
}
