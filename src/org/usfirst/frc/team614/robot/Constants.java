package org.usfirst.frc.team614.robot;

// Constants used throughout the project

public class Constants {
	

	/*
	 * PID Tuning Parameters
	 */
	
	public static final double Kp = 0.0;
	public static final double Ki = 0.0;
	public static final double Kd = 0.0;
	
	// Shooter
	public static final double MOTOR_FORWARD = 1.0;
	public static final double MOTOR_REVERSE = 1.0;
	public static final double MOTOR_UP = .1;
	public static final double MOTOR_DOWN = .1;
	
	public static final double ANGLE_REDUCTION_SPEED_DOWN = 1;
	public static final double ANGLE_REDUCTION_SPEED_UP = 1;
	
	public static final double TARGET_RATE = 760000; // to be change when the max rate of the flywheels are
}
