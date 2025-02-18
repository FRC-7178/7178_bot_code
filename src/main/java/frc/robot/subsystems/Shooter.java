package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatorCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.ShooterConstants;

public class Shooter extends SubsystemBase{
    private final WPI_TalonFX m_upperShooterMotor = new WPI_TalonFX(ShooterConstants.kUpperShooterMotorPort);
    private final WPI_TalonFX m_lowerShooterMotor = new WPI_TalonFX(ShooterConstants.kLowerShooterMotorPort);
    private final WPI_TalonSRX m_assistMotor = new WPI_TalonSRX(ShooterConstants.kAssistMotorPort);
    private TalonFXConfiguration m_configs = new TalonFXConfiguration();
    private double m_upperVelocityTarget = 0.0;
    private double m_lowerVelocityTarget = 0.0;

    public Shooter(){
        m_upperShooterMotor.configFactoryDefault();
        m_lowerShooterMotor.configFactoryDefault();
        m_configs.openloopRamp = 1.0; // seconds to go from 0 to full speed
        m_configs.statorCurrLimit = new StatorCurrentLimitConfiguration(true,50.0,55.0,1.0);
        m_configs.supplyCurrLimit = new SupplyCurrentLimitConfiguration(true,40.0,45.0,0.5);
        m_configs.primaryPID.selectedFeedbackSensor = FeedbackDevice.IntegratedSensor;
        m_configs.nominalOutputForward = 0.0;
        m_configs.nominalOutputReverse = 0.0;
        m_configs.peakOutputForward = 1.0;
        m_configs.peakOutputReverse = 0.0; // don't allow reverse
        m_configs.primaryPID.selectedFeedbackSensor = FeedbackDevice.IntegratedSensor;

        m_upperShooterMotor.config_kF(0, Constants.ShooterConstants.kF,20);
        m_upperShooterMotor.config_kD(0,Constants.ShooterConstants.kD, 20);
        m_upperShooterMotor.config_kP(0, Constants.ShooterConstants.kP, 20);
        m_upperShooterMotor.config_kI(0, Constants.ShooterConstants.kI, 20);
        m_upperShooterMotor.config_IntegralZone(0, Constants.ShooterConstants.KIzone, 20);
        m_upperShooterMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 20);

        m_lowerShooterMotor.config_kF(0, Constants.ShooterConstants.kF,20);
        m_lowerShooterMotor.config_kD(0,Constants.ShooterConstants.kD, 20);
        m_lowerShooterMotor.config_kP(0, Constants.ShooterConstants.kP, 20);
        m_lowerShooterMotor.config_kI(0, Constants.ShooterConstants.kI, 20);
        m_lowerShooterMotor.config_IntegralZone(0, Constants.ShooterConstants.KIzone, 20);
        m_lowerShooterMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 20);


        m_upperShooterMotor.configAllSettings(m_configs,20);
        m_lowerShooterMotor.configAllSettings(m_configs,20);
        m_upperShooterMotor.setNeutralMode(NeutralMode.Coast);
        m_lowerShooterMotor.setNeutralMode(NeutralMode.Coast);
        m_lowerShooterMotor.setInverted(false); // invert the lower one so always positive value
        m_upperShooterMotor.setInverted(true); // invert the lower one so always positive value

        m_assistMotor.setNeutralMode(NeutralMode.Brake);


    }

    public void shooterOn(){
        m_upperShooterMotor.set(ControlMode.PercentOutput,ShooterConstants.kUpperShooterMotorSpeed);
        m_lowerShooterMotor.set(ControlMode.PercentOutput,ShooterConstants.kLowerShooterMotorSpeed);
    }

    public void shooterOff(){
        m_upperShooterMotor.set(ControlMode.PercentOutput,0.0);
        m_lowerShooterMotor.set(ControlMode.PercentOutput,0.0);
        m_upperVelocityTarget = 0;
        m_lowerVelocityTarget = 0;
    }

    public void assistOn(){
        m_assistMotor.set(ShooterConstants.kAssistMotorSpeed);
    }

    public void assistOff(){
        m_assistMotor.set(0.0);
    }

    public double getUpperShooterVelocity(){
        return(m_upperShooterMotor.getSelectedSensorVelocity());
    }

    public double getLowerShooterVelocity(){
        return(m_lowerShooterMotor.getSelectedSensorVelocity());
    }

    public void speedControlShooter(double upperSpeedTarget, double lowerSpeedTarget){
        m_upperShooterMotor.set(ControlMode.Velocity,upperSpeedTarget);
        m_lowerShooterMotor.set(ControlMode.Velocity,lowerSpeedTarget);
        m_upperVelocityTarget = upperSpeedTarget;
        m_lowerVelocityTarget = lowerSpeedTarget;
    }

    @Override
    public void periodic(){
        SmartDashboard.putNumber("US Speed",m_upperShooterMotor.getSelectedSensorVelocity());
        SmartDashboard.putNumber("LS Speed",m_lowerShooterMotor.getSelectedSensorVelocity());
        SmartDashboard.putNumber("US Set",m_upperShooterMotor.getMotorOutputPercent());
        SmartDashboard.putNumber("LS Set",m_lowerShooterMotor.getMotorOutputPercent());
        SmartDashboard.putNumber("US Target",m_upperVelocityTarget);
        SmartDashboard.putNumber("LS Target",m_lowerVelocityTarget);
        SmartDashboard.putNumber("Assist Set",m_assistMotor.get());
    }
}
