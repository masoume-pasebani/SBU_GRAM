package Client.Controller;

import Client.API;
import Common.Model.Account;
import Common.Model.PageLoader;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class Search_Controller {

    @FXML
    private TextField search;
    @FXML
    private Label error_label;

    public void search(MouseEvent mouseEvent) {
        if(!valid_username(search.getText())){
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    error_label.setText("There is no account with this username!");
                    error_label.setVisible(true);
                }
            });

        }
        if(valid_username(search.getText())){
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    Account account=new Account(search.getText());
                }
            });
        }

    }

    public boolean valid_username(String username){
        return API.IsUserNameExists(username);
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("timeline");
    }
}
