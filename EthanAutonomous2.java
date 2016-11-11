package org.firstinspires.ftc.teamcode;

//Import all the things
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;          
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.hardware.Servo;


//I don't know what this does. Ask Oliver or Halil
@Autonomous(name = "EthanAutonomous2", group = "Omnibot")



public class EthanAutonomous2 extends OpMode {

    //Define all the motors
    DcMotor motorFl;
    DcMotor motorFr;
    DcMotor motorBl;
    DcMotor motorBr;

    //This probably defines the variables for motor values 
    float Flpower;
    float Frpower;
    float Blpower;
    float Brpower;

    //Internal map, each 5 characters is a line break
    int[] num = {1,1,1,1,1,1,0,0,0,1,1,0,0,0,1,1,0,0,0,1,1,0,0,0,1,1,0,0,0,1,1,1,1,1,1};

    //Defines the x and y vars of robot
    static int y = 0;  
    static int x = 0;  

    float joystickY = 0;
    float joystickX = 0;
    
    //Parser x and parser y? I don't know that these are ever used.
    int parX = 0;
    int parY = 0;

    
    //This is for the translator function.
    int translatedX = 0;
    int translatedY = 0;

    //Particle launcher angle
    double PARTLAUNCHANG = 0;

    //Wait, if this is the location of the robot, what are just x and y?
    int myX = 1;
    int myY = 1;

    //Reverse translator
    int revTranslateX = 0;
    int revTranslateY = 0;
    int cloneOfPointOnLineForRevTranslate;

    //Return thing?
    
    int inDirMyX = 0;
    int inDirMyY = 0;


    @Override
    public void init() {
        //Define motors as hardwareMaps
        motorFl = hardwareMap.dcMotor.get("motor_1");
        motorFr = hardwareMap.dcMotor.get("motor_2");
        motorBl = hardwareMap.dcMotor.get("motor_3");
        motorBr = hardwareMap.dcMotor.get("motor_4");
        motorFl.setDirection(DcMotorSimple.Direction.REVERSE);
        motorBl.setDirection(DcMotorSimple.Direction.REVERSE);



        //Very long variable name!
}
            //
    //This part actually turns the motors and tells the robot to drive to a certain place.
    public void driveTo(int driveToX, int driveToY){ //Oh! Someone added all the motor code!
      
      while(driveToY != myY && driveToX != myX){

        if(driveToY > myY){

            if(!(driveToY == myY && !(inDir(1, 1, myY, myX) == 1))){
                  joystickY = -1;          // Virtual joystick, because I'm copying Oliver's code
                  try {                   //Pause for one second
                    Thread.sleep(1000);                 //1000 milliseconds is one second.
                  } 
                  catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                  }
                myY = myY-1;
            }
        }
        if(driveToX > myX) {


            if (!(driveToX == myX) && !(inDir(2, 1, myX, myY) == 1)) {
              joystickX = -1;
              try {
                Thread.sleep(1000);                 //1000 milliseconds is one second.
              } 
              catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
                //move right
                myX = myX -1;
            }
        }

        if (driveToY < myY) {

                if (!(driveToY == myY) && !(inDir(3, 1, myX, myY) == 1)) {
                  joystickY = 1;
                  try {
                    Thread.sleep(1000);                 //1000 milliseconds is one second.
                  } 
                  catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                  }
                  myY = myY - 1;
                }
            }
        if (driveToX < myX) {


                if (!(driveToX == myX) && !(inDir(4, 1, myX, myY) == 1)){
                  try {
                    Thread.sleep(1000);                 //1000 milliseconds is one second.
                  }
                   catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                  }
                }
            }


        Flpower = joystickY;
      	Frpower = joystickY;  //Actually defines the motor powers (Crazy, I know!)
      	Blpower = joystickX;
      	Brpower = joystickX;  //I don't know why I did this, these are wrong. Pls help. -Ethan


      }
    }


   
    //Evaluates map element in given direction and distance.
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

    //Changes the angle of the particle launcher, once that actually gets working.
    public void raiseParticleLauncher(double toHeight){
      while(PARTLAUNCHANG != toHeight){

        if(PARTLAUNCHANG < toHeight){
            //Send power to servos, lower.
        }
        else if(PARTLAUNCHANG > toHeight){
            //send power to servos, raise.
        }
        else{
            //Fire the particle!
        }
      }
    }
        //Turns a point on the line into X and Y values
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
        //Turns an X and Y value into a point on the line.
        public static int translate(int translateX, int translateY){


            return x+(5*y);
        }

    @Override //I don't know what this is.
    public void loop() { 

    }
}

/*

myY = 1
myX = 1


driveTo(3,8)

>Repeats evaluation of driveTo conditions, eventually drives to location


*/ 











