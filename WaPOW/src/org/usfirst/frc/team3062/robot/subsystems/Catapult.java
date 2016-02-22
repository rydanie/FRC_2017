package org.usfirst.frc.team3062.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Catapult extends Subsystem {
	
	private DoubleSolenoid catapult;
	
	public Catapult(){
		
		catapult  = new DoubleSolenoid(0,1);
		
		catapult.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void extend(){
		
		catapult.set(DoubleSolenoid.Value.kForward);
	}
    
	
	public void retract(){
		
		catapult.set(DoubleSolenoid.Value.kReverse);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

