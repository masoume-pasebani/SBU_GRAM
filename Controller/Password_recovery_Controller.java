package Controller;

import Model.PageLoader;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class Password_recovery_Controller {

    public void back(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("login");
    }
}
