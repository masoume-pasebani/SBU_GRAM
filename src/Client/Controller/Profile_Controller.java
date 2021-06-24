package Client.Controller;

import Client.ClientEXE;
import Common.Model.Account;
import Common.Model.PageLoader;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;

public class Profile_Controller extends Controller implements Initializable {
    @FXML
    private Label birth_l;
    @FXML
    private Label user_l;
    @FXML
    private Label lastname_l;
    @FXML
    private Label name_l;
    private ImageView menu;
    @FXML
    private Label phone_l;
    @FXML
    private ImageView image;
    @FXML
    private Label posts;
    @FXML
    private Label followers;
    @FXML
    private Label following;
    @FXML
    private ListView listview;


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
        Image image1=new Image(new ByteArrayInputStream(account.getImage()));
        image.setImage(image1);
        listview.setItems(FXCollections.observableArrayList(account.getPosts()));
        listview.setCellFactory(listView -> new PostItem());

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

    public void edit_info(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("edit");

    }

    public void backtimeline(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("timeline");
    }
}
