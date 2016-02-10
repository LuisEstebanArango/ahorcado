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
public class Game {

    private String shownWord = "";
    private List<Character> letter;
    private int intentos = 0;
    private int maxIntentos = 6;
    private int state = 0; // 0 = is playing, 1 = won, 2 = lost

    public Game() {
        letter = new ArrayList<>();
        state = 0;
    }

    public String getShownWord() {
        return shownWord;
    }

    public void setShownWord(String shownWord) {
        this.shownWord = shownWord;
    }

    public List<Character> getLetter() {
        return letter;
    }

    public void setLetter(List<Character> letter) {
        this.letter = letter;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public int getMaxIntentos() {
        return maxIntentos;
    }

    public void setMaxIntentos(int maxIntentos) {
        this.maxIntentos = maxIntentos;
    }

    void incrementarIntentos() {
        ++intentos;
    }

    void addChar(char j) {
        letter.add(j);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "shownWord: " + shownWord + "\n"
                + "intentos: " + intentos + "\n"
                + "maxIntentos: " + maxIntentos + "\n";
    }

}
