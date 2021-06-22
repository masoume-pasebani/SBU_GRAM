package Client.Controller;

import Client.ClientEXE;
import Common.Model.Account;
import Common.Model.PageLoader;
import Common.Model.Post;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Newpost_Controller {

    @FXML
    private ImageView post_image;
    @FXML
    private TextField post_title;
    @FXML
    private TextArea desc;
    @FXML
    private Button add_image;
    Post current_post=new Post();
    Account account= ClientEXE.getProfile();

    public static javafx.scene.image.Image chooseImage() {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog( PageLoader.stage.getScene().getWindow() );
        return new Image( file.toURI().toString() );
    }

    public void add_image(ActionEvent actionEvent) {
        post_image.setImage(chooseImage());
        current_post.setAddress(post_image.toString());
    }

    public void back_to_timeline(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("timeline");
    }

    public void publish_post(MouseEvent mouseEvent) {

        current_post.setTitle(post_title.getText());
        current_post.setDesc(desc.getText());
        current_post.setWritername(account.getUsername());
        


    }
}
