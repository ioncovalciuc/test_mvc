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
            textArea.setText("");
            try {
                pin=Integer.parseInt(textPin);
                info.setText("Got it:"+pin+"Waiting...");


                Thread thread=new Thread(()->{
                    sendButton.setEnabled(false);
                    boolean result;
                    result=controller.checkPin(pin);
                    String resultMessage;
                    if(result){
                        resultMessage="Right";
                    }else {
                        resultMessage="Wrong, try again";
                    }
                    info.setText(resultMessage);
                    sendButton.setEnabled(true);

                });
                thread.start();
            } catch (NumberFormatException ex) {
                info.setText("Only numbers allowed...");
            }


            // abrabotca pincoda


        });

        setVisible(true);

    }

//    private void checkPin() {
//
//    }


}
