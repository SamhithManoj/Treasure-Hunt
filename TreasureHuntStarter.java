import java.util.Scanner;
public class TreasureHuntStarter{
  public static final boolean DEFAULT_VISIBILITY = true;
  private Cell[][] board;
  private Scanner reader;
  private Treasure treasure;
  private int guess;

  public TreasureHuntStarter(){
    reader = new Scanner(System.in);
    board = new Cell[8][10];
    guess = 0;
  }

  public void play(){
    setBoard();
    printBoard();
    while (true){
      guess++;
      int r,c;
      do{
        System.out.print("Row = ");
        r = reader.nextInt();
        System.out.print("Col = ");
        c = reader.nextInt();
      } while (r < 0 || r >= board.length || c < 0 || c >= board[0].length);
      if (r == treasure.getRow() && c == treasure.getCol()){
        treasure.show(board);
        printBoard();
        System.out.println("- YOU WIN IN "+guess+" GUESSES! -");
        break;
      }
      /* ADD CODE TO HANDLE HINT AND REVEAL CELLS  */
         else if (board[r][c] instanceof HintCell) {
            ((HintCell)board[r][c]).hint(board);
          }
          else if(board[r][c] instanceof RevealCell){
              ((RevealCell)board[r][c]).reveal(board);
            }
        System.out.println("------ guess "+guess+" -------");
      printBoard();
    }
     }

  public void setBoard(){
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
          int rand = (int)(Math.random()*100)+1;
          if (rand <= 30)
            board[i][j] = new RowHint(i,j,"R",DEFAULT_VISIBILITY);
          else if (rand <= 60)
            board[i][j] = new ColHint(i,j,"C",DEFAULT_VISIBILITY);
          else if (rand <= 80)
            board[i][j] = new RevealRow(i,j,"W",DEFAULT_VISIBILITY);
          else if (rand <= 100)
            board[i][j] = new RevealCol(i,j,"L",DEFAULT_VISIBILITY);
      }
    }
    placeTreasure();

  }

  public void placeTreasure(){
    int tr = (int)(Math.random()*board.length);
    int tc = (int)(Math.random()*board[0].length);
    treasure = new Treasure(tr,tc,"$");
    board[tr][tc] = treasure;
  }


  public void printBoard(){
    System.out.print("  ");
    for (int i = 0; i < board[0].length; i++)
      System.out.print(i+" ");
    System.out.println();
    for (int i = 0; i < board.length; i++){
      System.out.print(i+" ");
      for (int j = 0; j < board[i].length; j++)
          if (board[i][j].isVisible())
             System.out.print(board[i][j].getSymbol()+" ");
          else
             System.out.print("# ");
      System.out.println();
    }
  }
}