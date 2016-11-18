package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "OmniBot Teleop", group = "Omnibot")
//@Disabled
public class OmnibotTeleop extends OpMode {

    DcMotor motorFl;
    DcMotor motorFr;
    DcMotor motorBl;
    DcMotor motorBr;

	CRServo spinner;

	//DcMotor launcher1;
	//DcMotor launcher2;

	float Flpower;
	float Frpower;
	float Blpower;
	float Brpower;

	double powerDivider; //Divide power by this much

	public OmnibotTeleop() {}

	@Override
	public void init() {
		/*
		 * Use the hardwareMap to get the dc motors by name. Note
		 * that the names of the devices must match the names used when you
		 * configured your robot and created the configuration file.
		 */

		/*
		 *   The Omnibot has four motors
		 *   "motor_1" is on the left side of the bot.
		 *   "motor_2" is on the right side of the bot.
		 *   "motor_3" is on the front side of the bot.
		 *   "motor_4" is on the back side of the bot.
		 */

        motorFl = hardwareMap.dcMotor.get("motor_1");
		motorFr = hardwareMap.dcMotor.get("motor_2");
        motorBl = hardwareMap.dcMotor.get("motor_3");
        motorBr = hardwareMap.dcMotor.get("motor_4");
		motorFl.setDirection(DcMotorSimple.Direction.REVERSE);
		motorBl.setDirection(DcMotorSimple.Direction.REVERSE);

		spinner = hardwareMap.crservo.get("servo_5");

		//launcher1 = hardwareMap.dcMotor.get("motor_5");
		//launcher2 = hardwareMap.dcMotor.get("motor_6");
	}
	@Override
	public void loop() {
        // Gamepad 1 controls the movement via the left stick and turning via the right stick
		// note that if y equal -1 then joystick is pushed all of the way forward.

        /*
		if (gamepad1.dpad_up){ //If you press the up d-pad, change sensitivity
			powerDivider = powerDivider + 0.001;
		}

		if (gamepad1.dpad_down) {
			powerDivider = powerDivider - 0.001;
		}
        */

		if (gamepad1.right_stick_x < -0.01|| gamepad1.right_stick_x > 0.01) {
			Flpower = gamepad1.right_stick_x;
			Frpower = -gamepad1.right_stick_x;
			Blpower = gamepad1.right_stick_x;
			Brpower = -gamepad1.right_stick_x;
		}
		else {
			Flpower = -gamepad1.left_stick_y + gamepad1.left_stick_x;
			Frpower = -gamepad1.left_stick_y + -gamepad1.left_stick_x;
			Blpower = -gamepad1.left_stick_y + -gamepad1.left_stick_x;
			Brpower = -gamepad1.left_stick_y + gamepad1.left_stick_x;
		}
		if(powerDivider <= 0){
			powerDivider = 1;
		}
		motorFl.setPower(Flpower /*/powerDivider*/);
		motorFr.setPower(Frpower /*/powerDivider*/);
		motorBl.setPower(Blpower /*/powerDivider*/);
		motorBr.setPower(Brpower /*/powerDivider*/);

		if(gamepad1.right_bumper){
            spinner.setPower(1);
		}
		else if(gamepad1.right_bumper){
            spinner.setPower(-1);
        }
        else {
            spinner.setPower(0);
        }

        if(gamepad1.b) {
			//launcher1.setPower(1);
			//launcher2.setPower(1);
		}
		if(gamepad1.a) {
			//launcher1.setPower(-1);
			//launcher2.setPower(-1);
		}

		//Send telemetry data back to driver station.
		telemetry.addData("stick X: ", -gamepad1.left_stick_x);
		telemetry.addData("stick Y: ", -gamepad1.left_stick_y);
		telemetry.addData("power divider:" powerDivider	)
        //telemetry.addData("Power Divider: ", powerDivider);
	}
}
