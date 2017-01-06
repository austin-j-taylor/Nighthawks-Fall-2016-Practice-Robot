
package org.usfirst.frc.team614.robot.commands.drivetrain;

import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Makes the drivetrain move at .5 speed for 1 second
 */
public class DriveStraight extends Command {

    public DriveStraight() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while(Robot.navX.getYaw() > 1 || Robot.navX.getYaw() < -1) {
	    	Robot.navX.zeroYaw();
	    	Robot.printNavxData();
	    	Robot.drivetrain.getController().enable();
	    	Robot.drivetrain.setUsingPID(true);
    	}
    	Robot.drivetrain.arcadeDrive(SmartDashboard.getNumber("SpeedValue", 0), Robot.drivetrain.getRotateRate());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.getController().disable();
    	Robot.drivetrain.setUsingPID(false);
    	Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drivetrain.getController().disable();
    	Robot.drivetrain.setUsingPID(false);
    	Robot.drivetrain.stop();
    }
}
