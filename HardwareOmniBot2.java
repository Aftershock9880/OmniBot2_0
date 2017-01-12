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
 * Front Left drive motor:    "motor_1"
 * Front Right drive motor:   "motor_2"
 * Back Left drive motor:     "motor_3"
 * Back Right drive motor:    "motor_4"
 *
 * Conveyor motor             "motor_5"
 * Sweeper servo:             "motor_6"
 *
 * Left Launcher motor        "launch_1"
 * Right Launcher motor       "launch_2
 *
 * Left Button Pusher servo:  "servo_1"
 * Right Button Pusher servo: "servo_1"
 *
 * Gyro sensor                "gyro_1"
 * Light sensor               "light_1"
 *
 * Left Color sensor          "color_1"
 * Right Color sensor         "color_2"
 *
 */

public class HardwareOmniBot2 {
    //Public OpMode members
    public DcMotor motorFl    = null;
    public DcMotor motorFr    = null;
    public DcMotor motorBl    = null;
    public DcMotor motorBr    = null;

    public DcMotor conveyor   = null;
    public DcMotor sweeper    = null;

    public DcMotor launcher1  = null;
    public DcMotor launcher2  = null;

    public CRServo button1    = null;
    public CRServo button2    = null;

    public GyroSensor gyro    = null;
    public LightSensor light  = null;
    public ColorSensor lColor = null;

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

        sweeper =   hwMap.dcMotor.get("motor_5");
        conveyor =  hwMap.dcMotor.get("motor_6");  conveyor.setDirection(DcMotorSimple.Direction.REVERSE);

        launcher1 = hwMap.dcMotor.get("launch_1");
        launcher2 = hwMap.dcMotor.get("launch_2");

        button1 =   hwMap.crservo.get("servo_1");
        button2 =   hwMap.crservo.get("servo_2");

        gyro =      hwMap.gyroSensor.get("gyro_1");
        light =     hwMap.lightSensor.get("light_1");
        lColor =    hwMap.colorSensor.get("color_1");
    }
}