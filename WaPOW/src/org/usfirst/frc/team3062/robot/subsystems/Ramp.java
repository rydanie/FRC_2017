package org.usfirst.frc.team3062.robot.subsystems;

import org.usfirst.frc.team3062.robot.OI;
import org.usfirst.frc.team3062.robot.Robot;

import edu.wpi.first.wpilibj.Solenoid;

public class Ramp {
	 /*
     * Code added 1/31/2017
     * Solenoid variable declaration
     * ( ?, ? ) refers to (slot, channel) respectively
     */
	// NOTE: ( 1, 1 ) is a PLACEHOLDER, NOT FINAL
    Solenoid solA = new Solenoid( 1, 1 );
    Solenoid solB = new Solenoid( 1, 1 );
    

	/*
	 * Code added 1/31/17
	 * does it work? nobody knows... yet
	 */
    public static OI oi;
    
	boolean aButtonPressed = Robot.oi.aButtonPressed();
	
	{
	if ( aButtonPressed == true ) {
		// code to release pneumatics
		if ( solA.get() == false || solB.get() == false ) {
			// code to release pneumatics
			solA.set( true );
			solB.set( true );
		}
		else if ( solA.get() == true || solB.get() == true ) {
			// code to draw in pneumatics
    		solA.set( false );
    		solB.set( false );
		}
	}
}
}
		
	


