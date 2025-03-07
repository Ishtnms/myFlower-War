package GameManager;

import GameUnits.GameFrame;

public class GameManagers {
    public static enum state{
        prepar, star , think , clear , end , gameover
    }
    public static state gameState = state.prepar;
    public static void main(String[] args) {
        while(gameState != state.gameover){
            switch(gameState){
                case prepar:
                    gameState = state.star;
                    break;
                case star:
                    GameWin.getGameWin().lunch();
                    GameWin.getGameWin().repaint();
                    gameState = state.think;
                    break;
                case think:
                    break;
                case clear:
                    break;
                case end:
                    break;
                case gameover:
                    break;
            }
        }
    }
}
