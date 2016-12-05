package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.RobotMap;
import org.usfirst.frc.team614.robot.commands.drivetrain.JoystickDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The drivetrain of the robot, consisting of the left motors and right motors.
 */
public class Drivetrain extends Subsystem {
	
	// VictorSP motor controllers
	VictorSP leftMotor = new VictorSP(RobotMap.drivetrainLeftMotor);
	VictorSP rightMotor = new VictorSP(RobotMap.drivetrainRightMotor);
	RobotDrive drivetrain;
	
    public Drivetrain() {
    	drivetrain = new RobotDrive(leftMotor, rightMotor);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new JoystickDrive());
    }
    // called by the JoystickDrive command constantly from execute()
    // moves the robot
    public void arcadeDrive(double moveValue, double rotateValue) {
    	drivetrain.arcadeDrive(moveValue, rotateValue);
    }
    // stops the robot
    public void stop() {
    	drivetrain.arcadeDrive(0, 0);
    }
}

