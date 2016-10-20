/* Copyright (c) 2014, 2015 Qualcomm Technologies Inc

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Qualcomm Technologies Inc nor the names of its contributors
may be used to endorse or promote products derived from this software without
specific prior written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Demonstrates empty OpMode
 */
@TeleOp(name = "Motor Teleop Test", group = "ohNoNoNoNoNoNONOAGHHHugh")
//@Disabled
public class EthanTestMotors extends OpMode {

      DcMotor frontLeft;
      DcMotor frontRight;
      DcMotor backLeft;
      DcMotor backRight;
      DcMotor zipTies;



  @Override
  public void init() {

    frontLeft  = hardwareMap.dcMotor.get("motor_1");
    frontRight = hardwareMap.dcMotor.get("motor_2");
    backLeft  = hardwareMap.dcMotor.get("motor_3");
    backRight = hardwareMap.dcMotor.get("motor_4");
    zipTies    = hardwareMap.dcMotor.get("motor_5");

    telemetry.addData("Status", "Initialized");
  }



  /*
     * Code to run when the op mode is first enabled goes here
     * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#start()
     */
  @Override
  public void init_loop() {

  }

  /*
   * This method will be called ONCE when start is pressed
   * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#loop()
   */
  @Override
  public void start() {

  }

  /*
   * This method will be called repeatedly in a loop
   * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#loop()
   */
  @Override
  public void loop() {
    if (-gamepad1.left_stick_y > 0.01) {
      yesAllMotors(0.05);
    }
    else {
      yesAllMotors(0);
    }
    if (-gamepad1.left_stick_y > -0.01) {
      yesHalfOfAllMotors(0.05);
    }
    else {
      yesAllMotors(0);
    }
    if (-gamepad1.left_stick_x > 0.01) {
      yesHalfOfAllMotors(-0.05);
    }
    else{
      yesAllMotors(0);
    }
    if (gamepad1.left_stick_x > -0.01) {
      yesAllMotors(-0.5);
    }
    else{
      yesAllMotors(0);
    }
    if (gamepad1.right_bumper) {
      zipTies.setPower(0.05);
    }
    else{
      zipTies.setPower(0);
    }

  }


  public void yesAllMotors(double howMuchPowerDoTheMotorsNeed) {

    backLeft.setPower(howMuchPowerDoTheMotorsNeed);
    backRight.setPower(howMuchPowerDoTheMotorsNeed);
    frontLeft.setPower(howMuchPowerDoTheMotorsNeed);
    frontRight.setPower(howMuchPowerDoTheMotorsNeed);
  }
  public void yesHalfOfAllMotors(double theMotorsNeedThisMuchPower){
    backRight.setPower(theMotorsNeedThisMuchPower);
    backLeft.setPower(-theMotorsNeedThisMuchPower);
    frontRight.setPower(theMotorsNeedThisMuchPower);
    frontLeft.setPower(-theMotorsNeedThisMuchPower);
  }
}