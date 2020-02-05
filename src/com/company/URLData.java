package com.company;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class URLData {
    String getDataFromURL(String url) {
        String data = new String();
        try (Scanner scanner = new Scanner(new URL((url)).openStream(), StandardCharsets.UTF_8.toString())) {
            data = (scanner.hasNext() ? scanner.next() : " ");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return data;
    }
}
