package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "OmniBot Autonomous", group = "Omnibot")
//@Disabled
public class BeaconTest extends OpMode {

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

    private ElapsedTime runtime = new ElapsedTime();

	public BeaconTest() {}

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
	}

    public void pressButton() {
        button.setPower(1);
    }

    @Override
    public void start() {
        runtime.reset();

    }

    @Override
    public void loop() {

        if (color.red() > color.blue()) {
            pressButton();
        }
    }
}
