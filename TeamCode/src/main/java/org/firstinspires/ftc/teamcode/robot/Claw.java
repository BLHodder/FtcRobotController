package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw extends Mechanisms{
    private Servo clawServo;

    public Claw(HardwareMap hardwareMap, String clawName) {
        clawServo = hardwareMap.servo.get(clawName);
    }



}
