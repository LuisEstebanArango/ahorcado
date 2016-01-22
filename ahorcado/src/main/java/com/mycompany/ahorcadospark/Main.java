/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ahorcadospark;

import com.mycompany.ahorcadospark.services.FirstService;
import com.mycompany.ahorcadospark.controllers.FirtController;
import spark.SparkBase;

/**
 *
 * @author Luis Esteban
 */
public class Main {

    public static void main(String[] args) {
        //Spark.staticFileLocation("/public");
        SparkBase.externalStaticFileLocation("/home/luis/repos/ahorcado/frontend");
        new FirtController(new FirstService());
    }
}
