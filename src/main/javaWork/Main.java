package main.javaWork;

import main.javaWork.controller.Controller;
import main.javaWork.model.Model;
import main.javaWork.view.UserView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Model model=new Model();
        Controller controller=new Controller(model);
        UserView userView=new UserView(controller);
        SwingUtilities.invokeLater(()->{
            userView.init();
        });
    }
}
