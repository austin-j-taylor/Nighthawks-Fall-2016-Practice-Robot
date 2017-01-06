package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.Robot;
import org.usfirst.frc.team614.robot.RobotMap;
import org.usfirst.frc.team614.robot.commands.drivetrain.JoystickDrive;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The drivetrain of the robot, consisting of the left motors and right motors.
 */
public class Drivetrain extends Subsystem implements PIDOutput {
	
	RobotDrive drivetrain;
	PIDController turnController;
    double rotateToAngleRate;
    private boolean usingPID = false;
    
    /* The following PID Controller coefficients will need to be tuned */
    /* to match the dynamics of your drive system.  Note that the      */
    /* SmartDashboard in Test mode has support for helping you tune    */
    /* controllers by displaying a form where you can enter new P, I,  */
    /* and D constants and test the mechanism.                         */
    
    static final double kP = 0.30;
    static final double kI = 0.00;
    static final double kD = 0.00;
    static final double kF = 0.00;

    static final double kToleranceDegrees = 2.0f;
	
	// VictorSP motor controllers
	VictorSP leftMotor = new VictorSP(RobotMap.drivetrainLeftMotor);
	VictorSP rightMotor = new VictorSP(RobotMap.drivetrainRightMotor);
	
    public Drivetrain() {
    	super("Drivetrain");
    	drivetrain = new RobotDrive(leftMotor, rightMotor);

//        turnController = new PIDController(kP, kI, kD, kF, Robot.navX, this);
        turnController = new PIDController(kP, kI,kD, kF, Robot.navX, this);
        turnController.setInputRange(-180.0f,  180.0f);
        turnController.setOutputRange(-1.0, 1.0);
        turnController.setAbsoluteTolerance(kToleranceDegrees);
        turnController.setContinuous(true);

        /* Add the PID Controller to the Test-mode dashboard, allowing manual  */
        /* tuning of the Turn Controller's P, I and D coefficients.            */
        /* Typically, only the P value needs to be modified.                   */
        LiveWindow.addActuator("DriveSystem", "RotateController", turnController);
        
        turnController.setSetpoint(0.0f);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new JoystickDrive());
    }
    // called by the JoystickDrive command constantly from execute()
    // moves the robot
    public void arcadeDrive(double moveValue, double rotateValue) {
    	drivetrain.arcadeDrive(-moveValue, -rotateValue);
    }
    // stops the robot
    public void stop() {
    	drivetrain.arcadeDrive(0, 0);
    }
    /* This function is invoked periodically by the PID Controller, */
    /* based upon navX MXP yaw angle input and PID Coefficients.    */
	public void pidWrite(double output) {
		rotateToAngleRate = output;
	}
	public double getRotateRate() {
		return rotateToAngleRate;
	}
	public void setUsingPID(boolean set) {
		usingPID = set;
	}
	public PIDController getController() {
		return turnController;
	}
}

