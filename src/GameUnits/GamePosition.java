package GameUnits;

public class GamePosition {

    public static int getP(int pC){
        if( pC > 60 && pC <= 120){return 0;}
        else if(pC>120 && pC <= 180){return 1;}
        else if(pC>180 && pC <= 240){return 2;}
        else if(pC>240 && pC <= 300){return 3;}
        else if(pC>300 && pC <= 360){return 4;}
        else if(pC>360 && pC <= 420){return 5;}
        else if(pC>420 && pC <= 480){return 6;}
        else if(pC>480 && pC <= 540){return 7;}

        return -1;
    }
}
