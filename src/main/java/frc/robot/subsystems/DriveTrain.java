package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  // Motors
  public CANSparkMax left1  = new CANSparkMax(Constants.CANIds.kRightDriveMotor1, MotorType.kBrushless);
  public CANSparkMax right1 = new CANSparkMax(Constants.CANIds.kLeftDriveMotor1, MotorType.kBrushless);
  public CANSparkMax left2  = new CANSparkMax(Constants.CANIds.kRightDriveMotor2, MotorType.kBrushless);
  public CANSparkMax right2 = new CANSparkMax(Constants.CANIds.kLeftDriveMotor2, MotorType.kBrushless);

  // Differential Drive
  private DifferentialDrive drive = new DifferentialDrive(left1, right1);

  /**
   * Constructor.
   */
  public DriveTrain() {
    // Invert right side
    this.drive.setRightSideInverted(true);

    this.left1.restoreFactoryDefaults();
    this.left2.restoreFactoryDefaults();
    this.right1.restoreFactoryDefaults();
    this.right2.restoreFactoryDefaults();

    this.left2.follow(left1);
    this.right2.follow(right1);
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
