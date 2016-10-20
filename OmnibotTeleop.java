/* Copyright (c) 2014 Qualcomm Technologies Inc

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Qualcomm Technologies Inc nor the names of its contributors
may be used to endorse or promote products derived from this software without
specific prior written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "OmniBot Test", group = "Omnibot")
//@Disabled
public class OmnibotTeleop extends OpMode {

	int testVar = 2;
    DcMotor motorFl;
    DcMotor motorFr;
    DcMotor motorBl;
    DcMotor motorBr;
	DcMotor spinner;
	Servo Servo1;

	/**
	 * Constructor
	 */
	public OmnibotTeleop() {

	}

	/*
	 * Code to run when the op mode is first enabled goes here
	 *
	 * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#start()
	 */
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
		spinner = hardwareMap.dcMotor.get("motor_5");
		Servo1 = hardwareMap.servo.get("servo_1");
        motorFl.setDirection(DcMotor.Direction.REVERSE);
        motorBr.setDirection(DcMotor.Direction.REVERSE);

	}

	/*
	 * This method will be called repeatedly in a loop
	 *
	 * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#run()
	 */
	@Override
	public void loop() {

		/*
		 * Gamepad 1 controls the motors via the left stick
		 */

        // note that if y equal -1 then joystick is pushed all of the way forward.
		motorFl.setPower(-gamepad1.left_stick_x + -gamepad1.left_stick_y);
		motorFr.setPower(-gamepad1.left_stick_x + gamepad1.left_stick_y);
		motorBl.setPower(-gamepad1.left_stick_x + -gamepad1.left_stick_y);
		motorBr.setPower(-gamepad1.left_stick_x + gamepad1.left_stick_y);

		if(gamepad1.y){
			motorFl.setPower(0.5);
			motorFr.setPower(-0.5);
			motorBl.setPower(0.5);
			motorBr.setPower(-0.5);
		}
		if(gamepad1.x){
			motorFl.setPower(-0.5);
			motorFr.setPower(0.5);
			motorBl.setPower(-0.5);
			motorBr.setPower(0.5);
		}



		if(gamepad1.right_bumper){
			spinner.setPower(0.5);
		}
		else {
			spinner.setPower(0);
		}
		if(gamepad1.b)
		{
		//noodleServo.
		}
		if(gamepad1.a)
		{
		//noodleServo.
		}
		/*
		if (gamepad1.left_stick_x == -0.0 || gamepad1.left_stick_y == -0.0) {
			motorFl.setPower(0.0);
			motorFr.setPower(0.0);
			motorBl.setPower(0.0);
			motorBr.setPower(0.0);
		}
        // Forward
        if (-gamepad1.left_stick_y > 1) {
            motorFl.setPower(0.5);
            motorFr.setPower(0.5);
            motorBl.setPower(0.5);
            motorBr.setPower(0.5);
        }
        // Left
        if (-gamepad1.left_stick_y > -1){
            motorFl.setPower(0.5);
            motorFr.setPower(-0.5);
            motorBl.setPower(0.5);
            motorBr.setPower(-0.5);
        }
        // Right
        if (-gamepad1.left_stick_x > 1){
            motorFl.setPower(-0.5);
            motorFr.setPower(0.5);
            motorBl.setPower(-0.5);
            motorBr.setPower(0.5);
        }
        // Back
        if (-gamepad1.left_stick_x > -1) {

        }

		motorFl.setPower(-0.5);
		motorFr.setPower(-0.5);
		motorBl.setPower(-0.5);
		motorBr.setPower(-0.5);
		*/
		/*
		 * Send telemetry data back to driver station. Note that if we are using
		 * a legacy NXT-compatible motor controller, then the getPower() method
		 * will return a null value. The legacy NXT-compatible motor controllers
		 * are currently write only.
		 */
		/*
		telemetry.addData("left tgt pwr", "left pwr: ");
		telemetry.addData("right tgt pwr", "right pwr: ");
        telemetry.addData("front tgt pwr", "front pwr: ");
        telemetry.addData("back tgt pwr", "back pwr: ");
		*/
		telemetry.addData("stick X: ", -gamepad1.left_stick_x);
		telemetry.addData("stick Y: ", -gamepad1.left_stick_y);

	}

	/*
	 * Code to run when the op mode is first disabled goes here
	 *
	 * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#stop()
	 */
	@Override
	public void stop() {

	}

	/*
	 * This method scales the joystick input so for low joystick values, the
	 * scaled value is less than linear.  This is to make it easier to drive
	 * the robot more precisely at slower speeds.
	 */
	double scaleInput(double dVal)  {
		double[] scaleArray = { 0.0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.24,
				0.30, 0.36, 0.43, 0.50, 0.60, 0.72, 0.85, 1.00, 1.00 };

		// get the corresponding index for the scaleInput array.
		int index = (int) (dVal * 16.0);

		// index should be positive.
		if (index < 0) {
			index = -index;
		}

		// index cannot exceed size of array minus 1.
		if (index > 16) {
			index = 16;
		}

		// get value from the array.
		double dScale = 0;
		if (dVal < 0) {
			dScale = -scaleArray[index];
		} else {
			dScale = scaleArray[index];
		}

		// return scaled value.
		return dScale;
	}
}
