package org.usfirst.frc.team614.robot;

import org.team708.robot.util.Gamepad;
import org.usfirst.frc.team614.robot.commands.TogglePiston;
import org.usfirst.frc.team614.robot.commands.drivetrain.MoveABit;
import org.usfirst.frc.team614.robot.commands.shooter.RevOutAndShoot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a gamepad button which is any button on a gamepad.
    // You create one by telling it which gamepad it's on and which button
    // number it is.
    // Gamepad gamepad = new Gamepad(port);
    // Button button = new JoystickButton(gamepad, buttonNumber);
    
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
	
	
	// X-Box controller(s)
	public static final Gamepad driverGamepad = new Gamepad(0);
	
	// Buttons attached to a controller
	private static final Button moveABit = new JoystickButton(driverGamepad, Gamepad.button_A);
	private static final Button revOutAndShoot = new JoystickButton(driverGamepad, Gamepad.button_B);
	private static final Button togglePiston1 = new JoystickButton(driverGamepad, Gamepad.button_L_Shoulder);
	
	public OI() {
		// Attachment of buttons to commands
		moveABit.whenPressed(new MoveABit());
		revOutAndShoot.whenPressed(new RevOutAndShoot());
		togglePiston1.whenPressed(new TogglePiston());
	}

}

