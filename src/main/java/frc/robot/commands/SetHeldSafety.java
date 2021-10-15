package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class SetHeldSafety extends CommandBase {
      // Robot container
  private RobotContainer rc;

  /**
   * Sets the safety mode.
   * @param container Robot container.
   * @param desiredMode boolean value which determines the mode to set to.
   */
  public SetHeldSafety(RobotContainer container) {
    this.rc = container;
  }

  @Override
  public void initialize() {
    this.rc.joy.setRumble(RumbleType.kLeftRumble, 1.0);
    this.rc.joy.setRumble(RumbleType.kRightRumble, 1.0);
    this.rc.controllerMode = RobotContainer.SafetyMode.SAFETY_OFF;
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {
    this.rc.controllerMode = RobotContainer.SafetyMode.SAFETY_ON;
    this.rc.joy.setRumble(RumbleType.kLeftRumble, 0.0);
    this.rc.joy.setRumble(RumbleType.kRightRumble, 0.0);
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}
