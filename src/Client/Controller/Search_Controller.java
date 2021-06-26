package Client.Controller;

import Client.API;
import Common.Model.Account;
import Common.Model.PageLoader;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;

public class Search_Controller {

    /**
     * this class is controller of search page
     * @author Masoume Pasebani
     * @version 1.0
     * @since 2021-06-25
     */

    public ListView listview;
    public AnchorPane root;
    @FXML
    private TextField search;
    @FXML
    private Label error_label;
    ArrayList<Account>list=new ArrayList<>();

    /**
     * this method will check the username first and then if user exists it will show the users item to go to her/his profile
     * @param mouseEvent
     */
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
                    error_label.setVisible(false);
                    Account account=new Account(search.getText());
                    list.add(account);
                    listview.setItems(FXCollections.observableArrayList(list));
                    listview.setCellFactory(listView -> new AccountItem());
                }
            });
        }

    }

    /**
     * this method checks that the username is exists or not
     * @param username
     * @return
     */
    public boolean valid_username(String username){
        return API.IsUserNameExists(username);
    }

    

    /**
     * this method loads timeline page
     * @param mouseEvent
     * @throws IOException
     */
    public void back(MouseEvent mouseEvent) throws IOException{
            new PageLoader().load("timeline");
        
    }
}
