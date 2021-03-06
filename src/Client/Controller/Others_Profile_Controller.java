package Client.Controller;

import Common.Model.PageLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class Others_Profile_Controller {
    /**
     * this is the others profile controller
     * @author Masoume Pasebani
     * @version 1.0
     * @since 2021-06-25
     */

    public ImageView others_profile;
    public Label number_of_followers;
    public Label number_of_following;
    public Button follow;
    public Label name_l;
    public Label lastname_l;
    public Label username_l;
    public Label birth_l;

    public void back(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("Search");
    }
    public void initialize(){
        username_l.setText(Postitem_Controller.user_label.getText());
        others_profile.setImage(Postitem_Controller.image.getImage());

    }
}
