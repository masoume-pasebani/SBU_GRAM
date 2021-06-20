package Client.Controller;

import Common.Model.PageLoader;
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

    public void add_image(ActionEvent actionEvent) {
    }

    public void back_to_timeline(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("timeline");
    }

    public void publish_post(MouseEvent mouseEvent) {

    }
}
