package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import static com.qualcomm.robotcore.util.Range.clip;

@TeleOp(name = "OmniBot Gyro Teleop", group = "OmniBot")
//@Disabled
public class OmniBotGyroTeleop extends OpMode {

    private HardwareOmniBot2 robot = new HardwareOmniBot2();

	private double powerDivider = 1; //Divide power by this much

    int direction;
    double lastError = 0;

    double Flpower;
    double Frpower;
    double Blpower;
    double Brpower;

    double kp = 1/600;
    //double ki = 1/600;
    double kd = 1/600;

    double p = 0;
    //double i = 0;
    double d = 0;

    double finalPD = 0;

	@Override
	public void init() {
        robot.init(hardwareMap);

    }

    //@Override
    //public void start() {}

	@Override
	public void loop() {

        /*
		if (gamepad1.dpad_up){ //If you press the up d-pad, change sensitivity
			powerDivider = powerDivider + 0.005;
		}
        if (gamepad1.dpad_down) {
			powerDivider = powerDivider - 0.005;
		}
        */

        // movement code, Gamepad 1 controls movement with left stick and turning with right stick
        if(powerDivider <= 1){
			powerDivider = 1;
		}

        if (gamepad1.right_stick_x > 0.001 || gamepad1.right_stick_x < -0.001) {
            Flpower = -gamepad1.left_stick_y +  gamepad1.left_stick_x +  gamepad1.right_stick_x;
            Frpower = -gamepad1.left_stick_y + -gamepad1.left_stick_x + -gamepad1.right_stick_x;
            Blpower = -gamepad1.left_stick_y + -gamepad1.left_stick_x +  gamepad1.right_stick_x;
            Brpower = -gamepad1.left_stick_y +  gamepad1.left_stick_x + -gamepad1.right_stick_x;
            direction = robot.gyro.getHeading();
        }
        else {
            Flpower = -gamepad1.left_stick_y +  gamepad1.left_stick_x;
            Frpower = -gamepad1.left_stick_y + -gamepad1.left_stick_x;
            Blpower = -gamepad1.left_stick_y + -gamepad1.left_stick_x;
            Brpower = -gamepad1.left_stick_y +  gamepad1.left_stick_x;
        }

        Flpower = clip(Flpower, -0.7, 0.7);
        Frpower = clip(Frpower, -0.7, 0.7);
        Blpower = clip(Blpower, -0.7, 0.7);
        Brpower = clip(Brpower, -0.7, 0.7);

        if (gamepad1.right_stick_x > 0.001 || gamepad1.right_stick_x < -0.001) {
                direction = robot.gyro.getHeading();
        }

        p = robot.gyro.getHeading() - direction;
        //i =+ p;
        d = p - lastError;
        lastError = p;
        double finalPD = p * kp + d * kd;

        Flpower =+  finalPD;
        Frpower =+ -finalPD;
        Blpower =+  finalPD;
        Brpower =+ -finalPD;

        robot.motorFl.setPower(Flpower);
        robot.motorFr.setPower(Frpower);
        robot.motorBl.setPower(Blpower);
        robot.motorBr.setPower(Brpower);

        /*while (robot.gyro.getHeading() < direction) {
            robot.motorFl.setPower(0.1);
            robot.motorFr.setPower(-0.1);
            robot.motorBl.setPower(0.1);
            robot.motorBr.setPower(-0.1);
        }
        while (robot.gyro.getHeading() > direction) {
            robot.motorFl.setPower(-0.1);
            robot.motorFr.setPower(0.1);
            robot.motorBl.setPower(-0.1);
            robot.motorBr.setPower(0.1);
        }*/

        /*/sweeper code, Gamepad 1 controls sweeping in with right bumper
		if(gamepad1.right_bumper){
            robot.sweeper.setPower(1);
		}
		else if(gamepad1.left_bumper){
            robot.sweeper.setPower(-1);
        }
        else {
            robot.sweeper.setPower(0);
        }*/

        //button pusher code, Gamepad 1 controls extending with right bumper and retracting with left bumper
        if(gamepad1.right_bumper) {
            robot.button.setPower(1);
        }
        else if (gamepad1.left_bumper || gamepad2.dpad_down){
            robot.button.setPower(-1);
        }
        else {
            robot.button.setPower(0);
        }

        //launcher code, Gamepad controls the conveyor and launcher wheels with b
        if(gamepad2.b) {
			robot.launcher.setPower(1);
            robot.conveyor.setPower(1);
		}

		//Send telemetry data back to driver station.
		telemetry.addData("left stick X: ", -gamepad1.left_stick_x);
		telemetry.addData("left stick Y: ", -gamepad1.left_stick_y);
        telemetry.addData("right stick Y: ", -gamepad1.right_stick_y);
		telemetry.addData("power divider: ", powerDivider);
        telemetry.addData("gyro heading: ", robot.gyro.getHeading());

        telemetry.addData("PD loop addition: ", finalPD);
	}
}