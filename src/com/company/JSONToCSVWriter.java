package com.company;
import com.opencsv.CSVWriter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONToCSVWriter {

        private MarketItem item = new MarketItem();

    void getDataByKey(String data)throws Exception{
        JSONParser jsonParser = new JSONParser();
        Object object = jsonParser.parse(data);
        JSONObject jParser = (JSONObject) object;
        item.setSuccess((Boolean) jParser.get("success"));
        item.setLowest_price((String) jParser.get("lowest_price"));
        item.setVolume((String) jParser.get("volume"));
        item.setMedian_price((String) jParser.get("median_price"));
    }
    void writeDataFromURLToCSV(String csv) throws Exception {

        String [] urlData = {item.getSuccess().toString(),
                item.getLowest_price(),
                item.getVolume(),
                item.getMedian_price(),
                java.util.Calendar.getInstance().getTime().toString()};
        String [] header = {"success", "lowest_price", "volume", "media_price", "time"};
        if(Files.exists(Paths.get("steamData.csv"))){
            CSVWriter writer = new CSVWriter(new FileWriter(csv, true));
            writer.writeNext(urlData, false);
            writer.close();
        }
        else {
            CSVWriter writer = new CSVWriter(new FileWriter(csv));
            writer.writeNext(header, false);
            writer.writeNext(urlData, false);
            writer.close();
        }
    }
}
