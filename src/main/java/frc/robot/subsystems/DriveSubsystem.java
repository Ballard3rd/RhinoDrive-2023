/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.OIConstants;

public class DriveSubsystem extends SubsystemBase {
  // Declaration of the drivetrain
  CANSparkMax driveLeftA;
  CANSparkMax driveLeftB;
  CANSparkMax driveLeftC;
  CANSparkMax driveRightA;
  CANSparkMax driveRightB;
  CANSparkMax driveRightC;
  
  // Declaration of the motor controllers
  // This allows you to manage the speeds of the motors on one side with one call
  MotorControllerGroup leftMotors;
  MotorControllerGroup rightMotors;

  // Declaration of the differential drive
  DifferentialDrive drive; 

  /**
   * Creates a new DriveTrain.
   */
  public DriveSubsystem(){
    // Instantiate the DriveTrain
    driveLeftA = new CANSparkMax(DriveConstants.kLeftMotorA, MotorType.kBrushless);
    driveLeftB = new CANSparkMax(DriveConstants.kLeftMotorB, MotorType.kBrushless);
    driveLeftC = new CANSparkMax(DriveConstants.kLeftMotorC, MotorType.kBrushless);
    driveRightA = new CANSparkMax(DriveConstants.kRightMotorA, MotorType.kBrushless);
    driveRightB = new CANSparkMax(DriveConstants.kRightMotorB, MotorType.kBrushless);
    driveRightC = new CANSparkMax(DriveConstants.kRightMotorC, MotorType.kBrushless);

    // Set inverted field to set motor direction when given a positive speed
    driveLeftA.setInverted(true);
    driveLeftB.setInverted(true);
    driveLeftC.setInverted(false);
    driveRightA.setInverted(true);
    driveRightB.setInverted(true);
    driveRightC.setInverted(true);

    // Burn settings to flash 
    // This is needed incase power is lost to the controller
    // Otherwise, the settings will revert to the last save
    driveLeftA.burnFlash();
    driveLeftB.burnFlash();
    driveLeftC.burnFlash();
    driveRightA.burnFlash();
    driveRightB.burnFlash();
    driveRightC.burnFlash();
 
    // Instantiate the motor controller groups
    leftMotors = new MotorControllerGroup(driveLeftA, driveLeftB, driveLeftC);
    rightMotors = new MotorControllerGroup(driveRightA, driveRightB, driveRightC);

    // Instantiate the differential drive
    drive = new DifferentialDrive(leftMotors, rightMotors);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  // driveWithJoysticks is used in teleop mode
  public void driveWithJoysticks(double forwardPower, double turnPower) {
    drive.curvatureDrive(Math.abs(forwardPower) < 0.1 ? 0 : forwardPower, Math.abs(turnPower) < 0.1 ? 0 : turnPower, true);
  }

  // driveForward is used in autonomous mode
  public void driveForward(double leftSpeed, double rightSpeed) {
    // Tank drive uses two different speeds,
    // one for the left side and one for the right side
    // This is because the motors don't turn at the same speeds
    // with the same inputs
    drive.tankDrive(leftSpeed, rightSpeed);
  }

  public void stop()
  {
    // Sets the speed of all motors on the drivetrain to 0
    drive.stopMotor();
  }
}
