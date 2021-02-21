package com.example.MMTLog;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessLog {

    static List<Map<String, Object>> fileData = new ArrayList<>();

    public void readLogsFromFile(String filePath, String[] keys) {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(filePath))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            System.out.println("Read JSON file " + obj);

//            JSONArray fileInput = (JSONArray) obj;
//            System.out.println(fileInput);
//
//            //Iterate over employee array
//            fileInput.forEach( emp -> saveFileData( (JSONObject) emp, keys ) );
            saveFileData( (JSONObject) obj, keys );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void saveFileData(JSONObject jsonObject, String[] keyNames) {

        Map<String, Object> map = new HashMap<>();

        for(String keyName : keyNames) {
            try{
                Object keyValue =  jsonObject.get(keyName);
                map.put(keyName, keyValue);
                System.out.println("Stored keyName and keyValue in Map " + keyName  +  " " + keyValue);
            }catch (Exception e) {
                System.out.println("Key doesn't exist name " +  keyName);
            }
        }
        fileData.add(map);
    }
}
