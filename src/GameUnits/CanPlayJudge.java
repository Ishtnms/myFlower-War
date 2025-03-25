package GameUnits;

import GameManager.GameManagers;

public class CanPlayJudge {
    public static boolean canPlay1(int r , int c){
        for(int rl = r+1 ; rl >= r-1 ; rl--){
            for(int cl = c+1 ; cl >= c-1 ; cl--){
                if(rl<0||rl>7||cl<0||cl>7){continue;}
                if((rl==0||rl==7)&&(cl<=5||cl>=2)){continue;}
                if(GameBoard.getGameBoard().board[rl][cl]!=null&&GameBoard.getGameBoard().board[rl][cl].getCamp()== GameManagers.GamePlayer){
                    return true;
                }
            }
        }
        return false;
    }
    public static  boolean canPlay2(int r , int c){
        for(int rl = r+1 ; rl >= r-1 ; rl--){
            for(int cl = c+2 ; cl >= c-2 ; cl--){
                if(rl<0||rl>7||cl<0||cl>7){continue;}
                if((rl==0||rl==7)&&(cl<=5||cl>=2)){continue;}
                if(GameBoard.getGameBoard().board[rl][cl]!=null&&GameBoard.getGameBoard().board[rl][cl].getCamp()== GameManagers.GamePlayer&&GameBoard.getGameBoard().board[rl][cl].getType()== GameManagers.PiecesType.Stem){
                    return true;
                }
            }
        }
        return false;
    }
}
