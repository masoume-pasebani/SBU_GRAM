package Client.Controller;

import Client.API;
import Client.ClientEXE;
import Common.Model.Account;
import Common.Model.PageLoader;
import Common.Model.Post;
import Server.Net.Server;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.*;

public class Newpost_Controller {
    /**
     * this is the new post controller
     * @author Masoume Pasebani
     * @version 1.0
     * @since 2021-06-25
     */


    public Label title_label;
    public Label desc_label;
    public Label image_label;
    @FXML
    private ImageView post_image;
    @FXML
    private TextField post_title;
    @FXML
    private TextArea desc;
    @FXML
    private Button add_image;

    public String image;
    Account account= ClientEXE.getProfile();

    /**
     * this method will use to choose an image for post
     * @param actionEvent
     * @throws IOException
     */
    public void add_image(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser=new FileChooser();
        File file=fileChooser.showOpenDialog(PageLoader.stage.getScene().getWindow());
        image=file.toString();
        FileInputStream fin=new FileInputStream(file);
        byte[] bytes=fin.readAllBytes();
        Image image1=new Image(new ByteArrayInputStream(bytes));
        post_image.setImage(image1);
    }

    /**
     * this will loads timeline
     * @param mouseEvent
     * @throws IOException
     */
    public void back_to_timeline(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("timeline");
    }

    /**
     * this method checks the fields and then it would publish the post
     * @param mouseEvent
     * @throws IOException
     */
    public void publish_post(MouseEvent mouseEvent) throws IOException {
        if(post_title.getText().isEmpty() || desc.getText().isEmpty() || post_image.getImage().equals("images/2103666.png")){
            image_label.setText("Fields should be fill!!");
            image_label.setVisible(true);
        }
        else {
            Post current_post=new Post();
            image_label.setVisible(false);
            current_post.setTitle(post_title.getText());
            current_post.setDesc(desc.getText());
            current_post.setWritername(account.getUsername());
            if(API.publish_post(current_post)) {

                new PageLoader().load("timeline");
            }

        }


    }
}
