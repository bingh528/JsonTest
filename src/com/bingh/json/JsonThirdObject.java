package com.bingh.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonThirdObject {

    private int age = 19;
    private String name = "michael caine";

    private List<String> messages;

    private Map<String, String> map;

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public JsonThirdObject() {
        this.messages = new ArrayList<String>() {
            {

                add("You wouldn't hit a man with no trousers..");

                add("At this point, I'd set you up with a..");

                add("You know, your bobby dangler, giggle stick,..");
            }
        };

        this.map = new HashMap<String, String>() {//214k
            {

                for (int i =0;i<9000;i++) {
                    put("value+"+i,"key="+i);
                }
            }

        };
//        this.map = new HashMap<String, String>() {//27.8M
//            {
//
//                for (int i =0;i<1000000;i++) {
//                    put("value+"+i,"key="+i);
//                }
//            }
//
//        };

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
        return "JsonThirdObject{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", messages=" + messages +
                '}';
    }
}
