package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ChassisConstants;

public class Chassis extends SubsystemBase {
    private final WPI_TalonSRX m_leftFront = new WPI_TalonSRX(2);
    private final WPI_TalonSRX m_leftFrontB = new WPI_TalonSRX(7);
    private final WPI_TalonSRX m_leftRear = new WPI_TalonSRX(1);
    private final WPI_TalonSRX m_leftRearB = new WPI_TalonSRX(6);
    private final WPI_TalonSRX m_rightFront = new WPI_TalonSRX(4);
    private final WPI_TalonSRX m_rightFrontB = new WPI_TalonSRX(5);
    private final WPI_TalonSRX m_rightRear = new WPI_TalonSRX(0);
    private final WPI_TalonSRX m_rightRearB = new WPI_TalonSRX(3);
    
    // private final CANSparkMax m_leftFront = new CANSparkMax(ChassisConstants.kLeftFrontPort, MotorType.kBrushless);
    // private final CANSparkMax m_rightFront = new CANSparkMax(ChassisConstants.kRightFrontPort, MotorType.kBrushless);
    // private final CANSparkMax m_rightRear = new CANSparkMax(ChassisConstants.kRightRearPort, MotorType.kBrushless);
    // private final CANSparkMax m_leftRear = new CANSparkMax(ChassisConstants.kLeftRearPort, MotorType.kBrushless);

    // private RelativeEncoder m_leftFrontEncoder = m_leftFront.getEncoder();
    // private RelativeEncoder m_rightFrontEncoder = m_rightFront.getEncoder();
    // private RelativeEncoder m_rightRearEncoder = m_rightRear.getEncoder();
    // private RelativeEncoder m_leftRearEncoder = m_leftRear.getEncoder();

    private final MecanumDrive m_drive = new MecanumDrive(m_leftFront, m_leftRear, m_rightFront, m_rightRear);

    public Chassis(){
        // m_leftFront.restoreFactoryDefaults();
        // m_rightFront.restoreFactoryDefaults();
        // m_rightRear.restoreFactoryDefaults();
        // m_leftRear.restoreFactoryDefaults();
        // m_leftFront.setSmartCurrentLimit(ChassisConstants.kCurrentLimit);
        // m_rightFront.setSmartCurrentLimit(ChassisConstants.kCurrentLimit);
        // m_rightRear.setSmartCurrentLimit(ChassisConstants.kCurrentLimit);
        // m_leftRear.setSmartCurrentLimit(ChassisConstants.kCurrentLimit);
        // m_leftFront.setIdleMode(IdleMode.kCoast);
        // m_rightFront.setIdleMode(IdleMode.kCoast);
        // m_rightRear.setIdleMode(IdleMode.kCoast);
        // m_leftRear.setIdleMode(IdleMode.kCoast);
        m_leftFrontB.follow(m_leftFront);
        m_leftRearB.follow(m_leftRear);
        m_rightFrontB.follow(m_rightFront);
        m_rightRearB.follow(m_rightRear);

    }

    public void drive(double ySpeed, double xSpeed, double zRotation){
        m_drive.driveCartesian(ySpeed, xSpeed, zRotation);
    }

    // public double getAverageEcoderPosition(){
    //     return(m_leftFrontEncoder.getPosition() + ((-1.0)*m_rightFrontEncoder.getPosition())) / 2.0;
    // }

    // public double getLeftFrontEncoder(){
    //     return m_leftFrontEncoder.getPosition();
    // }
    // public double getRightFrontEncoder(){
    //     return m_rightFrontEncoder.getPosition();
    // }
    // public double getRightRearEncoder(){
    //     return m_rightRearEncoder.getPosition();
    // }
    // public double getLeftRearEncoder(){
    //     return m_leftRearEncoder.getPosition();
    // }

    // public void resetEncoders(){
    //     m_leftFrontEncoder.setPosition(0.0);
    //     m_rightFrontEncoder.setPosition(0.0);
    //     m_rightRearEncoder.setPosition(0.0);
    //     m_leftRearEncoder.setPosition(0.0);
    // }

    //This is called every 20ms
    @Override
    public void periodic(){
        // SmartDashboard.putNumber("LF_Enc",m_leftFrontEncoder.getPosition());
        // SmartDashboard.putNumber("RF_Enc",m_rightFrontEncoder.getPosition());
        // SmartDashboard.putNumber("RR_Enc",m_rightRearEncoder.getPosition());
        // SmartDashboard.putNumber("LR_Enc",m_leftRearEncoder.getPosition());
        SmartDashboard.putNumber("LF_Speed",m_leftFront.get());
        SmartDashboard.putNumber("RF_Speed",m_rightFront.get());
        SmartDashboard.putNumber("RR_Speed",m_rightRear.get());
        SmartDashboard.putNumber("LR_Speed",m_leftRear.get());
        // SmartDashboard.putNumber("AveragePosition",this.getAverageEcoderPosition());
    }

}
