package org.usfirst.frc.team3062.robot.subsystems;

import org.usfirst.frc.team3062.robot.Robot;
import org.usfirst.frc.team3062.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class Chassis extends Subsystem {
    RobotDrive myRobot;  // class that handles basic drive operations
    TalonSRX leftFront;
    TalonSRX leftRear;
    TalonSRX rightFront;
    TalonSRX rightRear;
    Encoder leftEncoder;
    Encoder rightEncoder;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
   
    double circumference;
    double disRo;
    double totalDis2;
    double totalDis;
    double totalTurnDis2;
    double totalTurnDis;
    
    
    public Chassis() {
		leftFront = new TalonSRX(1);
    	leftRear = new TalonSRX(2);
    	rightFront = new TalonSRX(3);
    	rightRear = new TalonSRX(4);
    	leftEncoder = new Encoder(0,1);
    	rightEncoder = new Encoder(2,3); 
  
    	leftEncoder.setDistancePerPulse(.05);
        rightEncoder.setDistancePerPulse(.05);
        
        circumference = 6 * Math.PI;
        disRo = circumference * .05;
        
        totalDis2 = 0;
        totalTurnDis2 = 0;
    	
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
    	
    	if ( rightValue > 0.02 && leftValue > 0.02 ) {
    		totalDis = disRo + totalDis2;
    		totalDis2 = totalDis;
    		SmartDashboard.putNumber("Distance", totalDis);
    		System.out.println(totalDis2);
    	}
    	else if (  rightValue < -0.02 && leftValue < 0.02 ) {
    		totalDis = totalDis2 - disRo;
    		totalDis2 = totalDis;
    		SmartDashboard.putNumber("Distance", totalDis);
    		System.out.println(totalDis2);
    	}
    	else if ( rightValue > 0.02 && leftValue < -0.02 ) {
    		totalTurnDis = totalTurnDis2 + disRo;
    		totalTurnDis2 = totalTurnDis;
    		SmartDashboard.putNumber("Turning Distance", totalTurnDis);
    		System.out.println(totalTurnDis2);
    		// if ( totalTurnDis = )
    	}
    	else if ( leftValue > 0.02 && rightValue < -0.02 ) {
    		totalTurnDis = totalTurnDis2 - disRo;
    		totalTurnDis2 = totalTurnDis;
    		SmartDashboard.putNumber("Turning Distance", totalTurnDis);
    		System.out.println(totalTurnDis2);
    	}
    }
    public double getLeftEncoder(){
    	return leftEncoder.getRate();
    }
    public double getRightEncoder(){
    	return rightEncoder.getRate();
    }
    
}
