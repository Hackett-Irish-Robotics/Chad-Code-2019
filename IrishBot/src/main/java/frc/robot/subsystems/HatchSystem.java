/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
//import edu.wpi.first.wpilibj.Solenoid;
//import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.RobotMap;
import frc.robot.commands.HatchCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//comment

public class HatchSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // We replaced the Solenoid with a DoubleSolenoid for more power.
  DoubleSolenoid  doubleHatchSolenoid = new DoubleSolenoid(RobotMap.HATCH_SOLENOID_OUT, RobotMap.HATCH_SOLENOID_IN);
  //Solenoid hatchSolenoid = new Solenoid(RobotMap.HATCH_SOLENOID);
  
  // Put the hatch arm out.
  public void hatchArmOut() {
    //hatchSolenoid.set(true);
    doubleHatchSolenoid.set(DoubleSolenoid.Value.kForward);
    SmartDashboard.putString("Solenoid", "true");

  }
  
  // Pull the hatch arm back in.
  public void hatchArmIn() {
    doubleHatchSolenoid.set(DoubleSolenoid.Value.kReverse);
    //hatchSolenoid.set(false);
    SmartDashboard.putString("Solenoid", "false");

  }

  // Turn off the hatch system.
  public void hatchOff() {
    doubleHatchSolenoid.set(DoubleSolenoid.Value.kOff);
  }



  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

    setDefaultCommand(new HatchCommand());
  }
}
