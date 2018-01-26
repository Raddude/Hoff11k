package OldVersions;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.hal.HAL;
import edu.wpi.first.wpilibj.hal.FRCNetComm.tInstances;
import edu.wpi.first.wpilibj.hal.FRCNetComm.tResourceType;

public class DriveTrain {
	
	private final int FRONT_RIGHT_TALON_ID = 8;
	private final int REAR_RIGHT_TALON_ID = 9;
	private final int FRONT_LEFT_TALON_ID = 6;
	private final int REAR_LEFT_TALON_ID = 7;
	private WPI_TalonSRX frontLeftMotor = new WPI_TalonSRX(FRONT_LEFT_TALON_ID);
	private WPI_TalonSRX backLeftMotor = new WPI_TalonSRX(REAR_LEFT_TALON_ID);	
	private WPI_TalonSRX frontRightMotor = new WPI_TalonSRX(FRONT_RIGHT_TALON_ID);
	private WPI_TalonSRX backRightMotor = new WPI_TalonSRX(REAR_RIGHT_TALON_ID);
	
	private SpeedControllerGroup leftMotors;
	private SpeedControllerGroup rightMotors;
	
	private DifferentialDrive myDrive;

	public DriveTrain() {
		frontLeftMotor.setInverted(true);
		backLeftMotor.setInverted(true);
		frontRightMotor.setInverted(false);
		backRightMotor.setInverted(false);
		//leftMotors = new SpeedControllerGroup(frontLeftMotor, backLeftMotor);
		//rightMotors = new SpeedControllerGroup(frontRightMotor, backRightMotor);
		//myDrive = new DifferentialDrive(leftMotors, rightMotors);
	}
	
	  @SuppressWarnings("ParameterName")
	  public void arcadeDrive(double xSpeed, double zRotation) {

	    double leftMotorOutput;
	    double rightMotorOutput;

	    double maxInput = Math.copySign(Math.max(Math.abs(xSpeed), Math.abs(zRotation)), xSpeed);

	    if (xSpeed >= 0.0) {
	      // First quadrant, else second quadrant
	      if (zRotation >= 0.0) {
	        leftMotorOutput = maxInput;
	        rightMotorOutput = xSpeed - zRotation;
	      } else {
	        leftMotorOutput = xSpeed + zRotation;
	        rightMotorOutput = maxInput;
	      }
	    } else {
	      // Third quadrant, else fourth quadrant
	      if (zRotation >= 0.0) {
	        leftMotorOutput = xSpeed + zRotation;
	        rightMotorOutput = maxInput;
	      } else {
	        leftMotorOutput = maxInput;
	        rightMotorOutput = xSpeed - zRotation;
	      }
	    }
	    
	    frontLeftMotor.set(leftMotorOutput);
	    backLeftMotor.set(leftMotorOutput);
	    System.out.println("Left: " + leftMotorOutput);
	    frontRightMotor.set(rightMotorOutput);
	    backRightMotor.set(rightMotorOutput);
	    System.out.println("Right: " + rightMotorOutput);
	  }
	  
	  public void simpleAutonomous (double timeToRun) {
		  
		  if (autoRunTime < timeToRun) {
			  frontLeftMotor.set(autoMotorSpeed);
			  frontRightMotor.set(autoMotorSpeed);
			  backLeftMotor.set(autoMotorSpeed);
			  backRightMotor.set(autoMotorSpeed);
			  autoRunTime = autoRunTime + 0.02;
			  System.out.println("Driving");
		  }
		  
		  else {
			  autoMotorSpeed = 0;
			  frontLeftMotor.set(autoMotorSpeed);
			  frontRightMotor.set(autoMotorSpeed);
			  backLeftMotor.set(autoMotorSpeed);
			  backRightMotor.set(autoMotorSpeed);
			  System.out.println("Stopped");
		  }
	  }
	  
	  public void resetVariables () {
		  autoRunTime = 0;
	  }

}
