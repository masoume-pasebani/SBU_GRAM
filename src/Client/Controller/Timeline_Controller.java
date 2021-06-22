package Client.Controller;

import Common.Model.PageLoader;
import Common.Model.Post;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class Timeline_Controller {

    @FXML
    private ListView<Post> listview;

    public void refresh(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("timeline");
    }

    public void search(MouseEvent mouseEvent) {

    }

    public void add_post(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("publish post");
    }

    public void gotopro(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("profile");
    }
}
