package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.lib.Deadzone;
import frc.robot.subsystems.DriveTrain;

public class TeleDrive extends CommandBase {
  // DriveTrain
  private DriveTrain dt;

  // Joystick
  private Joystick joy;

  /**
   * Sets the drive mode to tele-operation.
   * @param dt DriveTrain Object
   * @param joy HID Joystick Object
   */
  public TeleDrive(DriveTrain dt, Joystick joy) {
    // Add requirements
    addRequirements(dt);
    this.dt = dt;
    this.joy = joy;
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    // Drive
    this.dt.drive(Deadzone.apply(joy.getRawAxis(1), 0.05),
        Deadzone.apply(-joy.getRawAxis(4), 0.05));
  }

  @Override
  public void end(boolean interrupted) {
    this.dt.drive(0, 0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
