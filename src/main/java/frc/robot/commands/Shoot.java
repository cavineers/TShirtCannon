package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Cannon;

public class Shoot extends CommandBase {
    // Cannon
    private Cannon cannon;

    // Start time
    private double startTime;

    public Shoot(Cannon cannon) {
        // Require the cannon
        addRequirements(cannon);
        this.cannon = cannon;
    }

    @Override
    public void initialize() {
        // Open the cannon
        this.cannon.open();

        // Start the timer
        this.startTime = Timer.getFPGATimestamp();
    }

    @Override
    public void execute() {
    }

    @Override
    public void end(boolean interrupted) {
        // Close when finished
        this.cannon.close();
    }

    @Override
    public boolean isFinished() {
        // Finished after .3 seconds
        return Timer.getFPGATimestamp()-this.startTime >= 0.3;
    }
}
