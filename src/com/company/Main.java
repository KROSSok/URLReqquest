package com.company;

public class Main {


    private static final long TIME_INTERVAL = 60000;

    public static void main(String[] args) throws Exception {
        String jsonData;
        String url;
        Config config = new Config();
        url = config.getURL("url");
        URLData urlData = new URLData();
        jsonData = urlData.getDataFromURL(url);
        JSONToCSVWriter jsonToCSVWriter = new JSONToCSVWriter();
        jsonToCSVWriter.getDataByKey(jsonData);
        jsonToCSVWriter.writeDataFromURLToCSV("steamData.csv");

        Runnable runnable = () -> {
            while (true) {
                try {
                    jsonToCSVWriter.getDataByKey(urlData.getDataFromURL(url));
                    System.out.println(urlData.getDataFromURL(url));
                    jsonToCSVWriter.writeDataFromURLToCSV("steamData.csv");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(TIME_INTERVAL);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}