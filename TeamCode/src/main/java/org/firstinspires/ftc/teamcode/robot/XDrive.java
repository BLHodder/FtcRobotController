package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.robot.DriveBase;


public class XDrive extends DriveBase {
    private DcMotor frontLeftMotor;
    private DcMotor backLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backRightMotor;
    private double powers[];
    double big = 0;

    public XDrive(HardwareMap hardwareMap, String frontLeft, String backLeft, String frontRight, String backRight) {
        frontLeftMotor = hardwareMap.dcMotor.get(frontLeft);
        frontRightMotor = hardwareMap.dcMotor.get(frontRight);
        backLeftMotor = hardwareMap.dcMotor.get(backLeft);
        backRightMotor = hardwareMap.dcMotor.get(backRight);


    }

    public void SetRunMode() {
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void SetStrafe(double power, double angle, double rotate) {
        double frontLeftPower = (-power * Math.cos(angle - Math.PI/4)-rotate) ;
        double backLeftPower = (-power * Math.sin(angle - Math.PI/4)-rotate);
        double frontRightPower = (power * Math.sin(angle - Math.PI/4)-rotate);
        double backRightPower = (power * Math.cos(angle - Math.PI/4)-rotate);

        powers[0] = frontLeftPower;
        powers[1] = backLeftPower;
        powers[2] = frontRightPower;
        powers[3] = backRightPower;

        for (int i = 0; i < powers.length; ++i) {
            big = Math.max(big,Math.abs(powers[i]));
        }

        frontLeftMotor.setPower(frontLeftPower/Math.max(big, 1));
        backLeftMotor.setPower(frontLeftPower/Math.max(big, 1));
        frontRightMotor.setPower(frontLeftPower/Math.max(big, 1));
        backRightMotor.setPower(frontLeftPower/Math.max(big, 1));
    }



}