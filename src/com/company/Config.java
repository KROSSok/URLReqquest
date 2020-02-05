package com.company;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;


public class Config {

    String getURL(String key) {
        String url = new String();
        JSONParser jsonParser = new JSONParser();
        try {
            Object object = jsonParser.parse(new FileReader("steamUrl.json"));
            JSONObject parser = (JSONObject) object;
            url = (String) parser.get(key);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return url;
    }
}
