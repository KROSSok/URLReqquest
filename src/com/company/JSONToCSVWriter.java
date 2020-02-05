package com.company;
import com.opencsv.CSVWriter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileWriter;
import java.util.Date;

public class JSONToCSVWriter {

    static Boolean success;
    static String lowest_price;
    static String volume;
    static String median_price;

    void getDataByKey(String data)throws Exception{
        JSONParser jsonParser = new JSONParser();
        Object object = jsonParser.parse(data);
        JSONObject jParser = (JSONObject) object;
        success = (Boolean) jParser.get("success");
        lowest_price = (String) jParser.get("lowest_price");
        volume = (String) jParser.get("volume");
        median_price = (String) jParser.get("median_price");
    }
    void writeDataFromURLToCSV(String csv) throws Exception {
        String [] urlData = {success.toString(), lowest_price, volume, median_price, java.util.Calendar.getInstance().getTime().toString()};
        String [] header = {"success", "lowest_price", "volume", "media_price", "time"};
        CSVWriter writer = new CSVWriter(new FileWriter(csv));
        writer.writeNext(header, false);
        writer.writeNext(urlData, false);
        writer.close();
    }
}
