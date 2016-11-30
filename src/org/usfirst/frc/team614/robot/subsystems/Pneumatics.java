package org.usfirst.frc.team614.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {

	private boolean pistonState1;
	private boolean pistonState2;
	private Compressor pneumaticCompressor;
	private DoubleSolenoid piston1;
	private DoubleSolenoid piston2;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public Pneumatics() {
		piston1 = new DoubleSolenoid(0, 1);
		piston2 = new DoubleSolenoid(2, 3);
		
		pneumaticCompressor = new Compressor(0);
		pneumaticCompressor.setClosedLoopControl(true);
		
		
	}
    
    public void extendPiston(int piston){
    	if(piston == 1) {
	    	pistonState1 = true;
	    	piston1.set(DoubleSolenoid.Value.kForward);
    	} else {
	    	pistonState2 = true;
	    	piston2.set(DoubleSolenoid.Value.kForward);
    	}
    }

    public void retractPiston(int piston){
    	if(piston == 1) {
	    	pistonState1 = false;
	    	piston1.set(DoubleSolenoid.Value.kReverse);
    	}
    	else {
	    	pistonState2 = false;
	    	piston2.set(DoubleSolenoid.Value.kReverse);
    	}
    }
    
    public boolean getPistonState(int piston){
    	if(piston == 1)
    		return pistonState1;
    	else
    		return pistonState2;
    }
    
    public void setPistonState(int piston, boolean newState){
    	if(piston == 1)
	        pistonState1 = newState;
    	else
    		pistonState2 = newState;
    }
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

