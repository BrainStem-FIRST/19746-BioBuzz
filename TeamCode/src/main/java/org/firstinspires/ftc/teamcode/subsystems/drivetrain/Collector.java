package org.firstinspires.ftc.teamcode.subsystems.drivetrain;

import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Collector {
    private final Telemetry telemetry;
    private final DcMotorEx collectorMotor;

    public enum CollectorState {
        OFF, INTAKE, EXTAKE
    }

    private CollectorState collectorState;

    public Collector(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;
        collectorMotor = hardwareMap.get(DcMotorEx.class, "collector");
        setCollectorState(CollectorState.OFF);
    }

    public void setCollectorState(CollectorState collectorState) {
        this.collectorState = collectorState;
    }

    public CollectorState getCollectorState() {
        return collectorState;
    }

    public void update() {
        switch (collectorState) {
            case OFF:
                collectorMotor.setPower(0);
                break;
            case INTAKE:
                collectorMotor.setPower(0.5);
                break;
            case EXTAKE:
                collectorMotor.setPower(-0.5);
                break;
        }

        telemetry.addLine("COLLECTOR-----");
        telemetry.addData("C state", collectorState);
        telemetry.addData("C motor power", collectorMotor.getPower());
    }
}