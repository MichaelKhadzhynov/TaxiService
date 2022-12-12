# Taxi Service App 
*****

Before using ***History Recording*** function in TaxiService, 
we must do some steps:</br>
1. Download HistoryRecording source from my GitHub by this link [HistoryRecording](https://github.com/MichaelKhadzhynov/HistoryRecording).
3. Open TaxiService project.
4. Add HistoryRecording source in TaxiService External Libraries and  do `reload all maven projects`.
5. Check **pom.xml** file of TaxiService source it must have this dependency: 
```xml
<dependency>
<groupId>history-recording</groupId>
<artifactId>history-recording</artifactId>
<version>1.0</version>
</dependency>
```

