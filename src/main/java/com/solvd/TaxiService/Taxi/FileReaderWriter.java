package com.solvd.TaxiService.Taxi;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;

public class FileReaderWriter {
    public static void fileReaderWriter() throws IOException {
        String fromFile = "/Users/michael/div/IntelejIDEA Project/TaxiService/src/main/resources/history/orderHistory.txt";
        String toFile = "/Users/michael/div/IntelejIDEA Project/TaxiService/src/main/resources/history/newFile.txt";


        String content = FileUtils.readFileToString(new File(fromFile), Charset.defaultCharset())
                .replaceAll("\\n+", " ").replaceAll("[^a-zA-Z ]", "")
                .replaceAll("\\s+", " ").toLowerCase(Locale.ROOT);
        List<String> list = Arrays.asList(content.split(" "));
        Map<String, Long> wordsMap = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Files.write(Path.of(toFile), wordsMap.entrySet().stream().map(k -> k.getKey() + " - " + k.getValue()).collect(Collectors.toList()), UTF_8);

    }
}
