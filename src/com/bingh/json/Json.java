package com.bingh.json;

import java.util.ArrayList;
import java.util.List;

public class Json {
 
 
 
          private int age = 52;
 
          private String name = "Jim Carrey";
 
          private JsonFirstObject jsnFO = new JsonFirstObject();
 
          private List<String> messages;
 
 
 
          public Json() {
 
            this.messages = new ArrayList<String>() {
 
                    {
 
                              add("Hey, maybe I will give you..");
 
                              add("Excuse me, I'd like to..");
 
                              add("Brain freeze. Alrighty Then I just..");
 
                              }
 
                    };
 
          }
 
          // Getter and setter


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

    public JsonFirstObject getJsnFO() {
        return jsnFO;
    }

    public void setJsnFO(JsonFirstObject jsnFO) {
        this.jsnFO = jsnFO;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "Json{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", jsnFO=" + jsnFO +
                ", messages=" + messages +
                '}';
    }
}
