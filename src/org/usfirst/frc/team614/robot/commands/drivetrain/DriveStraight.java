
package org.usfirst.frc.team614.robot.commands.drivetrain;

import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Makes the drivetrain move at .5 speed for 1 second
 */
public class DriveStraight extends Command {
	private double speed;
//	boolean movingRight = true;

    public DriveStraight(double forwardValue) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
        speed = forwardValue;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.navX.zeroYaw();
    	Robot.printNavxData();
    	Robot.drivetrain.setUsingPID(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.arcadeDrive(SmartDashboard.getNumber("SpeedValue", 0), Robot.drivetrain.getRotateRate());
//    	Robot.drivetrain.setMoveSpeed(SmartDashboard.getNumber("SpeedValue", 0));
//    	if(Robot.navX.getYaw() > 0) {
//    		Robot.drivetrain.arcadeDrive(SmartDashboard.getNumber("SpeedValue", .1), -SmartDashboard.getNumber("RotateValue", .1));
//    	} else if(Robot.navX.getYaw() < 0) {
//    		Robot.drivetrain.arcadeDrive(SmartDashboard.getNumber("SpeedValue", .1), SmartDashboard.getNumber("RotateValue", .1));
//    	} else
//    		Robot.drivetrain.arcadeDrive(SmartDashboard.getNumber("SpeedValue", .1), 0);
    	
//    	if(movingRight) {
//    		Robot.drivetrain.arcadeDrive(speed, 0.0);
//	    	if(Robot.navX.getYaw() > 3)
//	    		movingRight = false;
//    	} else {
//    		Robot.drivetrain.arcadeDrive(0.5, 0.0);
//	    	if(Robot.navX.getYaw() < 0)
//	    		movingRight = true;
//    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drivetrain.stop();
    }
}
