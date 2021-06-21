package Client.Controller;



import Client.API;
import Client.Client;
import Client.ClientEXE;
import Common.Help.Validation;
import Common.Model.Account;
import Common.Model.PageLoader;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class login_Controller extends Controller{


    @FXML
    private Label label_for_pass;
    @FXML
    private Label label_for_username;
    @FXML
    private PasswordField password_field;
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
                String password = password_field.getText();

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

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        label_for_pass.setText("Logging in...");
                        label_for_pass.setVisible(true);
                    }
                });

                Account account= API.login(username,password);
                if(account==null){
                    showInvalidLoginDialog();
                    return;
                }
                ClientEXE.setProfile(account);
                try {
                    new PageLoader().load("timeline");
                } catch (IOException e) {
                    e.printStackTrace();
                }
//                try {
//                    DB.oos.writeObject(new LoginCommand(username, password));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            }
        };
        return runnable;
    }

    public void showInvalidLoginDialog() {
        String title = "Error in login";
        String contentText = "invalid username or password\nTry again or sign up";
        this.makeAndShowInformationDialog( title, contentText );
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
    public void showNotConnectedDialog(){
        String title = "not connected to server";
        String contentText = "you are not connected to server yet, please use connection panel!";
        this.makeAndShowInformationDialog( title, contentText );

    }

    public void recovery(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("pass_recovery");
    }
}

