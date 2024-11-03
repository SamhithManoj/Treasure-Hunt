public class RowHint extends Cell implements HintCell{

  public RowHint(int row, int col, String s,boolean v){  super(row, col,s,v); }

  public void hint(Cell[][] board){
    int treasureRow = 0;
      for (int i = 0; i < board.length; i++){
        for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] instanceof Treasure){
          setSymbol(""+i);
          treasureRow = i;
          break;
        }
      }
      int rowDist = Math.abs(getRow() - treasureRow);
      setSymbol("" + rowDist);
    }

  }


}