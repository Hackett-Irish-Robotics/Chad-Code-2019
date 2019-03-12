/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class CargoCommand extends Command {
  public CargoCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_cargosystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_cargosystem.CargoStop();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    // Here we use the gamepadController
    // Button7 is up and Button8 is down
    if(Robot.m_oi.gamepadController.getRawButton(7)) {
      Robot.m_cargosystem.CargoUp();
      SmartDashboard.putString("Cargo", "Up");
  } else if(Robot.m_oi.gamepadController.getRawButton(8)) {
    Robot.m_cargosystem.CargoDown();
      SmartDashboard.putString("Cargo", "Down");
  } else {
      // Stop the cargo!
      Robot.m_cargosystem.CargoStop();
  }


  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_cargosystem.CargoStop();
    }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
