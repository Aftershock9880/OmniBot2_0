package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name = "OmniBot Beacon Test", group = "Omnibot")
//@Disabled
public class BeaconTest extends LinearOpMode {

    /*
     *   The Omnibot v2 has four motors
     *   "motor_1" is on the front left side of the bot.
     *   "motor_2" is on the front right side of the bot.
     *   "motor_3" is on the back left side of the bot.
     *   "motor_4" is on the back right side of the bot.
     */
    DcMotor motorFl;
    DcMotor motorFr;
    DcMotor motorBl;
    DcMotor motorBr;

    DcMotor launcher1;
    DcMotor launcher2;
    DcMotor launcherControl;

    DcMotor conveyor;

    CRServo sweeper;
    CRServo button;

    ColorSensor color;
    GyroSensor gyro;

    private ElapsedTime pressButtonT = new ElapsedTime();
    private ElapsedTime moveT = new ElapsedTime();

    @Override
    public final void runOpMode() {
        /* Use the hardwareMap to get the dc motors by name.
         * Note that the names of the devices must match the names in the config file.
         */

        motorFl = hardwareMap.dcMotor.get("motor_1"); motorFl.setDirection(DcMotorSimple.Direction.REVERSE);
        motorFr = hardwareMap.dcMotor.get("motor_2");
        motorBl = hardwareMap.dcMotor.get("motor_3"); motorBl.setDirection(DcMotorSimple.Direction.REVERSE);
        motorBr = hardwareMap.dcMotor.get("motor_4");

        //launcher1 = hardwareMap.dcMotor.get("launch_1");
        //launcher2 = hardwareMap.dcMotor.get("launch_2");
        //launcherControl = hardwareMap.dcMotor.get("launch_3");

        //conveyor = hardwareMap.dcMotor.get("motor_5");

        sweeper = hardwareMap.crservo.get("servo_1");
        button = hardwareMap.crservo.get("servo_2");

        color = hardwareMap.colorSensor.get("color_1");
        gyro = hardwareMap.gyroSensor.get("gyro_1");

        waitForStart();

        //check if the beacon is red
        if (color.red() > color.blue()) {
            pressButton(0.5);
        }

        //move right for 0.2 seconds
        else {
            move(1,-1,-1,1, 0.2);
        }

        //check if the beacon is red
        if (color.red() > color.blue()) {
            pressButton(0.5);
        }
    }

    public void pressButton(double pressTime) {
        pressButtonT.reset();
        while (pressButtonT.time() < pressTime) {
            button.setPower(1);
        }
        while (pressButtonT.time() > pressTime && pressButtonT.time() < pressTime*2) {
            button.setPower(-1);
        }
        while (pressButtonT.time() > pressTime*2) {
            button.setPower(0);
        }
    }

    public void move(double Fl, double Fr, double Bl, double Br, double moveTime) {
        moveT.reset();
        while (moveT.time() < moveTime) {
            motorFl.setPower(Fl);
            motorFr.setPower(Fr);
            motorBl.setPower(Bl);
            motorBr.setPower(Br);
        }
        while (moveT.time() > moveTime) {
            motorFl.setPower(0);
            motorFr.setPower(0);
            motorBl.setPower(0);
            motorBr.setPower(0);
        }
    }
}