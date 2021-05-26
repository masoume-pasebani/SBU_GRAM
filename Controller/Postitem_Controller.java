package Controller;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Postitem_Controller {
    @FXML
    private ImageView dislike_pic;
    @FXML
    private ImageView like_pic;
    @FXML
    private ImageView repost_pic;

    public void like(MouseEvent mouseEvent) {
        if(mouseEvent.getClickCount()%2==0){
            like_pic.setVisible(true);
        }
        else
            like_pic.setVisible(false);
    }

    public void repost(MouseEvent mouseEvent) {

    }
}
