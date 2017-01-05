package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

import static com.qualcomm.robotcore.util.Range.clip;

@TeleOp(name = "OmniBot Teleop", group = "OmniBot")
//@Disabled
public class OmniBotTeleop extends OpMode {

    private HardwareOmniBot2 robot = new HardwareOmniBot2();

	private double powerDivider = 1; //Divide power by this much

    double Flpower;
    double Frpower;
    double Blpower;
    double Brpower;

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

        Flpower = -gamepad1.left_stick_y +  gamepad1.left_stick_x +  gamepad1.right_stick_x /*/powerDivider*/;
        Frpower = -gamepad1.left_stick_y + -gamepad1.left_stick_x + -gamepad1.right_stick_x /*/powerDivider*/;
        Blpower = -gamepad1.left_stick_y + -gamepad1.left_stick_x +  gamepad1.right_stick_x /*/powerDivider*/;
        Brpower = -gamepad1.left_stick_y +  gamepad1.left_stick_x + -gamepad1.right_stick_x /*/powerDivider*/;

        Flpower = clip(Flpower, -0.7, 0.7);
        Frpower = clip(Frpower, -0.7, 0.7);
        Blpower = clip(Blpower, -0.7, 0.7);
        Brpower = clip(Brpower, -0.7, 0.7);

		robot.motorFl.setPower(Flpower /*-gamepad1.left_stick_y +  gamepad1.left_stick_x +  gamepad1.right_stick_x /powerDivider*/);
		robot.motorFr.setPower(Frpower /*-gamepad1.left_stick_y + -gamepad1.left_stick_x + -gamepad1.right_stick_x /powerDivider*/);
		robot.motorBl.setPower(Blpower /*-gamepad1.left_stick_y + -gamepad1.left_stick_x +  gamepad1.right_stick_x /powerDivider*/);
		robot.motorBr.setPower(Brpower /*-gamepad1.left_stick_y +  gamepad1.left_stick_x + -gamepad1.right_stick_x /powerDivider*/);

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
			//robot.launcher.setPower(1);
            //robot.conveyor.setPower(1);
		}

		//Send telemetry data back to driver station.
		telemetry.addData("stick X: ", -gamepad1.left_stick_x);
		telemetry.addData("stick Y: ", -gamepad1.left_stick_y);
		telemetry.addData("power divider:", powerDivider);
	}
}