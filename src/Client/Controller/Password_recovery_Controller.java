package Client.Controller;

import Common.Model.PageLoader;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class Password_recovery_Controller {



    public void back_to_login(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("login");
    }
}