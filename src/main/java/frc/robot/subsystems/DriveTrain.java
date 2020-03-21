package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
    // Motors
    public WPI_TalonSRX m_leftMotor1  = new WPI_TalonSRX(Constants.CANIds.LeftDrive1);
    public WPI_TalonSRX m_leftMotor2  = new WPI_TalonSRX(Constants.CANIds.LeftDrive2);
    
    public WPI_TalonSRX m_rightMotor1 = new WPI_TalonSRX(Constants.CANIds.RightDrive1);
    public WPI_TalonSRX m_rightMotor2 = new WPI_TalonSRX(Constants.CANIds.RightDrive2);
    
    // Differential Drive
    private DifferentialDrive drive = new DifferentialDrive(m_leftMotor1, m_rightMotor1);

    /**
     * Constructor
     */
    public DriveTrain() {
        // Follow
        this.m_leftMotor2.follow(this.m_leftMotor1);
        this.m_rightMotor2.follow(this.m_rightMotor1);

        // Invert right side
        this.drive.setRightSideInverted(true);
    }

    /**
     * Drive
     * @param forward forward param
     * @param rotate rotation param
     */
    public void drive(double forward, double rotate) {
        drive.curvatureDrive(forward, rotate, false);
    }

    /**
     * Periodic
     */
    @Override
    public void periodic() {}
}
