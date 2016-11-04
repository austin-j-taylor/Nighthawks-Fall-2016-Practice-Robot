package org.usfirst.frc.team614.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;

	
	// Motor Controller Ports (PWM)
	// Change these when you shuffle PWM cables around
	public static int drivetrainLeftMotor = 1;
	public static int drivetrainRightMotor = 0;
	
	public static int shooterLeftMotor = 3;
	public static int shooterRightMotor = 2;
	public static int shooterAngleMotor = 4;
	
	
	//Encoder ports (DIO)
		
		//Shooter Encoders
		public static final int leftShooterEncoder_A  = 0;
		public static final int leftShooterEncoder_B  = 1; 
		public static final int rightShooterEncoder_A = 2;
		public static final int rightShooterEncoder_B = 3;
		public static final int angleShooterEncoder_A = 4;
		public static final int angleShooterEncoder_B = 5;
}
