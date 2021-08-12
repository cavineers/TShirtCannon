package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  // Motors
  public WPI_TalonSRX leftMotor1  = new WPI_TalonSRX(Constants.CANIds.LeftDrive1);
  public WPI_TalonSRX leftMotor2  = new WPI_TalonSRX(Constants.CANIds.LeftDrive2);

  public WPI_TalonSRX rightMotor1 = new WPI_TalonSRX(Constants.CANIds.RightDrive1);
  public WPI_TalonSRX rightMotor2 = new WPI_TalonSRX(Constants.CANIds.RightDrive2);

  // Differential Drive
  private DifferentialDrive drive = new DifferentialDrive(leftMotor1, rightMotor1);

  /**
   * Constructor.
   */
  public DriveTrain() {
    // Follow
    this.leftMotor2.follow(this.leftMotor1);
    this.rightMotor2.follow(this.rightMotor1);

    // Invert right side
    this.drive.setRightSideInverted(true);
  }

  /**
   * Drive.
   * @param forward forward param
   * @param rotate rotation param
   */
  public void drive(double forward, double rotate) {
    drive.curvatureDrive(forward, rotate, false);
  }

  /**
   * Periodic.
   */
  @Override
  public void periodic() {}
}
