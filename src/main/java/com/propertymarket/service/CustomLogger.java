package com.propertymarket.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CustomLogger {
    public static void writeToFile(String data) throws IOException {
        File file = new File("/home/shuvo/Desktop/code/java/PropertyMarket/src/main/logs/customlog");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(data.getBytes());
    }

}
