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
	public static int leftPistonOut = 2;

//tank drive motors
	public static int left1 = 6; //14
	public static int left2 = 5; //15
	public static int left3 = 4; //16
	public static int right1 = 11;
	public static int right2 = 12;
	public static int right3 = 13;
	
	
//intake motors
	public static int intake1 = 1;	
	public static int intake2 = 2;	
	

//climb motors
	public static int climb1 = 3; //was 3

//Analog input
	public static int ultrasonicChannel1 = 0;
	public static int ultrasonicChannel2 = 1;

	
	
	
	
	
	

}