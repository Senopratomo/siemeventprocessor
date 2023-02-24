package org.senolab.siemeventprocessor.controller;

import com.google.gson.*;
import org.senolab.siemeventprocessor.model.siemjson.Event;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class SIEMParser {

    public static void getBeginAndEndTimestamps(String jsonFile) throws FileNotFoundException {
        JsonStreamParser jsonStreamParser = new JsonStreamParser(
                new InputStreamReader(
                        new FileInputStream(jsonFile), StandardCharsets.UTF_8));
        Gson gson = new GsonBuilder().create();
        Event event = null;
        long beginTime = 0, endTime = 0;
        while (jsonStreamParser.hasNext()) {
            JsonElement jsonElement = jsonStreamParser.next();
            if(jsonElement.isJsonObject()) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                if (jsonObject.has("type")) {
                    event = gson.fromJson(jsonObject, Event.class);
                }
            }
            if(event != null) {
                long startTime = Long.parseLong(event.getHttpMessage().getStart());
                if(beginTime < 1) beginTime = startTime;
                if (startTime < beginTime) {
                    beginTime = startTime;
                }
                if (startTime > endTime) {
                    endTime = startTime;
                }
            }
        }
        System.out.println("Start time in this data collection : "+beginTime);
        System.out.println("End time in this data collection : "+endTime);
    }

    public static void countUniqueIps(String jsonFile) throws FileNotFoundException {
        JsonStreamParser jsonStreamParser = new JsonStreamParser(
                new InputStreamReader(
                        new FileInputStream(jsonFile), StandardCharsets.UTF_8));
        Gson gson = new GsonBuilder().create();
        Event event = null;
        HashSet<String> uniqueIps = new HashSet<String>();
        while (jsonStreamParser.hasNext()) {
            JsonElement jsonElement = jsonStreamParser.next();
            if(jsonElement.isJsonObject()) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                if (jsonObject.has("type")) {
                    event = gson.fromJson(jsonObject, Event.class);
                }
            }
            if(event != null) {
                uniqueIps.add(event.getAttackData().getClientIP());
            }
        }
        for(String ip : uniqueIps) {
            System.out.println(ip);
        }
        System.out.println("Total Unique IPs: "+uniqueIps.size());
    }

    public static void countEventByPolicy(String jsonFile, String policyId) throws FileNotFoundException {
        JsonStreamParser jsonStreamParser = new JsonStreamParser(
                new InputStreamReader(
                        new FileInputStream(jsonFile), StandardCharsets.UTF_8));
        Gson gson = new GsonBuilder().create();
        Event event = null;
        int totalNumberOfEvents = 0;
        while (jsonStreamParser.hasNext()) {
            JsonElement jsonElement = jsonStreamParser.next();
            if(jsonElement.isJsonObject()) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                if (jsonObject.has("type")) {
                    event = gson.fromJson(jsonObject, Event.class);
                    if(event.getAttackData().getPolicyId().equalsIgnoreCase(policyId)) {
                        totalNumberOfEvents++;
                    }
                }
            }
        }
        System.out.println("Total number of events for policy id "+policyId+" is "+totalNumberOfEvents);
    }

    public static void totalEvent(String jsonFile) throws FileNotFoundException {
        JsonStreamParser jsonStreamParser = new JsonStreamParser(
                new InputStreamReader(
                        new FileInputStream(jsonFile), StandardCharsets.UTF_8));
        Gson gson = new GsonBuilder().create();
        Event event = null;
        int numOfEvents = 0;
        while (jsonStreamParser.hasNext()) {
            JsonElement jsonElement = jsonStreamParser.next();
            if(jsonElement.isJsonObject()) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                if (jsonObject.has("type")) {
                    numOfEvents++;
                }
            }
        }
        System.out.println("Total number of events: "+numOfEvents);
    }

    public static void countEventByTimestamps(String jsonFile, long start, long end) throws FileNotFoundException {
        JsonStreamParser jsonStreamParser = new JsonStreamParser(
                new InputStreamReader(
                        new FileInputStream(jsonFile), StandardCharsets.UTF_8));
        Gson gson = new GsonBuilder().create();
        Event event = null;
        int numOfEvents = 0;
        while (jsonStreamParser.hasNext()) {
            JsonElement jsonElement = jsonStreamParser.next();
            if(jsonElement.isJsonObject()) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                if (jsonObject.has("type")) {
                    event = gson.fromJson(jsonObject, Event.class);
                    long timestamp = Long.parseLong(event.getHttpMessage().getStart());
                    if(timestamp >= start && timestamp <= end) {
                        numOfEvents++;
                    }
                }
            }
        }
        System.out.println("Total number of events between "+start+" and "+end+" : "+numOfEvents);
    }

    public static void countUniqueRequestIds(String jsonFile) throws FileNotFoundException {
        JsonStreamParser jsonStreamParser = new JsonStreamParser(
                new InputStreamReader(
                        new FileInputStream(jsonFile), StandardCharsets.UTF_8));
        Gson gson = new GsonBuilder().create();
        Event event = null;
        HashSet<String> uniqueRequestIds = new HashSet<String>();
        while (jsonStreamParser.hasNext()) {
            JsonElement jsonElement = jsonStreamParser.next();
            if(jsonElement.isJsonObject()) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                if (jsonObject.has("type")) {
                    event = gson.fromJson(jsonObject, Event.class);
                }
            }
            if(event != null) {
                uniqueRequestIds.add(event.getHttpMessage().getRequestId());
            }
        }
        for(String requestId : uniqueRequestIds) {
            System.out.println(requestId);
        }
        System.out.println("Total Unique IPs: "+uniqueRequestIds.size());
    }

    public static void getStringValueBasedOnKey(String key, String file) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Path.of(file));
        } catch (IOException e) {
            System.out.println("Error occurred during reading of the file! Please check whetehr " +
                    "the full path of the file is correct OR whether the file exist in the path specified!");
            e.printStackTrace();
        }
        for (String line: lines) {
            if(line.startsWith(key)) {
                String[] splitted = line.split(":");
                System.out.println(splitted[1].trim());
            }
        }
    }

    public static void isFirstFileSubsetOfSecondFile(String firstFile, String secondFile) {
        try {
            List<String> firstFileList = Files.readAllLines(Path.of(firstFile));
            List<String> secondFileList = Files.readAllLines(Path.of(secondFile));
            Set<String> firstFileSet = new HashSet<>(firstFileList);
            Set<String> secondFileSet = new HashSet<>(secondFileList);
            if (secondFileSet.containsAll(firstFileSet)) {
                System.out.println("All items in "+firstFile+ " exist in "+secondFile+".");
            } else {
                System.out.println("Some (if not all) items in "+firstFile+ "does NOT exist in "+secondFile+".");
            }
        } catch (IOException e) {
            System.out.println("Error occurred during reading of the file! Please check whetehr " +
                    "the full path of the file is correct OR whether the file exist in the path specified!");
            e.printStackTrace();
        }
    }
}
