package Controller;


import Help.Validation;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class login_and_signup_Controller {


    @FXML
    private Label label_for_pass;
    @FXML
    private Label label_for_username;
    @FXML
    private Button signup_button;
    @FXML
    private ImageView logo;
    @FXML
    private Button login_button;
    @FXML
    private TextField username_field;
    @FXML
    private PasswordField password_field;
    @FXML
    private TextField password_show;

    public void Signup(ActionEvent actionEvent) {
        this.signupfunc();
    }

    public void login(ActionEvent actionEvent) {
        this.loginfunc();
    }

    public void show_pass(ActionEvent actionEvent) {
        if(!password_show.isVisible()){
            password_show.setVisible(true);
            password_show.setText(password_field.getText());
        }
        else{
            password_show.setVisible(false);
            password_show.setText(password_show.getText());
        }
    }

    void loginfunc() {
        (new Thread(this.LoginHandler())).start();
    }

    private Runnable LoginHandler() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String username = username_field.getText();
                if (username.isEmpty()) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            label_for_username.setText("No username provided.");
                            label_for_username.setVisible(true);
                        }
                    });
                    return;
                }
                if (password_field.getText().isEmpty()) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            label_for_pass.setText("No password provided.");
                            label_for_pass.setVisible(true);
                        }
                    });
                    return;
                }
                if (!Validation.isAlphaNumeric(username_field.getText())) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            label_for_username.setText("Invalid username.");
                            label_for_username.setVisible(true);
                        }
                    });
                    return;
                }
                if (!Validation.isAlphaNumeric(password_field.getText()) || password_field.getText().length() < 8) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            label_for_pass.setText("Invalid password.");
                            label_for_pass.setVisible(true);
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

    private void signupfunc() {
        (new Thread(this.SignUpHandler())).start();
    }

    private Runnable SignUpHandler() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String username = username_field.getText();
                if (username.isEmpty()) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            label_for_pass.setText("No username provided.");
                            label_for_pass.setVisible(true);
                        }
                    });
                    return;
                }
                if (password_field.getText().isEmpty()) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            label_for_pass.setText("No password provided.");
                            label_for_pass.setVisible(true);
                        }
                    });
                    return;
                }
                if (!Validation.isAlphaNumeric(username_field.getText())) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            label_for_pass.setText("Invalid username.");
                            label_for_pass.setVisible(true);
                        }
                    });
                    return;
                }
                if (!Validation.isAlphaNumeric(password_field.getText()) || password_field.getText().length() < 8) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            label_for_pass.setText("Invalid password.");
                            label_for_pass.setVisible(true);

                        }
                    });
                    return;
                }
                String password = password_field.getText();
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        label_for_pass.setText("Signing up...");
                        label_for_pass.setVisible(true);
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

    }}
