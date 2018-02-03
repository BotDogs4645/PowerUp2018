/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4645.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap 
{

//pneumatics
	public static int leftPistonIn = 1;
	public static int leftPistonOut =2;

//tank drive motors
	public static int left1 = 1;
	public static int left2 = 2;
	public static int left3 = 3;
	public static int right1 = 4;
	public static int right2 = 5;
	public static int right3 = 6;
	
	
//intake motors
	public static int intake1 = 12;	
	public static int intake2 = 13;	
	

//climb motors
	public static int climb1 = 10;	
	public static int climb2 = 14;	
	
	
//encoder motors
	public static int encoderMotor1=11;



	
	
	
	
	
	

}
