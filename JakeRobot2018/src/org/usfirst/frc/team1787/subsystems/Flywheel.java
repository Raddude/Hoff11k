package org.usfirst.frc.team1787.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Flywheel {
	
	private static final Flywheel instance = new Flywheel();
	
	//Setting up IDs with more intuitive names
	private final int TURRET_FLYWHEEL_TALON_ID = 5;
	private final int FLYWHEEL_ENCODER_A_CHANNEL = 6;
	private final int FLYWHEEL_ENCODER_B_CHANNEL = 7;
	
	private final double FLYWHEEL_VOLTAGE_SPEED_VALUE = 0.6;
	
	
	private WPI_TalonSRX flywheelMotor = new WPI_TalonSRX(TURRET_FLYWHEEL_TALON_ID);
	private Encoder flywheelEncoder = new Encoder(FLYWHEEL_ENCODER_A_CHANNEL, FLYWHEEL_ENCODER_B_CHANNEL);
	
	//PID Variables
	private double FLYWHEEL_KP = 0;
	private double FLYWHEEL_KI = 0;
	private double FLYWHEEL_KD = 0;
	private double FLYWHEEL_KF = 0;
	private double FLYWHEEL_TARGET_SPEED = 5;
	
	private PIDController flywheelController = new PIDController(FLYWHEEL_KP, FLYWHEEL_KI, FLYWHEEL_KD, FLYWHEEL_KF, flywheelEncoder, flywheelMotor, PIDController.kDefaultPeriod);
	
	public Flywheel() {
		
	}
	
	public void runFlywheelVoltage() {
		flywheelMotor.set(FLYWHEEL_VOLTAGE_SPEED_VALUE);
	}
	
	public void runFlywheelPID() {
		flywheelController.setSetpoint(FLYWHEEL_TARGET_SPEED);
		flywheelController.enable();
	}
	
	public void stopFlywheel() {
		flywheelController.reset();
	}
	
	public void sendShuffleboadData() {
		SmartDashboard.putData("Flywheel PID Controller", flywheelController);
		SmartDashboard.putData("Flywheel Encoder", flywheelEncoder);
	}
	
	public static Flywheel getInstance() {
		return instance;
	}
	
	
	
	

}
