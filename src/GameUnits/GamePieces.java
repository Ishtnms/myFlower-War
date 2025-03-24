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
                if(type == GameManagers.PiecesType.Leaf){
                        if(camp == GameManagers.Player.Red){
                                g.drawImage(GameImg.RedLeaf,(positionC+1)*60+5,(positionR+1)*60+5,null);}
                        if(camp == GameManagers.Player.Blue){
                                g.drawImage(GameImg.BlueLeaf,(positionC+1)*60+5,(positionR+1)*60+5,null);
                        }
                }
                if(type == GameManagers.PiecesType.Root){
                        if(camp == GameManagers.Player.Red){
                                g.drawImage(GameImg.RedRoot,(positionC+1)*60+5,(positionR+1)*60+5,null);}
                        if(camp == GameManagers.Player.Blue){
                                g.drawImage(GameImg.BlueRoot,(positionC+1)*60+5,(positionR+1)*60+5,null);
                        }


                }
                if(type == GameManagers.PiecesType.Stem){
                        if(camp == GameManagers.Player.Red){
                                g.drawImage(GameImg.RedStem,(positionC+1)*60+5,(positionR+1)*60+5,null);}
                        if(camp == GameManagers.Player.Blue){
                                g.drawImage(GameImg.BlueStem,(positionC+1)*60+5,(positionR+1)*60+5,null);
                        }

                }
        }

}
