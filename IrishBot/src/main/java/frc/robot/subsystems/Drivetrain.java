/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
//import edu.wpi.first.wpilibj.Victor;
//import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveArcade;


/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // Here we are creating the Victor variables to
  // control the drive.

  /* =========================================
  SPECIAL NOTE: Let's check that we are using
  Victors and not Victor SPs. 
  We need to change these if they are
  Victor S
  Victor rightFrontVictor = null;
  Victor rightBackVictor = null;
  ============================================
  */

  // Should be able to use VictorSP instead of these.
 // Victor leftFrontVictor = null;
  //Victor leftBackVictor = null;
  //Victor rightFrontVictor = null;
  //Victor rightBackVictor = null;

  //VictorSP leftFrontVictor = null;
  //VictorSP leftBackVictor = null;
  //VictorSP rightFrontVictor = null;
  //VictorSP rightBackVictor = null;



  // Fur use with PWM if needed.
  PWMVictorSPX leftFrontVictorSPX = null;
  PWMVictorSPX leftBackVictorSPX = null;
  PWMVictorSPX rightFrontVictorSPX = null;
  PWMVictorSPX rightBackVictorSPX = null;

  // Creating our Arcade drive.
  DifferentialDrive differentialDrive = null;

  public Drivetrain() {
  // Here we are linking them to the RobotMap.java so we 
  // can use the objects for each and link them to the IDs on
  // the RoboRio.

  //leftFrontVictor = new VictorSP(RobotMap.DRIVETRAIN_LEFT_FRONT_VICTOR);
  //leftBackVictor = new VictorSP(RobotMap.DRIVETRAIN_LEFT_BACK_VICTOR);
  //rightFrontVictor = new VictorSP(RobotMap.DRIVETRAIN_RIGHT_FRONT_VICTOR);
  //rightBackVictor = new VictorSP(RobotMap.DRIVETRAIN_RIGHT_BACK_VICTOR);

  // For use woth PWM if needed.
    leftFrontVictorSPX = new PWMVictorSPX(RobotMap.DRIVETRAIN_LEFT_FRONT_VICTOR);
    leftBackVictorSPX = new PWMVictorSPX(RobotMap.DRIVETRAIN_LEFT_BACK_VICTOR);
    rightFrontVictorSPX = new PWMVictorSPX(RobotMap.DRIVETRAIN_RIGHT_FRONT_VICTOR);
    rightBackVictorSPX = new PWMVictorSPX(RobotMap.DRIVETRAIN_RIGHT_BACK_VICTOR);

  
  // Time to group up our motors so they can work together.
  //SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftFrontVictor, leftBackVictor);
  //SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightFrontVictor, rightBackVictor);

  // For use with PWN if needed.
  SpeedControllerGroup leftMotorsSPX = new SpeedControllerGroup(leftFrontVictorSPX, leftBackVictorSPX);
  SpeedControllerGroup rightMotorsSPX = new SpeedControllerGroup(rightFrontVictorSPX, rightBackVictorSPX);

  //differentialDrive = new DifferentialDrive(leftMotors, rightMotors);

  // For use with PWN if needed.
  differentialDrive = new DifferentialDrive(leftMotorsSPX, rightMotorsSPX);

  }
 
  // Full speed for the drive. Had issues when tried to slow it
  // down when moving forward and backward.
  public void arcadeDrive(double moveSpeed, double rotateSpeed) {
    differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);

  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

    // We want to make sure we have the robot drive running.
    setDefaultCommand(new DriveArcade());
  }
}
