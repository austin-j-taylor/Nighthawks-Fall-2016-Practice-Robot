package org.usfirst.frc.team614.robot.commands.shooter;

import org.usfirst.frc.team614.robot.commands.TogglePiston;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * Shoots the ball out of the shooter.
 */
public class RevOutAndShoot extends CommandGroup {
    
    public  RevOutAndShoot() {
    	// begins spinning flywheels
    	addSequential(new RevOut());
    	// waits 1 second
    	addSequential(new WaitCommand(1));
    	// extends piston
    	addSequential(new TogglePiston());
    	// waits 1 second
    	addSequential(new WaitCommand(1));
    	// stops spinning flywheels
    	addSequential(new StopFlywheels());
    	// retracts piston
    	addSequential(new TogglePiston());
    	
    }
}
