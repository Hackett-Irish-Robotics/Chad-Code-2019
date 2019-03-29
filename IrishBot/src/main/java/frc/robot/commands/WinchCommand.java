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

public class WinchCommand extends Command {
  public WinchCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_winch);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_winch.WinchStop();
    Robot.m_winch.initializeCounter();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {


    // Here we use the gamepadController
    // Button5 is up and Button6 is down
    if(Robot.m_oi.gamepadController.getRawButton(5)) {
        Robot.m_winch.WinchUp();
        SmartDashboard.putString("Winch", "Up");
    } else if(Robot.m_oi.gamepadController.getRawButton(6)) {
        Robot.m_winch.WinchDown();
        SmartDashboard.putString("Winch", "Down");
    } else {
        // Stop the winch!
        Robot.m_winch.WinchStop();
    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    //Checking for the boolean
    return Robot.m_winch.isSwitchSet();
  }

  // Called once after isFinished returns true.
  // We want to make sure we stop the winch here.
  @Override
  protected void end() {
    Robot.m_winch.WinchStop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
