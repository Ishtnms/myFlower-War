package GameUnits;

public class GameBoard {
    static GameBoard gameBoard = new GameBoard();
    public static GameBoard getGameBoard(){
        return gameBoard;
    }
    static int[][] board = new int[8][8];
   static void boradinit()
    {
        for(int i = 0 ; i < 8 ; i++)
        {
            for(int j = 0 ; j < 8 ; j++)
            {
                if(i == 1 && (j == 3 || j ==4))
                {
                    board[i][j] = 1;
                }
                else if(i == 6&& (j == 3 || j == 4)){
                    board[i][j] = 4;
                }
                else{
                    board[i][j] = 0;
                }

            }
        }
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
