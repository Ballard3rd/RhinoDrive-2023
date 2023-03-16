// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ElevatorRotateSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ElevatorRotateForward extends CommandBase {
  private final ElevatorRotateSubsystem m_elevatorRotateSubsystem;

  public ElevatorRotateForward(ElevatorRotateSubsystem elevatorRotateSubsystem) {
    m_elevatorRotateSubsystem = elevatorRotateSubsystem;
    addRequirements(m_elevatorRotateSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    m_elevatorRotateSubsystem.rotateForward();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
      m_elevatorRotateSubsystem.stop();
  }
}
