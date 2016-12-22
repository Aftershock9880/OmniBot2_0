package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Hardware;

/**
 * This is NOT an opmode.
 *
 * This class can be used to define all the specific hardware for the OmniBot2.0.
 *
 * This hardware class uses the following device names that have been configured on the robot phone:
 *
 * Front Left drive motor:   "motor_1"
 * Front Right drive motor:  "motor_2"
 * Back Left drive motor:    "motor_3"
 * Back Right drive motor:   "motor_4"
 *
 * Conveyor motor            "motor_5"
 * Launcher motor            "motor_6"
 *
 * Sweeper servo:            "servo_1"
 * Button Pusher servo:      "servo_2"
 *
 * Gyro sensor               "gyro_1"
 * Color sensor              "color_1"
 * Light sensor              "light_1"
 */
public class HardwareOmniBot2
{
    //Public OpMode members
    public DcMotor motorFl;
    public DcMotor motorFr;
    public DcMotor motorBl;
    public DcMotor motorBr;

    public DcMotor conveyor;
    public DcMotor launcher;

    public CRServo sweeper;
    public CRServo button;

    public GyroSensor gyro;
    public ColorSensor color;
    public LightSensor light;

    //Local OpMode members
    public HardwareMap hwMap;

    //Constructor
    public HardwareOmniBot2() {}

    /* Initialize standard Hardware interfaces */
    public void init() {

        motorFl =  hwMap.dcMotor.get("motor_1"); motorFl.setDirection(DcMotorSimple.Direction.REVERSE);
        motorFr =  hwMap.dcMotor.get("motor_2");
        motorBl =  hwMap.dcMotor.get("motor_3"); motorBl.setDirection(DcMotorSimple.Direction.REVERSE);
        motorBr =  hwMap.dcMotor.get("motor_4");

        conveyor = hwMap.dcMotor.get("motor_5"); conveyor.setDirection(DcMotorSimple.Direction.REVERSE);
        launcher = hwMap.dcMotor.get("motor_6");

        sweeper =  hwMap.crservo.get("servo_1");
        button =   hwMap.crservo.get("servo_2");

        gyro =     hwMap.gyroSensor.get("gyro_1");
        color =    hwMap.colorSensor.get("color_1");
        light =    hwMap.lightSensor.get("light_1");
    }
}
