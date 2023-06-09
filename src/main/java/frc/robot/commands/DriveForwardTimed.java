/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.DriveSubsystem;

public class DriveForwardTimed extends CommandBase {
  DriveSubsystem driveTrain;
  private boolean finish = false;
  Timer timer;
  /**
   * Creates a new DriveForwardTimed.
   */
  public DriveForwardTimed(DriveSubsystem dt) {
    driveTrain = dt;
    timer = new Timer();
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
    
    // Check to see if we still need to move forward
    while(timer.get() < DriveConstants.kDriveForwardTime)
    {
      driveTrain.driveForward(DriveConstants.kAutonomousLeftSpeed, DriveConstants.kAutonomousRightSpeed);
    }
    // We have satisfied our forward time
    finish = true;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finish;
  }
}
