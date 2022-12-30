package com.solvd.TaxiService.GUI;

import com.solvd.TaxiService.Person.Client;
import com.solvd.TaxiService.Person.Dispatcher;
import com.solvd.TaxiService.Taxi.Order;
import com.solvd.TaxiService.enums.TaxiCars;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;

public class TaxiSimpleGUI extends JFrame {

    private final TaxiCars[] cars = {TaxiCars.LIMOUSINE, TaxiCars.CROSSOVER, TaxiCars.PICKUP};
    protected final JComboBox<TaxiCars> inputTypeCar = new JComboBox(cars);
    protected final JTextField inputDistance = new JTextField(5);
    protected final JTextField inputPassengerNumber = new JTextField(5);
    protected final JCheckBox internetInCar = new JCheckBox("Internet in car:", false);
    protected final JCheckBox animalTransportation = new JCheckBox("Animal transportation:", false);
    protected final JCheckBox conditioner = new JCheckBox("Conditioner:", false);
    protected final JCheckBox silenceInCar = new JCheckBox("SilenceInCar:", false);
    protected final JCheckBox LuggageInCabin = new JCheckBox("Luggage in cabin:", false);
    protected final JLabel distanceLabel = new JLabel(" Input distance:");
    protected final JLabel carTypeLabel = new JLabel(" Input car type:");
    protected final JLabel passNumberLabel = new JLabel(" Input passengers number:");

    public TaxiSimpleGUI() {
        super("Taxi Service");
        this.setBounds(500, 250, 350, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(10, 2));
        container.setBackground(Color.GRAY.brighter());
        container.add(carTypeLabel);
        container.add(inputTypeCar);

        container.add(passNumberLabel);
        container.add(inputPassengerNumber);

        container.add(distanceLabel);
        container.add(inputDistance);

        container.add(internetInCar);
        container.add(animalTransportation);
        container.add(conditioner);
        container.add(silenceInCar);
        container.add(LuggageInCabin);

        JButton confirm = new JButton("Confirm order");

        confirm.addActionListener(new ButtonEventListener());
        container.add(confirm);
    }

    class ButtonEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Order order = new Order();


            order.setTaxi((TaxiCars) inputTypeCar.getSelectedItem());

            int pasNum = Integer.parseInt(inputPassengerNumber.getText());
            order.setPassengerNumber(pasNum);
            int distance = Integer.parseInt(inputDistance.getText());
            order.setDistanceOfDriving(distance);

            if (internetInCar.isSelected()) order.setInternetInCar("yes");
            else order.setInternetInCar("no");
            if (animalTransportation.isSelected()) order.setAnimalTransportation("yes");
            else order.setAnimalTransportation("no");
            if (conditioner.isSelected()) order.setConditioner("yes");
            else order.setConditioner("no");
            if (silenceInCar.isSelected()) order.setSilenceInCar("yes");
            else order.setSilenceInCar("no");
            if (LuggageInCabin.isSelected()) order.setLuggageInCabin("yes");
            else order.setLuggageInCabin("no");

            String massage = "";
            if (order.getPrice() > 0 && order.orderConfirm()) {
                massage += ("Price - " + order.getPrice() + "\n"
                        + "Car model - " + order.getTaxi().getDriversAndCars().getCar().getModel() + "\n"
                        + "Car number - " + order.getTaxi().getDriversAndCars().getCar().getCarNumber() + "\n"
                        + "Driver name - " + order.getTaxi().getDriversAndCars().getDriver().getName() + "\n"
                        + "Driver phone number - +380" + order.getTaxi().getDriversAndCars().getDriver().getPhoneNumber() + "\n"
                        + "Driver knowledge of city Level - " + order.getTaxi().getDriversAndCars().getDriver().getKnowledgeOfCity() + "\n"
                        + "Driver license expired date - " + order.getTaxi().getDriversAndCars().getDriver().getLicense().getDateOfExpired() + "\n"
                        + "Order creation time - " + LocalDateTime.now());
            } else massage += "Try again";

            JOptionPane.showMessageDialog(null, massage, "Order Result", JOptionPane.PLAIN_MESSAGE);

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


        }
    }
}
