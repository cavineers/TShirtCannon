package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SealingPiston;

public class TogglePistons extends CommandBase {
  // Piston
  private SealingPiston pistons;

  /**
   * Toggles the piston positions.
   * @param pistons AnglePiston Objects
   */
  public TogglePistons(SealingPiston pistons) {
    // Add to requirements
    addRequirements(pistons);
    this.pistons = pistons;
  }

  @Override
  public void initialize() {
    // Toggle pistons
    if (this.pistons.getPistonState() == SealingPiston.PistonState.RETRACTED) {
      this.pistons.setPistonState(SealingPiston.PistonState.EXTENDED);
    } else {
      this.pistons.setPistonState(SealingPiston.PistonState.RETRACTED);
    }
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    // Immediately end
    return true;
  }
}
