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
public class WordSearcher {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    SearchForWords();
  }
  
  public static void SearchForWords() {
    SearchSmallGrid();
    SearchBigGrid();
  }
  
  public static void SearchSmallGrid() {
    System.out.println("checking small grid...");
    char letters[][] = {
      {'c','a','x','b'},
      {'a','l','m','o'},
      {'t','a','a','o'},
      {'l','t','p','g'}
    };
    
    String words[] = {"cat","lag","map","lat","am"};
    
    WordSearch wordSearch = new WordSearch(letters, words);
    wordSearch.FindWords();
    System.out.println();
  }
  
  public static void SearchBigGrid() {
    System.out.println("checking big grid...");
    char letters[][] = {
      {'s','t','o','p','o','r','d','h'},
      {'s','e','p','a','c','s','e','o'},
      {'f','b','u','r','n','i','u','s'},
      {'i','i','l','w','a','r','c','e'},
      {'r','o','l','l','e','e','s','p'},
      {'e','h','o','t','o','n','e','l'},
      {'h','l','a','d','d','e','r','e'},
      {'i','w','e','k','o','m','s','h'}
    };
    
    String words[] = {"hot","hose","rescue","roll","smoke", "crawl", "escape",
    "ladder", "stop", "help", "fire", "burn", "water", "siren", "drop"};
    
    WordSearch wordSearch = new WordSearch(letters, words);
    wordSearch.FindWords();
    System.out.println();
  }  
}
