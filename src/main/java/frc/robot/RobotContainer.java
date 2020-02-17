package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Rumble;
import frc.robot.commands.SetSafety;
import frc.robot.commands.Shoot;
import frc.robot.commands.TogglePistons;
import frc.robot.subsystems.AnglePistons;
import frc.robot.subsystems.Cannon;
import frc.robot.subsystems.DriveTrain;

public class RobotContainer {
    // Controller
    public Joystick joy = new Joystick(0);
    public JoystickButton a_button = new JoystickButton(joy, 1);
    public JoystickButton b_button = new JoystickButton(joy, 2);
    public JoystickButton x_button = new JoystickButton(joy, 3);
    public JoystickButton y_button = new JoystickButton(joy, 4);

    public JoystickButton l_bump = new JoystickButton(joy, 5);
    public JoystickButton r_bump = new JoystickButton(joy, 6);
    public JoystickButton left_menu = new JoystickButton(joy, 7);
    public JoystickButton right_menu = new JoystickButton(joy, 8);
    public JoystickButton left_stick = new JoystickButton(joy, 9);
    public JoystickButton right_stick = new JoystickButton(joy, 10);

    public int lastDpad = -1;

    // Controller map mode
    public enum SafetyMode {
        SAFETY_ON, // Can't shoot
        SAFETY_OFF // Can shoot
    } 

    // Current mode
    public SafetyMode controllerMode = SafetyMode.SAFETY_ON;

    // Subsystems
    public AnglePistons pistons = new AnglePistons();
    public Cannon leftCannon = new Cannon(Constants.PCMChannels.LeftCannon);
    public Cannon rightCannon = new Cannon(Constants.PCMChannels.RightCannon);
    public DriveTrain drivetrain = new DriveTrain(this.joy);

    public RobotContainer() {
        configureButtonBindings();
    }

    private void configureButtonBindings() {
        // Safety on/off
        right_menu.whenPressed(new SetSafety(this, SafetyMode.SAFETY_OFF));
        left_menu.whenPressed(new SetSafety(this, SafetyMode.SAFETY_ON));

        // Toggle pistons
        a_button.whenPressed(new TogglePistons(this.pistons));
    }

    public void controllerPeriodic() {
        if (lastDpad != joy.getPOV()) {
			switch (joy.getPOV()) {
                case 90: { //*RIGHT
                    if (controllerMode == SafetyMode.SAFETY_OFF) {
                        System.out.println("Shooting right cannon");
                        new Shoot(this.rightCannon);
                        new SetSafety(this, SafetyMode.SAFETY_ON);
                    } else {
                        System.out.println("Can't fire. Controller locked");
                        new Rumble(this.joy, 0.4, 0.8);
                    }
                    break;
                }
                case 270: { //*LEFT
                    if (controllerMode == SafetyMode.SAFETY_OFF) {
                        System.out.println("Shooting left cannon");
                        new Shoot(this.leftCannon);
                        new SetSafety(this, SafetyMode.SAFETY_ON);
                    } else {
                        System.out.println("Can't fire. Controller locked");
                        new Rumble(this.joy, 0.4, 0.8);
                    }
                    break;
                }
			}
		}
		lastDpad = joy.getPOV();
    }
}
