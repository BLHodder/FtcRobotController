package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Hardware;

public class Robot {
    private Ducky duck;
    private XDrive xDrive;
    private Claw claw;

    public Robot(HardwareMap hardwareMap, String duckName, String frontLeft, String backLeft, String frontRight, String backRight, String clawName) {

        this.duck = new Ducky(hardwareMap,  duckName);
        this.xDrive = new XDrive(hardwareMap, frontLeft, backLeft, frontRight, backRight);
        this.claw = new Claw(hardwareMap, clawName);


    }

    public void SetDuckPower(double power) {this.duck.SetPower(power);}

    public void SetRunMode() {this.xDrive.SetRunMode();}

    public void SetStrafe(double power, double angle, double rotate) {this.xDrive.SetStrafe(power, angle, rotate);}












}