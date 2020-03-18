package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AnglePistons;

public class TogglePistons extends CommandBase {
    // Piston
    private AnglePistons pistons;

    public TogglePistons(AnglePistons pistons) {
        // Add to requirements
        addRequirements(pistons);
        this.pistons = pistons;
    }

    @Override
    public void initialize() {
        // Toggle pistons
        if (this.pistons.getPistonState() == AnglePistons.PistonState.RETRACTED) {
            this.pistons.setPistonState(AnglePistons.PistonState.EXTENDED);
        } else {
            this.pistons.setPistonState(AnglePistons.PistonState.RETRACTED);
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
