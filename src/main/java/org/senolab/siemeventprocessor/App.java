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
                    default:
                        System.out.println("You specify incorrect command! Please try again");
                }
            } catch (FileNotFoundException e) {
                System.out.println("There is no file with specified path! Please ensure that file exist in the path you specified!");
                e.printStackTrace();
            }
        } else {
            System.out.println("This SIEM event processor CLI takes two arguments: \n" +
                    "1) Full path to JSON file containing JSON body from SIEM call \n" +
                    "2) Command \n" +
                    "3) (optional) for command countEventByPolicy specify the policyId\n\n" +
                    "Some predefined command are: \n" +
                    "1) getBeginAndEndTimestamps - after sorting by date all the SIEM event, " +
                    "it output the timestamp of first event and last event \n" +
                    "2) countUniqueIps - output all the unique Client IP and the total number \n" +
                    "3) countEventByPolicy - output total number of SIEM event by policy - take one additional arg: policyid\n" +
                    "4) totalEvent - output the total number of security event in the file");
        }
    }

}
