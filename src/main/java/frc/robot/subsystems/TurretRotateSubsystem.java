// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants.TurretRotateConstants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * The elevator rotate subsystem is a simple system with two 
 * motors for rotatingthe elevator forward and backward.
 */
public class TurretRotateSubsystem extends SubsystemBase {
  private final CANSparkMax m_Motor = new CANSparkMax(TurretRotateConstants.kTurretRotateCanId, MotorType.kBrushless);

  /** Create a new elevator rotate subsystem. */
  public TurretRotateSubsystem() {
    // Factory reset, so we get the SPARKS MAX to a known state before configuring
    // them. This is useful in case a SPARK MAX is swapped out.
    m_Motor.restoreFactoryDefaults();

    // Invert the turning encoder, since the output shaft rotates in the opposite direction of
    // the steering motor in the MAXSwerve Module.
    m_Motor.setInverted(TurretRotateConstants.kTurretRotateMotorInverted);
  
    // Save the SPARK MAX configurations. If a SPARK MAX browns out during
    // operation, it will maintain the above configurations.
    m_Motor.burnFlash();
  }

  /** Set the elevator rotate motor to move in the backward direction. */
  public void rotateCCW() {
    m_Motor.set(-1);
  }

  /** Set the elevator rotate motor to move in the forward direction. */
  public void rotateCW() {
    m_Motor.set(1);
  }

  /** Stops the elevator motor from moving. */
  public void stop() {
    m_Motor.set(0);
  }

  /** Call log method every loop. */
  @Override
  public void periodic() {

  }
}
