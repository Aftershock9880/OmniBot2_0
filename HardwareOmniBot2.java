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
 * This class is used to define all the hardware for the OmniBot2.0.
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

public class HardwareOmniBot2 {
    //Public OpMode members
    public DcMotor motorFl    = null;
    public DcMotor motorFr    = null;
    public DcMotor motorBl    = null;
    public DcMotor motorBr    = null;

    public DcMotor conveyor   = null;

    public DcMotor launcher1  = null;
    public DcMotor launcher2  = null;

    public CRServo sweeper    = null;
    public CRServo button1    = null;
    public CRServo button2    = null;

    public GyroSensor gyro    = null;
    public LightSensor light  = null;

    public ColorSensor color1 = null;
    public ColorSensor color2 = null;

    //Local OpMode members
    HardwareMap hwMap         = null;

    //Constructor
    HardwareOmniBot2() {}

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        motorFl =   hwMap.dcMotor.get("motor_1");  motorFl.setDirection(DcMotorSimple.Direction.REVERSE);
        motorFr =   hwMap.dcMotor.get("motor_2");
        motorBl =   hwMap.dcMotor.get("motor_3");  motorBl.setDirection(DcMotorSimple.Direction.REVERSE);
        motorBr =   hwMap.dcMotor.get("motor_4");

        conveyor =  hwMap.dcMotor.get("motor_5");  conveyor.setDirection(DcMotorSimple.Direction.REVERSE);

        launcher1 = hwMap.dcMotor.get("launch_1");
        launcher2 = hwMap.dcMotor.get("launch_2"); launcher2.setDirection(DcMotorSimple.Direction.REVERSE);

        sweeper =   hwMap.crservo.get("servo_1");
        button1 =   hwMap.crservo.get("servo_2");
        button2 =   hwMap.crservo.get("servo_3");

        gyro =      hwMap.gyroSensor.get("gyro_1");
        light =     hwMap.lightSensor.get("light_1");

        color1 =    hwMap.colorSensor.get("color_1");
        color2 =    hwMap.colorSensor.get("color_2");
    }
}