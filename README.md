<h1>SIEM Event Processor</h1>
<p>This is simple CLI client with built-in command to analyze JSON output from 
   Akamai SIEM OPEN API
</p>
<h3>Prerequisite</h3>
<p>
    <ul>
        <li>Java installed in the local (note: I use JAVA 11 in this sample, but if you have different JAVA version locally, change the "properties" tag in pom.xml
        <li>Maven installed in local</li>
    </ul>    
</p>
<h3>Setup</h3>
<p>
    <ul>
        <li>Clone this project</li>
        <li>Go to that root dir of the project</li>
        <li>Run Maven install - $mvn clean install</li>
        <li>Run: $java -jar target/SIEMProcessor.jar</li>
    </ul>
</p>

<h3>How to use this client</h3>
<p>This CLI takes 2 - 3 arguments separated by a single space depends on the command and options that you'd like to run:
    <ul>
        <li>(Required) args[0] is Full path to JSON file containing JSON body from SIEM call</li>
        <li>(Required) args[1] is Command</li>
        <li>(Optional) args[2] is for command countEventByPolicy specify the policyId</li>                                
    </ul>
</p>
<p>Some predefined commands:
    <ul>
        <li>getBeginAndEndTimestamps - after sorting by date all the SIEM event,
            it output the timestamp of first event and last event
        </li>
        <li>countUniqueIps - output all the unique Client IP and the total number</li>
        <li>countEventByPolicy - output total number of SIEM event by policy - take one additional arg: policyid</li>
        <li>totalEvent - output the total number of security event in the file</li>
    </ul>
</p>    
<br>
<p>Sample usage:<br>
Coming soon....
<br>
<br>
any feedback or issue, feel free to email esenopra@akamai.com with subject "OpenCLIClient - Feedback"
</p>
