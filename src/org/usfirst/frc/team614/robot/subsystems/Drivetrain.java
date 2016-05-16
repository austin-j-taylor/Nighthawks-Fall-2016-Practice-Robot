package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.commands.drivetrain.JoystickDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
	
	//VictorSP leftMotor, rightMotor;
	VictorSP leftMotor = new VictorSP(1);
	VictorSP rightMotor = new VictorSP(0);
	RobotDrive drivetrain;
	
	    public Drivetrain() {
    	drivetrain = new RobotDrive(leftMotor, rightMotor);
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	    public void arcadeDrive(double leftValue, double rightValue) {
	    	drivetrain.arcadeDrive(leftValue, rightValue);
	    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new JoystickDrive());
    }
}

