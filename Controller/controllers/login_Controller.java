package Controller.controllers;


import Help.Validation;
import Model.PageLoader;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class login_Controller{


    @FXML
    private Label label_for_pass;
    @FXML
    private Label label_for_username;
    @FXML
    private PasswordField password_field;
    @FXML
    private Button login_button;
    @FXML
    private Button signup_button;
    @FXML
    private TextField show_password;
    @FXML
    private TextField username_field;


    void loginfunc() {
        (new Thread(this.LoginHandler())).start();
    }

    private Runnable LoginHandler() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String username = username_field.getText();
                if (username.isEmpty() && password_field.getText().isEmpty()) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            label_for_username.setText("No username provided!");
                            label_for_username.setVisible(true);
                            label_for_pass.setText("No password provided!");
                            label_for_pass.setVisible(true);
                        }
                    });
                    return;
                }
                if (!username.isEmpty() && Validation.isAlphaNumeric(username_field.getText()) && password_field.getText().isEmpty()) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            label_for_username.setVisible(false);
                            label_for_pass.setText("No password provided.");
                            label_for_pass.setVisible(true);
                        }
                    });
                    return;
                }
                if (!Validation.isAlphaNumeric(username_field.getText()) && password_field.getText().isEmpty()) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            label_for_username.setText("Invalid username!");
                            label_for_username.setVisible(true);
                            label_for_pass.setText("No password provided!");
                            label_for_pass.setVisible(true);
                        }
                    });
                    return;
                }
                if (!Validation.isAlphaNumeric(username_field.getText()) && !Validation.isAlphaNumeric(password_field.getText()) || password_field.getText().length() < 8) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            label_for_username.setText("Invalid username!");
                            label_for_username.setVisible(true);
                            label_for_pass.setText("Invalid password!");
                            label_for_pass.setVisible(true);
                        }
                    });
                    return;
                }
                if(!username.isEmpty() && (Validation.isAlphaNumeric(password_field.getText())||!Validation.isAlphaNumeric(password_field.getText()))){
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            label_for_username.setText("No username provided!");
                            label_for_username.setVisible(true);
                            label_for_pass.setVisible(false);
                        }
                    });
                    return;
                }
                String password = password_field.getText();
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        label_for_pass.setText("Logging in...");
                        label_for_pass.setVisible(true);
                    }
                });
//                try {
//                    DB.oos.writeObject(new LoginCommand(username, password));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            }
        };
        return runnable;
    }


    public void login(ActionEvent actionEvent) throws IOException {
        this.loginfunc();

    }

    public void signup(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("signup");
    }

    public void show_pass(ActionEvent actionEvent) {

        if (!show_password.isVisible()) {
            show_password.setVisible(true);
            show_password.setText(password_field.getText());
        } else {
            show_password.setVisible(false);
            show_password.setText(show_password.getText());
        }
    }
}

