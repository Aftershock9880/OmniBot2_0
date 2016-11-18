package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "OmniBot Autonomous", group = "Omnibot")
//@Disabled
public class OmnibotBasicAutonomous extends OpMode {

    DcMotor motorFl;
    DcMotor motorFr;
    DcMotor motorBl;
    DcMotor motorBr;

    private ElapsedTime runtime = new ElapsedTime();

	public OmnibotBasicAutonomous() {}

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
    public void start() {
        runtime.reset();
    }

    @Override
    public void loop() {
        // Gamepad 1 controls the movement via the left stick and turning via the right stick
        // note that if y equal -1 then joystick is pushed all of the way forward.

        if (runtime.time() < 4){
        	motorFl.setPower(1);
        	motorFr.setPower(1);
        	motorBl.setPower(1);
        	motorBr.setPower(1);
        }
        else {
            motorFl.setPower(0);
            motorFr.setPower(0);
            motorBl.setPower(0);
            motorBr.setPower(0);
        }
    }
}
