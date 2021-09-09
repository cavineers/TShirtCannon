package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Revolver;
import frc.robot.subsystems.SealingPiston;
import frc.robot.subsystems.SealingPiston.PistonState;

public class Reload extends CommandBase {

    private SealingPiston m_piston;
    private Revolver m_revolver;
    private double m_timer;

    public Reload(SealingPiston piston, Revolver revolver) {
        this.m_piston = piston;
        this.m_revolver = revolver;

        addRequirements(m_piston);
        addRequirements(m_revolver);
    }

    // Called just before this Command runs the first time
    @Override
    public void initialize() {
        // Set timer.
        this.m_timer = Timer.getFPGATimestamp();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    public void execute() {
        // TODO: Extend piston, Rotate revolver, and retract piston.
        this.m_piston.setPistonState(PistonState.EXTENDED);
    }

    @Override
    public void end(boolean interrupted) {
        // Retract piston when command is finished.
        this.m_piston.setPistonState(PistonState.RETRACTED);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    public boolean isFinished() {
        // TODO: Change this value so it runs for x amount of time.
        // Finished after 1.2 seconds
        return Timer.getFPGATimestamp() - this.m_timer >= 1.2;
    }
}
