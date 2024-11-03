public class RevealCol extends Cell implements RevealCell {

public RevealCol(int row, int col, String s, boolean v) {
  super(row, col, s, v);
}

public void reveal(Cell[][] board) {
    setVisible(false);
    for (int j = 0; j < board.length; j++) {
      if (board[j][getCol()] instanceof RevealCell) {
        board[j][getCol()].setSymbol(" ");
        board[j][getCol()].setVisible(true);
      }
    }
  }
  }