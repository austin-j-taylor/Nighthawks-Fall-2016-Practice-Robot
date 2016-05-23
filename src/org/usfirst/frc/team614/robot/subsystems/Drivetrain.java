package org.usfirst.frc.team614.robot.subsystems;

import org.team708.robot.util.Gamepad;
import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.OI;
import org.usfirst.frc.team614.robot.commands.drivetrain.JoystickDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {

	private final double SPEED_SCALE = 1.0;
	
	/*
	 * RobotDrive enumerations for motors:
		    static final int kFrontLeft_val = 0;
		    static final int kFrontRight_val = 1;
		    static final int kRearLeft_val = 2;
		    static final int kRearRight_val = 3;
	 */
	
//	 REVERSE N (MECANUM STANDARD):
	VictorSP frontleftMotor = new VictorSP(0);
	VictorSP backleftMotor = new VictorSP(1);
	VictorSP frontrightMotor = new VictorSP(2);
	VictorSP backrightMotor = new VictorSP(3);
	
//	 RobotDrive ENUMERATION:
//	VictorSP frontleftMotor = new VictorSP(0);
//	VictorSP backleftMotor = new VictorSP(2);
//	VictorSP frontrightMotor = new VictorSP(1);
//	VictorSP backrightMotor = new VictorSP(3);
	
//	U:
//	VictorSP frontleftMotor = new VictorSP(0);
//	VictorSP backleftMotor = new VictorSP(1);
//	VictorSP frontrightMotor = new VictorSP(3);
//	VictorSP backrightMotor = new VictorSP(2);
	
	RobotDrive drivetrain;
	
	    public Drivetrain() {
	    	drivetrain = new RobotDrive(frontleftMotor, backleftMotor, frontrightMotor, backrightMotor);
//	        drivetrain.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
//	        drivetrain.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
	        drivetrain.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
	        drivetrain.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
	        
	    }
	    public void mecanumDriveMode(double magnitude, double direction, double rotation) { 
	    	drivetrain.mecanumDrive_Polar(magnitude / SPEED_SCALE, direction, rotation / SPEED_SCALE); //To increase the sensitivity, decrease SPEED_SCALE to a number below one but above 0
																			//To decrease the sensitivity, increase SPEED_SCALE to a number above one; 		SPEED_SCALE is here until a proper ramp function is implemented
	    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new JoystickDrive());
    }
}

