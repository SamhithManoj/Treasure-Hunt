public class RevealRow extends Cell implements RevealCell {

public RevealRow(int row, int col, String s, boolean v) {
  super(row, col, s, v);
}

public void reveal(Cell[][] board) {
    setVisible(false);
    for (int j = 0; j < board[0].length; j++) {
      if (board[getRow()][j] instanceof RevealCell) {
        board[getRow()][j].setSymbol(" ");
        board[getRow()][j].setVisible(true);
      }
    }
  }
  }