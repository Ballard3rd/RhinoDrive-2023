/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants.OIConstants;
import frc.robot.commands.AutoForward;
import frc.robot.commands.DriveForwardTimed;
import frc.robot.commands.DriveWithJoysticks;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

    // Drivetrain declaration
    private final DriveSubsystem driveTrain;

    // Joystick declaration
    private final DriveWithJoysticks driveWithJoystick;
    public static XboxController driverJoystick;

    // Commands declaration
    private final DriveForwardTimed driveForwardTimed;
    private final AutoForward autoForward;

    // Instantiate a sendable chooser to select which autonomous command to run
    SendableChooser<Command> chooser = new SendableChooser<>();


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Instantiate the drivetrain
    driveTrain = new DriveSubsystem();
    driveWithJoystick = new DriveWithJoysticks(driveTrain);
    driveWithJoystick.addRequirements(driveTrain);
    driveTrain.setDefaultCommand(driveWithJoystick);

    // Instantiate the driveForwardTimed command
    driveForwardTimed = new DriveForwardTimed(driveTrain);
    driveForwardTimed.addRequirements(driveTrain);

    // Instantiate the autoForward command
    autoForward = new AutoForward(driveTrain);

    // Instantiate the driverJoystick object
    driverJoystick = new XboxController(OIConstants.kDriverControllerPort);

    // Add choices as options here

    // Default option
    chooser.setDefaultOption("Forward 3 seconds", autoForward);
    // Add to Choices to SmartDashboard
    SmartDashboard.putData("Autonomous", chooser);

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // Get selected option to run in autonomous
    return chooser.getSelected();
  }
}
