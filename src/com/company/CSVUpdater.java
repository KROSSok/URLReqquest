package com.company;
import java.io.*;
import java.util.TimerTask;


import com.opencsv.CSVWriter;


public class CSVUpdater {
    void updateDataInCSV(String data, String filename) throws Exception {
        JSONToCSVWriter jsonToCSVWriter = new JSONToCSVWriter();
        jsonToCSVWriter.getDataByKey(data);

        String [] urlData = {
                JSONToCSVWriter.success.toString(),
                JSONToCSVWriter.lowest_price,
                JSONToCSVWriter.volume,
                JSONToCSVWriter.median_price,
                java.util.Calendar.getInstance().getTime().toString()
        };

        CSVWriter writer = new CSVWriter(new FileWriter(filename, true));
        writer.writeNext(urlData, false);
        writer.close();
    }

}