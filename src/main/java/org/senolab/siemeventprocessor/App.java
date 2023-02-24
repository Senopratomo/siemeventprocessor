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
                    case "countUniqueRequestIds":
                        SIEMParser.countUniqueRequestIds(args[0]);
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
                    case "getStringValueBasedOnKey":
                        SIEMParser.getStringValueBasedOnKey(args[2], args[0]);
                        break;
                    case "isSubsetOf":
                        SIEMParser.isFirstFileSubsetOfSecondFile(args[0], args[2]);
                        break;
                    default:
                        System.out.println("You specify incorrect command! Please try again");
                }
            } catch (FileNotFoundException e) {
                System.out.println("There is no file with specified path! Please ensure that file exist in the path you specified!");
                e.printStackTrace();
            }
        } else {
            String instructionMessage = """
                    SIEM data utility processor v1.0
                    
                    This SIEM event processor CLI takes 2-3 arguments: 
                    1) Full path to JSON file containing JSON body from SIEM call
                    2) Command (see below of all possible commands) 
                    3) (optional) additional required argument depends on the command (see below list of possible commands for details) 
                                       
                    Some predefined command are:
                    1) getBeginAndEndTimestamps - after sorting by date all the SIEM event, it output the timestamp of first event and last event
                    2) countUniqueIps - output all the unique Client IP and the total number
                    3) countUniqueRequestIds - output all the unique requestId and the total number
                    4) countEventByPolicy - output total number of SIEM event by policy. 
                       It takes one additional arg: policyid
                    5) totalEvent - output the total number of security event in the JSON file
                    6) countEventByTimestamps - output the total number of security event in the JSON file within start and end timestamps args
                       It takes one additional arg start and end timestamp (in epoch format) separated by '-' (dash): {startTimestamp}-{endTimestamp}
                    7) getStringValueBasedOnKey - It parse a text file and output all values in "key:value" formatted text from each line in the specified text file. 
                       It takes two arguments:
                       - full path to file containing text
                       - the key string
                       see example for details below
                    8) isSubsetOf - it takes two files containing list of items. It will check whether the items in first list is a subset of items in second list.
                       It takes two arguments:
                       - full path to first file containing first list of items (in 1st arg position)
                       - full path to the second file containing second list of items (in 3rd arg position)  
                       see example for details below
                    
                                        
                    Sample usage (in the order of the command above):
                    1) java -jar SIEMProcessor.jar /home/user/siem_output.json getBeginAndEndTimestamps
                    2) java -jar SIEMProcessor.jar /home/user/siem_output.json countUniqueIps
                    3) java -jar SIEMProcessor.jar /home/user/siem_output.json countUniqueRequestIds
                    4) java -jar SIEMProcessor.jar /home/user/siem_output.json countEventByPolicy policy_1234
                    5) java -jar SIEMProcessor.jar /home/user/siem_output.json totalEvent
                    6) java -jar SIEMProcessor.jar /home/user/siem_output.json countEventByTimestamps 1599030062-1599030262
                    7) Given a text file /home/user/sample-text.txt containing the following text:
                       key: value1
                       bla bla bla
                       key: value2
                       another bla bla
                       yet another bla bla
                       key: value3
                       
                       The goal is to extract 'value1', 'value2', and 'value3' based on 'key' (as the key).
                       Command:
                       java -jar SIEMProcessor.jar /home/user/sample-text.txt getStringValueBasedOnKey key
                       
                       output:
                       value1
                       value2
                       value3
                    
                    8) Given two files as follows:
                       First file - /home/user/firstFile.txt contains:   
                       value1
                       value2
                       
                       Second file - /home/user/secondFile.txt contains:
                       value1
                       value2
                       value3
                       
                       The goal is to find out whether the list of items in first file is a subset of list of items in second file
                       Command:
                       java -jar SIEMProcessor.jar /home/user/firstFile.txt isSubsetOf /home/user/secondFile.txt
                       
                       output:
                       All items in /home/user/firstFile.txt exist in /home/user/secondFile.txt
                    
                    any questions or problems, feel free to file a "issue" in the Github repo - https://github.com/Senopratomo/siemeventprocessor   
                    """;
            System.out.println(instructionMessage);
        }
    }

}
