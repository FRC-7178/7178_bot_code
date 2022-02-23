package frc.robot;

public final class Constants {

    public static final class OIConstants{
        public static final int kDriverPort = 0;
        public static final int kCoDriverPort = 1;
    }

    public static final class ChassisConstants{
        public static final int kLeftFrontPort = 1;
        public static final int kRightFrontPort = 2;
        public static final int kRightRearPort = 3;
        public static final int kLeftRearPort = 4;

        public static final int kCurrentLimit = 40; // 40A current limit for motors eventhough it could be higher but not higher than 50A as the rating is 40A @80%
    }

    public static final class IntakeConstants{
        public static final int kIntakeMotorPort = 8;
        public static final double kIntakeMotorSpeed = 0.8;
    }

    public static final class TraverseConstants{
        public static final int kTraverseMotorPort = 15;
        public static final double kTraverseMotorSpeed = 0.8;
        public static final int kTraverseSensorPort = 1;
    }

    public static final class IndexerConstants{
        public static final int kIndexerMotorPort = 9;
        // Might need to retune later
        // As Mr. Gilbert said- "50% isn't always 50%"
        public static final double kIndexerMotorSpeed = 0.5;
        public static final int kIndexerSensorPort = 0;
    }

    public static final class ShooterConstants{
        public static final int kUpperShooterMotorPort = 13;
        public static final double kUpperShooterMotorSpeed = 0.35;
        public static final int kLowerShooterMotorPort = 14;
        public static final double kLowerShooterMotorSpeed = 0.55;
        public static final int kAssistMotorPort = 10;
        public static final double kAssistMotorSpeed = 0.5;

        public static final double kUpperShooterSpeed = 6000;
        public static final double kLowerShooterSpeed = 11000;
        public static final long kMaxIndexTimeMS = 5000; // time to determine we have no more balls in the indexer
        public static final long kMaxRampTimeMS = 100; // time to deterine we have a stable speed
        public static final long kMaxReleaseTimeMS = 100; // time to recoginze we released a ball from the indexer


        public static final double kF = 0.05; 
        public static final double kD = 5.0;
        public static final double kI = 0.001;
        public static final double kP = 0.1;
        public static final int KIzone = 300;
        

    }

}
