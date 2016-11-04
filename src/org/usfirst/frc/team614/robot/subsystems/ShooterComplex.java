
package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.Constants;
import org.usfirst.frc.team614.robot.RobotMap;
import org.usfirst.frc.team614.robot.commands.shooter.ShooterDrive;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ShooterComplex extends PIDSubsystem {
    
	private VictorSP leftMotor, rightMotor, angleMotor;
	private Talon TEDMotor;
	private Servo servo;
	private Encoder leftEncoder, rightEncoder, angleEncoder;
	private double distancePerPulse;
	private RobotDrive flywheelDrive;
	

	private double moveSpeed = 0.0;
	private double pidOutput = 0.0;
	public PIDController leftFlywheelPID, rightFlywheelPID;
	
	private AnalogGyro Gyro;
	
	private boolean usePID = true;
	
	public ShooterComplex() {
		
		
		super("Shooter", Constants.Kp, Constants.Ki, Constants.Kd);
		//Initializes the motors
		leftMotor = new VictorSP(RobotMap.shooterLeftMotor);
		rightMotor = new VictorSP(RobotMap.shooterRightMotor);
				
		angleMotor = new VictorSP(RobotMap.shooterAngleMotor);
		
	
		//Initializes the encoders
		leftEncoder = new Encoder(RobotMap.leftShooterEncoder_A, RobotMap.leftShooterEncoder_B);
		rightEncoder = new Encoder(RobotMap.rightShooterEncoder_A, RobotMap.rightShooterEncoder_B);
		angleEncoder = new Encoder(RobotMap.angleShooterEncoder_A, RobotMap.angleShooterEncoder_B);
		
		resetEncoders();
		
		
		distancePerPulse = 10; //change to whatever the rate is when the encoder comes in
		
		
		leftFlywheelPID = new PIDController(Constants.Kp, Constants.Ki, Constants.Kd, leftEncoder, leftMotor);
		rightFlywheelPID = new PIDController(Constants.Kp, Constants.Ki, Constants.Kd, rightEncoder, rightMotor);
				
		
		//Initializes drivetrain class for the two flywheels
		flywheelDrive = new RobotDrive(leftMotor, rightMotor);
		
		
		//PID Stuff; change these when we find the desired rpm for the flywheel 
		
		
		
//		setInputRange(0, 800000);
//		setAbsoluteTolerance(1000);
//		setSetpoint(Constants.TARGET_RATE);
	 
		leftFlywheelPID.setInputRange(0,800000);
		leftFlywheelPID.setAbsoluteTolerance(1000);
		leftFlywheelPID.setSetpoint(Constants.TARGET_RATE);
	
		rightFlywheelPID.setInputRange(0, 8000000);
		rightFlywheelPID.setAbsoluteTolerance(1000);
		rightFlywheelPID.setSetpoint(Constants.TARGET_RATE);
		
//		leftMotor.setSafetyEnabled(false);
//		rightMotor.setSafetyEnabled(false);
//		TEDMotor.setSafetyEnabled(false);
		 
	}
	
	public void initDefaultCommand() {
	        // Set the default command for a subsystem here.
	    	setDefaultCommand(new ShooterDrive());
	
	    	//setDefaultCommand(new ShootSequence());
	    
	    }
	    
	/*
	 * Flywheel Methods
	 */

	/**
	 * Spins up the shooter flywheel to shoot out
	 */
	public void shootMode(double value, boolean usePID){
		  
		//  value = value * Constants.DRIVE_MOTOR_MAX_SPEED;
	
	    	if(usePID){
	    		//Disables the PID controller if it is enabled so the drivetrain can move freely
	    		if(!leftFlywheelPID.isEnabled() || !rightFlywheelPID.isEnabled())
	    		{
//	    		getPIDController().setPID(Constants.Kp,  Constants.Ki,  Constants.Kd);
//	    		getPIDController().reset();
	    
	    		leftFlywheelPID.setPID(Constants.Kp, Constants.Ki, Constants.Kd);
	    		leftFlywheelPID.reset();
	    		
	    		
	    		rightFlywheelPID.setPID(Constants.Kp, Constants.Ki, Constants.Kd);
	    		rightFlywheelPID.reset();
	    	
	    		resetFlywheelEncoders();
	    		enable();
	    		resetFlywheelEncoders();
	    		}
	    		else if(leftFlywheelPID.isEnabled() || rightFlywheelPID.isEnabled()) {
//	    			getPIDController().reset();
	    			
	    			leftFlywheelPID.reset();
	    			rightFlywheelPID.reset(); 
	    			
	    		
	    			
	    		}
	    		
	    		flywheelDrive.arcadeDrive(value, value);
	    		
	    		//Disables the PID Controller if it is enables so the drivetrain can move freely
	    		if(leftFlywheelPID.isEnabled() || rightFlywheelPID.isEnabled())
//	    		getPIDController().reset();
	    		
	    		leftFlywheelPID.reset();
	    		rightFlywheelPID.reset();
	    	
	    	}
	    	
		  flywheelDrive.tankDrive(value, value);
	  }
	  
	  
	public void revUpForward(){
		leftMotor.set(-Constants.MOTOR_FORWARD);
		rightMotor.set(Constants.MOTOR_FORWARD);
		
	}
	/**
	 * Spins up the shooter flywheel to bring in the ball
	 */
	public void revUpReverse(){
		leftMotor.set(-Constants.MOTOR_REVERSE);
		rightMotor.set(Constants.MOTOR_REVERSE);
	}
	
	/**
	 * Moves the shooter up to shoot higher
	 */
	
	public void stopFlywheel(){
		flywheelDrive.stopMotor();	}

	
	/*
	 * AngleMotor Methods
	 */
	public void setMotorSpeed(double motorSpeed){
		 if(motorSpeed <0){
			 angleMotor.set(motorSpeed*Constants.ANGLE_REDUCTION_SPEED_DOWN);
		 }
		 else if(motorSpeed>0){
			 angleMotor.set(motorSpeed* Constants.ANGLE_REDUCTION_SPEED_UP);
		 }
		 else{
			 angleMotor.set(0);
		 }
	 }
	 
	 /*
	 * Moves the shooter up to shoot higher
	 */
	public void angleUp(){
		angleMotor.set(Constants.MOTOR_UP);
	}
		
	/*
	 * Moves the shooter down to shoot lower
	 */	
	public void angleDown(){
		angleMotor.set(Constants.MOTOR_DOWN);
	}
	
	public void stopAngle(){
		angleMotor.set(0);
	}
	
	/*
	 * Encoder Methods
	 */	
	public double getLeftEncoderRPM(){
		return leftEncoder.getRate();
	}
	
	public double getRightEncoderRPM(){
		return rightEncoder.getRate();
	}
	
	public double getAngleEncoderRPM(){
		return angleEncoder.getRate();
	}
	
	public void resetFlywheelEncoders(){
		leftEncoder.reset();
		rightEncoder.reset();
	}
	
	public void resetAngleEncoder(){
		angleEncoder.reset();
	}
	
	public void resetEncoders(){
		leftEncoder.reset();
		rightEncoder.reset();
		//angleEncoder.reset();
	}
	
	
	 /* PID Methods
     * 
     */
    
    public double returnPIDInput(){
    	return leftEncoder.getRate();
    }
   
    public boolean getUsePID() {
    	return usePID;
    }
    
    public void setUsePID(boolean usePID){
    	this.usePID = usePID;
    }
    
    public void usePIDOutput(double output){
    	pidOutput = output;
    	flywheelDrive.arcadeDrive(moveSpeed, -output);
    }
    
    public void togglePID(){
    	usePID = !usePID;
    }
	
	// once I inevitably figure out SmartDashboard...
    
//	public void sendToDashboard(){
//		if(false){
//		SmartDashboard.putNumber("Left Flywheel RPM: ", getLeftEncoderRPM());
//		SmartDashboard.putNumber("Right Flywheel RPM: ", getRightEncoderRPM());
//		SmartDashboard.putNumber("Lift RPM: ", getAngleEncoderRPM());
//		
//		}
//		SmartDashboard.putBoolean("Shooter PID", getUsePID());
//	}



 
}

