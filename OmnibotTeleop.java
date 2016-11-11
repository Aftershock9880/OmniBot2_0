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
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "OmniBot Teleop", group = "Omnibot")
//@Disabled
public class OmnibotTeleop extends OpMode {

    DcMotor motorFl;
    DcMotor motorFr;
    DcMotor motorBl;
    DcMotor motorBr;

	//DcMotor spinner;

	//DcMotor launcher1;
	//DcMotor launcher2;

	float Flpower;
	float Frpower;
	float Blpower;
	float Brpower;

	int powerDivider; //Divide power by this much

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

		//spinner = hardwareMap.dcMotor.get("motor_5");

		//launcher1 = hardwareMap.dcMotor.get("motor_5");
		//launcher2 = hardwareMap.dcMotor.get("motor_5");
	}
	@Override
	public void loop() {
        // Gamepad 1 controls the movement via the left stick and turning via the right stick
		// note that if y equal -1 then joystick is pushed all of the way forward.

		if (gamepad1.dpad_up){ //If you press the up d-pad, change sensitivity
			powerDivider = powerDivider + 1;
		}
		if (gamepad1.dpad_down) {
			powerDivider = powerDivider - 1;
		}
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
		motorFl.setPower(Flpower/powerDivider);
		motorFr.setPower(Frpower/powerDivider);
		motorBl.setPower(Blpower/powerDivider);
		motorBr.setPower(Brpower/powerDivider);

		if(gamepad1.right_bumper){
			//spinner.setPower(0.5);
		}
		else {
			//spinner.setPower(0.0);
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

	}
}
