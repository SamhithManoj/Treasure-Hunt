public class ColHint extends Cell implements HintCell {

  public ColHint(int row, int col, String s,boolean v){  super(row, col,s,v); }

public void hint(Cell[][] board){
    int treasureCol = 0;
      for (int i = 0; i < board.length; i++){
        for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] instanceof Treasure){
          setSymbol(""+i);
          treasureCol = j;
          break;
        }
      }
      int colDist = Math.abs(getCol() - treasureCol);
      setSymbol("" + colDist);
    }

  }


}