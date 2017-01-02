package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "OmniBot Beacon Test", group = "OmniBot")
//@Disabled
public class BeaconTest extends LinearOpMode {

    private HardwareOmniBot2 robot = new HardwareOmniBot2();

    private ElapsedTime pressButtonT = new ElapsedTime();
    private ElapsedTime moveT = new ElapsedTime();

    @Override
    public final void runOpMode() {

        robot.init(hardwareMap);

        //moveFor(1,1,1,1, 2);
        //moveFor(-1,-1,-1,-1, 2);

        moveTo(2,2,2,2);

        moveFor(-1,-1,-1,-1, 1);

        moveUntil(1,1,1,1, moveT.time() > 2);

        pressButton(3.1);

        waitForStart();
        telemetry.addData("Status: ", "starting");

        moveTo(-2,-2,-2,-2);

        moveFor(1,1,1,1, 1);

        moveUntil(-1,-1,-1,-1, moveT.time() > 2);

        /*moveUntil(1,1,1,1, robot.light.getLightDetected() > 30);

        //check if the beacon is red
        if (robot.color.red() > robot.color.blue()) {
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
        if (robot.color.red() > robot.color.blue()) {
            telemetry.addData("Button Color: ", "Red");
            pressButton(0.5);
        }*/
    }

    void pressButton(double extendTime) {
        telemetry.addData("Status: ", "Pressing Button");
        pressButtonT.reset();
        while (pressButtonT.time() <= extendTime && opModeIsActive()) {
            robot.button.setPower(1);
        }
        while (pressButtonT.time() <= extendTime*2 && opModeIsActive()) {
            robot.button.setPower(-1);
        }
        robot.button.setPower(0);
        telemetry.addData("Status: ", "Doing Nothing");
        telemetry.update();
    }

    void moveFor(double Fl, double Fr, double Bl, double Br, double moveTime) {
        telemetry.addData("Status: ", "Moving");
        moveT.reset();
        while (moveT.time() <= moveTime && opModeIsActive()) {
            robot.motorFl.setPower(Fl);
            robot.motorFr.setPower(Fr);
            robot.motorBl.setPower(Bl);
            robot.motorBr.setPower(Br);
        }
        robot.motorFl.setPower(0);
        robot.motorFr.setPower(0);
        robot.motorBl.setPower(0);
        robot.motorBr.setPower(0);
        telemetry.addData("Status: ", "Doing Nothing");
        telemetry.update();
    }

    void moveUntil(double Fl, double Fr, double Bl, double Br, boolean thingIsTrue) {
        telemetry.addData("Status: ", "Moving");
        while (thingIsTrue && opModeIsActive()) {
            robot.motorFl.setPower(Fl);
            robot.motorFr.setPower(Fr);
            robot.motorBl.setPower(Bl);
            robot.motorBr.setPower(Br);
        }
        robot.motorFl.setPower(0);
        robot.motorFr.setPower(0);
        robot.motorBl.setPower(0);
        robot.motorBr.setPower(0);
        telemetry.addData("Status: ", "Doing Nothing");
        telemetry.update();
    }

    void moveTo(double FlEnc, double FrEnc, double BlEnc, double BrEnc) {
        telemetry.addData("Status: ", "Moving");
        robot.motorFl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorFr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorBl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorBr.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.motorFl.setTargetPosition(robot.motorFl.getCurrentPosition() + (int)Math.round(FlEnc * 1680));
        robot.motorFr.setTargetPosition(robot.motorFr.getCurrentPosition() + (int)Math.round(FrEnc * 1680));
        robot.motorBl.setTargetPosition(robot.motorBl.getCurrentPosition() + (int)Math.round(BlEnc * 1680));
        robot.motorBr.setTargetPosition(robot.motorBr.getCurrentPosition() + (int)Math.round(BrEnc * 1680));

        while (robot.motorFl.isBusy()&& robot.motorFr.isBusy()&& robot.motorBl.isBusy()&& robot.motorBr.isBusy()&& opModeIsActive()) {
            robot.motorFl.setPower(0.5);
            robot.motorFr.setPower(0.5);
            robot.motorBl.setPower(0.5);
            robot.motorBr.setPower(0.5);
        }

        robot.motorFl.setPower(0);
        robot.motorFr.setPower(0);
        robot.motorBl.setPower(0);
        robot.motorBr.setPower(0);

        robot.motorFl.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.motorFr.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.motorBl.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.motorBr.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        telemetry.addData("Status: ", "Doing Nothing");
        telemetry.update();
    }
}