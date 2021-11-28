package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;



import org.firstinspires.ftc.teamcode.lib.GamepadWrapper;
import org.firstinspires.ftc.teamcode.robot.MotorMap;
import org.firstinspires.ftc.teamcode.robot.Robot;


@TeleOp(name="TestOP", group="LinearOpMode")
public class testOp extends OpMode {
    private GamepadWrapper gamepadWrapper;
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    private int DuckCounter = 0;
    private Robot robot;
    double powerLeft;
    double powerRight;
    double rotatePower;



    @Override
    public void init() {
        gamepadWrapper = new GamepadWrapper();
        robot = new Robot(hardwareMap, "duckServo", "frontLeft", "backLeft", "frontRight", "backRight");
        robot.SetRunMode();


        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        backRight = hardwareMap.dcMotor.get("backRight");

        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontLeft.setPower(0);

        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setPower(0);

        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.setPower(0);

        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setPower(0);



    }


    @Override
    public void init_loop() {

    }

    @Override
    public void start () {

    }

    @Override
    public void loop () {
        powerLeft = -gamepad1.left_stick_y;
        powerRight = -gamepad1.left_stick_x;
        rotatePower = -gamepad1.right_stick_x;

        if(Math.abs(rotatePower) > 0.01) {
            frontLeft.setPower(rotatePower);
            frontRight.setPower(rotatePower);
            backRight.setPower(rotatePower);
            backLeft.setPower(rotatePower);
        } else{
            frontLeft.setPower(powerLeft);
            frontRight.setPower(powerRight);
            backRight.setPower(-powerLeft);
            backLeft.setPower(-powerRight);
        }


        if (gamepadWrapper.isPressed("g2_a")) {
            ++DuckCounter;
            if (DuckCounter % 2 == 0) {
                robot.SetDuckPower(0.5);
            } else {
                robot.SetDuckPower(0);
            }
        }







    }

    @Override
    public void stop() {

    }




}
