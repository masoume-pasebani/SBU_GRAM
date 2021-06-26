package Client.Controller;

import Client.API;
import Client.ClientEXE;
import Common.Help.Validation;
import Common.Model.Account;
import Common.Model.PageLoader;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Change_Info_Controller extends Controller {
    /**
     * this is the controller of editing info
     * @author Masoume Pasebani
     * @version 1.0
     * @since 2021-06-25
     */

    @FXML
    private Label error;
    @FXML
    private ImageView image;
    @FXML
    private Label pass_label;
    @FXML
    private Label confirm_label;
    @FXML
    private TextField name;
    @FXML
    private TextField phonenumber;
    @FXML
    private TextField birthyear;
    @FXML
    private PasswordField confirm_pass;
    @FXML
    private PasswordField pass;
    @FXML
    private TextField lastname;
    public String image1;

    /**
     * this method loads profile page
     * @param mouseEvent
     * @throws IOException
     */
    public void back(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("profile");
    }

    public void done(MouseEvent mouseEvent) {
        changeProfile();
    }

    /**
     * this method will checks fields and then will change the info
     */
    public void changeProfile(){
            if(name.getText().isEmpty() || lastname.getText().isEmpty() || phonenumber.getText().isEmpty() ||birthyear.getText().isEmpty() || pass.getText().isEmpty() || confirm_pass.getText().isEmpty()){
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        error.setText("Fill the blank fields!!");
                        error.setVisible(true);
                    }
                });

            }
            if (!isValidPhone()) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        error.setVisible(false);
                        error.setText("Invalid phone number!!");
                        error.setVisible(true);
                    }
                });
            }
            if(!Validation.isAlphaNumeric(pass.getText()) || pass.getText().length()<8) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        error.setVisible(false);
                        error.setText("Invalid password");
                        error.setVisible(true);
                    }
                });
            }
            if(!pass.getText().equals(confirm_pass.getText())) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        error.setVisible(false);
                        error.setText("Passwords do not match!!");
                        error.setVisible(true);
                    }
                });
            }
            if(!name.getText().isEmpty() &&  !lastname.getText().isEmpty() && !phonenumber.getText().isEmpty() && !birthyear.getText().isEmpty() && !pass.getText().isEmpty() && !confirm_pass.getText().isEmpty() && isValidPhone() && Validation.isAlphaNumeric(pass.getText()) && pass.getText().length()>=8 && pass.getText().equals(confirm_pass.getText())){
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Account account=ClientEXE.getProfile();
                        account.setName(name.getText());
                        account.setLastname(lastname.getText());
                        account.setBirth(birthyear.getText());
                        account.setPhonenumber(phonenumber.getText());
                        account.setPassword(pass.getText());
                        API.updateProfile(account);
                        try {
                            new PageLoader().load("profile");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });


        }
    }

    /**
     * the method of choosing image
     * @param actionEvent
     * @throws IOException
     */
    public void change_photo(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser=new FileChooser();
        File file=fileChooser.showOpenDialog(PageLoader.stage.getScene().getWindow());
        image1=file.toString();
        FileInputStream fin=new FileInputStream(file);
        byte[] bytes=fin.readAllBytes();
        Image image2=new Image(new ByteArrayInputStream(bytes));
        image.setImage(image2);
    }

    public boolean isValidPhone(){
        String phoneNumber = phonenumber.getText();
        if ( phoneNumber == null ) return true;
        if ( phoneNumber.equals("0") || phoneNumber.equals("")  ) return true;
        try{
            Long number = Long.parseLong(phoneNumber);
        } catch (Exception e) {
            String title = "Error in phone number";
            String contentText = "please enter in this format : 09000000000";
            makeAndShowInformationDialog( title, contentText );
            return false;
        }
        return true;
    }

}
