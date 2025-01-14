package com.corndel.nozama.exercises;

import static org.assertj.core.api.Assertions.assertThat;

import io.javalin.Javalin;
import io.javalin.json.JavalinJackson;
import io.javalin.testtools.JavalinTest;
import org.junit.jupiter.api.Test;

public class D3E1Tests {
  D3E1 d3e1 = new D3E1();
  Javalin app = d3e1.javalinApp();

  @Test
  public void GET_counter_returns_counter_state() {
    JavalinTest.test(
        app,
        (server, client) -> {
          var response = client.get("/counter");
          var counterJson = new JavalinJackson().toJsonString(D3E1.counter, Counter.class);
          assertThat(response.body().string()).isEqualTo(counterJson);
        });
  }

  @Test
  public void PUT_counter_increment_returns_state() {
    JavalinTest.test(
        app,
        (server, client) -> {
          var response = client.put("/counter/increment");
          var counterJson = new JavalinJackson().toJsonString(D3E1.counter, Counter.class);

          assertThat(response.code()).isEqualTo(200);
          assertThat(response.body().string()).isEqualTo(counterJson);
        });
  }

  @Test
  public void PUT_counter_increment_increments_state() {
    JavalinTest.test(
        app,
        (server, client) -> {
          D3E1.counter.count = 0;
          client.put("/counter/increment");
          assertThat(D3E1.counter.count).isEqualTo(1);
        });
  }
}
