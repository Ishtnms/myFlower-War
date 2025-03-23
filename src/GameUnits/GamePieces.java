package GameUnits;

import GameManager.GameManagers;

import java.awt.*;

public class GamePieces {
        private boolean isClear = false;
        private GameManagers.PiecesType type;
        private GameManagers.Player camp ;
        private int positionR = 0;
        private int positionC = 0;
        public boolean getClear(){return isClear;}
        public int getPR(){ return positionR; }
        public int getPC(){ return positionC; }
        public GameManagers.Player getCamp(){return camp;}
        public GameManagers.PiecesType getType(){ return type; }
        public void setClear(boolean isClear){ this.isClear = isClear;}
        public void setPositionR(int PR){ positionR=PR; }
        public void setPositionC(int PC){ positionC=PC; }
        public void setCamp(GameManagers.Player gameCamp){camp = gameCamp;}
        public void setType(GameManagers.PiecesType gameType){type = gameType;}

        public GamePieces(int r , int c , GameManagers.PiecesType gameType , GameManagers.Player gameCamp){
            positionC = c;
            positionR = r;
            type = gameType;
            camp = gameCamp;
        }
        public void paintSelf(Graphics g){

        }

}
