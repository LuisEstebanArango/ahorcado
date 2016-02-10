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
import spark.Spark;
import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.put;

/**
 *
 * @author Luis Esteban
 */
public class FirtController {

    public FirtController(final FirstService firtService) {

        /**
         * Esto se ejecuto antes de entrar a cualquier endpoint
         */
        before((req, res) -> {
            /*if(req.session(false) == null){

             }*/
            System.out.println(req.session().attributes());
            System.out.println("Esto es antes de cualquier cosa");
        });

        /**
         * Se obtiene una palabra mostrada
         */
        get("/displayed_word", (Request req, Response res) -> {
            firtService.getWord();
            return JsonUtil.toJson(firtService.ahorcado.getGame());
        });

        /**
         * Se obtiene una palabra oculta
         */
        get("/hidden_word", (Request req, Response res) -> {
            return JsonUtil.toJson(firtService.ahorcado.getHiddenWord());
        });

        /**
         * Se inicia el juego y se selecciona aleatoriamente una palabra
         */
        put("/word", (req, res) -> {
            firtService.selectWord();
            return JsonUtil.toJson(firtService.ahorcado.getGame());
        });

        /**
         * Se verifica si la letra que llega se encuentra en la palabra
         */
        get("/letter/:letter", (req, res) -> {
            firtService.newLetter(req.params("letter"));
            return JsonUtil.toJson(firtService.ahorcado.getGame());
        });

        /**
         * Esto se ejecuta despues de entrar a cualquier endpoint
         */
        Spark.after((req, res) -> {

            System.out.println(firtService.ahorcado.getGame());
        });
    }
}
