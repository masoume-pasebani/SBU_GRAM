package Client.Controller;

import Common.Model.Account;
import Common.Model.PageLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.io.IOException;

public class Account_controller {
    AnchorPane root;
    Account account;
    @FXML
    private Label username;


    public Account_controller(Account account) throws IOException {
        new PageLoader().load("AccountItem",this);
        this.account=account;
    }
    public void see_profile(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("Othersprofile");
    }

    public AnchorPane init(){
        username.setText(account.getUsername());
        return root;
    }
}
