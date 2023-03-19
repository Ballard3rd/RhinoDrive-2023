// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants.TheClawConstants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * The Claw subsystem is a simple system with a
 * motor for grabbing and releasing the game pieces.
 */
public class TheClawSubsystem extends SubsystemBase {
  private final CANSparkMax m_Motor = new CANSparkMax(TheClawConstants.kTheClawCanId, MotorType.kBrushless);

  /** Create a new TheClaw subsystem. */
  public TheClawSubsystem() {
    // Factory reset, so we get the SPARKS MAX to a known state before configuring
    // them. This is useful in case a SPARK MAX is swapped out.
    m_Motor.restoreFactoryDefaults();

    // Invert the turning encoder, since the output shaft rotates in the opposite
    // direction of
    // the steering motor in the MAXSwerve Module.
    m_Motor.setInverted(TheClawConstants.kTheClawMotorInverted);

    // Save the SPARK MAX configurations. If a SPARK MAX browns out during
    // operation, it will maintain the above configurations.
    m_Motor.burnFlash();
  }

  /** Set the claw motor to move in the open direction. */
  public void open() {
    m_Motor.set(-TheClawConstants.kTheClawMotorSpeed);
  }

  /** Set the claw motor to move in the close direction. */
  public void close() {
    m_Motor.set(TheClawConstants.kTheClawMotorSpeed);
  }

  /** Stops the claw motor from moving. */
  public void stop() {
    m_Motor.set(0);
  }

  @Override
  public void periodic() {

  }
}
