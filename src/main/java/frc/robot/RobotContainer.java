package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
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

    public POVButton dPadLeft = new POVButton(this.joy, 270);
    public POVButton dPadRight = new POVButton(this.joy, 90);

    // Controller map mode
    public enum SafetyMode {
        SAFETY_ON, // Can't shoot
        SAFETY_OFF // Can shoot
    } 

    // Current mode
    public SafetyMode controllerMode = SafetyMode.SAFETY_ON;

    // Subsystems
    public DriveTrain drivetrain = new DriveTrain();
    public AnglePistons pistons = new AnglePistons();
    public Cannon leftCannon = new Cannon(Constants.PCMChannels.LeftCannon);
    public Cannon rightCannon = new Cannon(Constants.PCMChannels.RightCannon);

    public RobotContainer() {
        configureButtonBindings();
    }

    private void configureButtonBindings() {
        // Safety on/off
        right_menu.whenPressed(new SetSafety(this, SafetyMode.SAFETY_OFF));
        left_menu.whenPressed(new SetSafety(this, SafetyMode.SAFETY_ON));

        // Toggle pistons
        a_button.whenPressed(new TogglePistons(this.pistons));

        // D-pad buttons
        dPadLeft.whenPressed(new Shoot(this.leftCannon, this));
        dPadRight.whenPressed(new Shoot(this.rightCannon, this));

    }
}
