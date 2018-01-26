package org.usfirst.frc.team1787.subsystems;

import org.usfirst.frc.team1787.subsystems.CustomPIDController;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;

public class Flywheel {
	
	private static final Flywheel instance = new Flywheel();
	
	//Setting up IDs with more intuitive names
	private final int TURRET_FLYWHEEL_TALON_ID = 5;
	private final int FLYWHEEL_ENCODER_A_CHANNEL = 6;
	private final int FLYWHEEL_ENCODER_B_CHANNEL = 7;
	
	private final double FLYWHEEL_VOLTAGE_SPEED_VALUE = 0.5;
	
	
	private WPI_TalonSRX flywheelMotor = new WPI_TalonSRX(TURRET_FLYWHEEL_TALON_ID);
	
	public Flywheel() {
		
	}
	
	public void runFlywheelVoltage() {
		flywheelMotor.set(FLYWHEEL_VOLTAGE_SPEED_VALUE);
	}
	
	public static Flywheel getInstance() {
		return instance;
	}
	
	
	
	

}
