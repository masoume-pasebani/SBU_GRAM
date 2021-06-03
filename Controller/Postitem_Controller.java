package Controller;

import Model.PageLoader;
import Model.Post;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Postitem_Controller {
    @FXML
    private Label user_label;
    @FXML
    private Label title_label;
    @FXML
    private Button see_more;
    @FXML
    private ImageView profile;
    @FXML
    private ImageView dislike_pic;
    @FXML
    private ImageView like_pic;
    @FXML
    private ImageView repost_pic;
    AnchorPane root;
    Post post;

    public Postitem_Controller(Post post) throws IOException {
        new PageLoader().load("postitem",this);
        this.post = post;
    }


    public void like(MouseEvent mouseEvent) {
        if(mouseEvent.getClickCount()%2==0){
            like_pic.setVisible(true);
        }
        else
            like_pic.setVisible(false);
    }

    public void repost(MouseEvent mouseEvent) {

    }


    public AnchorPane init() {
        user_label.setText(post.getWritername());
        title_label.setText(post.getTitle());
        return root;
    }
}
