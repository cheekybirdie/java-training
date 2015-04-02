/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cheekybirdie;

/**
 *
 * @author Rich
 */
public class WordSearch {
  char _letters[][];
  String _words[];
  
  public WordSearch(char letters[][], String words[]){
    _letters = letters;
    _words = words;
  }
  
  public int ColCount() {
    return _letters[0].length;
  }
  
  public int RowCount() {
    return _letters.length;
  }
  
  public void FindWords() {
    for(String word : _words) {
      FindWord(word);
    }
  }
  
  private enum Direction {
    North, Northeast, East, Southeast,
    South, Southwest, West, Northwest 
  }
  
  // Cell represents an Column,Row i.e. X,Y address of a letter in the grid
  private class Cell {
    public int Column;
    public int Row;
    
    public Cell(int column, int row) {
      Column = column;
      Row = row;
    }
  }
  
  private void FindWord(String word) {
    for(int col=0; col < this.ColCount();col++) {
      for (int row=0; row < this.RowCount(); row++) {
        for (Direction dir : Direction.values()) {
          if (WordExists(col, row, word, dir)) {
            System.out.print(word + " exists at (" + col + "," + row + ") ");
            System.out.println("heading " + dir.toString());
            return; // return when a match is found; assumes word exists once
          }
        }
      }
    }
    
    System.out.println(word + " was not found");
  }

  private Cell GetAdjacentCell(int col, int row, Direction direction) {
    Cell cell = null;

    switch (direction) {
      case North: cell = new Cell(col, row - 1);
        break;
      case Northeast: cell = new Cell(col + 1, row - 1);
        break;
      case East: cell = new Cell(col + 1, row);
        break;
      case Southeast: cell = new Cell(col + 1, row + 1);
        break;
      case South: cell = new Cell(col, row + 1);
        break;
      case Southwest: cell = new Cell(col - 1, row + 1);
        break;
      case West: cell = new Cell(col - 1, row);
        break;
      case Northwest: cell = new Cell(col - 1, row - 1);
        break;
    }
    
    if (!IsValidCoordinate(cell.Column, cell.Row)) {
      cell = null; // set cell to null if it's out of bounds
    }

    return cell;
  }
  
  private boolean IsValidCoordinate(int col, int row) {
    if ((col < 0) || (row < 0)) {
      return false;
    }
    
    if (col > (this.ColCount() -1)) {
      return false;
    }
    
    if (row > (this.RowCount() -1)) {
      return false;
    }
    
    return true;
  }
  
  private boolean WordExists(int col, int row, String word, Direction direction) {
    // check if the first chars match
    if (_letters[row][col] != word.charAt(0)) {
      return false;
    }
    
    // if we made it this far, the first letters match

    // no need to keep looking if this is the last letter
    if (word.length() == 1) {
      return true;
    }
    
    // get the location of the next letter along the current path/direction
    Cell nextCell = GetAdjacentCell(col, row, direction);
    
    // null means the adjacent cell was out of bounds
    if (nextCell == null) {
      return false;
    }
    
    // check if the next letter along the direction is a match
    //if (_letters[nextCell.Row][nextCell.Column] != word.charAt(1)) {
    //  return false;
    //}
    
    return WordExists(nextCell.Column, nextCell.Row, word.substring(1), direction);
  }
}
