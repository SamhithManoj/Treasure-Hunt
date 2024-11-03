public abstract class Cell{

  private String s;
  private int row, col;
  private boolean visible;


  public Cell(int row, int col,String s){
    this.row = row;
    this.col = col;
    this.s = s;
    this.visible = false;
  }

  public Cell(int row, int col,String s, boolean visible){
    this.row = row;
    this.col = col;
    this.s = s;
    this.visible = visible;
  }

  public boolean isVisible(){ return visible; }

  public void setVisible(boolean status) { visible = status; }

  public String getSymbol() { return s; }

  public void setSymbol(String s ){ this.s = s; }

  public int getRow() { return row; }

  public int getCol() { return col; }

}