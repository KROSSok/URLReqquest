package com.company;

public class Main {

    static String jsonData;
    static String url;
    static final long timeInterval = 100000;

    public static void main(String[] args) throws Exception {

        Config config = new Config();
        url = config.getURL("url");
        URLData urlData = new URLData();
        jsonData = urlData.getDataFromURL(url);
        System.out.println(jsonData);
        JSONToCSVWriter jsonToCSVWriter = new JSONToCSVWriter();
        jsonToCSVWriter.getDataByKey(jsonData);
        jsonToCSVWriter.writeDataFromURLToCSV("steamData.csv");
        CSVUpdater csvUpdater = new CSVUpdater();

        Runnable runnable = () -> {
            while (true) {
                // ------- code for task to run
                jsonData = urlData.getDataFromURL(url);
                try {
                    System.out.println(jsonData);
                    csvUpdater.updateDataInCSV(Main.jsonData, "steamData.csv");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(timeInterval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}