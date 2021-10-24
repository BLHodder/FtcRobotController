package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Ducky {
    private CRServo duckServo;

    public Ducky(HardwareMap hardwareMap, String duckName) {
        duckServo = hardwareMap.crservo.get(duckName);
    }

    public void SetPower(double power) {
        duckServo.setPower(power);
    }
}
