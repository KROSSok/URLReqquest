package com.company;
import com.opencsv.CSVWriter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import static java.lang.System.lineSeparator;

public class Config {
    static String data;
    static Boolean urls;
    static String urls1;
    static String urls2;
    static String urls3;

    class JsonParser {
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

    void csvWriter(String key) throws Exception {
        JsonParser parser = new JsonParser();
        String url = parser.getURL(key);

        try (Scanner scanner = new Scanner(new URL(url).openStream(), StandardCharsets.UTF_8.toString())) {
            data = (scanner.hasNext() ? scanner.next() : " ");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        JSONParser jsonParser = new JSONParser();
        Object object = jsonParser.parse(data);
        JSONObject jParser = (JSONObject) object;
        urls = (Boolean) jParser.get("success");
        urls1 = (String) jParser.get("lowest_price");
        urls2 = (String) jParser.get("volume");
        urls3 = (String) jParser.get("median_price");

        String[] myData = {urls.toString(), urls1, urls2, urls3};
        String csv = "steamData.csv";
        CSVWriter writer = new CSVWriter(new FileWriter(csv));
        writer.writeNext(myData, Boolean.parseBoolean(lineSeparator()));
        writer.close();
    }
}