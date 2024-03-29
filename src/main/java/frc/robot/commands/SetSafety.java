package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class SetSafety extends CommandBase {
  // Robot container
  private RobotContainer rc;

  // Safety mode
  private RobotContainer.SafetyMode wantedMode;

  /**
   * Sets the safety mode.
   * @param container Robot container.
   * @param desiredMode boolean value which determines the mode to set to.
   */
  public SetSafety(RobotContainer container, RobotContainer.SafetyMode desiredMode) {
    this.rc = container;
    this.wantedMode = desiredMode;
    container.joy.setRumble(RumbleType.kLeftRumble, 1.0);
    container.joy.setRumble(RumbleType.kRightRumble, 1.0);
  }

  @Override
  public void initialize() {
    this.rc.controllerMode = wantedMode;
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {
    this.rc.joy.setRumble(RumbleType.kLeftRumble, 0.0);
    this.rc.joy.setRumble(RumbleType.kRightRumble, 0.0);
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}
