/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

// The bot might be using a Victor instead. Make sure to check this.
// It is using a Victor, but this Talon code works since we
// are just moving the motor backwards and forwards.
// If we need to adjust the motor, we might want to change
// the motor object as well.
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.WinchCommand;


public class WinchSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  PWMTalonSRX TalonWinch = null;

  // Trying the PWM version of the Talon
  // However, we might need to use a different controller.
  public WinchSystem() {

    TalonWinch = new PWMTalonSRX(RobotMap.HATCH_WINCH_CONTROLLER);
    TalonWinch.enableDeadbandElimination(true);

  }

  // We need to check the speed. This might be too fast.
  public void WinchUp() {
    TalonWinch.set(.7);
  }

  public void WinchDown() {
    TalonWinch.set(-.7);
  }

  public void WinchStop() {
    TalonWinch.stopMotor();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new WinchCommand());
  }
}
