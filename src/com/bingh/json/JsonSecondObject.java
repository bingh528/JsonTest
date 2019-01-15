package com.bingh.json;

import java.util.ArrayList;
import java.util.List;

public class JsonSecondObject {
 
 
 
          private int age = 83;
 
          private String name = "Clint Eastwood";
 
          private JsonThirdObject jsnTO = new JsonThirdObject();
 
          private List<String> messages;
 
 
 
          public JsonSecondObject() {
 
            this.messages = new ArrayList<String>() {

                    {

                              add("This is the AK-47 assault..");

                              add("Are you feeling lucky..");

                              add("When a naked man's chasing a..");

                              }

                    };
 
          }
 
          // Getter and setter


    public JsonThirdObject getJsnTO() {
        return jsnTO;
    }

    public void setJsnTO(JsonThirdObject jsnTO) {
        this.jsnTO = jsnTO;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "JsonSecondObject{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", jsnTO=" + jsnTO +
                ", messages=" + messages +
                '}';
    }
}
