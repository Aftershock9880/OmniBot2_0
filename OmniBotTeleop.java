package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "OmniBot Teleop", group = "Omnibot")
//@Disabled
public class OmniBotTeleop extends OpMode {

    HardwareOmniBot2 robot = new HardwareOmniBot2();

    float Flpower;
	float Frpower;
	float Blpower;
	float Brpower;

	double powerDivider; //Divide power by this much

	@Override
	public void init() {
        robot.init();

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
        if(powerDivider <= 0){
			powerDivider = 0.001;
		}
		robot.motorFl.setPower(-gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x /*/powerDivider*/);
		robot.motorFr.setPower(-gamepad1.left_stick_y + -gamepad1.left_stick_x + -gamepad1.right_stick_x /*/powerDivider*/);
		robot.motorBl.setPower(-gamepad1.left_stick_y + -gamepad1.left_stick_x + gamepad1.right_stick_x /*/powerDivider*/);
		robot.motorBr.setPower(-gamepad1.left_stick_y + gamepad1.left_stick_x + -gamepad1.right_stick_x /*/powerDivider*/);

        //sweeper code, Gamepad 1 controls sweeping in with right bumper and
		if(gamepad1.right_bumper){
            robot.sweeper.setPower(1);
		}
		else if(gamepad1.left_bumper){
            robot.sweeper.setPower(-1);
        }
        else {
            robot.sweeper.setPower(0);
        }

        //button pusher code, Gamepad 1 controls extending with y and retracting with a
        if(gamepad1.y) {
            robot.button.setPower(1);
        }
        else if (gamepad1.a || gamepad2.dpad_down){
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
		telemetry.addData("stick X: ", -gamepad1.left_stick_x);
		telemetry.addData("stick Y: ", -gamepad1.left_stick_y);
		telemetry.addData("power divider:", powerDivider);
        //telemetry.addData("Power Divider: ", powerDivider);
	}
}
