package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "EthanAutonomous2", group = "Omnibot")
/**
 * Created by student on 10/18/16.
 */

public class EthanAutonomous2 extends OpMode {
    DcMotor motorFl;
    DcMotor motorFr;
    DcMotor motorBl;
    DcMotor motorBr;



public EthanAutonomous2(){

}

  @Override
        public void init() {
          motorFl = hardwareMap.dcMotor.get("motor_1");
          motorFr = hardwareMap.dcMotor.get("motor_2");
          motorBl = hardwareMap.dcMotor.get("motor_3");
          motorBr = hardwareMap.dcMotor.get("motor_4");
          motorFl.setDirection(DcMotorSimple.Direction.REVERSE);
          motorBl.setDirection(DcMotorSimple.Direction.REVERSE);

          


              int[] num = {1,1,1,1,1,1,0,0,0,1,1,0,0,0,1,1,0,0,0,1,1,0,0,0,1,1,0,0,0,1,1,1,1,1,1};

              int parX = 0;
              int parY = 0;

              int translatedX = 0;
              int translatedY = 0;


              int myX = 1;
              int myY = 1;

              double PARTLAUNCHANG = 0;

              int revTranslateX = 0;
              int revTranslateY = 0;
              int inDirMyX = 0;
              int inDirMyY = 0;
              int cloneOfPointOnLineForRevTranslate = 0; //Very long variable name!


              public void driveTo(int driveToX, int driveToY){


                  if(driveToY > myY){


                      if(!(driveToY == myY && !(inDir(1, 1, myY, myX) == 1))){
                          //move up
                          myY ++;





                      }
                  }
                  if(driveToX > myX) {

                      {
                          if (!(driveToX == myX) && !(inDir(2, 1, myX, myY) == 1)) {
                              //move right
                              myX ++;
                          }


                      }
                      if (driveToY < myY) {

                          if (!(driveToY == myY) && !(inDir(3, 1, myX, myY) == 1)) {

                              }

                      }
                      if (driveToX < myX) {

                          {
                              if (!(driveToX == myX) && !(inDir(4, 1, myX, myY) == 1)){

                              }
                          }



                      }
                  }
              }
                      public static int inDir(int inDirection,int distance, int inDirMyX,int inDirMyY){
                          if(inDirection == 1){
                              return(translate(inDirMyX,(inDirMyY+distance)));}
                          else if(inDirection == 2){
                              return(translate((inDirMyX+distance),inDirMyY));}
                          else if(inDirection == 3){
                              return(translate(inDirMyX,(inDirMyY-distance)));}
                          else if(inDirection == 4){
                              return translate((inDirMyX-distance),inDirMyY);}
                          return inDirection;
                      }

                      public void raiseParticleLauncher(double toHeight){
                          if(PARTLAUNCHANG<toHeight){
                              //Send power to servos, lower.

                          }
                          else if(PARTLAUNCHANG > toHeight){
                              //send power to servos, lower.
                          }
                          else{
                              //Dunk the particle!
                          }
                      }
                      public void revTranslate(int pointOnLine){
                              cloneOfPointOnLineForRevTranslate = pointOnLine;
                          if(pointOnLine % 5 != 0){ //If 5 (width of the map) divides evenly into the pointOnLine
                              cloneOfPointOnLineForRevTranslate --;
                              revTranslateX ++;
                          }
                          else{
                              revTranslateY = cloneOfPointOnLineForRevTranslate/5;

                          }
                      }
                      public static int translate(int translateX,int translateY){
                          int y = 0;
                          int x = 0;
                          return(x+(5*y));
                      }

                  }
                

        

        }
        @Override
        public void loop(){

          
        }


}
