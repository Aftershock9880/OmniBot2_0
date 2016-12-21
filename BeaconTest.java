package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

import static com.qualcomm.robotcore.hardware.DcMotor.RunMode.RUN_TO_POSITION;

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

    HardwareOmniBot2 robot = new HardwareOmniBot2();

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
    LightSensor light;
    GyroSensor gyro;

    private ElapsedTime pressButtonT = new ElapsedTime();
    private ElapsedTime moveT = new ElapsedTime();

    @Override
    public final void runOpMode() {
        /* Use the hardwareMap to get the dc motors by name.
         * Note that the names of the devices must match the names in the config file.
         */

        robot.init(hardwareMap);

        motorFl = hardwareMap.dcMotor.get("motor_1"); motorFl.setDirection(DcMotorSimple.Direction.REVERSE);
        motorFr = hardwareMap.dcMotor.get("motor_2");
        motorBl = hardwareMap.dcMotor.get("motor_3"); motorBl.setDirection(DcMotorSimple.Direction.REVERSE);
        motorBr = hardwareMap.dcMotor.get("motor_4");

        //launcher1 = hardwareMap.dcMotor.get("launch_1");
        //launcher2 = hardwareMap.dcMotor.get("launch_2");
        //launcherControl = hardwareMap.dcMotor.get("launch_3");

        //conveyor = hardwareMap.dcMotor.get("motor_5");

        //sweeper = hardwareMap.crservo.get("servo_1");
        button = hardwareMap.crservo.get("servo_2");

        color = hardwareMap.colorSensor.get("color_1");
        light = hardwareMap.lightSensor.get("light_1");
        gyro = hardwareMap.gyroSensor.get("gyro_1");

        pressButton(1);

        //moveFor(1,1,1,1, 2);
        //moveFor(-1,-1,-1,-1, 2);

        moveTo(1,1,1,1);
        moveTo(0,0,0,0);

        waitForStart();
        telemetry.addData("Status: ", "starting");

        moveTo(0.5,0.5,0.5,0.5);
        moveUntil(1,1,1,1, light.getLightDetected() > 30);

        //check if the beacon is red
        if (color.red() > color.blue()) {
            telemetry.addData("Button Color: ", "Red");
            pressButton(0.5);
        }
        //move right for 0.2 seconds
        else {
            telemetry.addData("Button Color: ", "Blue");
            moveFor(1,-1,-1,1, 0.2);
        }
        telemetry.update();

        //check if the beacon is red
        if (color.red() > color.blue()) {
            telemetry.addData("Button Color: ", "Red");
            pressButton(0.5);
        }
    }

    public void pressButton(double extendTime) {
        telemetry.addData("Status: ", "Pressing Button");
        pressButtonT.reset();
        while (pressButtonT.time() <= extendTime && opModeIsActive()) {
            button.setPower(1);
        }
        while (pressButtonT.time() <= extendTime*2 && opModeIsActive()) {
            button.setPower(-1);
        }
        button.setPower(0);
        telemetry.addData("Status: ", "Doing Nothing");
        telemetry.update();
    }

    public void moveFor(double Fl, double Fr, double Bl, double Br, double moveTime) {
        telemetry.addData("Status: ", "Moving");
        moveT.reset();
        while (moveT.time() <= moveTime && opModeIsActive()) {
            motorFl.setPower(Fl);
            motorFr.setPower(Fr);
            motorBl.setPower(Bl);
            motorBr.setPower(Br);
        }
        motorFl.setPower(0);
        motorFr.setPower(0);
        motorBl.setPower(0);
        motorBr.setPower(0);
        telemetry.addData("Status: ", "Doing Nothing");
        telemetry.update();
    }

    public void moveUntil(double Fl, double Fr, double Bl, double Br, boolean thingIsTrue) {
        telemetry.addData("Status: ", "Moving");
        while (thingIsTrue && opModeIsActive()) {
            motorFl.setPower(Fl);
            motorFr.setPower(Fr);
            motorBl.setPower(Bl);
            motorBr.setPower(Br);
        }
        motorFl.setPower(0);
        motorFr.setPower(0);
        motorBl.setPower(0);
        motorBr.setPower(0);
        telemetry.addData("Status: ", "Doing Nothing");
        telemetry.update();
    }

    public void moveTo(double FlEnc, double FrEnc, double BlEnc, double BrEnc) {
        telemetry.addData("Status: ", "Moving");
        motorFl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorFr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBr.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        motorFl.setTargetPosition(motorFl.getCurrentPosition() + (int)Math.round(FlEnc * 1680));
        motorFr.setTargetPosition(motorFr.getCurrentPosition() + (int)Math.round(FrEnc * 1680));
        motorBl.setTargetPosition(motorBl.getCurrentPosition() + (int)Math.round(BlEnc * 1680));
        motorBr.setTargetPosition(motorBr.getCurrentPosition() + (int)Math.round(BrEnc * 1680));

        while (
            motorFl.isBusy()&& motorFr.isBusy()&& motorBl.isBusy()&& motorBr.isBusy()&& opModeIsActive()) {
            motorFl.setPower(1);
            motorFr.setPower(1);
            motorBl.setPower(1);
            motorBr.setPower(1);
        }

        motorFl.setPower(0);
        motorFr.setPower(0);
        motorBl.setPower(0);
        motorBr.setPower(0);

        motorFl.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorFr.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorBl.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorBr.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        telemetry.addData("Status: ", "Doing Nothing");
        telemetry.update();
    }
}