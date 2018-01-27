package org.usfirst.frc.team1787.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class SlewingRing {
	//Turret talon IDs
	private final int TURRET_TALON_ID = 1;
	private WPI_TalonSRX turretMotor = new WPI_TalonSRX(TURRET_TALON_ID);
	private static final SlewingRing instance = new SlewingRing();
	
	public void turnTurret(double turnValue) {
		if (turnValue > 0.025 || turnValue < -0.025) {
			turretMotor.set(turnValue);
		}
		else  {
			turretMotor.set(0);
		}
	}
	
	
	public static SlewingRing getInstance() {
		return instance;
	}
}
