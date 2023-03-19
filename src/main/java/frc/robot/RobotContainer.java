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
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.OIConstants;
import frc.robot.subsystems.TheClawSubsystem;
import frc.robot.subsystems.TromboneSubsystem;
import frc.robot.subsystems.TurretRotateSubsystem;
import frc.robot.commands.DriveForwardTimed;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;

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
    //private final DriveWithJoysticks driveWithJoystick;
    public static XboxController driverJoystick;

    // Commands declaration
    private final DriveForwardTimed driveForwardTimed;
    private final CommandBase autoForward;
    private final TurretRotateSubsystem m_turretRotateSubsystem;
    private final TromboneSubsystem m_tromboneSubsystem;
    private final TheClawSubsystem m_theClawSubsystem;

    // Instantiate a sendable chooser to select which autonomous command to run
    SendableChooser<Command> chooser = new SendableChooser<>();


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Instantiate the drivetrain
    driverJoystick = new XboxController(OIConstants.kDriverControllerPort);
    driveTrain = new DriveSubsystem();
    //driveWithJoystick = new DriveWithJoysticks(driveTrain);
    //driveWithJoystick.addRequirements(driveTrain);
    driveTrain.setDefaultCommand(new RunCommand(() -> driveTrain.driveWithJoysticks(driverJoystick.getLeftY(), driverJoystick.getRightX()), driveTrain));
    m_turretRotateSubsystem = new TurretRotateSubsystem();
    m_tromboneSubsystem = new TromboneSubsystem();
    m_theClawSubsystem = new TheClawSubsystem();

    // Instantiate the driveForwardTimed command
    driveForwardTimed = new DriveForwardTimed(driveTrain);
    driveForwardTimed.addRequirements(driveTrain);

    // Instantiate the autoForward command
    autoForward = new StartEndCommand(() -> driveTrain.driveForward(DriveConstants.kAutonomousLeftSpeed, DriveConstants.kAutonomousRightSpeed), 
    () -> driveTrain.driveForward(0, 0), driveTrain)
    .withTimeout(DriveConstants.kDriveForwardTime);

    // Instantiate the driverJoystick object

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
    // Turret rotate button assignments
    new JoystickButton(driverJoystick, XboxController.Button.kY.value)
    .whileTrue(new StartEndCommand(() -> m_turretRotateSubsystem.rotateCW(), 
    () -> m_turretRotateSubsystem.stop(), m_turretRotateSubsystem));

    new JoystickButton(driverJoystick, XboxController.Button.kA.value)
    .whileTrue(new StartEndCommand(() -> m_turretRotateSubsystem.rotateCCW(),
    () -> m_turretRotateSubsystem.stop(), m_turretRotateSubsystem));

    // Trombone extend button assignments
    new JoystickButton(driverJoystick, XboxController.Button.kX.value)
    .whileTrue(new StartEndCommand(() -> m_tromboneSubsystem.extend(),
    () -> m_tromboneSubsystem.stop(), m_tromboneSubsystem));

    new JoystickButton(driverJoystick, XboxController.Button.kB.value)
    .whileTrue(new StartEndCommand(() -> m_tromboneSubsystem.retract(),
    () -> m_tromboneSubsystem.stop(), m_tromboneSubsystem));

    // The Claw button assignments
    new JoystickButton(driverJoystick, XboxController.Button.kLeftBumper.value)
    .whileTrue(new StartEndCommand(() -> m_theClawSubsystem.open(),
    () -> m_theClawSubsystem.stop(), m_theClawSubsystem));

    new JoystickButton(driverJoystick, XboxController.Button.kRightBumper.value)
    .whileTrue(new StartEndCommand(() -> m_theClawSubsystem.close(),
    () -> m_theClawSubsystem.stop(), m_theClawSubsystem));
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
