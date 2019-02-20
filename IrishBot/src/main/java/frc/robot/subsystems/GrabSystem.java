/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.RobotMap;
import frc.robot.commands.GrabCommand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class GrabSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // Using a single solenoid for the grab system.
  // The pneumatic pulls back on its own.
  Solenoid grabSolenoid = new Solenoid(RobotMap.GRAB_SOLENOID);

  // Grabber out.
  public void grabArmOut() {
    grabSolenoid.set(true);
    SmartDashboard.putString("Grabber", "true");

  }
  // Grabber in. We should not need this, but 
  // here for code symmetry.
  public void grabArmIn() {
    grabSolenoid.set(false);
    SmartDashboard.putString("Grabber", "false");

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new GrabCommand());
  }
}
