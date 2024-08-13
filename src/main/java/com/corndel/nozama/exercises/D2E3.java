package com.corndel.nozama.exercises;

import io.javalin.Javalin;
import io.javalin.http.HttpStatus;
import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

import java.util.ArrayList;

import com.corndel.nozama.repositories.UserRepository;

public class D2E3 {
  private Javalin app;
  private ArrayList<Alarm> alarms;

  public D2E3() {
    alarms = new ArrayList<Alarm>();
    alarms.add(new Alarm("08:30", "Wake up!"));
    alarms.add(new Alarm("17:00", "Go home!"));

    app = Javalin.create();

    // https://tech-docs.corndel.com/express/body-and-headers.html
    app.get(
        "/alarms",
        ctx -> {
          /** Responds with all the alarms as a JSON response */
          ctx.json(alarms);
        });

    app.get(
        "/alarms/{index}",
        ctx -> {
          var index = Integer.parseInt(ctx.pathParam("index"));

          ctx.json(alarms.get(index));
        });

    app.post(
        "/alarms",
        ctx -> {
          /**
           * Request contains a new alarm in the req.body Push it to the end of the alarms
           * array
           * Respond with a 201 status code
           */
          var alarm = ctx.bodyAsClass(Alarm.class);
          alarms.add(alarm);
          ctx.status(HttpStatus.CREATED).json(alarm);
        });
  }

  public Javalin javalinApp() {
    return app;
  }

  public ArrayList<Alarm> getAlarms() {
    return alarms;
  }
}

class Alarm {
  public String time;
  public String message;

  public Alarm() {
  }

  public Alarm(String time, String message) {
    this.time = time;
    this.message = message;
  }
}
