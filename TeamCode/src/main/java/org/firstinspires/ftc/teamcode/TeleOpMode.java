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
        //Before testing on ground, test with the robot elevate to make sure all wheels spin
        // properly and in the correct direction
        frontLeft.setPower(-power * Math.cos(angle - Math.PI/4));
        backLeft.setPower(-power * Math.sin(angle - Math.PI/4));
        frontRight.setPower(power * Math.sin(angle - Math.PI/4));
        backRight.setPower(power * Math.cos(angle - Math.PI/4));

        



    }

    @Override
    public void stop() {

    }




}
