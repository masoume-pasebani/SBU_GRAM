package Client.Controller;

import Common.Model.PageLoader;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class Timeline_Controller {


    public void refresh(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("timeline");
    }

    public void search(MouseEvent mouseEvent) {

    }

    public void add_post(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("publish post");
    }


    public void go_to_profile(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("profile");
    }
}
