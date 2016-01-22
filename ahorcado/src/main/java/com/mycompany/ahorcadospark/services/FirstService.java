/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ahorcadospark.services;

import com.mycompany.ahorcadospark.data.Ahorcado;

/**
 *
 * @author Luis Esteban
 */
public class FirstService {

    public Ahorcado ahorcado = new Ahorcado();

    public void getWord() {
        ahorcado.getGame().getShownWord();
    }

    public void selectWord() {
        ahorcado.selectWord();
    }

    public void newLetter(String params) {
        ahorcado.isChar(params.toUpperCase().charAt(0));
    }
}
