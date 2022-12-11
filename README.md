# Taxi Service App 
*****

Before using ***History Recording*** function in TaxiService, 
we must do some steps:</br>
1. Download HistoryRecording source from my GitHub by this link [HistoryRecording](https://github.com/MichaelKhadzhynov/HistoryRecording).
2. Open HistoryRecording project and do `mvn clean install`.
3. Open TaxiService project.
4. Check **pom.xml** file of TaxiService source it must have this dependency: 
```xml
<dependency>
<groupId>history-recording</groupId>
<artifactId>history-recording</artifactId>
<version>1.0</version>
</dependency>
```
4. Then when you open maven libraries in TaxiService project and selected any class <br>
from history-recording libraries IntelliJ IDEA will offer install path to HistoryRecording source file, do it.
