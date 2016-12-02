package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
    
	VictorSP shooterLeftMotor = new VictorSP(RobotMap.shooterLeftMotor);
	VictorSP shooterRightMotor = new VictorSP(RobotMap.shooterRightMotor);
	
	public Shooter() {
		
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void revOut() {
		shooterLeftMotor.set(-1.0);
		shooterRightMotor.set(1.0);
	}
	public void stop() {
		shooterLeftMotor.set(0.0);
		shooterRightMotor.set(0.0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

