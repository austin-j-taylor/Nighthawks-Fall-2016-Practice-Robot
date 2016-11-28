
package org.usfirst.frc.team614.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team614.robot.Robot;

/**
 *
 */
public class TogglePiston extends Command {

    public TogglePiston() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		Robot.pneumatics.extendPiston();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	Robot.drivetrain.arcadeDrive(0.5, 0.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
		Robot.pneumatics.retractPiston();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
		Robot.pneumatics.retractPiston();
    }
}
