package org.usfirst.frc.team3062.robot.subsystems;

import org.usfirst.frc.team3062.robot.Robot;
import org.usfirst.frc.team3062.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class Chassis extends Subsystem {
    RobotDrive myRobot;  // class that handles basic drive operations
    Jaguar leftFront;
    Jaguar leftRear;
    Jaguar rightFront;
    Jaguar rightRear;
    Encoder leftEncoder;
    Encoder rightEncoder;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
   
    public Chassis() {
		leftFront = new Jaguar(1);
    	leftRear = new Jaguar(2);
    	rightFront = new Jaguar(3);
    	rightRear = new Jaguar(4);
    	leftEncoder = new Encoder(0,1);
    	rightEncoder = new Encoder(2,3); 
  
    	leftEncoder.setDistancePerPulse(.05);
        rightEncoder.setDistancePerPulse(.05);
        
    	
        myRobot = new RobotDrive(leftFront,leftRear,rightFront,rightRear);
        //myRobot.setExpiration(0.1);
        myRobot.setSafetyEnabled(false);
        
        
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand( new DriveWithJoystick() );
    }
    
    public void driveWithJoystick( double leftValue, double rightValue ) {
    	myRobot.tankDrive( leftValue,  rightValue );
    }
    public double getLeftEncoder(){
    	return leftEncoder.getRate();
    }
    public double getRightEncoder(){
    	return rightEncoder.getRate();
    }
    
}
