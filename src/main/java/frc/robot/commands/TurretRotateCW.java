// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.TurretRotateSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurretRotateCW extends CommandBase {
  private final TurretRotateSubsystem m_turretRotateSubsystem;

  public TurretRotateCW(TurretRotateSubsystem turretRotateSubsystem) {
    m_turretRotateSubsystem = turretRotateSubsystem;
    addRequirements(m_turretRotateSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    m_turretRotateSubsystem.rotateCW();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
      m_turretRotateSubsystem.stop();
  }
}
