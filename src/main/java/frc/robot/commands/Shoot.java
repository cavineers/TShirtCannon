package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.RobotContainer.SafetyMode;
import frc.robot.subsystems.Cannon;

public class Shoot extends CommandBase {
    // Cannon
    private Cannon m_cannon;

    // Start time
    private double m_startTime;

    private RobotContainer m_rc;

    public Shoot(Cannon cannon, RobotContainer rc) {
        this.m_cannon = cannon;
        this.m_rc = rc;

        addRequirements(cannon);
    }

    @Override
    public void initialize() {
        // If the safety is off
        if (this.m_rc.controllerMode == SafetyMode.SAFETY_OFF) {
            // Open the barrel
            this.m_cannon.open();

            // Turn the safety back on
            this.m_rc.controllerMode = SafetyMode.SAFETY_ON;
        }

        // Start the timer
        this.m_startTime = Timer.getFPGATimestamp();
    }

    @Override
    public void execute() {
    }

    @Override
    public void end(boolean interrupted) {
        // Close when finished
        this.m_cannon.close();
    }

    @Override
    public boolean isFinished() {
        // Finished after .3 seconds
        return Timer.getFPGATimestamp()-this.m_startTime >= 0.3;
    }
}
