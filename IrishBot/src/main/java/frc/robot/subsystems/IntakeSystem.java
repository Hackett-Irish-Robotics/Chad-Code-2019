/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.IntakeCommand;

/**
 * Add your docs here.
 */
public class IntakeSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  Spark LeftRoller = null;
  Spark RightRoller = null;
  SpeedControllerGroup IntakeMotors = new SpeedControllerGroup(LeftRoller,RightRoller);

  public IntakeSystem() {
    LeftRoller = new Spark(RobotMap.INTAKE_ROLLER_LEFT);
    RightRoller = new Spark(RobotMap.INTAKE_ROLLER_RIGHT);
    LeftRoller.enableDeadbandElimination(true);
    RightRoller.enableDeadbandElimination(true);

  }

    // Cargo in and Cargo Out. Test these and reverse
    // if necessary.

    // If the Speed Controller group does not work,
    // we can control the motors independently.
    
    public void IntakeIn() {
      IntakeMotors.set(1);
      /*
      LeftRoller.set(1);
      RightRoller.set(1);
      */
    }
  
    public void IntakeOut() {
      IntakeMotors.set(-1);

      /*
      LeftRoller.set(-1);
      RightRoller.set(-1);
      */

    }
  
    public void IntakeStop() {
      IntakeMotors.stopMotor();

      /*
      LeftRoller.stopMotor();
      RightRoller.stopMotor();
      */
    }
  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new IntakeCommand()); 
  }
}
