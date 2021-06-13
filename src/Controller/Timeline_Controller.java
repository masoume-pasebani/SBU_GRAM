package Controller;

import Model.Account;
import Model.PageLoader;
import Model.Post;
import Model.Privacy;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

import java.io.IOException;
import java.util.ArrayList;

public class Timeline_Controller {


    public void refresh(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("timeline");
    }

    public void search(MouseEvent mouseEvent) {

    }

    public void add_post(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("publish post");
    }


    public void go_to_profile(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("profile");
    }
}
