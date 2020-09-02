package org.senolab.siemeventprocessor;

import org.senolab.siemeventprocessor.controller.SIEMParser;

import java.io.FileNotFoundException;

public class App {

    public static void main(String[] args) {
        if(args.length == 2) {
            try {
                switch (args[1]) {
                    case "getBeginAndEndTimestamps":
                        SIEMParser.getBeginAndEndTimestamps(args[0]);
                        break;
                    case "countUniqueIps":
                        SIEMParser.countUniqueIps(args[0]);
                        break;
                    case "totalEvent":
                        SIEMParser.totalEvent(args[0]);
                        break;
                    default:
                        System.out.println("You specify incorrect command! Please try again");
                }
            } catch (FileNotFoundException e) {
                System.out.println("There is no file with specified path! Please ensure that file exist in the path you specified!");
                e.printStackTrace();
            }
        } else if (args.length == 3) {
            try {
                switch (args[1]) {
                    case "countEventByPolicy":
                        SIEMParser.countEventByPolicy(args[0], args[2]);
                        break;
                    case "countEventByTimestamps":
                        String[] timestamps = args[2].split("-");
                        long start = Long.parseLong(timestamps[0]);
                        long end = Long.parseLong(timestamps[1]);
                        SIEMParser.countEventByTimestamps(args[0], start, end);
                        break;
                    default:
                        System.out.println("You specify incorrect command! Please try again");
                }
            } catch (FileNotFoundException e) {
                System.out.println("There is no file with specified path! Please ensure that file exist in the path you specified!");
                e.printStackTrace();
            }
        } else {
            System.out.println("This SIEM event processor CLI takes 2-3 arguments: \n" +
                    "1) Full path to JSON file containing JSON body from SIEM call \n" +
                    "2) Command \n" +
                    "3) (optional) for command countEventByPolicy specify the policyId\n\n" +
                    "Some predefined command are: \n" +
                    "1) getBeginAndEndTimestamps - after sorting by date all the SIEM event, " +
                    "it output the timestamp of first event and last event \n" +
                    "2) countUniqueIps - output all the unique Client IP and the total number \n" +
                    "3) countEventByPolicy - output total number of SIEM event by policy - take one additional arg: policyid\n" +
                    "4) totalEvent - output the total number of security event in the JSON file\n" +
                    "5) countEventByTimestamps - output the total number of security event in the JSON file within start and end timestamps args" +
                    " - take one additional arg start and end timestamp (in epoch format) separated by '-' (dash): {startTimestamp}-{endTimestamp}\n" +
                    "\n" +
                    "Sample usage: \n" +
                    "1) java -jar SIEMProcessor.jar /home/user/siem_output.json getBeginAndEndTimestamps\n" +
                    "2) java -jar SIEMProcessor.jar /home/user/siem_output.json countUniqueIps\n" +
                    "3) java -jar SIEMProcessor.jar /home/user/siem_output.json countEventByPolicy policy_1234\n" +
                    "4) java -jar SIEMProcessor.jar /home/user/siem_output.json totalEvent\n" +
                    "5) java -jar SIEMProcessor.jar /home/user/siem_output.json countEventByTimestamps 1599030062-1599030262\n\n");
        }
    }

}
