package frc.lib;

public class Deadzone {
    public static double apply(double a, double b) {
        if (Math.abs(a) <= b) {
            return 0;
        } else {
            return a;
        }
    }
}