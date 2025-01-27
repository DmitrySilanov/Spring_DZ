package com.example;

import org.apache.commons.*;
import com.google.gson.*;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Gson g = new Gson();
        Person person = new Person("Micle", "Jackson", 30);
        String json =  g.toJson(person);
        System.out.println(json);
        Person deserializedPerson = g.fromJson(json, Person.class);
        System.out.println(deserializedPerson.toString());
    }


}
