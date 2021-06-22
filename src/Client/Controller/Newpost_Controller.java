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
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class Newpost_Controller {
    @FXML
    private TextField post_title;
    @FXML
    private TextArea desc;
    @FXML
    private Button add_image;
    Post current_post=new Post();
    Account account= ClientEXE.getProfile();

    public void add_image(ActionEvent actionEvent) {
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
