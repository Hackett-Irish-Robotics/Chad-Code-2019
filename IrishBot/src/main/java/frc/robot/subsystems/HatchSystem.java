/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.RobotMap;
import frc.robot.commands.HatchCommand;


// For testing
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class HatchSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  Solenoid hatchSolenoid = new Solenoid(RobotMap.HATCH_SOLENOID);
  



  public void hatchArmOut() {
    hatchSolenoid.set(true);
    SmartDashboard.putString("Solenoid", "true");

  }
  
  public void hatchArmIn() {
    hatchSolenoid.set(false);
    SmartDashboard.putString("Solenoid", "false");

  }



  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

  //TESTING TESTING TESTING
  // Try to extend it. 
  //hatchSolenoid.set(true);

    setDefaultCommand(new HatchCommand());
  }
}
