package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class TeleDrive extends CommandBase {
    // DriveTrain
    private DriveTrain dt;

    // Joystick
    private Joystick joy;

    public TeleDrive(DriveTrain dt, Joystick joy) {
        // Add requirements
        addRequirements(dt);
        this.dt = dt;
        this.joy = joy;
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        // Drive
        this.dt.drive(-joy.getRawAxis(1), -joy.getRawAxis(4));
    }

    @Override
    public void end(boolean interrupted) {
        this.dt.drive(0, 0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
