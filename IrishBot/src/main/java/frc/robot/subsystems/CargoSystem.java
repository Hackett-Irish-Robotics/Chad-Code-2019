/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.CargoCommand;
import edu.wpi.first.wpilibj.PWMVictorSPX;


public class CargoSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  PWMVictorSPX CargoWinch = null;

  public CargoSystem() {
    CargoWinch = new PWMVictorSPX(RobotMap.CARGO_WINCH_CONTROLLER);
    CargoWinch.enableDeadbandElimination(true);

  }

  // We need to check the speed. 
  // Ran at .7 in testing. Might be able
  // to set to full speed (1, -1)
  public void CargoUp() {
    CargoWinch.set(1);
  }

  public void CargoDown() {
    CargoWinch.set(-1);
  }

  public void CargoStop() {
    CargoWinch.stopMotor();
  }



  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new CargoCommand());
  }
}
