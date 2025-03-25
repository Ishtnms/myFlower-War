package GameUnits;

import GameManager.GameManagers;
import GameManager.GameWin;

public class GameBoard {

    GamePieces currentPieces = null;
    static GameBoard gameBoard = new GameBoard("棋盘创建");
    public GamePieces ERedRoot = null;
    public GamePieces EBlueRoot = null;
    public GamePieces ERedStem = null;
    public GamePieces EBlueStem = null;
    public static GameBoard getGameBoard(){
        return gameBoard;
    }
    public GamePieces[][] board = new GamePieces[8][8];
   void boradInit()
    {
        for(int i = 0 ; i < 8 ; i++)
        {
            for(int j = 0 ; j < 8 ; j++)
            {
                if(i == 1 && (j == 3 || j ==4))
                {
                board[i][j] = new GamePieces(i,j, GameManagers.PiecesType.Leaf, GameManagers.Player.Blue);
                }
                else if(i == 6&& (j == 3 || j == 4)){
                board[i][j] = new GamePieces(i,j, GameManagers.PiecesType.Leaf, GameManagers.Player.Red);
                }

            }
        }
    }

    public GameBoard(String s){
       boradInit();
    }
    public GameBoard(){

    }
    public void setCurrentPiecesNUll(){
       currentPieces = null;
    }
    public GamePieces getCurrentPieces(){return currentPieces;}
    public void play(int r ,int c){
       if(GameManagers.gameState == GameManagers.state.think)
       currentPieces = playLeaf(r,c);
    }
    public void play(int r , int c , GameManagers.PiecesType type){
       if( GameManagers.gameState == GameManagers.state.think&&(CanPlayJudge.canPlay1(r,c)||CanPlayJudge.canPlay2(r,c)))
       {if(type == GameManagers.PiecesType.Leaf){
           currentPieces = playLeaf(r,c);
        }
        if(type == GameManagers.PiecesType.Stem){
           currentPieces = playStem(r,c);
        }
        if(type == GameManagers.PiecesType.Root){
           currentPieces = playRoot(r,c);
        }
       }
    }
    public  GamePieces playLeaf(int r ,int c){
       if(board[r][c] == null){
        board[r][c] = new GamePieces(r,c,GameManagers.PiecesType.Leaf,GameManagers.GamePlayer);
       return board[r][c];}
    return  null;
   }
   public GamePieces playRoot(int r,int c){
     if(board[r][c] == null){
         if(GameManagers.GamePlayer == GameManagers.Player.Blue && GameBoard.getGameBoard().EBlueRoot == null){
             board[r][c] = new GamePieces(r,c, GameManagers.PiecesType.Root,GameManagers.GamePlayer);
             GameBoard.getGameBoard().EBlueRoot = board[r][c];
             return board[r][c];
         }
         if(GameManagers.GamePlayer == GameManagers.Player.Red && GameBoard.getGameBoard().ERedRoot == null){
             board[r][c] = new GamePieces(r,c, GameManagers.PiecesType.Root,GameManagers.GamePlayer);
             GameBoard.getGameBoard().ERedRoot = board[r][c];
             return board[r][c];
         }
     }
       return null;
   }
   public GamePieces playStem(int r,int c){
       if(board[r][c] == null){
           if(GameManagers.GamePlayer == GameManagers.Player.Blue && GameBoard.getGameBoard().EBlueStem == null){
               board[r][c] = new GamePieces(r,c, GameManagers.PiecesType.Stem,GameManagers.GamePlayer);
               GameBoard.getGameBoard().EBlueStem = board[r][c];
               return board[r][c];
           }
           if(GameManagers.GamePlayer == GameManagers.Player.Red && GameBoard.getGameBoard().ERedStem == null){
               board[r][c] = new GamePieces(r,c, GameManagers.PiecesType.Stem,GameManagers.GamePlayer);
               GameBoard.getGameBoard().ERedStem = board[r][c];
               return board[r][c];
           }
       }
       return null;
   }

    public void clearOfPush(){
       clearOfPushRR();
       clearOfPushRL();
       clearOfPushCU();
       clearOfPushCD();
    }
    //实现棋子推动的方法
    //向右推
    void clearOfPushRR(){
      int cellCount = 0;//记录需要推动的棋子
      for(int c = currentPieces.getPC()+1 ; c <= currentPieces.getPC()+3 ; c++){
          if( c > 7){continue;}//不能超出范围
          if(board[currentPieces.getPR()][c] == null){break;}//检测到为空时退出检测
          if(c == 7){return;}//遇到边界时不推动
          if(currentPieces.getPR() == 0 && (c+1<6||c+1>1)&&currentPieces.getCamp() == GameManagers.Player.Blue){return;}//遇到自己的核心区时不推动
          if(currentPieces.getPR() == 7 && (c+1<6||c+1>1)&&currentPieces.getCamp() == GameManagers.Player.Red){return;}
          if(board[currentPieces.getPR()][c].getType() == GameManagers.PiecesType.Root){return;}//遇到根时不推动
          if(board[currentPieces.getPR()][c].getCamp() == currentPieces.getCamp()){return;}//有自己同阵营的不推动
          cellCount++;
      }
      for(int c = currentPieces.getPC()+cellCount ; c > currentPieces.getPC() ; c--){
          if(board[currentPieces.getPR()][c] != null){
              board[currentPieces.getPR()][c].setPositionC(c+1);//棋子位置推动的设置
              board[currentPieces.getPR()][c+1] = board[currentPieces.getPR()][c];//棋盘存储的设置
              board[currentPieces.getPR()][c] = null;//将被移动的位置设为空
          }
      }

    }
    //向左推
    void clearOfPushRL(){
        int cellCount = 0;
        for(int c = currentPieces.getPC()-1 ; c >= currentPieces.getPC()-3 ; c--){
            if( c < 0){continue;}
            if(board[currentPieces.getPR()][c] == null){break;}
            if(c == 0){return;}
            if(currentPieces.getPR() == 0 && (c+1<6||c+1>1)&&currentPieces.getCamp() == GameManagers.Player.Blue){return;}
            if(currentPieces.getPR() == 7 && (c+1<6||c+1>1)&&currentPieces.getCamp() == GameManagers.Player.Red){return;}
            if(board[currentPieces.getPR()][c].getType() == GameManagers.PiecesType.Root){return;}
            if(board[currentPieces.getPR()][c].getCamp() == currentPieces.getCamp()){return;}
            cellCount++;
        }
        for(int c = currentPieces.getPC()-cellCount ; c < currentPieces.getPC() ; c++){
            if(board[currentPieces.getPR()][c] != null){
                board[currentPieces.getPR()][c].setPositionC(c-1);
                board[currentPieces.getPR()][c-1] = board[currentPieces.getPR()][c];
                board[currentPieces.getPR()][c] = null;
            }
        }
    }
    //向上推
    void clearOfPushCD(){
       int cellCount = 0;
       for(int r = currentPieces.getPR()+1; r <= currentPieces.getPR()+3 ; r++){
           if(r>7){continue;}
           if(board[r][currentPieces.getPC()]==null){break;}
           if(r==7){return;}
           if(r == 0 && (currentPieces.getPC()<6||currentPieces.getPC()+1>1)&&currentPieces.getCamp() == GameManagers.Player.Blue){return;}
           if(r == 7 && (currentPieces.getPC()+1<6||currentPieces.getPC()+1>1)&&currentPieces.getCamp() == GameManagers.Player.Red){return;}
           if(board[r][currentPieces.getPC()].getType() == GameManagers.PiecesType.Root){return;}
           if(board[r][currentPieces.getPC()].getCamp() == currentPieces.getCamp()){return;}
           cellCount++;
       }
       for(int r = currentPieces.getPR()+cellCount; r >currentPieces.getPR();r--){
           if(board[r][currentPieces.getPC()] != null){
               board[r][currentPieces.getPC()].setPositionR(r+1);
               board[r+1][currentPieces.getPC()] = board[r][currentPieces.getPC()];
               board[r][currentPieces.getPC()] =null;
           }
       }
    }
    //向下推
    void clearOfPushCU(){
        int cellCount = 0;
        for(int r = currentPieces.getPR()-1; r >= currentPieces.getPR()-3 ; r--){
            if(r<0){continue;}
            if(board[r][currentPieces.getPC()]==null){break;}
            if(r==0){return;}
            if(r == 0 && (currentPieces.getPC()<6||currentPieces.getPC()+1>1)&&currentPieces.getCamp() == GameManagers.Player.Blue){return;}
            if(r == 7 && (currentPieces.getPC()+1<6||currentPieces.getPC()+1>1)&&currentPieces.getCamp() == GameManagers.Player.Red){return;}
            if(board[r][currentPieces.getPC()].getType() == GameManagers.PiecesType.Root){return;}
            if(board[r][currentPieces.getPC()].getCamp() == currentPieces.getCamp()){return;}
            cellCount++;
        }
        for(int r = currentPieces.getPR()-cellCount; r < currentPieces.getPR();r++){
            if(board[r][currentPieces.getPC()] != null){
                board[r][currentPieces.getPC()].setPositionR(r-1);
                board[r-1][currentPieces.getPC()] = board[r][currentPieces.getPC()];
                board[r][currentPieces.getPC()] =null;
            }
        }
    }
    //以上为实现棋子推动的方法
    //删除相连棋子的方法
    public void clearOfClearPieces(){
       for(int r=1 ; r < 7 ; r++){
           for(int c = 1 ; c < 7 ; c++){
               if(board[r+1][c] != null && board[r-1][c] != null&&board[r][c]!=null){
                   if(board[r][c].getCamp() == board[r+1][c].getCamp() && board[r][c].getCamp() == board[r-1][c].getCamp()){
                       board[r][c].setClear(true);
                       board[r-1][c].setClear((true));
                       board[r+1][c].setClear(true);
                   }
               }
               if(board[r][c+1]!=null&&board[r][c-1]!=null&&board[r][c]!=null){
                   if(board[r][c].getCamp() == board[r][c+1].getCamp()&&board[r][c].getCamp() == board[r][c-1].getCamp()){
                       board[r][c].setClear(true);
                       board[r][c+1].setClear(true);
                       board[r][c-1].setClear(true);
                   }
               }
           }
       }
       for(int r = 0 ; r < 8 ; r++){
           for(int c= 0 ; c < 8 ; c++){
               if(board[r][c]!=null){
                   if(board[r][c].getClear()){
                       board[r][c] = null;
                   }
               }
           }
       }
    }
    public GameManagers.state gameEndJudge(){
       int ER;
       int count = 0;
       if(GameManagers.GamePlayer == GameManagers.Player.Blue){ ER = 0;}
       else{ER = 7;}
       for(int EC = 2 ; EC <=5 ; EC++){
           if(board[ER][EC] != null){count++;}
       }
       if(count==4){return GameManagers.state.gameover;}
        else {return GameManagers.state.think;}
    }
//   public static void main(String[] args) {
//       boradinit();
//        for(int i = 0 ; i < 8 ; i++){
//            for(int j = 0 ; j < 8 ; j++)
//            {
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.print("\n");
//        }
//    }
}
