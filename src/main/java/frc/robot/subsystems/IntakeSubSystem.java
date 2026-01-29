// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;

public class IntakeSubSystem extends SubsystemBase {
    SparkMax intakeMotor = new SparkMax(10, MotorType.kBrushless);
    SparkMaxConfig config = new SparkMaxConfig();
    Joystick driverJoystick = new Joystick(0);

    public IntakeSubSystem() {
    config.inverted(false)
          .smartCurrentLimit(30)
          .idleMode(IdleMode.kBrake);
    intakeMotor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  public void intakeIn() {
    driverJoystick.button(2, null);
    intakeMotor.set(0.7);
  }

  public void intakeOut() {
    driverJoystick.button(3, null);
    intakeMotor.set(-0.7);
  }

  public void stop() {
    driverJoystick.button(4, null);
    intakeMotor.set(0);
  }

  @Override
  public void periodic() {
  }
}