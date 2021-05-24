package Controller;

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

public class Signup_Controller {


    @FXML
    private Label user_label;
    @FXML
    private Label pass_label;
    @FXML
    private TextField name_field;
    @FXML
    private TextField lastname_field;
    @FXML
    private TextField birthdate_field;
    @FXML
    private TextField username_field;
    @FXML
    private PasswordField pass_field;
    @FXML
    private Button login_btn;
    @FXML
    private Button signup_btn;



    public void signup(ActionEvent actionEvent) throws IOException {
        this.signUp();
        new PageLoader().load("Mainpage");
    }

    public void login(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("login");
    }
    private void signUp() {
        (new Thread(this.getSignUpHandler())).start();
    }

    private Runnable getSignUpHandler() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String username = username_field.getText();
                if (username.isEmpty()) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            user_label.setText("No username provided.");
                            user_label.setVisible(true);
                        }
                    });
                    return;
                }
                if (pass_field.getText().isEmpty()) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            pass_label.setText("No password provided.");
                            pass_label.setVisible(true);
                        }
                    });
                    return;
                }
                if (!Validation.isAlphaNumeric(username_field.getText())) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            user_label.setText("Invalid username.");
                            user_label.setVisible(true);
                        }
                    });
                    return;
                }
                if (!Validation.isAlphaNumeric(pass_field.getText())|| pass_field.getText().length() < 8) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            pass_label.setText("Invalid password.");
                            pass_label.setVisible(true);
                        }
                    });
                    return;
                }
                String password = pass_field.getText();
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        pass_label.setText("Signing up...");
                        pass_label.setVisible(true);
                    }
                });

//                try {
//                    DB.oos.writeObject(new SignUpCommand(username, password));
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    Platform.runLater(new Runnable() {
//                        @Override
//                        public void run() {
//                            errorLbl.setText("Couldn't connect to server.");
//                            errorLbl.setVisible(true);
//                        }
//                    });
//                }
            }
        };
        return runnable;
    }

}
