package frc.robot;

public final class Constants {
  // Can IDs
  public static final class CANIds {
    public static final int kPCM = 0;
    public static final int kPDP = 15;
    public static final int kRightDriveMotor1 = 1;
    public static final int kLeftDriveMotor1 = 2;
    public static final int kRightDriveMotor2 = 3;
    public static final int kLeftDriveMotor2 = 4;
    public static int kRevolver = 5;
  }

  public static final class Revolver {
    public static final double kSpeedForward = 0.4;
    public static final double kSpeedReverse = -0.3;
  }

  // PCM Channels
  public static final class PCMChannels {
    public static final int kTopCannon = 3;
    public static final int kLeftCannon = 4;
    public static final int kRightCannon = 5;
  }
}
