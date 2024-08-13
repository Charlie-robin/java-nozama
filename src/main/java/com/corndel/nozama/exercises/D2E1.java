package com.corndel.nozama.exercises;

import io.javalin.Javalin;

public class D2E1 {
  private Javalin app;

  public D2E1() {
    app = Javalin.create();

    /**
     * Add a single GET /ping endpoint to app -
     * It should respond with the simple string "pong"
     *
     * https://tech-docs.corndel.com/javalin/creating-a-server.html
     * https://tech-docs.corndel.com/javalin/request-response.html
     */
  }

  public Javalin javalinApp() {
    app.get("/ping", ctx -> ctx.result("pong"));

    return app;
  }
}
