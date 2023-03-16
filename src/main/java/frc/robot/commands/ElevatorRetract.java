// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ElevatorExtendSubsystem;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class ElevatorRetract extends WaitCommand {
  private final ElevatorExtendSubsystem m_elevatorExtendSubsystem;

  public ElevatorRetract(ElevatorExtendSubsystem elevatorExtendSubsystem) {
    super(1);
    m_elevatorExtendSubsystem = elevatorExtendSubsystem;
    addRequirements(m_elevatorExtendSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    m_elevatorExtendSubsystem.retract();
    super.initialize();
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
