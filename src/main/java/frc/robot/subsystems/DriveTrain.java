package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.TeleDrive;

public class DriveTrain extends SubsystemBase {
    public WPI_TalonSRX leftMotor1  = new WPI_TalonSRX(Constants.CANIds.LeftDrive1);
    public WPI_TalonSRX leftMotor2  = new WPI_TalonSRX(Constants.CANIds.LeftDrive2);
    
    public WPI_TalonSRX rightMotor1 = new WPI_TalonSRX(Constants.CANIds.RightDrive1);
    public WPI_TalonSRX rightMotor2 = new WPI_TalonSRX(Constants.CANIds.RightDrive2);
    
    private DifferentialDrive drive = new DifferentialDrive(leftMotor1, rightMotor1);

    private Joystick joy;

    public DriveTrain(Joystick joy) {
        // Follow
        this.leftMotor2.follow(leftMotor1);
        this.rightMotor2.follow(rightMotor1);

        // Invert right side
        this.drive.setRightSideInverted(true);

        // Needs joystick
        this.joy = joy;

        setDefaultCommand(new TeleDrive(this, this.joy));
    }

    public void drive(double forward, double rotate) {
        drive.curvatureDrive(forward, rotate, false);
    }

    @Override
    public void periodic() {} // no periodic
}
