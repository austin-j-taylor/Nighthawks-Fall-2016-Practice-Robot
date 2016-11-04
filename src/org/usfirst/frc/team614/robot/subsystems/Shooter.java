package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.RobotMap;
import org.usfirst.frc.team614.robot.commands.shooter.ShooterDrive;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {

	private VictorSP leftMotor, rightMotor, angleMotor;
	
	public Shooter() {
		//Initializes the motors
		leftMotor = new VictorSP(RobotMap.shooterLeftMotor);
		rightMotor = new VictorSP(RobotMap.shooterRightMotor);
				
		angleMotor = new VictorSP(RobotMap.shooterAngleMotor);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ShooterDrive());
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
    // makes flywheels shoot out the ball
	public void revUpForward(){
		leftMotor.set(-Constants.MOTOR_FORWARD);
		rightMotor.set(Constants.MOTOR_FORWARD);
		
	}
	
	// makes flywheels suck in the ball
	public void revUpReverse(){
		leftMotor.set(-Constants.MOTOR_REVERSE);
		rightMotor.set(Constants.MOTOR_REVERSE);
	}
	
	// makes the flywheels stop
	public void stopFlywheels() {
		leftMotor.set(0);
		rightMotor.set(0);
	}
	
    // sets angle motor speed
	public void setMotorSpeed(double motorSpeed){
		 if(motorSpeed <0){
			 angleMotor.set(motorSpeed*Constants.ANGLE_REDUCTION_SPEED_DOWN);
		 }
		 else if(motorSpeed>0){
			 angleMotor.set(motorSpeed* Constants.ANGLE_REDUCTION_SPEED_UP);
		 }
		 else{
			 angleMotor.set(0);
		 }
	 }
	 /*
	 * Moves the shooter up to shoot higher
	 */
	public void angleUp(){
		angleMotor.set(Constants.MOTOR_UP);
	}
		
	/*
	 * Moves the shooter down to shoot lower
	 */	
	public void angleDown(){
		angleMotor.set(Constants.MOTOR_DOWN);
	}
	
	public void stopAngle(){
		angleMotor.set(0);
	}
}

