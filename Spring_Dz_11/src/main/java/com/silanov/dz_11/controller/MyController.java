package com.silanov.dz_11.controller;

import com.silanov.dz_11.MyMetrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  private final MyMetrics myMetrics;

  @Autowired
  public MyController(MyMetrics myMetrics) {
    this.myMetrics = myMetrics;
  }

  @GetMapping("/hello")
  public String hello() {
    myMetrics.incrementHelloCounter();
    return "Hello World!";
  }
}