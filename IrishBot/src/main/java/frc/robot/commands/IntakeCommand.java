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

public class IntakeCommand extends Command {
  public IntakeCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
   // requires(Robot.m_intakesystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //Robot.m_intakesystem.IntakeStop();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // Here we use the gamepadController
    // Button2 is IN and Button3 is OUT
    
    /*
    if(Robot.m_oi.gamepadController.getRawButton(2)) {
      Robot.m_intakesystem.IntakeIn();
      SmartDashboard.putString("Intake", "In");
  } else if(Robot.m_oi.gamepadController.getRawButton(1)) {
      Robot.m_intakesystem.IntakeOut();
      SmartDashboard.putString("Intake", "Out");
  } else {
      // Stop the Intake!
      Robot.m_intakesystem.IntakeStop();
  }
*/


  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
   // Robot.m_intakesystem.IntakeStop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
