package Client.Controller;

import Client.API;
import Client.ClientEXE;
import Common.Model.Account;
import Common.Model.PageLoader;
import Common.Model.Post;
import Server.Net.Server;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Timeline_Controller {


    public static ListView<Post> listview;
    public static List<Post> postList=new ArrayList<>();

    public void initialize(){
//        API.show_list_post(usernames());
//        listview.setItems(FXCollections.observableArrayList(postList));
//        listview.setCellFactory(listview ->new PostItem());

    }

    public void refresh(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("timeline");
    }

    public void search(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("search");

    }

    public void add_post(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("publish post");
    }

    public void gotopro(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("profile");
    }

    public void logout() throws IOException {
        API.logout();
        Client.Client.disconnectFromServer();
        ClientEXE.profile = null;
        new PageLoader().load("login");
    }
    public String usernames(){
        String allusenames ="";
        for (Account a:Server.accounts) {
            allusenames+=" "+a.getUsername();
        }
        return allusenames;
    }
}
