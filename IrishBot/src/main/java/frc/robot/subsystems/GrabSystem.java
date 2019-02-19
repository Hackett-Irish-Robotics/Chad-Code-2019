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

/**
 * Add your docs here.
 */
public class GrabSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  Solenoid grabSolenoid = new Solenoid(RobotMap.GRAB_SOLENOID);


  public void grabArmOut() {
    grabSolenoid.set(true);
    SmartDashboard.putString("Grabber", "true");

  }
  
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
