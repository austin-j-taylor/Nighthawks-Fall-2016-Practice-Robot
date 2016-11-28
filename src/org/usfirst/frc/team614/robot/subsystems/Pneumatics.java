package org.usfirst.frc.team614.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {
    
	private boolean pistonState;
	
	private Compressor pneumaticCompressor;
	private Solenoid piston;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public Pneumatics() {
		pneumaticCompressor = new Compressor(0);
		pneumaticCompressor.setClosedLoopControl(true);
		
		piston = new Solenoid(5);
		
	}
    
    public void extendPiston(){
    	pistonState = true;
    	piston.set(pistonState);
    }

    public void retractPiston(){
    	pistonState = false;
    	piston.set(pistonState);
    }
    
    public boolean getPistonState(){
        return pistonState;
    }
    
    public void setPistonState(boolean newState){
        pistonState = newState;
    }
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

