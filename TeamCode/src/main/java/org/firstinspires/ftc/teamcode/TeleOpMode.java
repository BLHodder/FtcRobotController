package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


import org.firstinspires.ftc.teamcode.lib.GamepadWrapper;
import org.firstinspires.ftc.teamcode.robot.MotorMap;



@TeleOp(name="TeleOpMode", group="LinearOpMode")
public class TeleOpMode extends OpMode {
    private GamepadWrapper gamepadWrapper;
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    private double powers[];
    double big = 0;



    @Override
    public void init() {
        gamepadWrapper = new GamepadWrapper();

        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        backRight = hardwareMap.dcMotor.get("backRight");

        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }


    @Override
    public void init_loop() {

    }

    @Override
    public void start () {

    }

    @Override
    public void loop () {

        double angle = Math.atan2(-gamepad1.left_stick_y, gamepad1.left_stick_x);
        double power = Math.sqrt(gamepad1.left_stick_y*gamepad1.left_stick_y+
                gamepad1.left_stick_x*gamepad1.left_stick_x);
        double rotate = gamepad1.right_stick_x;
        //Before testing on ground, test with the robot elevate to make sure all wheels spin
        // properly and in the correct direction
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



        frontLeft.setPower(frontLeftPower/Math.max(big, 1));
        backLeft.setPower(frontLeftPower/Math.max(big, 1));
        frontRight.setPower(frontLeftPower/Math.max(big, 1));
        backRight.setPower(frontLeftPower/Math.max(big, 1));

        /**
        frontLeft.setPower(-rotate);
        backLeft.setPower(-rotate);
        frontRight.setPower(-rotate);
        backRight.setPower(-rotate);
        */





    }

    @Override
    public void stop() {

    }




}
