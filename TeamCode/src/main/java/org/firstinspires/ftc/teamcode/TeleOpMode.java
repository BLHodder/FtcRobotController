package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.lib.GamepadWrapper;
import org.firstinspires.ftc.teamcode.robot.MotorMap;


@TeleOp(name="TeleOpMode", group="LinearOpMode")
public class TeleOpMode extends OpMode {
    private MotorMap motorMap;
    private GamepadWrapper gamepadWrapper;
    private ElapsedTime robotTime;
    private Robot robot;



    @Override
    public void init() {
        motorMap = new MotorMap(hardwareMap, "forwardLeft", "forwardRight", "backLeft", "backRight");
        for (DcMotor motor : motorMap.GetMotorMap().values()) {
            motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }

        gamepadWrapper = new GamepadWrapper();

        robotTime = new ElapsedTime();
        robotTime.reset();


    }


    @Override
    public void init_loop() {

    }

    @Override
    public void start () {

    }

    @Override
    public void loop () {
        gamepadWrapper.updateGamepadInputs(gamepad1, gamepad2);

        double angle = Math.atan2(-gamepad1.left_stick_y, gamepad1.left_stick_x);
        double power = Math.sqrt(gamepad1.left_stick_y*gamepad1.left_stick_y+gamepad1.left_stick_x*gamepad1.left_stick_x);
        robot.



    }

    @Override
    public void stop() {

    }




}
