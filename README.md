<h1>SIEM Event Processor</h1>
<p>This is simple CLI client with built-in command to analyze JSON output from 
   Akamai SIEM OPEN API
</p>
<h3>Prerequisite</h3>
<p>
    <ul>
        <li>Java installed in the local (note: I use JAVA 19 in this sample, but if you have different JAVA version locally, change the "properties" tag in pom.xml</li>
        <li>Maven installed in local</li>
    </ul></p>
<h3>Setup</h3>
<p>
    <ul>
        <li>Clone this project</li>
        <li>Go to that root dir of the project</li>
        <li>Run Maven install - $mvn clean install</li>
        <li>Run: $java -jar target/SIEMProcessor.jar</li>
    </ul></p>

<h3>How to use this client</h3>
<p>This CLI takes 2 - 3 arguments separated by a single space depends on the command and options that you'd like to run:
    <ul>
        <li>(Required) args[0] is Full path to JSON file containing JSON body from SIEM call</li>
        <li>(Required) args[1] is Command (see below for list of available commands)</li>
        <li>(Optional) 3) (optional) additional required argument depends on the command (see below list of possible commands for details)</li>                                
    </ul></p>
<p> commands:
    <ul>
        <li>getBeginAndEndTimestamps - after sorting by date all the SIEM event,
            it output the timestamp of first event and last event
        </li>
        <li>countUniqueIps - output all the unique Client IP and the total number</li>
        <li>countRequestIds - output all the unique Request IDs and the total number</li>
        <li>countEventByPolicy - output total number of SIEM event by policy - take one additional arg: policyid</li>
        <li>totalEvent - output the total number of security event in the file</li>
        <li>
          countEventByTimestamps - output the total number of security event in the JSON file within start and end timestamps args<br>
          It takes one additional arg start and end timestamp (in epoch format) separated by '-' (dash): {startTimestamp}-{endTimestamp}
        </li>
        <li>
          getStringValueBasedOnKey - It parse a text file and output all values in "key:value" formatted text from each line in the specified text file.<br>
          It takes two arguments:<br>
          - full path to file containing text<br>
          - the key string<br>
          see example for details below<br>
        </li>
        <li>
          isSubsetOf - it takes two files containing list of items. It will check whether the items in first list is a subset of items in second list.<br>
          It takes two arguments:<br>
          - full path to first file containing first list of items (in 1st arg position)<br>
          - full path to the second file containing second list of items (in 3rd arg position)<br>  
          see example for details below
        </li>
    </ul></p>    
<br>
<p>Sample usage:<br>
    <ul>
        <li>1) java -jar SIEMProcessor.jar /home/user/siem_output.json getBeginAndEndTimestamps</li>
        <li>2) java -jar SIEMProcessor.jar /home/user/siem_output.json countUniqueIps</li>            
        <li>3) java -jar SIEMProcessor.jar /home/user/siem_output.json countEventByPolicy policy_1234</li>
        <li>4) java -jar SIEMProcessor.jar /home/user/siem_output.json totalEvent</li>
        <li>5) java -jar SIEMProcessor.jar /home/user/siem_output.json countEventByTimestamps 1599030062-1599030262</li>
        <li>6) java -jar SIEMProcessor.jar /home/user/siem_output.json countEventByTimestamps 1599030062-1599030262</li>
        <li>
            7) Given a text file /home/user/sample-text.txt containing the following text:<br>
               key: value1<br>
               bla bla bla<br>
               key: value2<br>
               another bla bla<br>
               yet another bla bla<br>
               key: value3<br>
               <br>
               The goal is to extract 'value1', 'value2', and 'value3' based on 'key' (as the key).<br>
               Command:<br>
               java -jar SIEMProcessor.jar /home/user/sample-text.txt getStringValueBasedOnKey key<br>
               <br>       
               output:<br>
               value1<br>
               value2<br>
               value3<br>
        </li>
        <li>
            8) Given two files as follows:<br>
               First file - /home/user/firstFile.txt contains:<br>   
               value1<br>
               value2<br>
               <br>
               Second file - /home/user/secondFile.txt contains:<br>
               value1<br>
               value2<br>
               value3<br>
               <br>       
               The goal is to find out whether the list of items in first file is a subset of list of items in second file<br>
               Command:<br>
               java -jar SIEMProcessor.jar /home/user/firstFile.txt isSubsetOf /home/user/secondFile.txt<br>
               <br>        
               output:<br>
               All items in /home/user/firstFile.txt exist in /home/user/secondFile.txt<br>
        </li>
    </ul>
<br>
<br>
any feedback or issue, feel free to open issues on this repo</p>
