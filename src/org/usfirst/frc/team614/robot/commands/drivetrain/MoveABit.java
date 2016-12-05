
package org.usfirst.frc.team614.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team614.robot.Robot;

/**
 * Makes the drivetrain move at .5 speed for 1 second
 */
public class MoveABit extends Command {
	int time;

    public MoveABit() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        time = 1;
    	setTimeout(time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.arcadeDrive(0.5, 0.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
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
