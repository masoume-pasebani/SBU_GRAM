package Client.Controller;

import Client.ClientEXE;
import Common.Model.Account;
import Common.Model.PageLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;

public class Profile_Controller extends Controller implements Initializable {
    public Label birth_l;
    public Label user_l;
    public Label lastname_l;
    public Label name_l;
    public ImageView menu;
    public Label phone_l;
    public ImageView image;
    public Label posts;
    public Label followers;
    public Label following;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Account account= ClientEXE.getProfile();
        name_l.setText(account.getName());
        user_l.setText(account.getUsername());
        lastname_l.setText(account.getLastname());
        birth_l.setText(account.getBirth());
        phone_l.setText(account.getPhonenumber());
        followers.setText(String.valueOf(account.getFollowers()));
        following.setText(String.valueOf(account.getFollowing()));
        posts.setText(String.valueOf(account.getPost()));
        image.setImage(image.getImage());

    }
    public boolean isValidPhone(){
        String phoneNumber = phone_l.getText();
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
    public void menu(MouseEvent mouseEvent) {
    }

    public void timeline(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("timeline");
    }


}
