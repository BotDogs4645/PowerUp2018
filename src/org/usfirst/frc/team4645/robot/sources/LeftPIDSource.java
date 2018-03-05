package org.usfirst.frc.team4645.robot.sources;

import org.usfirst.frc.team4645.robot.Robot;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class LeftPIDSource implements PIDSource
{

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public PIDSourceType getPIDSourceType() 
	{
		// TODO Auto-generated method stub
		return PIDSourceType.kDisplacement; //what is kDisplacement
	}

	@Override
	public double pidGet() 
	{
		// TODO Auto-generated method stub
		return Robot.tankDriveSubsystem.getLeftPosition();
	}

}
