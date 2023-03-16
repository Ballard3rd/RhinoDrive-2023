/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
	public static final class DriveConstants {
    // CAN ids for wiring team
	public static final int kLeftMotorA = 3;
	public static final int kLeftMotorB = 4;
	public static final int kLeftMotorC = 5;
	public static final int kRightMotorA = 6;
	public static final int kRightMotorB = 7;
	public static final int kRightMotorC = 8;

		// Speeds
	public static final double kDrivetrainSpeed = 0.7;
	public static final double kDriveForwardTime = 3.0;
	public static final double kAutonomousLeftSpeed = 0.6;
	public static final double kAutonomousRightSpeed = 0.6;
  }

public static final class OIConstants {
	public static final int kDriverControllerPort = 0;
	public static final int kXboxLeftXAxis = 1;
	public static final int kXboxLeftYAxis = 4;
  }

public static final class ElevatorRotateConstants {
    // SPARK MAX CAN IDs
    public static final int kLeftRotateCanId = 18;
    public static final int kRightRotateCanId = 19;
    public static final boolean kElevatorRotateLeftEncoderInverted = false;
    public static final boolean kElevatorRotateRightEncoderInverted = true;	
  }

  
  public static final class ElevatorExtendConstants {
    public static final int kLeftExtendCanId = 20;
    public static final int kRightExtendCanId = 21;
    public static final boolean kElevatorExtendLeftEncoderInverted = false;
    public static final boolean kElevatorExtendRightEncoderInverted = true;    
  }

  public static final class GrabberConstants {
    public static final int kLeftGrabberCanId = 22;
    public static final int kRightGrabberCanId = 23;
    public static final boolean kGrabberLeftEncoderInverted = false;
    public static final boolean kGrabberRightEncoderInverted = true;	
  }
}
