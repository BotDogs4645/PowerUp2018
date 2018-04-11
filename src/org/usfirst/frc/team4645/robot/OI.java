
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc.team4645.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team4645.robot.commands.ClimbCommandDown;
import org.usfirst.frc.team4645.robot.commands.ClimbCommandUp;
import org.usfirst.frc.team4645.robot.commands.IntakeCommand;
import org.usfirst.frc.team4645.robot.commands.MoveWithColorSensor;
import org.usfirst.frc.team4645.robot.commands.MoveWithUltrasonic;
import org.usfirst.frc.team4645.robot.commands.OuttakeCommand;
import org.usfirst.frc.team4645.robot.commands.PneumaticsCommandIn;



/**
* This class is the glue that binds the controls on the physical operator
* interface to the commands and command groups that allow control of the robot.
*/


public class OI
{
//creates joytick object
	
	public static Joystick joystick1 = new Joystick(1);
//pneumatics button
	Button button = new JoystickButton(joystick1,3);
	Button buttonIntake = new JoystickButton(joystick1,5);
	Button buttonOuttake = new JoystickButton(joystick1,6);
	Button buttonClimbUp = new JoystickButton(joystick1,7);
	Button buttonClimbDown = new JoystickButton(joystick1,8);
	Button testButton = new JoystickButton(joystick1, 11);

	public OI()
	{
		button.whileHeld(new PneumaticsCommandIn());
		buttonIntake.whileHeld(new IntakeCommand());
		buttonOuttake.whileHeld(new OuttakeCommand());
		buttonClimbUp.whileHeld(new ClimbCommandUp());
		buttonClimbDown.whileHeld(new ClimbCommandDown());
		testButton.whenPressed(new MoveWithUltrasonic(false));
	}
}
