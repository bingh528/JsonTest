package us.bingh.json;


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsonTest {
    private static final int loop = 1499;

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

//        jackson
//        Json json = new Json();
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        try {
//            objectMapper.writeValue(new File("jackson.json"),json);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Read JSON from file, convert JSON back to object");

//        try {
//
//            Json jsonObj = objectMapper.readValue(new File("jackson.json"), Json.class);
//
//        } catch (JsonGenerationException e) {
//
//        } catch (JsonMappingException e) {
//
//        } catch (IOException e) {
//
//        }

        //gson


//        Json jsonObj = new Json();
//
//        Gson gson = new Gson();
//
//
//        System.out.println("Convert Java object to JSON format and save to file");
//
//        try (FileWriter writer = new FileWriter("gson.json")) {
//
//            writer.write(gson.toJson(jsonObj));
//
//        } catch (IOException e) {
//
//
//        }


//        System.out.println("Read JSON from file, convert JSON string back to object");
//
//        try (BufferedReader reader = new BufferedReader(new FileReader("gson.json"))) {
//
//            Json jsonObj = gson.fromJson(reader, Json.class);
//
//        } catch (FileNotFoundException e) {
//
//        } catch (IOException e) {
//        }


        //json-lib
        Json jsonObj = new Json();

//        net.sf.json.JSONObject json;
//
//        System.out.println("Convert Java object to JSON format and save to file");
//
//        try (FileWriter writer = new FileWriter("json-lib.json")) {
//
//            json = net.sf.json.JSONObject.fromObject(jsonObj);
//
//            json.write(writer);
//
//        } catch (IOException e) {
//
//        }

        System.out.println("Read JSON from file, convert JSON string back to object");

        try (BufferedReader reader = new BufferedReader(new FileReader("json-lib.json"))) {

            jsonObj = (Json) net.sf.json.JSONObject.toBean(net.sf.json.JSONObject.fromObject(reader), Json.class);

        } catch (IOException ex) {

        }


        //fastjson
//        Json jsonObj = new Json();
//
//
//        System.out.println("Convert Java object to JSON format and save to file");
//
//        try (FileWriter writer = new FileWriter("fastjson.json")) {
//
//            JSON.writeJSONString(writer,jsonObj);
//
//        } catch (IOException e) {
//
//        }

//        System.out.println("Read JSON from file, convert JSON string back to object");
//
//        try (FileInputStream reader = new FileInputStream(new File("gson.json"))) {
//
//            Object object = JSON.parseObject(reader, Json.class);
//
//        } catch (FileNotFoundException e) {
//
//        } catch (IOException e) {
//        }
//
        //FlexJson

//        Json jsonObj = new Json();
//
//        flexjson.JSONSerializer serializer = new JSONSerializer();
//
//        System.out.println("Convert Java object to JSON format and save to file");
//
//        try (FileWriter writer = new FileWriter("flexjson.json")) {
//
//            serializer.deepSerialize(jsonObj, writer);
//
//        } catch (IOException e) {
//
//        }
//
//
//        System.out.println("Read JSON from file, convert JSON string back to object");
//
//        try (BufferedReader reader = new BufferedReader(new FileReader("flexjson.json"))) {
//
//            new JSONDeserializer<Json>().deserialize(reader);
//        } catch (FileNotFoundException e) {
//
//        } catch (IOException e) {
//
//
//        }

        //json-io

//        Json jsonObj = new Json();
//
//        System.out.println("Convert Java object to JSON format and save to file");
//
//        try (JsonWriter writer = new JsonWriter(new FileOutputStream("json-io.json"))){
//
//            writer.write(jsonObj);
//
//        } catch (IOException e) {
//
//        }
//
//
//        System.out.println("Read JSON from file, convert JSON string back to object");
//
//        try (JsonReader reader = new JsonReader(new FileInputStream(new File("json-io.json")))) {
//
//            reader.readObject();
//
//        } catch (FileNotFoundException e) {
//
//        } catch (IOException e) {
//
//        }

        //Genson

//        Json jsonObj = new Json();
//
//        Genson genson = new Genson();
//
//        System.out.println("Convert Java object to JSON format and save to file");
//
//        try (FileWriter writer = new FileWriter("genson.json")) {
//
//            writer.write(genson.serialize(jsonObj));
//
//        } catch (IOException e) {
//
//        }

//        System.out.println("Read JSON from file, convert JSON string back to object");
//
//        try (BufferedReader reader = new BufferedReader(new FileReader("genson.json"))) {
//
//            genson.deserialize(reader, Json.class);
//
//        } catch (FileNotFoundException e) {
//
//        } catch (IOException e) {
//
//        }


        //JSONiJ
//        Json jsonObj = new Json();

//        System.out.println("Convert Java object to JSON format and save to file");
//
//        try (FileWriter writer = new FileWriter("jsonij.json")) {
//
//            writer.write(JSONMarshaler.marshalObject(jsonObj).toJSON());
//
//        } catch (IOException e) {
//
//        }

//        System.out.println("Read JSON from file, convert JSON string back to object");
//
//        try (BufferedReader reader = new BufferedReader(new FileReader("jsonij.json"))) {
//
//            cc.plural.jsonij.JSON json = cc.plural.jsonij.JSON.parse(reader);
//
//
//            // Now we need to parse the JSONObject object and put values back
//
//            // to our Json object
//
//            for (Field field : jsonObj.getClass().getDeclaredFields()) {
//
//                try {
//
//                    field.setAccessible(true);
//
//                    field.set(field.getName(), json.get(field.getName()));
//
//                } catch (IllegalArgumentException | IllegalAccessException e) {
//
//                }
//
//            }
//
//        } catch (FileNotFoundException e) {
//
//        } catch (IOException | ParserException e) {
//
//        }


        long end = System.currentTimeMillis();

        System.out.println("运行时间  = " + (end - start) + "ms");
        long max = Runtime.getRuntime().maxMemory() / (1024 * 1024);//最大可用内存，对应-Xmx

        long free = Runtime.getRuntime().freeMemory() / (1024 * 1024);//当前JVM空闲内存
        long total = Runtime.getRuntime().totalMemory() / (1024 * 1024);//当前JVM占用的内存总数，其值相当于当前JVM已使用的内存及freeMemory()的总和


        System.out.print("最大可用内存 = " + max + "  ，空闲内存 = " + free + "   ， 占用内存数 = " + (total - free));

    }

    private static void iteratorloop(List list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
    }

    private static List createList() {
        List list = new ArrayList(1);
        for (int i = 0; i < list.size(); i++) {
            list.add(i);
        }
        return list;
    }

}
