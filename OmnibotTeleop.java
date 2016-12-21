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

    DcMotor motorFl;
    DcMotor motorFr;
    DcMotor motorBl;
    DcMotor motorBr;

    DcMotor conveyor;
    DcMotor launcher;

    CRServo sweeper;
    CRServo button;

    GyroSensor gyro;
    ColorSensor color;

    float Flpower;
	float Frpower;
	float Blpower;
	float Brpower;


	double powerDivider; //Divide power by this much

	@Override
	public void init() {
		//Use hardwareMap to get objects by name.

        robot.init(hardwareMap);

        motorFl = hardwareMap.dcMotor.get("motor_1"); motorFl.setDirection(DcMotorSimple.Direction.REVERSE);
		motorFr = hardwareMap.dcMotor.get("motor_2");
        motorBl = hardwareMap.dcMotor.get("motor_3"); motorBl.setDirection(DcMotorSimple.Direction.REVERSE);
        motorBr = hardwareMap.dcMotor.get("motor_4");

        //conveyor = hardwareMap.dcMotor.get("motor_5"); conveyor.setDirection(DcMotorSimple.Direction.REVERSE);
		//launcher = hardwareMap.dcMotor.get("motor_6");

        //sweeper = hardwareMap.crservo.get("servo_1");
        button = hardwareMap.crservo.get("servo_2");

        gyro = hardwareMap.gyroSensor.get("gyro_1");
        color = hardwareMap.colorSensor.get("color_1");

    }

    //@Override
    //public void start() {}

	@Override
	public void loop() {
        // movement code, Gamepad 1 controls movement with left stick and turning with right stick
		Flpower = -gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x;
		Frpower = -gamepad1.left_stick_y + -gamepad1.left_stick_x + -gamepad1.right_stick_x;
		Blpower = -gamepad1.left_stick_y + -gamepad1.left_stick_x + gamepad1.right_stick_x;
		Brpower = -gamepad1.left_stick_y + gamepad1.left_stick_x + -gamepad1.right_stick_x;

        /*
		if (gamepad1.dpad_up){ //If you press the up d-pad, change sensitivity
			powerDivider = powerDivider + 0.005;
		}
        if (gamepad1.dpad_down) {
			powerDivider = powerDivider - 0.005;
		}
        */

        if(powerDivider <= 0){
			powerDivider = 0.001;
		}
		motorFl.setPower(Flpower /*/powerDivider*/);
		motorFr.setPower(Frpower /*/powerDivider*/);
		motorBl.setPower(Blpower /*/powerDivider*/);
		motorBr.setPower(Brpower /*/powerDivider*/);

        //sweeper code, Gamepad 1 controls sweeping in with right bumper and
		if(gamepad1.right_bumper){
            sweeper.setPower(1);
		}
		else if(gamepad1.left_bumper){
            sweeper.setPower(-1);
        }
        else {
            sweeper.setPower(0);
        }

        //button pusher code, Gamepad 1 controls extending with y and retracting with a
        if(gamepad1.y) {
            button.setPower(1);
        }
        else if (gamepad1.a || gamepad2.dpad_down){
            button.setPower(-1);
        }
        else {
            button.setPower(0);
        }

        //launcher code, Gamepad controls the conveyor and launcher wheels with b
        if(gamepad2.b) {
			launcher.setPower(1);
            conveyor.setPower(1);
		}

		//Send telemetry data back to driver station.
		telemetry.addData("stick X: ", -gamepad1.left_stick_x);
		telemetry.addData("stick Y: ", -gamepad1.left_stick_y);
		telemetry.addData("power divider:", powerDivider	);
        //telemetry.addData("Power Divider: ", powerDivider);
	}
}
