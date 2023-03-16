// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.GrabberSubsystem;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class GrabberOpen extends WaitCommand {
  private final GrabberSubsystem m_grabberSubsystem;

  public GrabberOpen(GrabberSubsystem grabberSubsystem) {
    super(1);
    m_grabberSubsystem = grabberSubsystem;
    addRequirements(m_grabberSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    m_grabberSubsystem.open();
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
    m_grabberSubsystem.stop();
  }
}
