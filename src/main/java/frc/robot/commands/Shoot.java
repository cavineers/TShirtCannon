package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Cannon;

public class Shoot extends CommandBase {
    private Cannon cannon;
    private double startTime;

    public Shoot(Cannon cannon) {
        addRequirements(cannon);
        this.cannon = cannon;
    }

    @Override
    public void initialize() {
        this.cannon.open();
        this.startTime = Timer.getFPGATimestamp();
    }

    @Override
    public void execute() {
    }

    @Override
    public void end(boolean interrupted) {
        this.cannon.close();
    }

    @Override
    public boolean isFinished() {
        return Timer.getFPGATimestamp()-this.startTime >= 0.3;
    }
}
