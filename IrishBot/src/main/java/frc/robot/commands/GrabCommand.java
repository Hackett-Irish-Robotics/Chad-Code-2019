/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class GrabCommand extends Command {
  public GrabCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_grabsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_grabsystem.grabArmIn();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
        // Get the Joystick trigger to extend the grabber.
        if (Robot.m_oi.driverController.getRawButton(2)) {
          Robot.m_grabsystem.grabArmOut();
        } else {
          Robot.m_grabsystem.grabArmIn();
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
        // might not need
        Robot.m_grabsystem.grabArmIn();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
