package org.usfirst.frc.team614.robot;

import org.team708.robot.util.Gamepad;
import org.usfirst.frc.team614.robot.commands.MoveABit;
import org.usfirst.frc.team614.robot.commands.RevOutAndShoot;
import org.usfirst.frc.team614.robot.commands.TogglePiston;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	public static Gamepad driverGamepad = new Gamepad(0);
//	public static Gamepad operatorGamepad = new Gamepad(1);


	private static final Button moveABit = new JoystickButton(driverGamepad, Gamepad.button_A);
	private static final Button revOutAndShoot = new JoystickButton(driverGamepad, Gamepad.button_B);
	
	private static final Button togglePiston1 = new JoystickButton(driverGamepad, Gamepad.button_L_Shoulder);
//	private static final Button togglePiston2 = new JoystickButton(driverGamepad, Gamepad.button_R_Shoulder);
//	private static final Button retractPiston = new JoystickButton(driverGamepad, Gamepad.button_L_Shoulder);
//	private static final Button revIn = new JoystickButton(driverGamepad, Gamepad.button_X);
//	private static final Button revOut = new JoystickButton(driverGamepad, Gamepad.button_Y);
	//private static final Button raiseLift = new JoystickButton(driverGamepad, Gamepad.button_X);
	//private static final Button lowerLift = new JoystickButton(driverGamepad, Gamepad.button_Y);
	
	
	public OI() {
		
		// button commands
		
		moveABit.whenPressed(new MoveABit());
		revOutAndShoot.whenPressed(new RevOutAndShoot());

		togglePiston1.whenPressed(new TogglePiston());
//		togglePiston2.whileHeld(new TogglePiston(2));
//		retractPiston.toggleWhenPressed(new RetractPiston());
//		revIn.whileHeld(new RevIn());
//		revOut.whileHeld(new RevOut());
		//raiseLift.whenPressed(new RaiseLift());
		//lowerLift.whenPressed(new LowerLift());
		
	}

}

