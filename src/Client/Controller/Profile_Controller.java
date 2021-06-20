package Client.Controller;

import Common.Model.PageLoader;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class Profile_Controller {
    public void menu(MouseEvent mouseEvent) {
    }

    public void timeline(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("timeline");
    }
}
