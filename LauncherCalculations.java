package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by student on 10/11/16.
 */
@Autonomous(name = "OmniBot Test", group = "Omnibot")
//@Disabled

public class LauncherCalculations extends OpMode {

    final double MOTOR_POWER = 0.5;

    DcMotor motorFl;
    DcMotor motorFr;
    DcMotor motorBl;
    DcMotor motorBr;

    public void init() {

        motorFl = hardwareMap.dcMotor.get("motor_1");
        motorFr = hardwareMap.dcMotor.get("motor_2");
        motorBl = hardwareMap.dcMotor.get("motor_3");
        motorBr = hardwareMap.dcMotor.get("motor_4");

    }
    public void init_loop() {

    }
    public void start() {

    }
    public void loop() {
        /*if(!gamepad1.a)
            motorFl.setPower(0.5);
        else
            motorFl.setPower(0);
        if(gamepad1.y && gamepad1.b)
            motorFr.setPower(0.5);
        else
            motorFr.setPower(0);
        int intKiloGrams = 10;
        double i = Math.pow(z, 3) * 5;*/
    }
}