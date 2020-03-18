package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Rumble extends CommandBase {
    // Joystick
    private Joystick joy;

    // Duration
    private double duration;

    // Strength
    private double strength;

    // Timer
    private double startTime;

    public Rumble(Joystick joy, double duration, double strength) {
        this.joy = joy;
        this.duration = duration;
        this.strength = strength;
        this.startTime = Timer.getFPGATimestamp();
    }

    @Override
    public void initialize() {
        // Start rumbling
        this.joy.setRumble(RumbleType.kLeftRumble, this.strength);
        this.joy.setRumble(RumbleType.kRightRumble, this.strength);
    }

    @Override
    public void execute() {}

    @Override
    public void end(boolean interrupted) {
        // Stop rumbling
        this.joy.setRumble(RumbleType.kLeftRumble, 0);
        this.joy.setRumble(RumbleType.kRightRumble, 0);
    }

    @Override
    public boolean isFinished() {
        // Stop after time
        return Timer.getFPGATimestamp()-this.startTime >= this.duration;
    }
}
