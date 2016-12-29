package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "OmniBot Autonomous", group = "Omnibot")
//@Disabled
public class OmniBotBasicAutonomous extends OpMode {

    HardwareOmniBot2 robot = new HardwareOmniBot2();

    private ElapsedTime runtime = new ElapsedTime();

	@Override
	public void init() {
        robot.init(hardwareMap);

	}

    @Override
    public void start() {
        runtime.reset();

    }

    @Override
    public void loop() {
        // Gamepad 1 controls the movement via the left stick and turning via the right stick
        // note that if y equal -1 then joystick is pushed all of the way forward.

        if (runtime.time() < 3.5){
        	robot.motorFl.setPower(1);
        	robot.motorFr.setPower(1);
        	robot.motorBl.setPower(1);
        	robot.motorBr.setPower(1);
        }
        else {
            robot.motorFl.setPower(0);
            robot.motorFr.setPower(0);
            robot.motorBl.setPower(0);
            robot.motorBr.setPower(0);
        }
    }
}
