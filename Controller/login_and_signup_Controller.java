package Controller;


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
    private Label label;
    @FXML
    private TextField password_show;

    public void Signup(ActionEvent actionEvent) {

    }

    public void login(ActionEvent actionEvent) {
        
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


}
