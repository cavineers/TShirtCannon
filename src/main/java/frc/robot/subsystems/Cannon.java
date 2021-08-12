package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Cannon extends SubsystemBase {
  // Solenoid
  private Solenoid sol;

  /**
   * constructor.
   * @param channel cannon id
   */
  public Cannon(int channel) {
    this.sol = new Solenoid(channel);
  }

  /**
   * Open the barrel.
   */
  public void open() {
    this.sol.set(true);
  }

  /**
   * Close the barrel.
   */
  public void close() {
    this.sol.set(false);
  }

  /**
   * Periodic.
   */
  @Override
  public void periodic() {}
}
