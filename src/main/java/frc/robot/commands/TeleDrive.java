package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class TeleDrive extends CommandBase {
    private DriveTrain dt;
    private Joystick joy;

    public TeleDrive(DriveTrain dt, Joystick joy) {
        addRequirements(dt);
        this.dt = dt;
        this.joy = joy;
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        this.dt.drive(-this.deadzone(joy.getRawAxis(1), 0.05), -this.deadzone(joy.getRawAxis(4), 0.05));
    }

    @Override
    public void end(boolean interrupted) {
        this.dt.drive(0, 0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    public double deadzone(double input, double removed) {
        if (Math.abs(input) <= removed)
            input = 0;
        else if (input < 0)
            input = -Math.pow(input, 2);
        else
            input = Math.pow(input, 2);
        return input;
    }
}
