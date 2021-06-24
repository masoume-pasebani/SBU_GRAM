package Client.Controller;

import Client.Client;
import Common.Help.Validation;
import Common.Model.Account;
import Common.Model.PageLoader;
import Client.API;
import Client.ClientEXE;
import Server.Net.Server;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.util.Duration;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serial;
import java.nio.charset.StandardCharsets;

public class Signup_Controller extends Controller {

    private final static String Profile_Picture="images/default_user.png";
    @FXML
    private Label confirm_label;
    @FXML
    private Label star3;
    @FXML
    private PasswordField confirm;
    @FXML
    private Label star1;
    @FXML
    private Label star2;
    @FXML
    private ImageView image;
    @FXML
    private Label question;
    @FXML
    private Button add_photo;
    @FXML
    private TextField birth_field;
    @FXML
    private TextField phonenumber_field;
    @FXML
    private Label user_label;
    @FXML
    private Label pass_label;
    @FXML
    private TextField name_field;
    @FXML
    private TextField lastname_field;
    @FXML
    private TextField username_field;
    @FXML
    private PasswordField pass_field;
    @FXML
    private Button login_btn;
    @FXML
    private Button signup_btn;

    public void initialize(){
        TranslateTransition transition=new TranslateTransition(Duration.millis(1000),add_photo);
        transition.setToX(-256);
        transition.playFromStart();
        TranslateTransition transition1=new TranslateTransition(Duration.millis(1000),signup_btn);
        transition1.setToX(-273);
        transition1.playFromStart();
        TranslateTransition transition2=new TranslateTransition(Duration.millis(1000),question);
        transition2.setToX(302);
        transition2.playFromStart();
        TranslateTransition transition3=new TranslateTransition(Duration.millis(1000),login_btn);
        transition3.setToX(-273);
        transition3.playFromStart();
        TranslateTransition transition4=new TranslateTransition(Duration.millis(1000),image);
        transition4.setToX(272);
        transition4.playFromStart();
        TranslateTransition transition5=new TranslateTransition(Duration.millis(1000),name_field);
        transition5.setToX(300);
        transition5.playFromStart();
        TranslateTransition transition6=new TranslateTransition(Duration.millis(1000),lastname_field);
        transition6.setToX(-302);
        transition6.playFromStart();
        TranslateTransition transition7=new TranslateTransition(Duration.millis(1000),phonenumber_field);
        transition7.setToX(289);
        transition7.playFromStart();
        TranslateTransition transition8=new TranslateTransition(Duration.millis(1000),birth_field);
        transition8.setToX(-313);
        transition8.playFromStart();
        TranslateTransition transition9=new TranslateTransition(Duration.millis(1000),username_field);
        transition9.setToX(302);
        transition9.playFromStart();
        TranslateTransition transition10=new TranslateTransition(Duration.millis(1000),pass_field);
        transition10.setToX(-295);
        transition10.playFromStart();
        TranslateTransition transition11=new TranslateTransition(Duration.millis(1000),star1);
        transition11.setToX(179);
        transition11.playFromStart();
        TranslateTransition transition12=new TranslateTransition(Duration.millis(1000),star2);
        transition12.setToX(-313);
        transition12.playFromStart();
        TranslateTransition transition13=new TranslateTransition(Duration.millis(1000),confirm);
        transition13.setToX(301);
        transition13.playFromStart();
        TranslateTransition transition14=new TranslateTransition(Duration.millis(1000),star3);
        transition14.setToX(198);
        transition14.playFromStart();


    }

    public void showNotConnectedDialog(){
        String title = "not connected to server";
        String contentText = "you are not connected to server yet, please use connection panel!";
        this.makeAndShowInformationDialog( title, contentText );

    }
    public void signup(ActionEvent actionEvent) throws IOException {

        this.signUp();

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
                String password = pass_field.getText();
                String confirm_str= confirm.getText();
                if (username.isEmpty() && pass_field.getText().isEmpty() && confirm_label.getText().isEmpty()) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            user_label.setText("No username provided!");
                            user_label.setVisible(true);
                            pass_label.setText("No password provided!");
                            pass_label.setVisible(true);
                            confirm_label.setText("No confirmation!");
                            confirm_label.setVisible(true);
                        }
                    });
                    return;
                }
                if (!username.isEmpty() && !Validation.isAlphaNumeric(username_field.getText()) && pass_field.getText().isEmpty() && confirm_label.getText().isEmpty()) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            user_label.setText("Invalid username!");
                            user_label.setVisible(true);
                            pass_label.setText("No password provided!");
                            pass_label.setVisible(true);
                            confirm_label.setText("No confirmation!");
                            confirm_label.setVisible(true);
                        }
                    });
                    return;
                }
                if (!username.isEmpty() && Validation.isAlphaNumeric(username_field.getText()) && pass_field.getText().isEmpty() && confirm_label.getText().isEmpty()) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            user_label.setVisible(false);
                            pass_label.setText("No password provided!");
                            pass_label.setVisible(true);
                            confirm_label.setText("No confirmation!");
                            confirm_label.setVisible(true);
                        }
                    });
                    return;
                }
                if (!Validation.isAlphaNumeric(pass_field.getText()) || pass_field.getText().length() < 8) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            user_label.setVisible(false);
                            pass_label.setText("Invalid password!");
                            pass_label.setVisible(true);
                            confirm_label.setVisible(false);
                        }
                    });
                    return;
                }


                if(Validation.isAlphaNumeric(username_field.getText()) && Validation.isAlphaNumeric(pass_field.getText()) && pass_field.getText().length()>=8 && !confirm.getText().equals(pass_field.getText())){
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            user_label.setVisible(false);
                            pass_label.setVisible(false);
                            confirm_label.setText("Passwords do not match!");
                            confirm_label.setVisible(true);
                        }
                    });
                }
                boolean exists=API.IsUserNameExists(username_field.getText());
                if ( exists){
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            pass_label.setVisible(false);
                            confirm_label.setVisible(false);
                            user_label.setText("Username already exists, choose another one!");
                            user_label.setVisible(true);

                        }
                    });

                }
                if(Validation.isAlphaNumeric(username_field.getText()) && Validation.isAlphaNumeric(pass_field.getText()) && pass_field.getText().length()>=8 && confirm.getText().equals(pass_field.getText())) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            pass_label.setVisible(false);
                            user_label.setVisible(false);
                            confirm_label.setVisible(false);
                            Account createaccount= null;
                            try {
                                createaccount = makeProfileFromPageContent();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            ClientEXE.setProfile(createaccount);
                            API.signUp(createaccount);
                            Server.accounts.add(createaccount);
                            showProfileCreatedDialog();
                            try {
                                new PageLoader().load("timeline");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    });
                    return;
                }


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

    private Account makeProfileFromPageContent() throws IOException {
        Account returnValue = new Account(username_field.getText(),pass_field.getText(),name_field.getText(),lastname_field.getText(),phonenumber_field.getText(),birth_field.getText(),image.getImage().getUrl().getBytes(StandardCharsets.UTF_8));
        returnValue.setUsername(username_field.getText());
        returnValue.setPassword(pass_field.getText() );
        returnValue.setName(name_field.getText() );
        returnValue.setLastname(lastname_field.getText() );
        returnValue.setBirth(birth_field.getText());
        returnValue.setPhonenumber(phonenumber_field.getText());
        returnValue.setImage( image.getImage().getUrl().getBytes(StandardCharsets.UTF_8) );

        return returnValue;
    }

    public void showProfileCreatedDialog( ){
        String title = "Success";
        String contentText = "profile created succesfully!";
        this.makeAndShowInformationDialog( title, contentText );
    }

    private void clearFields() {
        this.username_field.setText( null );
        this.pass_field.setText( null );
        this.confirm.setText( null );
        this.name_field.setText( null );
        this.lastname_field.setText( null );
        this.phonenumber_field.setText(null);
        this.birth_field.setText(null);
        Image defaultImage = new Image( Signup_Controller.Profile_Picture);
        this.image.setImage( defaultImage );
    }

    public void add(ActionEvent actionEvent) {
        image.setImage(chooseImage());
    }
    public static Image chooseImage() {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog( PageLoader.stage.getScene().getWindow() );
        return new Image( file.toURI().toString() );
    }


}
