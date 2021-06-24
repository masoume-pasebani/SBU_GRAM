package Client.Controller;

import Client.API;
import Client.ClientEXE;
import Common.Help.Validation;
import Common.Model.Account;
import Common.Model.PageLoader;
import Server.Net.Server;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.io.IOException;

public class Password_recovery_Controller {

    @FXML
    private Label pass_label;
    @FXML
    private ImageView check2;
    @FXML
    private Label pass_q;
    @FXML
    private PasswordField newpass_field;
    @FXML
    private PasswordField confirm_field;
    @FXML
    private Label error;
    @FXML
    private ImageView check;
    @FXML
    private TextField phone_field;
    @FXML
    private TextField username_field;

    public void back_to_login(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("login");
    }


    public void show_change_pass() {
        TranslateTransition transition = new TranslateTransition(Duration.millis(1000), pass_q);
        transition.setToX(-312);
        transition.play();
        TranslateTransition transition1 = new TranslateTransition(Duration.millis(1000), newpass_field);
        transition1.setToX(316);
        transition1.play();
        TranslateTransition transition2 = new TranslateTransition(Duration.millis(1000), confirm_field);
        transition2.setToX(-312);
        transition2.play();
    }

    public void check(MouseEvent mouseEvent) {
        if(username_field.getText().isEmpty() || phone_field.getText().isEmpty()) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    error.setText("No username or Phone number provided!");
                    error.setVisible(true);
                }
            });
            return;

        }

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < Server.accounts.size(); i++) {
                    if (Server.accounts.get(i).getUsername().equals(username_field.getText()) && Server.accounts.get(i).getPhonenumber().equals(phone_field.getText())) {
                        error.setVisible(false);
                        show_change_pass();
                        check.setVisible(false);
                        check2.setVisible(true);
                    }
                    else{
                        error.setText("try again!");
                        error.setVisible(true);
                    }
                }
            }
        });

    }

    public void check2(MouseEvent mouseEvent) throws IOException {
        check.setVisible(false);
        show_change_pass();
        if (newpass_field.getText().isEmpty() || confirm_field.getText().isEmpty()) {
            pass_label.setText("No password/confirmation provided!");
            pass_label.setVisible(true);
        }
        if (!Validation.isAlphaNumeric(newpass_field.getText()) || newpass_field.getText().length() < 8) {
            pass_label.setVisible(false);
            pass_label.setText("Invalid Password!");
            pass_label.setVisible(true);
        }
        if (!confirm_field.getText().equals(newpass_field.getText())) {
            pass_label.setVisible(false);
            pass_label.setText("Passwords do not match!");
            pass_label.setVisible(true);
        }
        if (Validation.isAlphaNumeric(newpass_field.getText()) && newpass_field.getText().length() >= 8 && confirm_field.getText().equals(newpass_field.getText())) {
            pass_label.setVisible(false);
            pass_label.setText("password changed successfully!");
            pass_label.setVisible(true);
           // API.pass_recovery(username_field.getText(),newpass_field.getText());
            new PageLoader().load("timeline");

        }
    }
}

