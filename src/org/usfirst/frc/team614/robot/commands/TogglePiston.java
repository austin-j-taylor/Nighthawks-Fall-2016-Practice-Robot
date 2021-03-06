
package org.usfirst.frc.team614.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team614.robot.Robot;

/**
 * Toggles the shooter piston; if it's in, make it out, and vice versa.
 */
public class TogglePiston extends Command {
    public TogglePiston() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.pneumatics);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (Robot.pneumatics.piston.get().equals(DoubleSolenoid.Value.kForward)) {
    		Robot.pneumatics.piston.set(DoubleSolenoid.Value.kReverse);
    	} else {
    		Robot.pneumatics.piston.set(DoubleSolenoid.Value.kForward);
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
