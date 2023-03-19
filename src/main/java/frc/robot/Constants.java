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
	public static final int kLeftMotorA = 4; // nothing
	public static final int kLeftMotorB = 7; // checked forward no backwards
	public static final int kLeftMotorC = 5; // good
	public static final int kRightMotorA = 2; // good 
	public static final int kRightMotorB = 3; // checked good
	public static final int kRightMotorC = 6; // checked good

		// Speeds
	public static final double kDrivetrainSpeed = 0.7;
	public static final double kDriveForwardTime = 2.0;
	public static final double kAutonomousLeftSpeed = 0.4;
	public static final double kAutonomousRightSpeed = 0.4;
  }

  public static final class OIConstants {
	  public static final int kDriverControllerPort = 0;
	  public static final int kXboxLeftXAxis = 1;
	  public static final int kXboxLeftYAxis = 4;
  }

  public static final class TurretRotateConstants {
    public static final int kTurretRotateCanId = 10;
    public static final boolean kTurretRotateMotorInverted = false;
    public static final double kTurretMotorSpeed = 0.3;
  }

  public static final class TromboneConstants {
    public static final int kTromboneCanId = 0;
    public static final boolean kTromboneMotorInverted = false;
    public static final double kTromboneMotorSpeed = 0.3; 
  }

  public static final class TheClawConstants {
    public static final int kTheClawCanId = 12;
    public static final boolean kTheClawMotorInverted = false;
    public static final double kTheClawMotorSpeed = 0.3;
  }
}
