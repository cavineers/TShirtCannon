package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Revolver extends SubsystemBase {
    public WPI_TalonSRX revolverMotor =  new WPI_TalonSRX(Constants.CANIds.kRevolver);

    public enum RevMotorState {
        ON,
        OFF,
        REVERSED
    }

    private RevMotorState currentMode = RevMotorState.OFF;

    public Revolver() {
        this.setMotorState(RevMotorState.OFF);
    }

    public void setMotorState(RevMotorState state) {
        this.currentMode = state;

        switch (state) {
            case ON:
                this.revolverMotor.set(ControlMode.PercentOutput, Constants.Revolver.kSpeedForward);
                break;
            case OFF:
                this.revolverMotor.set(ControlMode.PercentOutput, 0);
                break;
            case REVERSED:
                this.revolverMotor.set(ControlMode.PercentOutput, Constants.Revolver.kSpeedReverse);
                break;
            default:
                this.setMotorState(RevMotorState.OFF);
        }
    }

    public RevMotorState getMotorState() {
        return this.currentMode;
    }
}
