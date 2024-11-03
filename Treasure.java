public class Treasure extends Cell{

  public Treasure(int row, int col, String s){  super(row,col,s); }

  public void show(Cell[][] board){
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        if (!(board[i][j] instanceof Treasure))
          board[i][j].setSymbol(" ");

        board[i][j].setVisible(true);
      }
    }
  }

}