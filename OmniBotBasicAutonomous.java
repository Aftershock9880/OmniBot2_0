package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "OmniBot Autonomous", group = "OmniBot")
//@Disabled
public class OmniBotBasicAutonomous extends OpMode {

    private HardwareOmniBot2 robot = new HardwareOmniBot2();

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
        if (runtime.time() < 3.5){
        	robot.motorFl.setPower(0.7);
        	robot.motorFr.setPower(0.7);
        	robot.motorBl.setPower(0.7);
        	robot.motorBr.setPower(0.7);
        }
        else {
            robot.motorFl.setPower(0);
            robot.motorFr.setPower(0);
            robot.motorBl.setPower(0);
            robot.motorBr.setPower(0);
        }
    }
}