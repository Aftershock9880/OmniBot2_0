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

    final double MOTOR_POWER = 1.0;

    DcMotor motorFl;
    DcMotor motorFr;
    DcMotor motorBl;
    DcMotor motorBr;
    DcMotor launcher;

    public void init() {

        //launcher is a placeholder until the motor exists in the app
        motorFl = hardwareMap.dcMotor.get("motor_1");
        motorFr = hardwareMap.dcMotor.get("motor_2");
        motorBl = hardwareMap.dcMotor.get("motor_3");
        motorBr = hardwareMap.dcMotor.get("motor_4");
        launcher = hardwareMap.dcMotor.get("launcher");

    }
    public void init_loop() {

    }
    public void start() {

    }
    public void loop() {
        if(gamepad1.a) {
            launcher.setPower(MOTOR_POWER);
        }
        else launcher.setPower(0);

    }
}