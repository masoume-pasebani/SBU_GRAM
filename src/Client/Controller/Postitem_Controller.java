package Client.Controller;

import Client.API;
import Client.ClientEXE;
import Common.Model.PageLoader;
import Common.Model.Post;
import Server.Net.Server;
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

    /**
     * this is the postitem controller
     * @author Masoume Pasebani
     * @version 1.0
     * @since 2021-06-25
     */
    public Label time_of_the_post;
    public Label number_of_likes;
    public ImageView image;
    public TextArea desc;
    public Label user_label;
    public Label title_label;
    public ImageView profile;
    public ImageView dislike_pic;
    public ImageView like_pic;
    public ImageView repost_pic;
    public AnchorPane root;
    public Post post;

    /**
     * it loads postitem
     * @param post
     * @throws IOException
     */
    public Postitem_Controller(Post post) throws IOException {
        new PageLoader().load("postitem",this);
        this.post = post;
    }


    /**
     * if you double click on mouse ypu would like the post
     * @param mouseEvent
     */
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

    /**
     * this method will initialize posts details
     * @return
     */
    public AnchorPane init() {

            user_label.setText(post.getWritername());
            title_label.setText(post.getTitle());
            desc.setText(post.getDesc());
            time_of_the_post.setText(post.getTimeString());
            number_of_likes.setText(String.valueOf(post.getLikes()));
            //Image postimage=new Image(new ByteArrayInputStream(post.getImage()));
            //image.setImage(postimage);
            //Image profile_image=new Image(new ByteArrayInputStream(post.getPublisher().getImage()));
            //profile.setImage(profile_image);
            return root;

    }
}
