package com.mycompany.ahorcadospark;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luis Esteban
 */
public interface ResponseTransformer {
  String render(Object model) throws Exception;
}
