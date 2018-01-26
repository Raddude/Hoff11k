package org.usfirst.frc.team1787.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;

public class Flywheel {
	
	private static final Flywheel instance = new Flywheel();
	
	private final int TURRET_FLYWHEEL_TALON_ID = 5;
	private WPI_TalonSRX flywheelMotor = new WPI_TalonSRX(TURRET_FLYWHEEL_TALON_ID);
	  
	private final int FLYWHEEL_ENCODER_A_CHANNEL = 6;
	private final int FLYWHEEL_ENCODER_B_CHANNEL = 7;
	private final double FLYWHEEL_ENCODER_REVOLUTIONS_PER_PULSE = 1.0 / 2048;
	private Encoder flywheelEncoder = new Encoder(FLYWHEEL_ENCODER_A_CHANNEL, FLYWHEEL_ENCODER_B_CHANNEL);

	
	private final double FLYWHEEL_PID_CONTROLLER_KP = 0;
	private final double FLYWHEEL_PID_CONTROLLER_KI = 0;
	private final double FLYWHEEL_PID_CONTROLLER_KD = 0;
	private final double FLYWHEEL_PID_ABSOLUTE_TOLERENCE_IN_REVOLUTIONS_PER_SECOND = 0;
	
	public Flywheel() {
		
	}
	
	public static Flywheel getInstance() {
		return instance;
	}
	
	

}
