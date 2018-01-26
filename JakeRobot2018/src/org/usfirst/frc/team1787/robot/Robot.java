/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1787.robot;

import org.usfirst.frc.team1787.subsystems.DriveTrain;
import org.usfirst.frc.team1787.subsystems.Flywheel;
import org.usfirst.frc.team1787.subsystems.Autonomous;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends TimedRobot {
	
	protected int farfar38;
	
	private DriveTrain driveTrain = DriveTrain.getInstance();
	private Autonomous autonomous = Autonomous.getInstance();
	private Flywheel flywheel = Flywheel.getInstance();
	
	private final int RIGHT_JOYSTICK_ID = 0;
	private final int LEFT_JOYSTICK_ID = 1;
	private Joystick rightStick = new Joystick(RIGHT_JOYSTICK_ID);
	private Joystick leftStick = new Joystick(LEFT_JOYSTICK_ID);
	
	//Input options
	private int FLYWHEEL_ACTIVATE_BUTTON; //define later
	private int FEEDER_ACTIVATE_BUTTON; //define later
	
	
	
	
	
	@Override
	public void robotInit() {
		
	}

	@Override
	public void autonomousInit() {
		autonomous.resetVariables();
	}
	
	@Override
	public void autonomousPeriodic() {
		autonomous.autonomous1();
	}
	
	@Override
	public void teleopInit() {
		
	}
	
	@Override
	public void teleopPeriodic() {
		driveTrain.arcadeDrive(-rightStick.getY(), rightStick.getX());
		
		if (leftStick.getRawButtonPressed(FLYWHEEL_ACTIVATE_BUTTON)) {
			flywheel.runFlywheelVoltage();
		}
		
		
	}

	@Override
	public void testPeriodic() {
		
	}
}
