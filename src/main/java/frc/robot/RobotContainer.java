package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.commands.SetSafety;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.Cannon;
import frc.robot.subsystems.DriveTrain;

public class RobotContainer {
  // Controller
  public Joystick joy = new Joystick(0);
  public JoystickButton m_aButton = new JoystickButton(joy, 1);
  public JoystickButton m_bButton = new JoystickButton(joy, 2);
  public JoystickButton m_xButton = new JoystickButton(joy, 3);
  public JoystickButton m_yButton = new JoystickButton(joy, 4);

  public JoystickButton m_lBump = new JoystickButton(joy, 5);
  public JoystickButton m_rBump = new JoystickButton(joy, 6);
  public JoystickButton m_leftMenu = new JoystickButton(joy, 7);
  public JoystickButton m_rightMenu = new JoystickButton(joy, 8);
  public JoystickButton m_leftStick = new JoystickButton(joy, 9);
  public JoystickButton m_rightStick = new JoystickButton(joy, 10);

  public POVButton m_dPadTop = new POVButton(this.joy, 0);
  public POVButton m_dPadRight = new POVButton(this.joy, 90);
  public POVButton m_dPadBottom = new POVButton(this.joy, 180);
  public POVButton m_dPadLeft = new POVButton(this.joy, 270);

  // Safety Enum
  public enum SafetyMode {
    SAFETY_ON, // Can't shoot
    SAFETY_OFF // Can shoot
  }

  // Current mode
  public SafetyMode controllerMode = SafetyMode.SAFETY_ON;

  // Subsystems
  public DriveTrain drivetrain = new DriveTrain();
  public Cannon leftCannon = new Cannon(Constants.PCMChannels.kLeftCannon);
  public Cannon rightCannon = new Cannon(Constants.PCMChannels.kRightCannon);
  public Cannon topCannon = new Cannon(Constants.PCMChannels.kTopCannon);

  public RobotContainer() {
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    // Safety on/off
    m_rightMenu.whenPressed(new SetSafety(this, SafetyMode.SAFETY_OFF));
    m_leftMenu.whenPressed(new SetSafety(this, SafetyMode.SAFETY_ON));

    // D-pad buttons
    m_dPadTop.whenPressed(new Shoot(this.topCannon, this));
    m_dPadLeft.whenPressed(new Shoot(this.leftCannon, this));
    m_dPadRight.whenPressed(new Shoot(this.rightCannon, this));
  }
}
