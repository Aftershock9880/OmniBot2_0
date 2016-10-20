package org.firstinspires.ftc.teamcode;

/**
 * Created by student on 10/18/16.
 */
public class EthanAutonomous {

    //Variables
    int[] num = {1,1,1,1,1,1,0,0,0,1,1,0,0,0,1,1,0,0,0,1,1,0,0,0,1,1,0,0,0,1,1,1,1,1,1};

    int parX = 0;
    int parY = 0;

    int translatedX = 0;
    int translatedY = 0;

    int inDirection;

    int distance;

    int myX = 1;
    int myY = 1;

    double partLaunchAng = 0.0;

    int revTranslateX = 0;
    int revTranslateY = 0;
    int cloneOfPointOnLineForRevTranslate = 0; //Very long variable name!

    public void inDir(int inDirection, int myX, int myY) {
        if (inDirection == 1) {
            return (translate(myX, (myY + distance)))
        }
        else if(inDirection == 2) {
            return (translate((myX + distance), myY))
        }
        else if(inDirection == 3)
            return (translate(myX, (myY - distance)))
        }
        else(inDirection == 4) {
            return translate((myX - distance), myY)
        }
    }

    public int translate(x,y){
        return(x+(5*y))
    }

    public void revTranslate(int pointOnLine){
        cloneOfPointOnLineForRevTranslate = pointOnLine;
        if((pointOnLine %% 5) != 0){ //If 5 (width of the map) divides evenly into the pointOnLine
            cloneOfPointOnLineForRevTranslate --;
            revTranslateX ++;

        }
        else{
            revTranslateY = cloneOfPointOnLineForRevTranslate/5;

        }
    }

    public void driveTo(int driveToX, int driveToY) {

        if (driveToY > myY) {

            if (!(driveToY == myY) && !(inDir(1, 1, myX, myY) == 1)) {
                //move up
            }
        }
        if (driveToX > myX) {

            if (!(driveToX == myX) && !(inDir(2, 1, myX, myY) == 1)) {
                    //move right
            }
        }
        if (driveToY < myY) {

            if (1(driveToY == myY) && !(inDir(3, 1, myX, myY) == 1)){
                    //move down
            }
        }
        if (driveToX < myX) {

            if (1(driveToX == myX) && !(inDir(4, 1, myX, myY) == 1)){
                    //move left
            }
        }
    }
}