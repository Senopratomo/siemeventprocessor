package org.senolab.siemeventprocessor.controller;

import com.google.gson.*;
import org.senolab.siemeventprocessor.model.Event;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;

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
}
