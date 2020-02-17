package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class AnglePistons extends SubsystemBase {
    // State
    public enum PistonState {
        EXTENDED,
        RETRACTED
    }

    // Solenoid
    private DoubleSolenoid sol = new DoubleSolenoid(Constants.PCMChannels.Piston1, Constants.PCMChannels.Piston2);

    /**
     * constructor
     */
    public AnglePistons() {
        // Auto retract on robot start
        this.setPistonState(PistonState.RETRACTED);
    }

    /**
     * set the wanted state
     * @param state wanted state
     */
    public void setPistonState(PistonState state) {
        if (state == PistonState.EXTENDED) {
            this.sol.set(DoubleSolenoid.Value.kForward);
        } else {
            this.sol.set(DoubleSolenoid.Value.kReverse);
        }
    }

    /**
     * get the current piston state
     * @return current state
     */
    public PistonState getPistonState() {
        if (sol.get() == DoubleSolenoid.Value.kForward) {
            return PistonState.EXTENDED;
        } else {
            return PistonState.RETRACTED;
        }
    }

    @Override
    public void periodic() {} // no periodic needed
}
