package Client.Controller;

import Client.API;
import Client.Client;
import Client.ClientEXE;
import Common.Model.Account;
import Common.Model.PageLoader;
import Common.Model.Post;
import Server.Net.Server;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collectors;



public class Timeline_Controller {
    /**
     * this controller shows the button of search,
    * logout,profile,refresh and add post
    * it also shows the list of posts
    * @author Masoume Pasebani
    * @version 1.0
     * @since 2021-06.25
     */



    public ListView<Post> listview;
    public  static AnchorPane root;

    /**
     * this method use for initialize the timeline page
     */
    public void initialize() {
        Set<Post>posts=API.get_Posts();
        List<Post> postList= posts.stream().filter(a->a.getWritername().equals(ClientEXE.getProfile())).sorted((x,y)->(int)(x.getCreatedTime()-y.getCreatedTime())).collect(Collectors.toList());
        listview.setItems(FXCollections.observableArrayList(postList));
        listview.setCellFactory(listview -> new PostItem());


    }

    /**
     * this method loads the timeline again
     * @param mouseEvent
     * @throws IOException
     */
    public void refresh(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("timeline");
    }

    /**
     * this method loads the search page to find a user
     * @param mouseEvent
     * @throws IOException
     */
    public void search(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("search");

    }

    /**
     * this method loads the publish post page to add a post
     * @param mouseEvent
     * @throws IOException
     */
    public void add_post(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("publish post");
    }

    /**
     * this method loads the profile page
     * @param mouseEvent
     * @throws IOException
     */
    public void gotopro(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("profile");
    }

    /**
     * this method will loads the login page
     * @throws IOException
     */
    public void logout() throws IOException {
        API.logout();
        Client.disconnectFromServer();
        ClientEXE.profile = null;
        new PageLoader().load("login");
    }

    public void post(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("postitem");
    }
}
