package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "OmniBot Gyro Teleop", group = "OmniBot")
//@Disabled
int i = 0;
switch(i){
	case general: //1
public class OmniBotGyroTeleop extends OpMode {
	
    private HardwareOmniBot2 robot = new HardwareOmniBot2();

	private double powerDivider = 1; //Divide power by this much

    int direction;

	@Override
	public void init() {
        robot.init(hardwareMap);

    }

    //@Override
    //public void start() {}

	@Override
	public void loop() {


        // movement code, Gamepad 1 controls movement with left stick and turning with right stick


        robot.motorFl.setPower(-gamepad1.left_stick_y +  gamepad1.left_stick_x +  gamepad1.right_stick_x);
        robot.motorFr.setPower(-gamepad1.left_stick_y + -gamepad1.left_stick_x + -gamepad1.right_stick_x);
        robot.motorBl.setPower(-gamepad1.left_stick_y + -gamepad1.left_stick_x +  gamepad1.right_stick_x);
        robot.motorBr.setPower(-gamepad1.left_stick_y +  gamepad1.left_stick_x + -gamepad1.right_stick_x);

        if (gamepad1.right_stick_x > 0.001 || gamepad1.right_stick_x < -0.001) {
                direction = robot.gyro.getHeading();
        }

		case firstWhile:
		if(robot.gyro.getHeading() < direction) {
			break;
		}
            robot.motorFl.setPower(0.1);
            robot.motorFr.setPower(-0.1);
            robot.motorBl.setPower(0.1);
            robot.motorBr.setPower(-0.1);
        
		case secondWhile:
		if(robot.gyro.getHeading() > direction) {
			break;
		}
            robot.motorFl.setPower(-0.1);
            robot.motorFr.setPower(0.1);
            robot.motorBl.setPower(-0.1);
            robot.motorBr.setPower(0.1);
		case continueGeneral:

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
		telemetry.addData("power divider: ", powerDivider);
        telemetry.addData("gyro heading: ", robot.gyro.getHeading());
	}
}
}
