// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants.TurretRotateConstants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * The turret subsystem is a simple system with a motor
 *  for rotating the turret.
 */
public class TurretRotateSubsystem extends SubsystemBase {
  private final CANSparkMax m_Motor = new CANSparkMax(TurretRotateConstants.kTurretRotateCanId, MotorType.kBrushless);

  /** Create a new turret rotate subsystem. */
  public TurretRotateSubsystem() {
    // Factory reset, so we get the SPARKS MAX to a known state before configuring
    // them. This is useful in case a SPARK MAX is swapped out.
    m_Motor.restoreFactoryDefaults();

    // Set whether the motor should be inverted.
    m_Motor.setInverted(TurretRotateConstants.kTurretRotateMotorInverted);
  
    // Save the SPARK MAX configurations. If a SPARK MAX browns out during
    // operation, it will maintain the above configurations.
    m_Motor.burnFlash();
  }

  /** Set the turret motor to rotate counter clockwise. */
  public void rotateCCW() {
    m_Motor.set(-TurretRotateConstants.kTurretMotorSpeed);
  }

  /** Set the turret motor to rotate clockwise. */
  public void rotateCW() {
    m_Motor.set(TurretRotateConstants.kTurretMotorSpeed);
  }

  /** Stops the turret motor from moving. */
  public void stop() {
    m_Motor.set(0);
  }

  @Override
  public void periodic() {

  }
}
