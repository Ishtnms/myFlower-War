package GameManager;

import GameUnits.GameBoard;
import GameUnits.GameFrame;

public class GameManagers {
    public static enum state{
        prepar, star , think , clear , end , gameover,shift
    }
    public static enum Player{
        Red,Blue
    }

    public static enum PiecesType{
        Leaf,Root,Stem
    }
    public static Player GamePlayer = Player.Blue;
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
                    try {
                        Thread.sleep(500);//不停一会棋子不 能正常放置
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if(GameBoard.getGameBoard().getCurrentPieces() != null){
                        GameWin.getGameWin().repaint();
                        gameState = state.shift;
                    }
                    break;
                case shift:
                    if(GamePlayer == Player.Blue){GamePlayer=Player.Red;}
                    else if(GamePlayer == Player.Red){GamePlayer=Player.Blue;}
                    gameState = state.clear;
                    break;
                case clear:
                    GameBoard.getGameBoard().clearOfPush();
                    GameBoard.getGameBoard().clearOfClearPieces();
                    GameBoard.getGameBoard().setCurrentPiecesNUll();
                    gameState = state.end;
                    break;
                case end:
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    GameWin.getGameWin().repaint();
                    gameState = state.think;
                    break;
                case gameover:
                    break;
            }
        }
    }
}
