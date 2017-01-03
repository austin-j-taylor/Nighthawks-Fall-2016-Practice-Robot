
package org.usfirst.frc.team614.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team614.robot.Robot;

/**
 * Makes the drivetrain move at .5 speed for 1 second
 */
public class MoveABit extends Command {
	private int time;
	boolean movingForward = true;

    public MoveABit() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.navX.zeroYaw();
    	Robot.printNavxData();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(movingForward) {
    		Robot.drivetrain.arcadeDrive(-0.5, 0.0);
	    	if(Robot.navX.getYaw() > 3)
	    		movingForward = false;
    	} else {
    		Robot.drivetrain.arcadeDrive(0.5, 0.0);
	    	if(Robot.navX.getYaw() < 0)
	    		movingForward = true;
    	}
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
