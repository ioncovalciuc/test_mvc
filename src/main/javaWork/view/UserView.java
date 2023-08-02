package main.javaWork.view;

import main.javaWork.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class UserView extends JFrame {
    private JTextArea textArea;
    private JButton sendButton;
    private JLabel info;
    private Controller controller;
    public UserView(Controller controller){
        this.controller=controller;
    }
    public void init(){
        setSize(500,400);
        textArea=new JTextArea();
        sendButton=new JButton("Send");
        info=new JLabel("Info");

        add(textArea, BorderLayout.CENTER);
        add(sendButton,BorderLayout.SOUTH);
        add(info,BorderLayout.NORTH);

        sendButton.addActionListener(e -> {
            int pin;
            String textPin=this.textArea.getText();
            pin=Integer.parseInt(textPin);
            info.setText("Got it:"+pin);

            controller.checkPin(pin);
            // abrabotca pincoda


        });

        setVisible(true);

    }

//    private void checkPin() {
//
//    }


}
