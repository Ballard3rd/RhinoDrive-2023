// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ElevatorExtendSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ElevatorExtend extends CommandBase {
  private final ElevatorExtendSubsystem m_elevatorExtendSubsystem;

  public ElevatorExtend(ElevatorExtendSubsystem elevatorRotateSubsystem) {
    m_elevatorExtendSubsystem = elevatorRotateSubsystem;
    addRequirements(m_elevatorExtendSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    m_elevatorExtendSubsystem.extend();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
      m_elevatorExtendSubsystem.stop();
  }
}
