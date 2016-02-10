/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ahorcadospark.data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis Esteban
 */
public class Ahorcado {

    private List<String> words;
    private String hiddenWord = "";
    private Game game;

    public Ahorcado() {
        game = new Game();
        words = new ArrayList<>();
        words.add("COLOMBIA");
        words.add("ARGENTINA");
        words.add("CHILE");
        words.add("FRANCIA");
        words.add("CANADA");
        words.add("NICARAGUA");
        words.add("VENEZUELA");
    }

    public void selectWord() {
        hiddenWord = words.get((int) (words.size() * Math.random()));
        game = new Game();
        String shownWord = "";
        for (int i = 0; i < hiddenWord.length(); i++) {
            shownWord += i + "";
        }
        game.setShownWord(shownWord);
    }

    public void isChar(char j) {
        if (!validateState()) {
            return;
        }
        if (game.getLetter().stream().filter(e -> e == j).count() > 0) {
            game.incrementarIntentos();
            validateState();
            return;
        }

        game.addChar(j);

        String temp = "";
        boolean isChar = false;
        for (int i = 0; i < hiddenWord.length(); i++) {
            if (j == hiddenWord.charAt(i)) {
                temp += hiddenWord.charAt(i);
                isChar = true;
            } else {
                temp += game.getShownWord().charAt(i);
            }
        }
        if (!isChar) {
            game.incrementarIntentos();
        }
        game.setShownWord(temp);
        validateState();
    }

    /**
     * valida si se está en juego o por el contrario ganó o perdió
     *
     * @return false si ya ganó o perdió y true si aun tiene intentos para jugar
     */
    private boolean validateState() {
        if (hiddenWord.compareTo(game.getShownWord()) == 0) {//ganó
            game.setState(1);
            return false;
        }
        if (game.getIntentos() >= game.getMaxIntentos()) {
            game.setState(2);
            return false;
        }
        game.setState(0);
        return true;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public String getHiddenWord() {
        return hiddenWord;
    }

    public void setHiddenWord(String hiddenWord) {
        this.hiddenWord = hiddenWord;
    }

}
