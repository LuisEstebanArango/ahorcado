/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ahorcadospark.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Luis Esteban
 */
public class Ahorcado {
    
    private List<String> words;
    private String hiddenWord = "";
    private Game game;
    
    public Ahorcado(){
        game = new Game();
        words = new ArrayList<String>();
        words.add("COLOMBIA");
        words.add("ARGENTINA");
        words.add("CHILE");
        words.add("FRANCIA");
        words.add("CANADA");
        words.add("NICARAGUA");
        words.add("VENEZUELA");
    }
    
    public void selectWord(){
        hiddenWord = words.get((int)(words.size() * Math.random()));
        game = new Game();
        String shownWord = "";
        for (int i = 0; i < hiddenWord.length(); i++) {
            shownWord += "_";
        }
        game.setShownWord(shownWord);
        //Arrays.stream(words)
    }
    
    public void isChar(char j){
        
        if(game.getLetter().stream().filter(e -> e == j).count() > 0){
            game.incrementarIntentos();
            return;
        }
        
        game.addChar(j);
        
        String temp = "";
        boolean isChar = true;
        for (int i = 0; i < hiddenWord.length(); i++) {
            if(j == hiddenWord.charAt(i)){
                temp += hiddenWord.charAt(i);
            }else{
                isChar = false;
                temp += game.getShownWord().charAt(i);
            }
        }
        if(!isChar)
            game.incrementarIntentos();
        game.setShownWord(temp);
    }
    
    /*public void selectWord(){
    hiddenWord = words.get((int)(words.size() * Math.random()));
    intentos = 0;
    shownWord = "";
    for (int i = 0; i < hiddenWord.length(); i++) {
    shownWord += "_";
    }
    //Arrays.stream(words)
    }
    public void isChar(char j){
    String temp = "";
    for (int i = 0; i < hiddenWord.length(); i++) {
    if(j == hiddenWord.charAt(i)){
    temp += hiddenWord.charAt(i);
    }else{
    temp += shownWord.charAt(i);
    intentos++;
    }
    }
    shownWord = temp;
    }*/
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
    
}
