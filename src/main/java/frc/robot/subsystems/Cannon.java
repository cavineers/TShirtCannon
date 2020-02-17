package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Cannon extends SubsystemBase {
    // Solenoid
    private Solenoid sol;


    public Cannon(int channel) {
        this.sol = new Solenoid(channel);
    }

    public void open() {
        this.sol.set(true);
    }

    public void close() {
        this.sol.set(false);
    }

    @Override
    public void periodic() {}
}
