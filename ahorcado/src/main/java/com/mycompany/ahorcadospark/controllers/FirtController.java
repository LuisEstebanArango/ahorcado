/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ahorcadospark.controllers;

import com.mycompany.ahorcadospark.JsonUtil;
import com.mycompany.ahorcadospark.services.FirstService;
import spark.Request;
import spark.Response;
import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.put;

/**
 *
 * @author Luis Esteban
 */
public class FirtController {

    public FirtController(final FirstService firtService) {

        before((req, res) -> {
            /*if(req.session(false) == null){

             }*/
            System.out.println(req.session().attributes());
            System.out.println("Esto es antes de cualquier cosa");
        });

        get("/word", (Request req, Response res) -> {
            firtService.getWord();
            return JsonUtil.toJson(firtService.ahorcado.getGame());
        });

        put("/word", (req, res) -> {
            firtService.selectWord();
            return JsonUtil.toJson(firtService.ahorcado.getGame());
        });

        get("/letter/:letter", (req, res) -> {
            firtService.newLetter(req.params("letter"));
            return JsonUtil.toJson(firtService.ahorcado.getGame());
        });
    }
}
