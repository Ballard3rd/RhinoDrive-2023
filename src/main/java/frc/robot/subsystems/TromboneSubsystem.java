// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants.TromboneConstants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * The claw subsystem is a simple system with a motor for opening and closing. If using stronger
 * motors, you should probably use a sensor so that the motors don't stall.
 */
public class TromboneSubsystem extends SubsystemBase {
  private final CANSparkMax m_Motor = new CANSparkMax(TromboneConstants.kTromboneCanId, MotorType.kBrushless);

  /** Create a new claw subsystem. */
  public TromboneSubsystem() {
    // Factory reset, so we get the SPARKS MAX to a known state before configuring
    // them. This is useful in case a SPARK MAX is swapped out.
    m_Motor.restoreFactoryDefaults();

    // Invert the turning encoder, since the output shaft rotates in the opposite direction of
    // the steering motor in the MAXSwerve Module.
    m_Motor.setInverted(TromboneConstants.kTromboneMotorInverted);
  
    // Save the SPARK MAX configurations. If a SPARK MAX browns out during
    // operation, it will maintain the above configurations.
    m_Motor.burnFlash();
  }

  /** Set the elevator extend motor to retract. */
  public void retract() {
    m_Motor.set(-1);
  }

  /** Set the elevator extend motor to move to extend. */
  public void extend() {
    m_Motor.set(1);
  }

  /** Stops the elevator extend motor from moving. */
  public void stop() {
    m_Motor.set(0);
  }

  /** Call log method every loop. */
  @Override
  public void periodic() {

  }
}
