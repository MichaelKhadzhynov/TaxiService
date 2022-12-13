package com.solvd.TaxiService;


import com.solvd.TaxiService.Person.Client;
import com.solvd.TaxiService.Person.Dispatcher;
import com.solvd.TaxiService.Taxi.Order;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

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

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);


    public static void main(String[] args) throws IOException {


        // Order creation
        Order order = new Order();
        order.orderParametersInput();

        // New client
        Client client = new Client();
        client.setOrder(order);

        // New dispatcher
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setClient(client);
        order.getTaxi().getDriversAndCars().getDriver().setDispatcher(dispatcher);

        // Get order confirmed result and recording order history
        order.confirmedOrderResult();
        order.orderHistoryRecording();









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


//        Order order = new Order(TaxiCars.CROSSOVER, 15, 2, "yes",
//                "yes", "no", "no", "no");