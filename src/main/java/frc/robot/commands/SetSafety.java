package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class SetSafety extends CommandBase {
    // Robot container
    private RobotContainer rc;

    // Safety mode
    private RobotContainer.SafetyMode wantedMode;

    public SetSafety(RobotContainer container, RobotContainer.SafetyMode desiredMode) {
        this.rc = container;
        this.wantedMode = desiredMode;
    }

    @Override
    public void initialize() {
        this.rc.controllerMode = wantedMode;
    }

    @Override
    public void execute() {}

    @Override
    public void end(boolean interrupted) {}

    @Override
    public boolean isFinished() {
        return true;
    }
}
