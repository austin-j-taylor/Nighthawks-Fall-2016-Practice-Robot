package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Uses two flywheels and a piston to shoot a ball.
 */
public class Shooter extends Subsystem {
    
	VictorSP shooterLeftMotor = new VictorSP(RobotMap.shooterLeftMotor);
	VictorSP shooterRightMotor = new VictorSP(RobotMap.shooterRightMotor);
	
	public Shooter() {
	}
	// spins the flywheels out to shoot a ball
	public void revOut() {
		shooterLeftMotor.set(-1.0);
		shooterRightMotor.set(1.0);
	}
	// spins the flywheels in to take in a ball
	public void revIn() {
		shooterLeftMotor.set(1.0);
		shooterRightMotor.set(-1.0);
	}
	// stops the flywheels
	public void stop() {
		shooterLeftMotor.set(0.0);
		shooterRightMotor.set(0.0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

