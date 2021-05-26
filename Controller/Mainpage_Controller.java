package Controller;

import Model.PageLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class Mainpage_Controller {
    @FXML
    private TextField title_field;
    @FXML
    private MenuButton menu_field;
    @FXML
    private Button publish_btn;
    @FXML
    private TextArea desc_field;
    @FXML
    private ListView list_of_posts;

    public void addpost(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("postitem");
    }

}
