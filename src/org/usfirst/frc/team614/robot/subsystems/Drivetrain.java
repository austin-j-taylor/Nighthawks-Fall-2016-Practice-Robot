package org.usfirst.frc.team614.robot.subsystems;

import org.team708.robot.util.Gamepad;
import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.OI;
import org.usfirst.frc.team614.robot.commands.drivetrain.JoystickDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {

	private final double SPEED_SCALE = 1.0;
	
	VictorSP frontleftMotor = new VictorSP(0); // 
	VictorSP backleftMotor = new VictorSP(1);  //
	VictorSP backrightMotor = new VictorSP(2); // 
	VictorSP frontrightMotor = new VictorSP(3);// 
	
	RobotDrive drivetrain;
	
	    public Drivetrain() {
	    	drivetrain = new RobotDrive(frontleftMotor, backleftMotor, frontrightMotor, backrightMotor);
	        drivetrain.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
	        drivetrain.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
//	        drivetrain.setInvertedMotor(1, true);
//	        drivetrain.setInvertedMotor(2, true);
//	        drivetrain.setInvertedMotor(3, true);
	        
	    }
	    public void mecanumDriveMode(double magnitude, double direction, double rotation){ 	
//	    	double controllerValue = 0.0;
//	    	double magnitude = 0.0;
//	    	double degrees = 0.0;
//	    	double rotation = 0.0;
//	    	
//	    	controllerValue = controller.getMagnitude();
//	    	
//	    	if(controllerValue < Constants.JOYSTICK_DEADBAND && controllerValue > -Constants.JOYSTICK_DEADBAND)
//	    		controllerValue = 0;	    	
//	    	magnitude = -((1.0039215686275 * Math.pow(controllerValue, 3)) - (0.00616246498603 * controllerValue));
//	    	
//	    	degrees = controller.getDirectionDegrees();
//	    	
//	    	rotation = -(controller.getRawAxis(4));
//	    	if(rotation < Constants.JOYSTICK_DEADBAND && rotation > -Constants.JOYSTICK_DEADBAND)
//	    		rotation = 0;
	    	//drivetrain.mecanumDrive_Cartesian(x, y, rotation, gyroAngle);
	    	drivetrain.mecanumDrive_Polar(magnitude / SPEED_SCALE, direction, rotation / SPEED_SCALE); //To increase the sensitivity, decrease SPEED_SCALE to a number below one but above 0
	    																						//To decrease the sensitivity, increase SPEED_SCALE to a number above one; 		SPEED_SCALE is here until a proper ramp function is implemented
	    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new JoystickDrive());
    }
}

