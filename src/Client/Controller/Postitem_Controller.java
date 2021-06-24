package Client.Controller;

import Client.API;
import Client.ClientEXE;
import Common.Model.PageLoader;
import Common.Model.Post;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Postitem_Controller {
    public Label time_of_the_post;
    public Label number_of_likes;
    public ImageView image;
    public TextArea desc;
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
            API.like(String.valueOf(post.getLikers()),post);
        }
        else
            like_pic.setVisible(false);
    }

    public void repost(MouseEvent mouseEvent) {

    }


    public AnchorPane init() {
        Post post= ClientEXE.getPost();
        user_label.setText(post.getWritername());
        title_label.setText(post.getTitle());
        desc.setText(post.getDesc());
        time_of_the_post.setText(post.getTimeString());
        number_of_likes.setText(String.valueOf(post.getLikes()));
        Image postimage=new Image(new ByteArrayInputStream(post.getImage()));
        image.setImage(postimage);
        Image profile_image=new Image(new ByteArrayInputStream(post.getPublisher().getImage()));
        profile.setImage(profile_image);
        return root;

    }
}
