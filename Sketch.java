import processing.core.PApplet;

public class Sketch extends PApplet {
  int CELL_WIDTH = 20;
  int CELL_HEIGHT = 20;
  int MARGIN = 5;
  int ROW_COUNT = 10;
  int COLUMN_COUNT = 10;
  int SCREEN_WIDTH = (CELL_WIDTH + MARGIN) * COLUMN_COUNT + MARGIN;
  int SCREEN_HEIGHT = (CELL_HEIGHT + MARGIN) * ROW_COUNT + MARGIN;
  int[][] intGrid;
  int white = 255;
  int row;
  int column;
  int greenCellCount = 0;

  
  
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
    // put your size call here
    size(SCREEN_WIDTH - 8, SCREEN_HEIGHT - 8);
    
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(0);
    intGrid = new int[10][10];
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    //draws grid
    for(column = 0; column < COLUMN_COUNT; column++){
      for(row = 0; row < ROW_COUNT; row++){        

        //conditions for if a block is clicked on
        if(intGrid[row][column] == 1){
          fill(0, 255, 0);
          rect((column * CELL_WIDTH) + MARGIN * column, (row * CELL_HEIGHT) + MARGIN * row, CELL_WIDTH, CELL_HEIGHT);
        }else{
          fill(white);
          rect((column * CELL_WIDTH) + MARGIN * column, (row * CELL_HEIGHT) + MARGIN * row, CELL_WIDTH, CELL_HEIGHT);
        } 
      }
    }
  }

  public void mousePressed(){
    System.out.println("click");
    System.out.println("mouse coordinates: " + mouseX + "," + mouseY);
    rowCheck();
    columnCheck();

    //checks if a block has been clicked
    //right block
    if(column < 9 && intGrid[row][column + 1] == 0){
      intGrid[row][column + 1] = 1;
      greenCellCount ++;
      
    }else if(column < 9 && intGrid[row][column + 1] == 1){
      intGrid[row][column + 1] = 0;
      greenCellCount --;       
      }

    //left block
    if(column > 0 && intGrid[row][column - 1] == 0){
      intGrid[row][column - 1] = 1;
      greenCellCount ++;
      
    }else if(column > 0 && intGrid[row][column - 1] == 1){
      intGrid[row][column - 1] = 0;
      greenCellCount --;     
      }

    //bottom block
    if(row < 9 && intGrid[row + 1][column] == 0){
      intGrid[row + 1][column] = 1;
      greenCellCount ++;
      
    }else if(row < 9 && intGrid[row + 1][column] == 1){
      intGrid[row + 1][column] = 0;
      greenCellCount --;      
    }

    //top block 
    if(row > 0 && intGrid[row - 1][column] == 0){
      intGrid[row - 1][column] = 1;
      greenCellCount ++;      
    }else if(row > 0 && intGrid[row - 1][column] == 1){
      intGrid[row - 1][column] = 0;
      greenCellCount --;   
    }

    //middle block
    if(intGrid[row][column] == 0){
    intGrid[row][column] = 1;
    greenCellCount ++;
    }else if(intGrid[row][column] == 1){
      intGrid[row][column] = 0;
      greenCellCount --;
    }
    
    System.out.println("Total of " + greenCellCount + " cells are selected.");
    columnCounter();
    rowCounter();
    continuousCount();
    System.out.println(" ");
    }

  public void rowCheck(){
    //checks in which row the mouse is
    if(mouseY <= 19){
      row = 0;
      System.out.print ("Grid coordinates: row: " + (row + 1));
    }else if(mouseY >= 24 && mouseY <= 44){
      row = 1;
      System.out.print ("Grid coordinates: row: " + (row + 1));
    }else if(mouseY >= 51 && mouseY <= 69){
      row = 2;
      System.out.print ("Grid coordinates: row: " + (row + 1));
    }else if(mouseY >= 76 && mouseY <= 94){
      row = 3;
      System.out.print ("Grid coordinates: row: " + (row + 1));
    }else if(mouseY >= 99 && mouseY <= 119){
      row = 4;
      System.out.print ("Grid coordinates: row: " + (row + 1));
    }else if(mouseY >= 124 && mouseY <= 144){
      row = 5;
      System.out.print ("Grid coordinates: row: " + (row + 1));
    }else if(mouseY >= 149 && mouseY <= 169){
      row = 6;
      System.out.print ("Grid coordinates: row: " + (row + 1));
    }else if(mouseY >= 174 && mouseY <= 194){
      row = 7;
      System.out.print ("Grid coordinates: row: " + (row + 1));
    }else if(mouseY >= 199 && mouseY <=219){
      row = 8;
      System.out.print ("Grid coordinates: row: " + (row + 1));
    }else if(mouseY >= 224 && mouseY <= 244){
      row = 9;
      System.out.print ("Grid coordinates: row: " + (row + 1));
    }
  }
  
  public void columnCheck(){
    //checks in which column the mouse is
    if(mouseX <= 19){
      column = 0;
      System.out.println (" column: " + (column + 1));
    }else if(mouseX >= 24 && mouseX <= 44){
      column = 1;
      System.out.println (" column: " + (column + 1));
    }else if(mouseX >= 51 && mouseX <= 69){
      column = 2;
      System.out.println (" column: " + (column + 1));
    }else if(mouseX >= 76 && mouseX <= 94){
      column = 3;
      System.out.println (" column: " + (column + 1));
    }else if(mouseX >= 99 && mouseX <= 119){
      column = 4;
      System.out.println (" column: " + (column + 1));
    }else if(mouseX >= 124 && mouseX <= 144){
      column = 5;
      System.out.println (" column: " + (column + 1));
    }else if(mouseX >= 149 && mouseX <= 169){
      column = 6;
      System.out.println (" column: " + (column + 1));
    }else if(mouseX >= 174 && mouseX <= 194){
      column = 7;
      System.out.println (" column: " + (column + 1));
    }else if(mouseX >= 199 && mouseX <=219){
      column = 8;
      System.out.println (" column: " + (column + 1));
    }else if(mouseX >= 224 && mouseX <= 244){
      column = 9;
      System.out.println (" column: " + (column + 1));
    }
  }
  
  public void rowCounter(){
    //tracks how many green blocks there are in each row
    for(int i = 0; i < ROW_COUNT; i++){
      int greenCellRow = 0;
      for(int j = 0; j < COLUMN_COUNT; j++){
        if(intGrid[i][j] == 1){
          greenCellRow ++;
        }
      }
      System.out.println("Row " + (i + 1) + " has " + greenCellRow + " cells selected");
    }
  }

  public void columnCounter(){
    //tracks how many green blocks there are in each column
    for(int i = 0; i < COLUMN_COUNT; i++){
      int greenCellColumn = 0;
      for(int j = 0; j < ROW_COUNT; j++){
        if(intGrid[j][i] == 1){
          greenCellColumn ++;
        }
      }
      System.out.println("Column " + (i + 1) + " has " + greenCellColumn + " cells selected");
    }
  }

  public void continuousCount(){
    //checks how many blocks are selected simultaneously in each row, does not print if there are only two or less blocks simultaneously selected
    for(int i = 0; i < ROW_COUNT; i++){
      int continuousRowCount = 0;
      int maxContinuousRow = 0;
      for(int j = 0; j < COLUMN_COUNT; j++){
        if(intGrid[i][j] == 1){
          continuousRowCount ++;
        }else if(intGrid[i][j] == 0){
          if(continuousRowCount > maxContinuousRow){
            maxContinuousRow = continuousRowCount;
          }
          continuousRowCount = 0;
        }
      }
      if(continuousRowCount > maxContinuousRow){
        maxContinuousRow = continuousRowCount;
      }
      if(maxContinuousRow > 2){
        System.out.println("There are " + maxContinuousRow + " continous blocks selected on row " + (i + 1));
      }
    }
  }
}
