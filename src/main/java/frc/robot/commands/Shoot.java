package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Cannon;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;

public class Shoot extends CommandBase {
  // Cannon
  private Cannon cannon;

  // Start time
  private double startTime;

  private RobotContainer rc;

  /**
   * Shoots the cannon.
   * @param cannon Cannon Object.
   * @param rc RobotContainer Object.
   */
  public Shoot(Cannon cannon, RobotContainer container) {
    this.cannon = cannon;
    this.rc = container;

    addRequirements(cannon);
    container.joy.setRumble(RumbleType.kLeftRumble, 1.0);
    container.joy.setRumble(RumbleType.kRightRumble, 1.0);
  }

  @Override
  public void initialize() {
    // If the safety is off
    if (this.rc.controllerMode == RobotContainer.SafetyMode.SAFETY_OFF) {
      // Open the barrel
      this.cannon.open();

      // Turn the safety back on
      this.rc.controllerMode = RobotContainer.SafetyMode.SAFETY_ON;
    }

    // Start the timer
    this.startTime = Timer.getFPGATimestamp();
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {
    // Close when finished
    this.cannon.close();
    this.rc.joy.setRumble(RumbleType.kLeftRumble, 0.0);
    this.rc.joy.setRumble(RumbleType.kRightRumble, 0.0);
  }

  @Override
  public boolean isFinished() {
    // Finished after .3 seconds
    return Timer.getFPGATimestamp() - this.startTime >= 0.3;
  }
}
