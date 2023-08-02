package main.javaWork;

import main.javaWork.controller.Controller;
import main.javaWork.view.UserView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Controller controller=new Controller();
        UserView userView=new UserView(controller);
        SwingUtilities.invokeLater(()->{
            userView.init();
        });
    }
}
