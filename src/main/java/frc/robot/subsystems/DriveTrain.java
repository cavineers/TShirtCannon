package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  // Motors
  public WPI_TalonSRX leftMotor  = new WPI_TalonSRX(Constants.CANIds.kLeftDriveMotor);

  public WPI_TalonSRX rightMotor = new WPI_TalonSRX(Constants.CANIds.kRightDriveMotor);

  // Differential Drive
  private DifferentialDrive drive = new DifferentialDrive(leftMotor, rightMotor);

  /**
   * Constructor.
   */
  public DriveTrain() {
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
