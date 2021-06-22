package Client.Controller;

import Client.API;
import Client.ClientEXE;
import Common.Help.Validation;
import Common.Model.Account;
import Common.Model.PageLoader;
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
    private Label p_label;
    @FXML
    private Label pass_label;
    @FXML
    private ImageView check1;
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
    private Label question;
    @FXML
    private TextField phone_field;
    @FXML
    private TextField username_field;

    public void back_to_login(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("login");
    }

    public void check(MouseEvent mouseEvent) {
        if(UserNameExists(username_field.getText())){
            error.setVisible(false);
            show_phonenumber();
            check.setVisible(false);
            check1.setVisible(true);
        }
        else{
            error.setText("There is no account with this username!");
            error.setVisible(true);
        }
    }

    public boolean UserNameExists(String username){
          return API.IsUserNameExists(username);

    }
    public void show_phonenumber(){
        TranslateTransition transition=new TranslateTransition(Duration.millis(1000),question);
        transition.setToX(-312);
        transition.play();
        TranslateTransition transition1=new TranslateTransition(Duration.millis(1000),phone_field);
        transition1.setToX(316);
        transition1.play();
    }
    public void show_change_pass(){
        TranslateTransition transition=new TranslateTransition(Duration.millis(1000),pass_q);
        transition.setToX(-312);
        transition.play();
        TranslateTransition transition1=new TranslateTransition(Duration.millis(1000),newpass_field);
        transition1.setToX(316);
        transition1.play();
        TranslateTransition transition2=new TranslateTransition(Duration.millis(1000),confirm_field);
        transition2.play();
    }

    public void check1(MouseEvent mouseEvent) {

        Account account=new Account(username_field.getText());
        if(phone_field.getText().equalsIgnoreCase(account.getPhonenumber())){
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    p_label.setVisible(false);
                    show_change_pass();
                    check1.setVisible(false);
                    check2.setVisible(true);
                }
            });
        }
        else {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    p_label.setText("Wrong PhoneNumber!!");
                    p_label.setVisible(true);
                }
            });
        }
    }

    public void check2(MouseEvent mouseEvent) {
        check1.setVisible(false);
        if(newpass_field.getText().isEmpty() || confirm_field.getText().isEmpty()){
            pass_label.setText("No password/confirmation provided!");
            pass_label.setVisible(true);
        }
        if(!Validation.isAlphaNumeric(newpass_field.getText()) || newpass_field.getText().length()<8){
            pass_label.setVisible(false);
            pass_label.setText("Invalid Password!");
            pass_label.setVisible(true);
        }
        if(!confirm_field.getText().equals(newpass_field.getText())){
            pass_label.setVisible(false);
            pass_label.setText("Passwords do not match!");
            pass_label.setVisible(true);
        }
        if(Validation.isAlphaNumeric(newpass_field.getText()) && newpass_field.getText().length()>=8 && confirm_field.getText().equals(newpass_field.getText())){
            pass_label.setVisible(false);
            pass_label.setText("password changed successfully!");
            pass_label.setVisible(true);
            ClientEXE.getProfile().setPassword( newpass_field.getText() );
        }

    }
}
