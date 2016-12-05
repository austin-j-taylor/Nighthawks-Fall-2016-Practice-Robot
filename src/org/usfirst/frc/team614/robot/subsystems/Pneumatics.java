package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.Robot;
import org.usfirst.frc.team614.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * controls the pneumatics systems of the robot
 */
public class Pneumatics extends Subsystem {

	// tells if piston is in or out
	public DoubleSolenoid piston;
	private Compressor pneumaticCompressor;

	public Pneumatics() {
		piston = new DoubleSolenoid(0, 1);
		piston.set(DoubleSolenoid.Value.kReverse);
		
		pneumaticCompressor = new Compressor(0);
		// sets compressor to compress air whenever tanks aren't full
		pneumaticCompressor.setClosedLoopControl(true);
	}
    // extends piston
    public void extendPiston(){
    	piston.set(RobotMap.pistonOut);
    }
    // retracts piston
    public void retractPiston(){
    	piston.set(RobotMap.pistonIn);
    }
    // returns piston state, forward or reverse
    public DoubleSolenoid.Value getPistonState(){
		return Robot.pneumatics.piston.get();
    }
    // sets piston state, forward or reverse
    public void setPistonState(DoubleSolenoid.Value newState){
    	piston.set(newState);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

