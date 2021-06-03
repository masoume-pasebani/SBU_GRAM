package Controller;

import Model.Post;
import Model.Privacy;
import Model.Profile;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;

public class Mainpage_Controller {
    @FXML
    private Button clear;
    @FXML
    private TextField title_field;
    @FXML
    private MenuButton menu_field;
    @FXML
    private Button publish_btn;
    @FXML
    private TextArea desc_field;
    @FXML
    private ListView<Post> list_of_posts;

    ArrayList<Post> posts=new ArrayList<>();
    Post post=new Post();

    @FXML
    public void initialize(){

        for (int i=0;i<=10;i++) {
            Post p=new Post();
            p.setTitle("title"+i);
            p.setWritername("user"+i);
            p.setDesc("desc"+i);
            posts.add(p);
        }

        list_of_posts.setItems(FXCollections.observableArrayList(posts));
        list_of_posts.setCellFactory(list_of_posts->new PostItem());

    }
    public void add_post(ActionEvent actionEvent) throws IOException {
        post.setTitle(title_field.getText());
        post.setDesc(desc_field.getText());
        post.setWritername(Profile.getName()+Profile.getLastname());

        posts.add(post);

        list_of_posts.setItems(FXCollections.observableArrayList(posts));
        list_of_posts.setCellFactory(list_of_posts->new PostItem());

        post=new Post();
        title_field.setText("");
        desc_field.setText("");
    }

    public void publicpost(ActionEvent actionEvent) {
        post.setPrivacy(Privacy.PUBLIC);
    }

    public void privatepost(ActionEvent actionEvent) {
        post.setPrivacy(Privacy.PRIVATE);
    }

    public void clear(ActionEvent actionEvent) {
        title_field.setText("");
        desc_field.setText("");
    }


    public void show_post(MouseEvent mouseEvent) {Post p = new Post();
        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).equals(p)) {
                title_field.setText(posts.get(i).getTitle());
                desc_field.setText(posts.get(i).getDesc());
            }
        }
    }
}
